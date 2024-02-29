<%@page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>upload stream data view</h1><hr>
<xmp>    
<%
	InputStream in = request.getInputStream();
	while(true){
		int readByte=in.read();
		if(readByte== -1)break;
		out.write(readByte);
		System.out.print((char)readByte);
	}
	out.flush();
%>
</xmp>