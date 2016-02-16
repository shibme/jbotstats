package me.shib.java.lib.jbotstats;

import java.util.LinkedList;
import java.util.Queue;

public class AnalyticsWorker {

    private JBotStats jBotStats;
    private Queue<AnalyticsData> analyticsDataQueue;
    private AnalyticsProcessingThread analyticsProcessingThread;

    public AnalyticsWorker(JBotStats jBotStats) {
        this.jBotStats = jBotStats;
        this.analyticsDataQueue = new LinkedList<>();
    }

    private synchronized void startAnalyticsProcessingThread() {
        if ((analyticsProcessingThread == null) || (!analyticsProcessingThread.isAlive())) {
            analyticsProcessingThread = new AnalyticsProcessingThread(jBotStats, analyticsDataQueue);
            analyticsProcessingThread.start();
        }
    }

    public void putData(AnalyticsData analyticsData) {
        analyticsDataQueue.add(analyticsData);
        startAnalyticsProcessingThread();
    }

}
