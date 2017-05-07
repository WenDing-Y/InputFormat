package com.beifeng.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestText {

	public  static Map<Integer, String> getText() {
		 Map<Integer, String> map=new HashMap();
		    File file = new File("D:/Test.txt");  
	        BufferedReader reader = null;  
	        try {  
	            reader = new BufferedReader(new FileReader(file));  
	            String tempString = null;  
	            int line = 1;  
	            while ((tempString = reader.readLine()) != null) {  
	            	map.put(line, tempString);
	                line++;  
	            }  
	            reader.close();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        } finally {   	
	            if (reader != null) {  
	                try {  
	                    reader.close();  
	                } catch (IOException e1) {  
	                }  
	            } 
	            return map;
	        }  
	}
	

}
