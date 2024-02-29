package web.servlet;

import java.io.PrintWriter;
import java.util.List;

import web.server.address.Address;
import web.server.address.AddressService;

public class AddressDetailServlet {
	public void service(PrintWriter out) throws Exception{
		AddressService addressService=new AddressService();
		Address address= addressService.addressDetail(107);
		out.println("<h1>Gangsa Server AddressDetailServlet--> AddressService.addressDetail</h1><hr>");
		out.println("["+address.getNo()+"]"+address.getPhone());
		
		
	}
}
