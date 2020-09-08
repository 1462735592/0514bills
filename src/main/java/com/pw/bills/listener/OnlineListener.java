package com.pw.bills.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.catalina.SessionEvent;
import org.apache.catalina.SessionListener;

import com.pw.bills.utils.OnlineCounter;

public class OnlineListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		OnlineCounter.raise();
		session.setAttribute("count", OnlineCounter.getCount());
	
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		OnlineCounter.reduce();
		session.setAttribute("count", OnlineCounter.getCount());
		
	}
	
}
