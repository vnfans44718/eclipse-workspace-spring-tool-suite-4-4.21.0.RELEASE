<%@page import="com.itwill.guest.Guest"%>
<%@page import="java.util.List"%>
<%@page import="com.itwill.guest.GuestService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	GuestService guestService=new GuestService();
	List<Guest> guestList=guestService.guestList();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
	<%for(Guest guest:guestList){ %>
	<li><%=guest %></li>
	<%} %>
</ul>
</body>
</html>