package com.beifeng.test;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TestMapper  extends Mapper<IntWritable, Text, Text, IntWritable>{

	private final static IntWritable one = new IntWritable(1);  
    private Text word = new Text();  
	@Override
	public void map(IntWritable key, Text value, Context context)
			throws IOException, InterruptedException {
	
		// TODO Auto-generated method stub
		  String line = value.toString();  
	        StringTokenizer st = new StringTokenizer(line," ");  
	          
	        while(st.hasMoreTokens()){  
	            word.set(st.nextToken()); 
	        
	            context.write(word,one);  
	           
	        }  
	}
  
}
