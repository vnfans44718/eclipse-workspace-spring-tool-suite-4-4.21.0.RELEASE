package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.itwill.address.Address;
import com.itwill.address.AddressService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/jdbc2")
public class JdbcServlet2 extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//재정의 위반때문에 try catch도 해줌
		try {
			/*
			 1. Service객체생성
			 */
			AddressService addressService = new AddressService();
			
			
			/*
			 2. Service객체 메소드 실행
			 */
			List<Address> addressList = addressService.addressList();
			
			
			/*
			 3. 클라이언트로 출력
			 */
			
			
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
			out.println("<p align=center><font size=5 color=#0000FF>◈◈ JDBC 테스트 2◈◈</font><br>");
			out.println(
					"<table width=80% align=center border=1 cellspacing=0 bordercolordark=white bordercolorlight=#ADADAD>");
			out.println("<tr bgcolor=#000000 class=t1>");
			out.println("<td align=center height=20 width=10%><font color=#FFFFFF>번호</font></td>");
			out.println("<td align=center height=20 width=25%><font color=#FFFFFF>이름</font></td>");
			out.println("<td align=center height=20 width=25%><font color=#FFFFFF>전화번호</font></td>");
			out.println("<td align=center height=20 width=50%><font color=#FFFFFF>주소</font></td>");
			out.println("</tr>");
			
			for (Address address: addressList) {
				out.println("<tr class=t1>");
				out.println("<td align=center width=10% height=20>"+address.getNo()+"</td>");
				out.println("<td align=center width=25% height=20>"+address.getName()+"</td>");
				out.println("<td align=center width=25% height=20>"+address.getPhone()+"</td>");
				out.println("<td align=center width=25% height=20>"+address.getAddress()+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</body>");
			out.println("</html> ");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//end service

}
