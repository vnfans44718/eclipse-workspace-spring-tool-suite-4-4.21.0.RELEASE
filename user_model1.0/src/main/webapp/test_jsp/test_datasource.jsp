<%@page import="com.itwill.user.UserDao"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="java.util.Properties"%>
<%@page import="org.apache.tomcat.dbcp.dbcp2.BasicDataSource"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	/****************org.apache.tomcat.dbcp.dbcp2.BasicDataSource**********/
	BasicDataSource basicDataSource=new BasicDataSource();
	Properties properties=new Properties();
	/***************[jdbc.properties]***********************
	spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
	spring.datasource.url=jdbc:oracle:thin:@124.198.47.195:1521:xe
	spring.datasource.username=jdeveloper30
	spring.datasource.password=jdeveloper30
	**************************************************************/
	properties.load(UserDao.class.getResourceAsStream("/jdbc.properties"));
	basicDataSource.setDriverClassName(properties.getProperty("spring.datasource.driver-class-name"));
	basicDataSource.setUrl(properties.getProperty("spring.datasource.url"));
	basicDataSource.setUsername(properties.getProperty("spring.datasource.username"));
	basicDataSource.setPassword(properties.getProperty("spring.datasource.password"));
	
	
	/******************** << javax.sql.DataSource >> **************************/
	DataSource dataSource=basicDataSource;
	Connection con=dataSource.getConnection();
	System.out.println("1.DataSource : " + dataSource);
	System.out.println("2.Connection : " + con);
	basicDataSource.close();
	%>
	<ol>
		<li>DataSource :<%=dataSource%></li>
		<li>Connection :<%=con%></li>
	</ol>
</body>
</html>