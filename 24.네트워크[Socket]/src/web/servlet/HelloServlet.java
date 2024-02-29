package web.servlet;

import java.io.PrintWriter;

public class HelloServlet {
	public void service(PrintWriter out) {
		out.println("<h1>Hello Tutor Servlet!!!!!</h1><hr>");
	}
}
