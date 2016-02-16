package me.shib.java.lib.jbotstats;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AnalyticsData {

    private Date accessTime;
    private String methodName;
    private Map<String, Object> objectMap;
    private Object returned;
    private IOException ioException;

    public AnalyticsData(String methodName) {
        this.accessTime = new Date();
        this.methodName = methodName;
        this.objectMap = new HashMap<>();
        this.returned = null;
        this.ioException = null;
    }

    public void setValue(String key, Object value) {
        objectMap.put(key, value);
    }

    protected Date getAccessTime() {
        return this.accessTime;
    }

    public void setAccessTime(Date accessTime) {
        if (accessTime != null) {
            this.accessTime = accessTime;
        }
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

    public void setReturned(Object returned) {
        this.returned = returned;
    }

    protected IOException getIoException() {
        return ioException;
    }

    public void setIoException(IOException ioException) {
        this.ioException = ioException;
    }

    protected Map<String, Object> getObjectMap() {
        return objectMap;
    }
}
