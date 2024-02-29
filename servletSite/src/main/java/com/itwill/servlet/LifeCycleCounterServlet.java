package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
web.xml설정
<servlet>
	<servlet-name>annotation_mapping</servlet-name>
	<servlet-class>com.itwill.servlet.AnnotationMappingServlet</servlet-class>
</servlet>
<servlet-mapping>
	<servlet-name>annotation_mapping</servlet-name>
	<url-pattern>/annotation_mapping</url-pattern>
</servlet-mapping>
*/
/*
* web.xml대신에 annotation[@] 사용
*/

/*@WebServlet(urlPatterns = {"/lifecycle_counter","/lifecycle_counter.itwill"})
--> url 패턴이 2개 이상일 때 사용

*/
@WebServlet("/lifecycle_counter")
public class LifeCycleCounterServlet extends HttpServlet {
	
	private int count;
	
	//객체는 클래스가 변경되거나 서버가 다운되면 사라지고 다시 생성됨
	/*서비스 요청시 클래스가 메모리로 올라와 최초로 생성자가 한번 호출되며 객체 생성
	다음 요청 시에는 서비스 객체 바로 활용
	*/
	//운용 시에는 클래스 파일 변경되지 않음

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("1.init메소드--> 생성자 호출 직후에 단 한번 호출[객체 초기화, 리소스 획득]");
	}
	
	public LifeCycleCounterServlet() {
		System.out.println("0.LifeCycleCounterServlet 기본생성자[최초요청시에 단한번 호출] 객체주소: "+this);
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("2.service 메소드 실행[요청시마다 호출]");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body bgcolor=#40e0d0 style=\"font-size: 9pt; line-height: 140%;\">");
		out.println("	<center>");
		out.println("		현재까지의 페이지뷰수");
		out.println("<font color=#0000FF>");
		count++;
		out.println(count);
		out.println("</font> 번입니다");
		out.println("	</center>");
		out.println("</body>");
		out.println("</html>");
	}

	@Override
	public void destroy() {
		System.out.println("3.destroy apthem --> 서블릿객체가 메모리에서 해제되기 직전에 호출[리소스반납]");
	}
	
	
}
