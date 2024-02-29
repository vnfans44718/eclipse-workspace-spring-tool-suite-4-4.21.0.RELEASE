package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ServletThreadServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println(request.getRemoteAddr()+" 님의 요청에의해 "+request.getLocalAddr()+"[강사서버]에서 할당된쓰레드는 "+currentThreadName+  " 입니다.");
		System.out.println(request.getLocalAddr()+"[강사서버]에서 "+request.getRemoteAddr()+" 님의 부라우져로 응답합니다. ");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>서블릿쓰레드</title>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h5>ServletThreadServlet[Dynamic Resource]실행쓰레드</h5>");
		out.println("<hr>");
		out.println("현재실행쓰레드이름:"+currentThreadName+"<br>");
		out.println(request.getRemoteAddr()+" 님의 요청에의해 "+request.getLocalAddr()+"[강사서버]에서 할당된쓰레드는 "+currentThreadName+  " 입니다.<br>");
		out.println(request.getLocalAddr()+"[강사서버]에서 "+request.getRemoteAddr()+" 님의 부라우져로 응답합니다. ");
		out.println("</body>");
		out.println("</html>");
		
		
		return;
	}

}
