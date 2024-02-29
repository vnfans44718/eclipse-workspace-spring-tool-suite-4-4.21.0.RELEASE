<%@page import="com.itwill.shop.cart.CartService"%>
<%@page import="com.itwill.shop.order.Order"%>
<%@page import="com.itwill.shop.order.OrderService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="login_check.jspf" %>    
<%
	/*
	주문생성
	*/
   	if(request.getMethod().equalsIgnoreCase("GET")){
   		response.sendRedirect("shop_main.jsp");
   		return;
   	}
	String buyType = request.getParameter("buyType");
	if (buyType == null)
		buyType = "";
	
	Order order=(Order)session.getAttribute("order");
	if(order==null){
		response.sendRedirect("shop_main.jsp");
		return;
	}
	String[] cart_item_noStr_array=(String[])session.getAttribute("cart_item_noStr_array");
	if(cart_item_noStr_array==null){
		cart_item_noStr_array=new String[]{};
	}
	
	OrderService orderService=new OrderService();
	if (buyType.equals("cart")) {
		orderService.create(order);		
	}else if(buyType.equals("cart_select")){
		orderService.create(order,cart_item_noStr_array);
	}else if(buyType.equals("direct")){
		orderService.create(order,cart_item_noStr_array);
	}

	response.sendRedirect("order_list.jsp");
    %>