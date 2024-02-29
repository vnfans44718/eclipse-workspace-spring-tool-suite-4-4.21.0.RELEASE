<%@page import="com.itwill.guest.Guest"%>
<%@page import="com.itwill.guest.GuestService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
errorPage="error_404.jsp"
	pageEncoding="UTF-8"%>
<%
/*
 * 0.요청객체encoding설정
 * 1.gust_no 파라메타받기
 * 2.GuestService객체생성
 * 3.GuestService객체 selectByNo(guest_no) 메쏘드호출
 * 4.Guest 출력
 */

request.setCharacterEncoding("UTF-8");

String noStr = request.getParameter("guest_no");

if (noStr == null || noStr.equals("")) {
	response.sendRedirect("guest_list.jsp");
	return;
}

GuestService guestService = new GuestService();

Guest detailGuest = guestService.guestDetail(Integer.parseInt(noStr));

if (detailGuest == null) {
	out.println("<script>");
	out.println("alert('존재하지 않는 게시물입니다.');");
	out.println("location.href ='guest_list.jsp';");
	out.println("</script>");
	return;
}
//null 체크
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>방명록 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="css/guest.css">

<script src="js/guest.js"></script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
	<!-- container start-->
	<div id="container">
		<!-- header start -->
		<div id="header">
			<!-- include_common_top.jsp start-->
			<jsp:include page="include_common_top.jsp" />
			<!-- include_common_top.jsp end-->
		</div>
		<!-- header end -->
		<!-- navigation start-->
		<div id="navigation">
			<!-- include_common_left.jsp start-->
			<jsp:include page="include_common_left.jsp" />
			<!-- include_common_left.jsp end-->
		</div>
		<!-- navigation end-->
		<!-- wrapper content start -->
		<div id="wrapper">




			<div id="content">
				<table border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td>
							<!--contents--> <br />
							<table style="padding-left: 10px" border=0 cellpadding=0
								cellspacing=0>
								<tr>
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>방명록 관리
											- 방명록 상세보기</b></td>
								</tr>
							</table> <!-- view Form  -->
							<form name="f" method="post">
								<input type="hidden" name="guest_no"
									value="<%=detailGuest.getGuestNo()%>" />
								<table border="0" cellpadding="0" cellspacing="1" width="590"
									bgcolor="BBBBBB">
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">번호</td>
										<td width=490 bgcolor="ffffff" align="left"
											style="padding-left: 10px"><%=detailGuest.getGuestNo()%></td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">이름</td>
										<td width=490 bgcolor="ffffff" align="left"
											style="padding-left: 10px"><%=detailGuest.getGuestName()%></td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">날짜</td>
										<td width=490 bgcolor="ffffff" align="left"
											style="padding-left: 10px"><%=detailGuest.getGuestDate()%></td>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">홈페이지</td>
										<td width=490 bgcolor="ffffff" align="left"
											style="padding-left: 10px"><%=detailGuest.getGuestHomepage()%></td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">제목</td>
										<td width=490 bgcolor="ffffff" align="left"
											style="padding-left: 10px"><%=detailGuest.getGuestTitle()%></td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="110">내용</td>
										<td width=490 bgcolor="ffffff" align="left"
											style="padding-left: 10px"><%=detailGuest.getGuestContent()%></td>
									</tr>
								</table>
							</form> <br />
							<table width=590 border=0 cellpadding=0 cellspacing=0>
								<tr>
									<td align=center><input type="button" value="수정"
										onClick="guestModifyForm();"> &nbsp; <input
										type="button" value="삭제" onClick="guestRemove();">
										&nbsp; <input type="button" value="목록" onClick="guestList()"></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</div>


		</div>
		<!-- wrapper content end-->
		<!-- footer start-->
		<div id="footer">
			<!-- include_common_bottom.jsp start-->
			<jsp:include page="include_common_bottom.jsp" />
			<!-- include_common_bottom.jsp end-->
		</div>
		<!-- footer end -->
	</div>
	<!--container end-->
</body>
</html>
