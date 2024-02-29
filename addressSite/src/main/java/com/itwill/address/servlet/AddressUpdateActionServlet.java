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
 * Servlet implementation class AddressDeleteActionServlet
 */
@WebServlet("/address_update_action")
public class AddressUpdateActionServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.sendError(403, "누구야");
		response.sendRedirect("address_main");;
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 요청라인  GET /addressSite/address_delete_action?no=1 HTTP/1.1
		 요청헤더  ....
		 요청바디 없다
		 */
		/*
		 * 0.요청객체encoding설정
		 * 1.파라메타받기(no,name,phone,address)
		 * 2.파라미터 데이터로 AddressService객체생성
		 * 3.AddressService 객체 생성
		 * 3.AddressService.update()메쏘드실행
		 * 4.클라이언트로 redirection 응답--> address_list 로 redirection
		 * 5-1. address_detail?no=로 redirection
		 * 5-2. address_list로 redirection
		 */

		try {
			request.setCharacterEncoding("UTF-8");
			String noStr = request.getParameter("no");
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			Address updateAddress = new Address(Integer.parseInt(noStr), name, phone, address);

			AddressService addressService = new AddressService();
			int updateRowCount = addressService.addressUpdate(updateAddress);

			response.sendRedirect("address_detail?no=" + noStr);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
