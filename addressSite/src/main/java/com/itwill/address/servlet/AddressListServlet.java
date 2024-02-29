package com.itwill.address.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.itwill.address.Address;
import com.itwill.address.AddressService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/address_list")
public class AddressListServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
	PrintWriter out = response.getWriter();
	
	try {
		AddressService addressService = new AddressService();
		List<Address> addresses=addressService.addressList();
		
		
	
	out.println("<!DOCTYPE html>");
	out.println("<html>");
	out.println("<head>");
	out.println("<meta charset='UTF-8'>");
	out.println("<title>Insert title here</title>");
	out.println("</head>");
	out.println("<body>");
	out.println("<h1>[주소록리스트]</h1><hr>");
	out.println("<div>");
	out.println("	<a href='address_insert_form'>[주소록쓰기폼]</a>");
	out.println("</div>");
	out.println("<div>");
	out.println("	<ul>");
	
	for (Address address : addresses) {
		out.printf("<li><a href='address_detail?no=%d'>[%d]%s</a></li>",address.getNo(),address.getNo(),address.getName());
		//[%d]%s 클릭하면 address_detail?no=%d로 이동
		
	}
	
	out.println("	</ul>");
	out.println("</div>");
	out.println("</body>");
	out.println("</html>");
	
	
	} catch (Exception e) {
		e.printStackTrace();
	}
}
	
	
}
