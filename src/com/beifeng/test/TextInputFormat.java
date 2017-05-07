package com.beifeng.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputFormat;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.JobContext;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;

public class TextInputFormat  extends InputFormat<IntWritable, Text>{

	@Override
	public List<InputSplit> getSplits(JobContext context) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		ArrayList<InputSplit> arrayList=new ArrayList<>();
		TestSplit testSplit=new TestSplit(1, 3);
		TestSplit testSplit2=new TestSplit(4, 6);
		arrayList.add(testSplit);
		arrayList.add(testSplit2);
		return arrayList;
	}

	@Override
	public RecordReader<IntWritable, Text> createRecordReader(InputSplit split, TaskAttemptContext context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		return new TestReader();
	}
  
}
