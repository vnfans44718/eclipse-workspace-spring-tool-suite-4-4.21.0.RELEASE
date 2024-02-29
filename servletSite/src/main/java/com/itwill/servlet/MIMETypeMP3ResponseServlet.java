package com.itwill.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/response_mp3")
public class MIMETypeMP3ResponseServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 응답객체에 MIME타입 설정
		 */
		response.setContentType("audio/mpeg");
		OutputStream out=response.getOutputStream();
		
		String mp3FilePath="C:\\2023-12-JAVA-DEVELOPER\\eclipse-workspace-spring-tool suite-4-4.21.0.RELEASE\\servletSite\\src\\main\\webapp\\image\\test.mp3";
		FileInputStream mp3InputStream = 
				new FileInputStream(mp3FilePath);
		
		while(true) {
			int readByte=mp3InputStream.read();
			if(readByte==-1)break;
			out.write(readByte);
		}
		mp3InputStream.close();
		out.close();
	}
}
