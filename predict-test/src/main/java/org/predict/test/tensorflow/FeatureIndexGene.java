package org.predict.test.tensorflow;


import com.google.common.hash.Hashing;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.Charset;

/**
 * Created by huixu on 13/12/2016.
 */
public class FeatureIndexGene {
    private static final int MODULE = 11701211;

    public static int getIndex(String feature) {
        if (StringUtils.isEmpty(feature)) {
            return -1;
        }
        int hashValue = (Hashing.murmur3_32().hashBytes(feature.getBytes()).asInt() & 0x7FFFFFFF) % MODULE;
        if (hashValue == 0) {
            // 使index不为0
            hashValue = MODULE;
        }
        return hashValue + 500;
    }

    /**
     * All features need be putted into 10000-8388608 hashing size, 10000-1048576 is smaller.
     * so indexGenerator is Deprecated, it is better to use indexGenerator_8.
     *
     * @param feature
     * @return
     */
    @Deprecated
    public static int indexGenerator(String feature) {
        return (int) (Math.abs(Hashing.murmur3_128().newHasher().putString(feature, Charset.defaultCharset()).hash().asLong()) % Math.pow(2, 20)) + 10000;
    }

    public static int indexGenerator_8(String feature) {
        return (int) (Math.abs(Hashing.murmur3_128().newHasher().putString(feature, Charset.defaultCharset()).hash().asLong()) % Math.pow(2, 23)) + 10000;
    }

    public static int indexGeneratorOf2M_from_1M(String feature) {
        return (int) (Math.abs(Hashing.murmur3_128().newHasher().putString(feature, Charset.defaultCharset()).hash().asLong()) % Math.pow(2, 21)) + 1000000;
    }

    public static int indexGenerator(String feature, int range, int start) {
        return (int) (Math.abs(Hashing.murmur3_128().newHasher().putString(feature, Charset.defaultCharset()).hash().asLong()) % range) + start;
    }

    public static int indexGenerator(int value, int start) {
        return value + start;
    }
}