package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/post_login")
public class PostLoginServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect("05-02.login_post.html");
		response.sendError(403);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*if (request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("GET방식요청");
		}else {
			System.out.println("POST방식요청");
		}*/
		//post방식은 반드시 폼을 사용하여 요청해야함, get방식은 url로 가능
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		/*
		 * 1.요청시 전송되는 파라메타받기
		 	 - 파라메타이름은 input element의 name속성의  값
		 		<form action="get_login" method="get">
					아이디:<input type="text" name="id"><br/>
					패에쓰:<input type="password" name="pass"><br/><br/>
				</form>	
		 */
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		if (id==null ||pass==null || id.equals("")|| pass.equals("")) {
			out.println("<h1>POST로그인 결과</h1><hr>");
			out.println("<h3>아이디 패스워드 다시</h3><hr>");
			
			out.println("<a href ='05-02.login_post.html'>다시 로그인</a>");
			return;
		}
		
		
		
		/*
		 * 2.서비스객체를 사용해서 업무(로그인)실행
		 * ----------
		 *  id | pass
		 * ----------
		 * xxxx|1111
		 * ----------
		 * yyyy|2222
		 * ----------
		 */
		
		boolean isMember1 = id.equals("xxxx") && pass.equals("1111");
		boolean isMember2 = id.equals("yyyy") && pass.equals("2222");
		
		
		/*
		 * 3.클라이언트로 출력
		 */
		
		out.println("<h1>POST로그인 결과</h1><hr>");
		if (isMember1 || isMember2) {
			out.println("<h3>"+id+"님 로그인 성공</h3>");
			out.println("<a href ='index.html'>메인으로</a>");
			
		}else {
			out.println("<h3>"+id+"님 로그인 실패</h3>");
			out.println("<a href ='05-02.login_post.html'>다시 로그인</a>");
			
		}
		
		
	}
}
