<%@page import="com.itwill.guest.Guest"%>
<%@page import="com.itwill.guest.GuestService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
	  GET방식이면 guest_main.jsp redirection
	    
	  0.요청객체encoding설정
	  1.파라메타받기(guest_name,guest_email,guest_homepage,guest_title,guest_content)
	     Guest객체생성
	  2.GuestService객체생성
	  3.GuestService객체 insertGuest(Guest객체) 메쏘드호출
	  4.guest_list.jsp로 redirection
	 */
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("guest_main.jsp");
		return;
	}
	String guest_name=request.getParameter("guest_name");
	String guest_email=request.getParameter("guest_email");
	String guest_homepage=request.getParameter("guest_homepage");
	String guest_title=request.getParameter("guest_title");
	String guest_content=request.getParameter("guest_content");
	GuestService guestService=new GuestService();
	int guest_no=guestService.guestWrite(Guest.builder()
							.guestName(guest_name)
							.guestEmail(guest_email)
							.guestHomepage(guest_homepage)
							.guestTitle(guest_title)
							.guestContent(guest_content)
							.build()
			);
	
	response.sendRedirect("guest_view.jsp?guest_no="+guest_no);
%>










