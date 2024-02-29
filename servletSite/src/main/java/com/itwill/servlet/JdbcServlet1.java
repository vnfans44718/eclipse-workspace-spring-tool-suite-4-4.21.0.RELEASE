package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/jdbc1")
public class JdbcServlet1 extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			/***************** 데이타베이스접속정보 ***********/
			String driverClass = "oracle.jdbc.OracleDriver";
			String url = "jdbc:oracle:thin:@124.198.47.195:1521:xe";
			String user = "jdeveloper30";
			String password = "jdeveloper30";
			/*****************************************************/
			String selectSql = "select no,name,phone,address from address order by no";
			Class.forName(driverClass);
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(selectSql);

			out.println("<html>");
			out.println("<head>");
			out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"com.css\">");
			out.println("</head>");
			out.println("<body>");
			out.println("<br>");
			out.println("<p align=center><font size=5 color=#0000FF>◈◈ JDBC 테스트 1◈◈</font><br>");
			out.println(
					"<table width=80% align=center border=1 cellspacing=0 bordercolordark=white bordercolorlight=#ADADAD>");
			out.println("<tr bgcolor=#000000 class=t1>");
			out.println("<td align=center height=20 width=10%><font color=#FFFFFF>번호</font></td>");
			out.println("<td align=center height=20 width=25%><font color=#FFFFFF>이름</font></td>");
			out.println("<td align=center height=20 width=25%><font color=#FFFFFF>전화번호</font></td>");
			out.println("<td align=center height=20 width=50%><font color=#FFFFFF>주소</font></td>");
			out.println("</tr>");
			while (rs.next()) {
				out.println("<tr class=t1>");
				out.println("<td align=center width=10% height=20>"+rs.getString("no")+"</td>");
				out.println("<td align=center width=25% height=20>"+rs.getString("name")+"</td>");
				out.println("<td align=center width=25% height=20>"+rs.getString("phone")+"</td>");
				out.println("<td align=center width=25% height=20>"+rs.getString("address")+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</body>");
			out.println("</html> ");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
