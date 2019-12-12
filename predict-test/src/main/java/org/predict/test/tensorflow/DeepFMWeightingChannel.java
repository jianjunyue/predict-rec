package org.predict.test.tensorflow;
 
import biz.k11i.xgboost.Predictor;
import biz.k11i.xgboost.util.FVec;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps; 
import org.apache.commons.io.FileUtils;
import org.predict.common.FileUtil;
import org.predict.common.RankModelUtil;
import org.predict.data.Feature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tensorflow.SavedModelBundle;
import org.tensorflow.Session;
import org.tensorflow.Tensor;

import javax.annotation.PostConstruct;
import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DeepFMWeightingChannel {
	private static final Logger log = LoggerFactory.getLogger(DeepFMWeightingChannel.class); 
    private static SavedModelBundle savedModelBundle;
    private static Map<Integer, DenseSplit> lineMaps = readFeatureSplits();
    private static Predictor click;
    private static Predictor order;
    private static Predictor pricePredictor;
    private static Session s;
    private static Tensor keepProb;
    private static Tensor isTrain;  

    private static void initModelBundle() { 
        try {
            URL t = DeepFMWeightingChannel.class.getClassLoader().getResource("dnnHuiXu/saved_model.pb");
            assert t != null;
            Path path = Paths.get(t.getPath());
            savedModelBundle = SavedModelBundle.load(path.getParent().toAbsolutePath().toString(), "serve");
        } catch (Exception e) {
            log.error(e.toString());
            System.exit(0);
        }
    }
 

    private static Map<Integer, DenseSplit> readFeatureSplits() {
        Map<Integer, DenseSplit> lineMaps = Maps.newHashMap();
        try {
            File fin = FileUtil.getFileFromClasspath("dnnHuiXuFile/splitFile");
            List<String> lines = FileUtils.readLines(fin, "utf-8");
            for (String s : lines) {
                String[] splitLines = s.split(" -> ");
                String[] splitItems = splitLines[1].split("#");
                List<Float> splitPoint = Lists.newArrayList();
                for (String splitItem : splitItems[0].split(", ")) {
                    splitPoint.add(Float.parseFloat(splitItem));
                }
                DenseSplit denseSplit = new DenseSplit();
                denseSplit.setSplitPoint(splitPoint);
                denseSplit.setNormalIndex(Integer.parseInt(splitItems[1]));
                lineMaps.put(Integer.parseInt(splitLines[0]), denseSplit);
            }
        } catch (Exception e) {
            log.error("DeepFMWeightingChannel: readFeatureSplits: " + e.getMessage());
        }
        return lineMaps;
    }

    private static int[] convertFeature(Map<Integer, Float> desnseFeatures, Map<Integer, DenseSplit> denseSplitMap, int[] clickLeaf, int[] orderLeaf) {
        int[] features = new int[872];
        for (int i = 0; i < 372; i++) {
            features[i] = i * 21;
        }
        for (Map.Entry<Integer, Float> denseFeature : desnseFeatures.entrySet()) {
            if (denseFeature.getKey() < 10000) {
                if (denseSplitMap.containsKey(denseFeature.getKey())) {
                    int index = 0;
                    List<Float> splitLists = denseSplitMap.get(denseFeature.getKey()).getSplitPoint();
                    int bias = denseSplitMap.get(denseFeature.getKey()).getNormalIndex();
                    boolean flag = true;
                    while (flag && index < 19) {
                        if (denseFeature.getValue() <= splitLists.get(index)) {
                            flag = false;
                        } else {
                            index += 1;
                        }
                    }
                    index += 1;
                    features[bias] = bias * 21 + index;
                }
            }
        }
        for (int i = 0; i < clickLeaf.length; i++) {
            features[i + 372] = clickLeaf[i] + i * 128 + 372 * 21;
        }
        for (int i = 0; i < orderLeaf.length; i++) {
            features[i + 372 + 250] = orderLeaf[i] + i * 128 + 32000 + 372 * 21;
        }
        return features;
    }
 
    public static void init() throws Exception { 
        initModelBundle();
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        click = new Predictor(cl.getResourceAsStream("dnnHuiXuFile/xg.model.click.txt.train20181225225706"));
        order = new Predictor(cl.getResourceAsStream("dnnHuiXuFile/xg.model.order.txt.train20181225231526"));
        pricePredictor = new Predictor(cl.getResourceAsStream("ftrl/xg.price20180305.model"));
        s = savedModelBundle.session();
        keepProb = Tensor.create(1.0f, new long[]{});
        isTrain = Tensor.create(false, new long[]{});
    }
 
    public static float predict( ) {
    	
    	List<Feature> features=features();
        HashMap<Integer, Float> featuresMap = Maps.newHashMap();
        features.forEach(feature -> featuresMap.put(feature.getIndex(), feature.getValue()));
        FVec fVec = FVec.Transformer.fromMap(featuresMap);

        int[] clickLeaf = click.predictLeaf(fVec);
        int[] orderLeaf = order.predictLeaf(fVec);

        int[] featureIntArray = convertFeature(featuresMap, lineMaps, clickLeaf, orderLeaf);
        int[][] feature = new int[1][872];
        feature[0] = featureIntArray;
        Tensor x = Tensor.create(feature, new long[]{1, 872});
        float[][] dnnOut = new float[1][1];
        List<Tensor<?>> out = s.runner()
                .feed("feature:0", x)
                .feed("keep_prob:0", keepProb)
                .feed("Placeholder:0", isTrain)
                .fetch("predict:0")
                .run();
        out.get(0).copyTo(dnnOut);
        x.close();
        for (Tensor tensor : out) {
            tensor.close();
        }
        double score;
        score = dnnOut[0][0] * 50000f;
        score = score * Math.pow(priceMaxMin(pricePredictor.predictSingle(fVec) * 100), 20);
//        shop.setScore((float) score);
        return (float) score;
    }
 
    public static List<Feature> features() {
    	 List<Feature> features = new ArrayList<Feature>();
        
    	 for(int i=8000;i<8028;i++) {
    		 features.add(new Feature(i,i*0.1f));
    	 }
    	 
        if (features.size() > 0) {
            features = features.stream().filter(RankModelUtil.distinctByKey(Feature::getIndex)).filter(x -> x.getIndex() != -1).filter(x -> Math.abs(x.getValue()) > 1e-5).filter(x -> Math.abs(x.getValue()) < 1e10).collect(Collectors.toList());
            features.sort(Comparator.comparingInt(Feature::getIndex));
        }
        

        return features;
    }
    
    public static double priceMaxMin(double price) {
        return Math.max(1.0, Math.min(100.0, price));
    }
}
