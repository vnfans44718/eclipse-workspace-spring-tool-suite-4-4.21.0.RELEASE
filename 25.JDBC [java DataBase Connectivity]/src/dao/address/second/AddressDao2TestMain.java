package dao.address.second;

public class AddressDao2TestMain {

	public static void main(String[] args) throws Exception {

		AddressDao2 addressDao2 = new AddressDao2();

		System.out.println("1.insert");
		//addressDao1.insert("삼소라","123-8989","서울");
		//addressDao1.insert("사소라","123-8989","강릉");
		System.out.println("2.updateByNO");
		addressDao2.updateByNo(2,"채인지","000-1111","대전");
		addressDao2.updateByNo(4,"제임스","555-1111","미국");
		System.out.println("3.deleteByNO");
		addressDao2.deleteByNO(3);
		System.out.println("4.selectByNO");
		addressDao2.selectByNo(10);
		System.out.println("5.selectAll");
		addressDao2.selectAll();
	}

}
