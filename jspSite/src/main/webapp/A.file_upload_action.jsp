<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("A.file_upload_form.jsp");
		return;
	}
	/*
	file upload component사용
	 - MultipartRequest(javax.servlet.http.HttpServletRequest request,
			 			java.lang.String saveDirectory,
			 			int maxPostSize, 
			 			java.lang.String encoding)
	 
	 - MultipartRequest(javax.servlet.http.HttpServletRequest request,
			 			java.lang.String saveDirectory,
			 			int maxPostSize, 
			 			java.lang.String encoding, 
			 			FileRenamePolicy policy)
	 */
	 
	/* String saveDirectory=application.getRealPath("/upload");
	int maxPostSize=1024*1024*100;
	String encoding="UTF-8";
	DefaultFileRenamePolicy defaultFileRenamePolicy=new DefaultFileRenamePolicy();
    MultipartRequest multipartRequest=
    		new MultipartRequest(request,saveDirectory,maxPostSize,encoding,defaultFileRenamePolicy);
    		 */
%>
<h1>Upload Data</h1>
<hr/>
<ul>

</ul>

