package com.itwill.address.servlet;

import java.io.IOException;

import com.itwill.address.Address;
import com.itwill.address.AddressService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddressInsertActionServlet
 */
@WebServlet("/address_insert_action")
public class AddressInsertActionServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("address_main");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			/*
			 * 0.요청객체encoding설정
			 * 1.파라메타받기
			 * 2.AddressService객체생성
			 * 3.AddressService.addressWrite()메쏘드실행
			 * 4.address_list 로 redirection
			 */
			request.setCharacterEncoding("UTF-8");
			String name=request.getParameter("name");
			String phone=request.getParameter("phone");
			String address=request.getParameter("address");
			
			AddressService addressService = new AddressService();
			int insertRowCount = addressService.addressWrite(new Address(0, name, phone, address));
			response.sendRedirect("address_list");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("address_error.html");
		}

	}

}
