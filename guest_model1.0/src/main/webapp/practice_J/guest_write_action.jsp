<%@page import="java.util.Date"%>
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

if (request.getMethod().equalsIgnoreCase("GET")) {
	response.sendRedirect("guest_main.jsp");
	return;

}

request.setCharacterEncoding("UTF-8");

String gName = request.getParameter("guest_name");
String gEmail = request.getParameter("guest_email");
String gHomepage = request.getParameter("guest_homepage");
String gTitle = request.getParameter("guest_title");
String gContent = request.getParameter("guest_content");

Date date = new Date();

Guest insertGuest = new Guest(0, gName, date, gEmail, gHomepage, gTitle, gContent);

GuestService guestService = new GuestService();

int findGuestNo = guestService.guestWrite(insertGuest);

response.sendRedirect("guest_view.jsp?guest_no="+findGuestNo);
%>