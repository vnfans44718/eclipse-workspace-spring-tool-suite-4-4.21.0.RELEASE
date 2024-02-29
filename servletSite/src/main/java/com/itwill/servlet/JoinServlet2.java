package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/join2")
public class JoinServlet2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * GET 방식으로 요청이 들어오면 05-03.form2.html로 방향재지정 (redirection)
		 */
		response.sendRedirect("05-03.form2.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		/*
		 * 1.파라메타받기
		 */

		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String gender = request.getParameter("gender");
		String job = request.getParameter("job");
		String[] hobbys = request.getParameterValues("hobby");
		if (hobbys == null) {
			hobbys = new String[0];
		}

		/*
		 * 2.Service객체 가입메쏘드호출
		 */

		/*
		 * 3.클라이언트로 응답 출력
		 */

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Insert title here</title>");
		out.println("<style type='text/css'>");
		out.println("td, tr, th {");
		out.println("	border: 1px solid black;");
		out.println("}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<h3 align='center'>가입정보결과</h3>");
		out.println("<center><table width='50%'>");
		out.println("		<tr>");
		out.println("			<th width='30%'>항목</th>");
		out.println("			<th width='60%'>입력값</th>");
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<td>아이디</td>");
		out.printf("			<td>%s</td>", id);
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<td>패쓰워드</td>");
		out.printf("			<td>*d</td>", pass);
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<td>이름</td>");
		out.printf("			<td>%s</td>", name);
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<td>주소</td>");
		out.printf("			<td>%s</td>", addr);
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<td>성별</td>");
		out.println("			<td>남(여)</td>");
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<td>직업</td>");
		out.printf("			<td>%s</td>", job);
		out.println("		</tr>");

		out.println("		<tr>");
		out.println("			<td rowspan='" + hobbys.length + "'>취미</td>");
		out.printf("<td>%s</td>", hobbys[0]);

		for (int i = 1; i < hobbys.length; i++) {
			out.println("		</tr>");
			out.printf("<td>%s</td>", hobbys[i]);
			out.println("		</tr>");
		}

		out.println("	</table></center>");
		out.println("</body>");
		out.println("</html>");
	}
}