package com.itwill.address.test;

import java.util.List;

import com.itwill.address.Address;
import com.itwill.address.AddressDao;

public class AddressDaoTestMain {

	public static void main(String[] args) throws Exception{
		AddressDao addressDao3=new AddressDao();
		System.out.println("1.insert");
		Address insertAddress=new Address(0, "김우미","666-6666", "CA");
		System.out.println(">> insert row count:"+addressDao3.insert(insertAddress));
		
		System.out.println("2.updateByNo");
		Address updateAddress=new Address(11, " 일레븐수정", "100-10000", "텐네시");
		System.out.println(">> update row count:"+
				addressDao3.updateByNo(updateAddress));
		System.out.println("3.deleteByNo");
		System.out.println(">> delete row count:"+addressDao3.deleteByNo(3));
		System.out.println("4.selectByNo");
		Address findAddress=addressDao3.selectByNo(10);
		System.out.println(findAddress);
		System.out.println("5.selectAll");
		List<Address> addressList=addressDao3.selectAll();
		for (Address address : addressList) {
			System.out.println(address);
		}

	}

}
