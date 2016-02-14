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

    protected Object getValue(String key) {
        return objectMap.get(key);
    }

    protected String getMethodName() {
        return methodName;
    }

    protected Object getReturned() {
        return returned;
    }

    protected Map<String, Object> getObjectMap() {
        return objectMap;
    }
}
