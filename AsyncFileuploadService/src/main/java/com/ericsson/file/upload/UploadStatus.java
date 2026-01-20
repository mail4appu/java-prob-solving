package com.ericsson.file.upload;

import java.util.HashMap;
import java.util.Map;

public class UploadStatus {
	public static volatile Map<String,Integer> statusMap= new HashMap<String, Integer>();
	String fileName;
	int status;

	public synchronized void updateUploadProgress(int percentage){
		statusMap.put(fileName, percentage);

	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public static Map<String, Integer> getMap(){
		synchronized (UploadStatus.class) {
			return statusMap;
		}
	}



}
