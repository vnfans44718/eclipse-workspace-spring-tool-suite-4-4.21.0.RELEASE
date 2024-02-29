<%@page import="java.net.URLEncoder"%>
<%@page import="com.itwill.user.User"%>
<%@page import="com.itwill.user.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
/*
	0  . GET방식요청일때 user_main.jsp로 redirection
	1  . 요청객체 인코딩설정
    2  . 파라메타 받기
    3  . UserService객체생성
    4  . UserService.create() 메쏘드실행
    5-1. 아이디중복이면 user_write_form.jsp  
    5-2. 가입성공이면   user_login_form.jsp 로 redierction
*/
if (request.getMethod().equalsIgnoreCase("GET")) {
	response.sendRedirect("user.main.jsp");
	return;

}

String userid = request.getParameter("userId");
String password = request.getParameter("password");
String name = request.getParameter("name");
String email = request.getParameter("email");

User user = User.builder().userid(userid).name(name).password(password).email(email).build();

UserService userService = new UserService();


int result = userService.create(user);
if (result == -1) {
	/*######### 아이디 중복 ########## */
	String msg = userid + " 는 이미 존재하는 아이디입니다.";
	/********** case1 script *********/
	out.println("<script>");
	out.println("alert('"+msg+"');");
	out.println("location.href='user_write_form.jsp';");
	out.println("</script>");

	/********** case2 redirect *********/
	/********** case3 forward *********/

} else if (result == 1) {
	response.sendRedirect("user_login_form.jsp");
}
%>
