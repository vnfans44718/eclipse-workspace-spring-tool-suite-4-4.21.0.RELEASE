package web.servlet;

import java.io.InputStream;
import java.io.OutputStream;

public class ImageServlet {
	public void service(OutputStream out) throws Exception {

		InputStream fis = ImageServlet.class.getResourceAsStream("/image/dog.png");
		;
		while (true) {
			int readByte = fis.read();
			if (readByte == -1)break;
		    out.write(readByte);
		}
	}
}
