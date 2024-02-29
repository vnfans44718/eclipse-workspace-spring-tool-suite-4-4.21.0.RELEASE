package com.itwill.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/response_image")
public class MIMETypeImageResponseServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 응답객체에 MIME타입 설정
		 */
		response.setContentType("image/jpeg");
		OutputStream out=response.getOutputStream();
		
		String imageFilePath="C:\\2023-12-JAVA-DEVELOPER\\eclipse-workspace-spring-tool suite-4-4.21.0.RELEASE\\servletSite\\src\\main\\webapp\\image\\album.jpg";
		FileInputStream imageInputStream = 
				new FileInputStream(imageFilePath);
		
		while(true) {
			int readByte=imageInputStream.read();
			if(readByte==-1)break;
			out.write(readByte);
		}
		imageInputStream.close();
		out.close();
	}
}
