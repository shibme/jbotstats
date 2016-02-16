package me.shib.java.lib.jbotstats;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AnalyticsData {

    private String methodName;
    private Object returned;
    private IOException ioException;
    private Map<String, Object> objectMap;

    public AnalyticsData(String methodName, Object returned, IOException ioException) {
        this.methodName = methodName;
        this.returned = returned;
        this.ioException = ioException;
        this.objectMap = new HashMap<>();
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

    protected IOException getIoException() {
        return ioException;
    }

    protected Map<String, Object> getObjectMap() {
        return objectMap;
    }
}
