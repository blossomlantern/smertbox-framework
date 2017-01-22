package com.smertbox.security.log.model;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LogQueue {
	private Queue<SysLog> logQueue;
	
	public LogQueue(ConcurrentLinkedQueue<SysLog> conLogQueue){
		this.logQueue = conLogQueue;
	}

	public Queue<SysLog> getLogQueue() {
		return logQueue;
	}

	public void setLogQueue(Queue<SysLog> logQueue) {
		this.logQueue = logQueue;
	}
	
	public void clear() {
		this.logQueue.clear();
		this.logQueue = null;
	}
	
	public int size() {
		return this.logQueue != null ? this.logQueue.size() : 0;
	}

	public boolean add(SysLog log) {
		return this.logQueue.add(log);
	}
}
