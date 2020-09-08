package com.pw.bills.utils;

public class OnlineCounter {
	public static Integer count=0;
	public static synchronized Integer getCount() {
		return count;
	}
	public static synchronized void raise() {
		count++;
	}
	public static synchronized void reduce() {
		count--;
	}
}
