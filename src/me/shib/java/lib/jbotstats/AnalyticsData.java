package me.shib.java.lib.jbotstats;

import java.util.HashMap;
import java.util.Map;

public class AnalyticsData {

    private String methodName;
    private Object returned;
    private Map<String, Object> objectMap;

    public AnalyticsData(String methodName, Object returned) {
        this.methodName = methodName;
        this.returned = returned;
        objectMap = new HashMap<>();
    }

    public void setValue(String key, Object value) {
        objectMap.put(key, value);
    }

    public Object getValue(String key) {
        return objectMap.get(key);
    }

    public String getMethodName() {
        return methodName;
    }

    public Object getReturned() {
        return returned;
    }
}
