package dao.address.first;

public class AddressDao1TestMain {

	public static void main(String[] args) throws Exception {

		AddressDao1 addressDao1 = new AddressDao1();

		System.out.println("1.insert");
		addressDao1.insert();
		System.out.println("2.updateByNO");
		addressDao1.updateByNo();
		System.out.println("3.deleteByNO");
		addressDao1.deleteByNO();
		System.out.println("4.selectByNO");
		addressDao1.selectByNo();
		System.out.println("5.selectAll");
		addressDao1.selectAll();
	}

}
