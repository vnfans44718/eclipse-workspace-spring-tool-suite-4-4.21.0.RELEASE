<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h1>[주소록쓰기폼]</h1><hr>
<hr>
	<div>
		<a href='address_list'>주소록리스트</a>
	</div>
	<form method="post" action="address_insert_action_p">
		
		이름----<input type="text" name="name"><br> 
		전화번호<input type="text" name="phone"><br> 
		주소----<input type="text" name="address"><br> 
		<input type="submit" value="주소록쓰기">
		<input type="reset" value="주소록쓰기폼지우기">
	</form>
</body>
</html>




