<%@page contentType="text/html; charset=UTF-8"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<TITLE>방가워요 JSP</TITLE>
<link rel="stylesheet" type="text/css" href="css/common.css">
</HEAD>
<BODY>
	<center>
		<H2>JSP 잘났어 정말 별꼴이야!!!!!!!!!</H2>
		
			<img src='tomcat.gif' />
				<H2>JSP구구단[스크립렛 &lt;% %&gt; ]</H2>
			<table border=1 width=600 bgcolor=#CCFF33  bordercolordark=#FF6600
				cellspacing=0>
			<%for(int i=1;i<=9;i++){ %>	
				<tr>
				<%
				 for(int j=2;j<=9;j++){ 
				%>	 
					 <td align=center><%out.print(j);%>*<%out.print(i);%>=<%out.print(j*i);%></td>
				 <%
				 }
				 %>	
				</tr>
			<%}%>	
			</table>
			<br/>
			<br/>
			<H2>JSP구구단[표현식 &lt;%= %&gt; ]</H2>
			<table border=1 width=600 bgcolor=#CCFF33  bordercolordark=#FF6600
				cellspacing=0>
			<%for(int i=1;i<=9;i++){ %>	
				<tr>
				<%
				 for(int j=2;j<=9;j++){ 
				%>	 
					 <td align=center><%=j%>*<%=i%>=<%=j*i%></td>
				<%
				 }
				 %>	
				</tr>
			<%}%>	
			</table>
	</center>		
			<br />
			<jsp:include page="6-2.action_tag_included_footer.jsp"/>
</BODY>
</HTML>
