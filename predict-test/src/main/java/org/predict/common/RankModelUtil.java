package org.predict.common;


import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets; 
import org.apache.commons.lang3.tuple.Pair;
import org.predict.test.tensorflow.DeepFMWeightingChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by ian on 2017/1/5.
 */
public class RankModelUtil {

	private static final Logger LOG = LoggerFactory.getLogger(RankModelUtil.class); 

    public static List<Integer> flavors = Arrays.asList(207, 220, 233, 239, 244, 248, 252, 260, 0, 209, 211, 212, 213, 214, 215, 216, 217, 218, 219, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 234, 235, 236, 237, 238, 240, 241, 242, 245, 246, 247, 249, 250, 251, 254, 255, 256, 257, 258, 263, 264, 265, 266, 267, 268, 269, 270, 271, 272, 273, 274);

    public static String getCategory() {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        if (hour >= 5 && hour < 10) {
            return "早餐";
        } else if (hour >= 10 && hour < 14) {
            return "正餐";
        } else if (hour >= 14 && hour < 16) {
            return "下午茶";
        } else if (hour >= 16 && hour < 20) {
            return "正餐";
        } else if (hour >= 20 && hour < 24) {
            return "夜宵";
        } else {
            return "其他";
        }
    }

    public static float minMax(float value, float min, float max) {
        if (value > max) {
            value = max;
        } else if (value < min) {
            value = min;
        }
        return (value - min) / (max - min);
    }

    public static float minMaxWithOutlierMean(float value, float min, float max, float mean) {
        if (value > max || value < min) {
            value = mean;
        }
        return (value - min) / (max - min);
    }

    public static String searchRegexKeyword(String keyword) {
        if (Strings.isNullOrEmpty(keyword)) {
            return "";
        } else {
            return keyword.replaceAll("[^\\u4e00-\\u9fa5a-zA-Z0-9]", "").toLowerCase();
        }
    }

    public static Integer getMinutes() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.HOUR_OF_DAY) * 60 + cal.get(Calendar.MINUTE);
    }

    public static String getWorkOrWeekendDays() {
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DAY_OF_WEEK);
        if (day == 1 || day == 7) {
            return "weekend";
        } else {
            return "workday";
        }
    }

    public static String getTimeInfoUsedForDt() {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        if (hour >= 0 && hour <= 9) {
            return "other";
        } else if (hour >= 10 && hour <= 14) {
            return "lunch";
        } else if (hour >= 15 && hour <= 16) {
            return "tea";
        } else if (hour >= 17 && hour <= 20) {
            return "supper";
        } else if (hour >= 21 && hour <= 23) {
            return "night";
        } else {
            return "";
        }
    }

    public static String getPeriodOfTime() {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        if (hour > 6 && hour <= 10) {
            // breakfast
            return "1";
        } else if (hour > 10 && hour <= 14) {
            // lunch
            return "2";
        } else if (hour > 14 && hour <= 17) {
            // tea
            return "3";
        } else if (hour > 17 && hour <= 21) {
            // supper
            return "4";
        } else {
            // other
            return "5";
        }
    }

    public static int getDayOfWeek() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    public static float similarity(List<Float> list1, List<Float> list2) {
        float sim = 0;
        if (list1 != null && list2 != null && list1.size() == list2.size()) {
            float dot = 0;
            float normA = 0;
            float normB = 0;
            for (int i = 0; i < list1.size(); i++) {
                Float a = list1.get(i);
                Float b = list2.get(i);
                dot += a * b;
                normA += Math.pow(a, 2);
                normB += Math.pow(b, 2);
            }
            if (normA > 0 && normB > 0) {
                sim = (float) (dot / (Math.pow(normA * normB, 0.5)));
            }
        }
        return sim;
    }

    public static Float innPro(List<Float> list1, List<Float> list2) {
        Float sim = 0f;
        if (list1 == null || list2 == null || list1.size() != list2.size()) {
            return null;
        } else {
            float dot = 0;
            float normA = 0;
            float normB = 0;
            for (int i = 0; i < list1.size(); i++) {
                Float a = list1.get(i);
                Float b = list2.get(i);
                dot += a * b;
                normA += Math.pow(a, 2);
                normB += Math.pow(b, 2);
            }
            if (normA > 0 && normB > 0) {
                sim = (float) (dot / (Math.pow(normA * normB, 0.5)));
            }
        }
        return sim;
    }


    public static Set<Integer> convertToLRFeature(int[] clickLeaf, int[] orderLeaf) {
        Set<Integer> featureValues = Sets.newHashSet();
        for (int i = 0; i < clickLeaf.length; i++) {
            featureValues.add(clickLeaf[i] + i * 128);
        }
        for (int j = 0; j < orderLeaf.length; j++) {
            featureValues.add(orderLeaf[j] + j * 128 + 32000);
        }
        return featureValues;
    }

    public static Float[] getZeroEm() {
        Float[] zeros = new Float[15];
        for (int i = 0; i < zeros.length; i++) {
            zeros[i] = 0.0f;
        }
        return zeros;
    }

    public static Float[] minusEm(Float[] a, Float[] b) {
        Float[] tmp = getZeroEm();
        if (a != null && b != null && a.length == 15 && b.length == 15) {
            for (int i = 0; i < 15; i++) {
                tmp[i] += a[i] - b[i];
            }
        }
        return tmp;
    }

    public static double crossEm(Float[] a, Float[] b) {
        float sumA = 0.0f;
        float sumB = 0.0f;
        float sum = 0.0f;
        if (a != null && b != null && a.length == 15 && b.length == 15) {
            for (int i = 0; i < 15; i++) {
                sumA += Math.pow(a[i], 2);
                sumB += Math.pow(b[i], 2);
                sum = a[i] * b[i];
            }
            if (sumA > 1e-5 && sumB > 1e-5) {
                return sum / (Math.sqrt(sumA) * Math.sqrt(sumB));
            } else {
                return 0.0;
            }
        } else {
            return 0.0;
        }

    }

    public static String Readfiles(String path) {
        StringBuilder tmp = new StringBuilder();
        InputStreamReader br = null;
        try {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            br = new InputStreamReader(cl.getResourceAsStream(path));
            int c = 0;
            while ((c = br.read()) != -1) {
                tmp.append((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return tmp.toString();
    }

    /**
     * the last one is bias if has bias
     *
     * @param v
     * @return
     */
    public static float[] ReadLiblinear(String v) {
        List<Float> w = Lists.newArrayList();
        String[] sW = v.split("\n");
        for (int i = 6; i < sW.length; i++) {
            w.add(Float.parseFloat(sW[i]));
        }
        float[] reW = new float[w.size()];
        for (int i = 0; i < w.size(); i++) {
            reW[i] = w.get(i);
        }
        return reW;
    }

    public void sumEm(Float[] sum, Float[] value, Float w) {
        if (sum != null && value != null && w != null && sum.length == 15 && value.length == 15) {
            for (int i = 0; i < 15; i++) {
                sum[i] += w * value[i];
            }
        }
    }


    public static boolean isPPEOrProduction() {
        try {
            String env = System.getProperty("env");
            return "prod".equals(env) || "ppe".equals(env);
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isProduction() {
        try {
            String env = System.getProperty("env");
            return "prod".equals(env);
        } catch (Exception e) {
            return false;
        }
    }

    public static Map<Integer, Integer> readIndexMap(InputStream inputStream) {
        Map<Integer, Integer> indexMaps = null;
        try {
            BufferedReader bre = new BufferedReader(new InputStreamReader(inputStream));
            List<String> lines = new ArrayList<>();
            String li;
            while ((li = bre.readLine()) != null) {
                lines.add(li);
            }
            indexMaps = lines.stream().map(line -> {
                String[] indexPair = line.split(" ");
                Integer index = Integer.valueOf(indexPair[0]);
                Integer indexNew = Integer.valueOf(indexPair[1]);
                return Pair.of(index, indexNew);
            }).collect(Collectors.toMap(Pair::getKey, Pair::getValue));

        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return indexMaps;
    }

    /**
     * read feature index file
     * Format: originIndex,newIndex
     */
    public static Map<Integer, Integer> readFeatureIndex(String path, Integer size) {
        double mapSize = size / 0.75;
        Map<Integer, Integer> rsMap = new HashMap<Integer, Integer>((int) mapSize);
        try {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            BufferedReader bre = new BufferedReader(new InputStreamReader(cl.getResourceAsStream(path)));
            List<String> lines = new ArrayList<>();
            String li;
            while ((li = bre.readLine()) != null) {
                lines.add(li);
            }
            for (String line : lines) {
                String[] tup = line.split(",");
                Integer originIndex = Integer.valueOf(tup[0]);
                Integer newIndex = Integer.valueOf(tup[1]);
                rsMap.put(originIndex, newIndex);
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return rsMap;
    }

    public static String shopNameRemoveAddress(String name) {
        int cnStart = name.indexOf("（");
        int enStart = name.indexOf("(");
        int subIndex;
        if (cnStart > 0 && enStart > 0) {
            subIndex = cnStart > enStart ? enStart : cnStart;
        } else if (cnStart > 0) {
            subIndex = cnStart;
        } else if (enStart > 0) {
            subIndex = enStart;
        } else {
            subIndex = name.length();
        }
        return name.substring(0, subIndex);
    }

    public static double priceMaxMin(double price) {
        return Math.max(1.0, Math.min(100.0, price));
    }


}
