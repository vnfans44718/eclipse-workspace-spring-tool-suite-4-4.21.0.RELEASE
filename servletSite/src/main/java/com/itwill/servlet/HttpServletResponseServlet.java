package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/response")
public class HttpServletResponseServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		String cmd = request.getParameter("cmd");
		if (cmd==null || cmd.equals("")) {
			/*******case1**********/
			/*out.println("<h1>다시요청하세요</h1><hr>");
			out.println("<a href='04.HttpServletResponse.html'>04.HttpServletResponse.html</a>");
			/*******case1**********/
			response.sendRedirect("04.HttpServletResponse.html");
			
			
			return;
			
		}
		if (cmd.equals("1")) {
			/*
			 정상응답
			 1. 응답라인 상태코드 200
			 2. 응답헤더 
			 3. 응답바디 데이터 전송
			 */
			out.println("<h3>정상응답<h3><hr>");
			
		}else if (cmd.equals("2")) {
			/*
			 에러응답
			 1. 응답라인 상태코드 4xx, 5xx
			 2. 응답헤더 
			 3. 응답바디 데이터 없음
			 */
			//response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "페이지를 찾을 수 없습니다.");
			
		}else if (cmd.equals("3")) {
			/*
			 redirect[방향재지정]응답
			 1. 응답라인 상태코드 302
			 2. 응답헤더[Location:05-03.form1.html(redirection url)이 포함] 
			 3. 응답바디 데이터 없음(보낼수없음)
			 */
			// 302는 두번의 응답과 요청이 있음 ex)로그인 성공과 동시에 메인페이지로 이동 --유저의 별다른 액션없이
			//리다이렉션은 바디 없음
			response.sendRedirect("./index.html");
			
			
			
			
		}
		
		
		
	}

}
