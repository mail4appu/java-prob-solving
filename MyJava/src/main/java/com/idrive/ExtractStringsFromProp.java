package com.idrive;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

public class ExtractStringsFromProp {
	public static void main(String[] args) {

		try {
			getClassPath();
			//System.out.println("*****"+ExtractStringsFromProp.class.getClass().);
			//BufferedReader br= new BufferedReader(new InputStreamReader(ExtractStringsFromProp.class.getClassLoader().getResourceAsStream("messages_en.properties")));
			BufferedReader br= new BufferedReader(new InputStreamReader( new FileInputStream(new File("/home/Test/workspace/MyJava/src/messages_en.properties"))));
			BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(new FileOutputStream("result.txt") ));
			String line="";
			int count=0;
			Map<String,Integer> keysNOccu=new HashMap<String, Integer>();
			while((line=br.readLine())!=null){
				if(!line.equals("") && line.contains("=")){
					
					String reqLines[]=line.split("=");
					if(reqLines[0]!=null)
					checkForDuplicateKeys(reqLines[0],keysNOccu);
					if(reqLines[1]!=null){
						writeToFile(reqLines[1], bw, ++count);
					}
				}

			}
			System.out.println("Final map is\n"+keysNOccu);
			bw.close();
			br.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}

	private static void writeToFile(String line, BufferedWriter writer, int count){
		try {
			if(line!=null){
				writer.write(count+").  "+ line+"\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void getClassPath(){
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		 
        URL[] urls = ((URLClassLoader)cl).getURLs();
 
        for(URL url: urls){
        	System.out.println(url.getFile());
        }
 
	}

private static void checkForDuplicateKeys(String key, Map<String, Integer> keysNOccu ){
	 if(keysNOccu.containsKey(key)){
		 keysNOccu.put(key, keysNOccu.get(key)+1);
		 
	 }else{
		 keysNOccu.put(key, 1);
	 }
	
	
}



}
