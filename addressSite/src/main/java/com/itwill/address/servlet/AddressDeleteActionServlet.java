package com.itwill.address.servlet;

import java.io.IOException;

import com.itwill.address.AddressService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddressDeleteActionServlet
 */
@WebServlet("/address_delete_action")
public class AddressDeleteActionServlet extends HttpServlet {
	

	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 요청라인  GET /addressSite/address_delete_action?no=1 HTTP/1.1
		 요청헤더  ....
		 요청바디 없다
		 */
		/*
		 * 0.요청객체encoding설정
		 * 1.파라메타받기
		 * 2.AddressService객체생성
		 * 3.AddressService.addressDelete()메쏘드실행
		 * 4.클라이언트로 redirection 응답--> address_list 로 redirection
		 */
		

		
		try {
			request.setCharacterEncoding("UTF-8");
			String noStr = request.getParameter("no");
			AddressService addressService = new AddressService();
			int rowCount = addressService.addressDelete(Integer.parseInt(noStr));
			response.sendRedirect("address_list");
			
			
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
