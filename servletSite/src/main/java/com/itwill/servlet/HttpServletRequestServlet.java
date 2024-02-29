package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/request")
public class HttpServletRequestServlet extends HttpServlet {
	
	
	//protected 범위를 좁게하면 재정의 위반
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		/***
		[ query string ]
				- 정의  : HTTP요청시 클라이언트가 서버로 요청시데이타를 전송하는형식 
		  		- 형식  : name1=value1&name2=value2
		  		- 요청예: name=kim&phone=1234&address=seoul
	  
			  1.GET  요청방식 : request.do?name=kim&phone=1234&address=seoul
			    
			    - 클라이언트요청URL : http://192.168.15.31/servletSite/request?name=kim&phone=1234&address=seoul
			    
	                	            -----------------------------------------------------------------
	             		요청라인    |GET request.do?name=kim&phone=1234&address=kyunggi HTTP/1.1    |
	             		요청헤더    |HOST:192.168.15.31                                             |
	             		.......     |...                                                            |
	                	            |---------------------------------------------------------------|
	             		요청바디    |없다                                                           |
	             		            -----------------------------------------------------------------
			    
			  2.POST 요청방식 : request.do  
			  
			    - 클라이언트요청URL : http://192.168.15.31/servletSite/request.do

	                	            -----------------------------------------------------------------
	             		요청라인    |POST request.do HTTP/1.1                                       |
	             		요청헤더    |HOST:192.168.15.31                                             |
	             		.......     |...                                                            |
	                	            |---------------------------------------------------------------|
	             		요청바디    |name=kim&phone=1234&address=kyunggi                            |
	             		            -----------------------------------------------------------------		    

			**/	
		
		/*
		 클라이언트요청URL : http://192.168.15.31/servletSite/request?name=kim&phone=1234&address=seoul
		 */
		
		String method=request.getMethod();
		String url=request.getRequestURL().toString();
		String uri=request.getRequestURI();
		String contextPath = request.getContextPath();
		String remoteAddress = request.getRemoteAddr();
		String queryString = request.getQueryString();
		
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		
		
		
		out.println("<h1>HttpServletRequest객체</h1><hr>");
		out.println("<ol>");
		out.println("<li>요청메소드:"+method+"</li>");
		out.println("<li>요청URL:"+url+"</li>");
		out.println("<li>요청URI:"+uri+"</li>");
		out.println("<li>contextPath:"+contextPath+"</li>");
		out.println("<li>remoteAddress:"+remoteAddress+"</li>");
		out.println("<li>요청시 전송된 파라미터</li>");
		out.println("<li>name 파라미터:"+name+"</li>");
		out.println("<li>phone 파라미터:"+phone+"</li>");
		out.println("<li>address 파라미터:"+address+"</li>");
		out.println("<li>queryString:"+queryString+"</li>");
		out.println("</ol>");
		
		
		
	}

}
