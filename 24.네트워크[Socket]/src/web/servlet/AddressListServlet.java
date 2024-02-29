package web.servlet;

import java.io.PrintWriter;
import java.util.List;

import web.server.address.Address;
import web.server.address.AddressService;

public class AddressListServlet {
	public void service(PrintWriter out) throws Exception{
		AddressService addressService=new AddressService();
		List<Address> addressList= addressService.addressList();
		for (Address address : addressList) {
			out.println("<h1>Gangsa Server AddressListServlet--> AddressService.addressList</h1><hr>");
			out.println("["+address.getNo()+"]"+address.getPhone());
		}
		
	}
}
