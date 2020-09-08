package com.pw.bills.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pw.bills.pojo.Bills;

public class Test11 {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		BillsExprot<Bills> bills = new BillsExprot<>();
		
		List<Bills> a = new ArrayList<>();
		for(int i = 0 ; i < 5 ; i++) {
			
			a.add(new Bills(i, "标题"+i, 100+i, new Date(), "备注"+i));
			
		}
		/* bills.getId(a); */

		
		
		
	}
}
