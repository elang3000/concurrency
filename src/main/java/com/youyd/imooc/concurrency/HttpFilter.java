package com.youyd.imooc.concurrency;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.youyd.imooc.concurrency.test.threadlocal.RequestHolder;

public class HttpFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest=(HttpServletRequest)request;
//		httpRequest.getSession().getAttribute("user");
		System.out.println("do filter :" +Thread.currentThread().getId()+"path:" +httpRequest.getServletPath());
		RequestHolder.add(Thread.currentThread().getId());
		chain.doFilter(httpRequest, response);;
		
	}

	@Override
	public void destroy() {
		
	}
	
}
