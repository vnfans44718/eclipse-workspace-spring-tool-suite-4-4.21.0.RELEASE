package com.itwill.address.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.itwill.address.Address;
import com.itwill.address.AddressService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/address_update_form")
public class AddressUpdateFormServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			
			/*
			 * 1.파라메타받기
			 * 2.AddressService객체생성
			 * 3.AddressService객체 addressDetail(1) 메쏘드호출 <-- 수정을 하기 위해서
			 * 4.반환받은 Address객체를 사용해서 클라이언트로 응답(수정폼 보여주기)
			 */
			
			
			request.setCharacterEncoding("UTF-8");
			String noStr = request.getParameter("no");
			if (noStr==null || noStr.equals("")) {
				response.sendRedirect("address_main");
				return;
			}
			
			AddressService addressService = new AddressService();
			Address address = addressService.addressDetail(Integer.parseInt(noStr));
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='UTF-8'>");
			out.println("<title>Insert title here</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>[김경호님 주소록 수정폼]</h1><hr>");
			out.println("<hr>");
			out.println("	<div>");
			out.println("		<a href='address_list'>[주소록리스트]</a>");
			out.println("	</div>");
			out.println("	<form method='post' action='address_update_action'>");
			out.println("	번호---"+address.getNo()+"<br>");
			out.println("		<input type='hidden' name='no' value='"+address.getNo()+"'> ");
			out.println("		이름----<input type='text' name='name' value='"+address.getName()+"'><br>");
			out.println("		전화번호<input type='text' name='phone' value='"+address.getPhone()+"'><br>");
			out.println("		주소----<input type='text' name='address' value='"+address.getAddress()+"'><br> ");
			out.println("		<input type='submit' value='주소록수정'>");
			out.println("		<input type='reset' value='주소록수정폼지우기'>");
			out.println("	</form>");
			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
