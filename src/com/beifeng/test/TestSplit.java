package com.beifeng.test;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.InputSplit;

public class TestSplit extends InputSplit implements Writable{
    private int start=0;
    private int end=0;
    
    public TestSplit() {
		// TODO Auto-generated constructor stub
	}
    
	@Override
	public long getLength() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		return end-start+1;
	}

	@Override
	public String[] getLocations() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		return new String[]{"hadoop1","hadoop2"};
	}

	@Override
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		 out.writeInt(start);
		 out.writeInt(end);
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		this.start=in.readInt();
		this.end=in.readInt();
		
	}

	public TestSplit(int start, int end) {
	
		this.start = start;
		this.end = end;
		
	}
	
	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
}
