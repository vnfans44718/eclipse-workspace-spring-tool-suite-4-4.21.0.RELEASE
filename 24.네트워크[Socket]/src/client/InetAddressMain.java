package client;

import java.net.InetAddress;
import java.util.Iterator;

public class InetAddressMain {

	public static void main(String[] args) throws Exception {
		System.out.println("---local address(IP)-----");
		InetAddress localAddress =  InetAddress.getLocalHost();
		/*
		 local host name:BOOK-N3DT601I5D
         local host address:192.168.15.31
		 */
		System.out.println("local host name:"+localAddress.getHostName());
		System.out.println("local host address:"+localAddress.getHostAddress());
		
		System.out.println("---remote address(IP)-----");
		InetAddress remoteAddress = InetAddress.getByName("www.aladin.co.kr");
		System.out.println("remote host name:"+remoteAddress.getHostName());
		System.out.println("remote host address:"+remoteAddress.getHostAddress());
		
		InetAddress[] remoteAddresses = InetAddress.getAllByName("www.naver.com");
		for (InetAddress inetAddress : remoteAddresses) {
			System.out.println(inetAddress);
		}
		
		
		
		
	}

}
