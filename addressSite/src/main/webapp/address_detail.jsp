<%@page import="com.itwill.address.Address"%>
<%@page import="com.itwill.address.AddressService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/*
 * 요청URL
 *   http://localhost/addressSite/address_detail.jsp?no=45
 
 *  0.요청객체encoding설정
 *  1.no 파라메타받기
 *  2.AddressService객체생성
 *  3.AddressService객체 selectByNo(no) 메쏘드호출
 *  4.Address객체 출력
 */
 
 request.setCharacterEncoding("UTF-8");

String no = request.getParameter("no");
if(no==null || no.equals(""))
{response.sendRedirect("address_main.jsp");
return;	

}

AddressService addressService = new AddressService();
Address findAddress = addressService.addressDetail(Integer.parseInt(no));
if(findAddress == null) 
{response.sendRedirect("address_list.jsp");
return;	}
 
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>Insert title here</title>
</head>
<body>


<h1>[<%=findAddress.getName()%> 님 주소록상세보기]</h1><hr>
<div>
	<a href='address_main.jsp'>[메인]</a>
	<a href='address_insert_form.jsp'>[주소록쓰기폼]</a>
	<a href='address_list.jsp'>[주소록리스트]</a>
	
	<form action="address_update_form.jsp" method="post" style="display: inline;">
		<input type="hidden" name="no" value="11">
		<input type="submit" value="<%=findAddress.getName()%>님 주소록수정폼[POST]">	
	</form> 
	
	<form action='address_delete_action.jsp' method='post' style='display:inline;'>
		<input type='hidden' name='no' value='11'>
		<input type='submit' value='<%=findAddress.getName()%>님삭제[POST]'>
	</form>
</div>
<p>
	번호:<%=findAddress.getNo()%><br>
	이름:<%=findAddress.getName()%><br>
	전화:<%=findAddress.getPhone()%><br>
	주소:<%=findAddress.getAddress()%><br>
</p>
</body>
</html>