<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
/*
	0.요청객체 인코딩설정
*/
response.setContentType("text/html;charset=UTF-8");
/*
 * 1.요청시 전송되는 파라메타받기
 	 - 파라메타이름은 input element의 name속성의  값
 		<form action="4.get_login_result.jsp" method="get">
	아이디:<input type="text" name="id"><br/>
	패에쓰:<input type="password" name="pass"><br/><br/>
		</form>	
 */
String id = request.getParameter("id");
String pass = request.getParameter("pass");
if (id == null || pass == null || id.equals("") || pass.equals("")) {
	out.println("<h1>GET로그인 결과</h1><hr>");
	out.println("<h3>아이디,패쓰워드를 입력하세요</h3><hr>");
	out.println("<a href='4.login_get_form.jsp'>다시로그인</a>");
	return;
}
/*
 * 2.서비스객체를 사용해서 업무(로그인)실행
 *  id |pass
 *  ---------
 *  xxx|1111
 *  yyy|2222
 */
boolean isMember1 = id.equals("xxxx") && pass.equals("1111");
boolean isMember2 = id.equals("yyyy") && pass.equals("2222");

/*
 * 3.클라이언트로 출력
 */
out.println("<h1>GET로그인 결과</h1><hr>");
if (isMember1 || isMember2) {
	/***************case1*************
	out.println("<h3>"+id+"님 로그인 성공</h3>");
	out.println("<a href='index.jsp'>메인으로</a>");
	*/
	/***************case2*************/
	response.sendRedirect("index.jsp");
	/********************************/
} else {
	out.println("<h3>" + id + "님 로그인 실패</h3>");
	out.println("<a href='4.login_get_form.jsp'>다시로그인</a>");
}
%>
