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


@WebServlet("/address_detail")
public class AddressDetailServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	try {
		
		/*
		 * 요청URL
		 *   http://localhost/addressSite/address_detail?no=1
		 *   http://localhost/addressSite/address_detail?no=2
		 *   http://localhost/addressSite/address_detail?no=3
		 *   http://localhost/addressSite/address_detail?no=4
		 *   http://localhost/addressSite/address_detail?no=5
		 */
		
		/*
		 * 0.요청객체encoding설정
		 * 1.파라메타받기
		 * 2.AddressService객체생성
		 * 3.AddressService객체 addressDetail(1) 메쏘드호출
		 * 4.Address객체 출력
		 */
		
		
		request.setCharacterEncoding("UTF-8");
		String noStr = request.getParameter("no");
		//get방식은 무조건 먼저 요청의 파라미터(PK)의 유효성체크를 해야함
		//addressDetail은 반드시 no가 필요합니다.
		//delete는 detail에서 해줘야한다
		if (noStr==null||noStr.equals("")) {
			response.sendRedirect("address_list");
			//addressList에 다시 요청이 감, 고객에게 url에 주고 클라이언트는 재요청
			return;
		}
		
		AddressService addressService = new AddressService();
		Address address = addressService.addressDetail(Integer.parseInt(noStr));
		if (address==null) {
			//get방식으로 url의 없는 no를 검색할 경우
			response.sendRedirect("address_list");
			
		}
		
		
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>[김경호님 주소록상세보기]</h1><hr>");
		out.println("<div>");
		//no 걸면 무조건 get방식이다
		
		
		out.println("	<a href='address_insert_form'>[주소록쓰기폼]</a>");
		out.println("	<a href='address_list'>[주소록리스트]</a>");
		out.println("	<a href='address_delete_action?no=" + address.getNo() + "'>" + address.getName()
		+ "님삭제[GET]</a>");
		

		out.println("<form action='address_delete_action' method='post'  style='display: inline;'>");
		out.println("<input type='hidden' name='no' value='"+address.getNo()+">");
		out.println("<input type='submit' value='"+address.getName()+"[POST]'>");
		out.println("</form>");

		out.println("	<a href='address_update_form?no="+address.getNo()+"'>[" + address.getName() + "님 주소록수정폼(GET)]</a>");
		
		
		
		out.println("</div>");
		out.println("<p>");
		out.println("	번호:"+address.getNo()+"<br>");
		out.println("	이름:"+address.getName()+"<br>");
		out.println("	전화:"+address.getPhone()+"<br>");
		out.println("	주소:"+address.getAddress()+"<br>");
		out.println("</p>");
		out.println("</body>");
		out.println("</html>");
		
	} catch (Exception e) {
		e.printStackTrace();
		response.sendRedirect("address_error.html");
	}
	
	

}
	
	
}
