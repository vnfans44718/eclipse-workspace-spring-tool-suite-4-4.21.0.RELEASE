<%@page contentType="text/html; charset=UTF-8"  %>
<%!
int count=0;
public void jspInit(){
	System.out.println("1.init메쏘드-->생성자호출직후에 단한번호출[객체초기화,리소스획득]");
	System.out.println("1.init메쏘드-->생성자호출직후에 단한번호출[객체초기화,리소스획득]");
}
public void jspDestroy(){
	System.out.println("3.destroy메쏘드-->서블릿객체가 메모리에서 해제되기직전에 호출[리소스반납]");
}
%>
<%
System.out.println("2.service 메쏘드 실행[요청시마다호출]:"+this);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/common.css">
</head>
			<body bgcolor=#40e0d0 style=font-size:9pt;line-height:140%;> 
			<center>			
			 현재까지의 페이지뷰수
			<font color=#0000FF>
			<%--
				out.println(++count);
			--%>
			<%= ++count %>
			</font>
			 입니다 
			</center>
			<jsp:include page="6-2.action_tag_included_footer.jsp"/> 
			</body> 
</html> 
