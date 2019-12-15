package org.predict.entity;

import java.util.Collections;
import java.util.List;
import java.util.Map;
 
public class ABInfo {

    private   Map<String, Object> abMap;

    private   List<Integer> bucketValues;
    

    public ABInfo(Map<String, Object> abMap) {
        this.abMap = abMap;
        this.bucketValues = Collections.emptyList();
    }

    public ABInfo(Map<String, Object> abMap, List<Integer> bucketValues) {
        this.abMap = abMap;
        this.bucketValues = bucketValues;
    }

    public Map<String, Object> getAbMap() {
        return abMap;
    }

    public List<Integer> getBucketValues() {
        return bucketValues;
    }
}
