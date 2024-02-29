<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
<%for(int i=0;i<10;i++){%>		
		<h3>안녕 JSP[change]</h3>
		<hr/>
<%}%>
<jsp:include page="6-2.action_tag_included_footer.jsp"/>
</body>
</html>
