package com.beifeng.test;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WordCount {
	public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
       
        Job job = new Job(conf, "wordcount");
        job.setJarByClass(WordCount.class);
        job.setInputFormatClass(TextInputFormat.class);
        job.setMapperClass(TestMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        job.setReducerClass(TestReduce.class);
       
       
        FileOutputFormat.setOutputPath(job, new Path("01/"));
        System.exit(job.waitForCompletion(true)?0:1);
    } 
}
