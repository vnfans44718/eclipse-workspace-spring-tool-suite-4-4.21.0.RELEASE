<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	/*
	 * 1.요청객체를사용해서 요청시 전송되는 쿼리스트링에 있는 파라메타받기
	 *    - 파라메타이름은 input element의 name속성과일치
	 *       <input type="text" name="searchkeyword">
	 *    - search?searchkeyword=java   
	 */
 	String searchKeyword=request.getParameter("searchkeyword");
 	if(searchKeyword==null || searchKeyword.equals("")){
 		out.println("검색어를 입력하지 않은 경우 재미있는 지식 결과를 랜덤하게 보여드립니다.<br>");
		out.println("<a href='4.search_form.jsp'>검색페이지</a> ");
		return;
 	}
 	/*
	 * 2.검색업무실행 -->Service객체사용
	 */
	/*
	 * 3.클라이언트로 검색결과 전송
	 */
 %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%out.println(searchKeyword); %> 검색결과</h1><hr>
	<ol>
	<%
		int searchResultCount = (int)(Math.random()*10);
	%>
	<%for(int i=0;i<searchResultCount;i++){ %>
		<li><% out.println(searchKeyword); %> 의 검색결과</li>
	<%}%>
	</ol>
	<a href='4.search_form.jsp'>다시검색</a>
</body>
</html>











