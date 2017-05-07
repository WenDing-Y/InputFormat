package com.beifeng.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;

public class TestReader  extends RecordReader<IntWritable, Text>{
    private TestSplit testsplit;
    private int start;     //记录的开始
    private int end;       //记录的结束 
    private IntWritable key=new IntWritable();  //返回的key
    private Text value=new Text();              //返回的value
    private Map<Integer, String> map=new HashMap<>();
	@Override
	public void initialize(InputSplit split, TaskAttemptContext context) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		testsplit=(TestSplit) split;
		start=testsplit.getStart();  
		end=testsplit.getEnd();
		map=TestText.getText();  //得到文件信息
	}

	@Override
	public boolean nextKeyValue() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
	  if (start<=end) {
		key.set(start);            //设置key和value
		value.set(map.get(start));
		start++;
		return true;
	}
	  else
		  return false;
	}

	@Override
	public IntWritable getCurrentKey() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		return key;
	}

	@Override
	public Text getCurrentValue() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		return value;
	}
    
	
	//后面两个方法可以不用实现
	@Override
	public float getProgress() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
