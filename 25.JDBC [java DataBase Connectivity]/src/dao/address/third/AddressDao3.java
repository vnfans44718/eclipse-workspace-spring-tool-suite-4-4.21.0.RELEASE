package dao.address.third;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * Dao(Data Access Object)클래스
  -address 테이블에 CRUD(Create,Read,Update,Delete) 작업을 하는 
  단위 메소드를 가지고 있는 클래스
   
 */

public class AddressDao3 {

	/*
	 데이터베이스 접속정보를 이용해서 
	 Connection 객체를 생성해서 반환하는 메소드
	 
	 */

	public Connection getConnection() throws Exception {

		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@124.198.47.195:1521:xe";
		String user = "jdeveloper39";
		String password = "jdeveloper39";
		/******************************************************************************/

		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
	}

	/*
	 * 사용한 Connection 객체를 close하는 메소드
	 */
	public void close(Connection con) throws Exception {
		con.close();

	}

	public int insert(String name, String phone, String address) throws Exception {

		String insertSql = "insert into address values(address_no_seq.nextval,'" + name + "','" + phone + "','"
				+ address + "')";

		Connection con = this.getConnection();
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(insertSql);
		stmt.close();
		this.close(con);
		return rowCount;

	}

	public int insert(Address address) throws Exception {

		String insertSql = "insert into address values(address_no_seq.nextval,'" + address.getName() + "','"
				+ address.getPhone() + "','" + address.getAddress() + "')";
		Connection con = this.getConnection();
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(insertSql);
		System.out.println(">> insert row count:" + rowCount);
		stmt.close();
		this.close(con);
		return rowCount;

	}

	public int updateByNo(int no, String name, String phone, String address) throws Exception {

		String updateSql = "update address set name='" + name + "', phone= '" + phone + "', address='" + address
				+ "' where no=" + no;
		/********************************************************************************/

		Connection con = getConnection();
		Statement stmt = con.createStatement();

		int rowCount = stmt.executeUpdate(updateSql);
		System.out.println(">> update row count :" + rowCount);

		stmt.close();
		this.close(con);
		return rowCount;
	}

	public int updateByNo(Address address) throws Exception {
		String updateSql = "update address set name='"+
				address.getName()+"' ,phone='"+
				address.getPhone()+"', address='"+
				address.getAddress()+"' where no="+
				address.getNo();
		/********************************************************************************/

		Connection con = getConnection();
		Statement stmt = con.createStatement();

		int rowCount = stmt.executeUpdate(updateSql);
		System.out.println(">> update row count :" + rowCount);

		stmt.close();
		this.close(con);
		return rowCount;
	}

	public void deleteByNO(int no) throws Exception {

		String deleteSql = "delete from address where no=" + no;
		/********************************************************************************/

		Connection con = getConnection();
		Statement stmt = con.createStatement();

		int rowCount = stmt.executeUpdate(deleteSql);
		System.out.println(">> delete row count :" + rowCount);

		stmt.close();
		this.close(con);
	}

	public Address selectByNo(int no) throws Exception {
		String selectSql = "select no,name,phone,address from address where no=" + no;
		Address findAddress = null;
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectSql);
		if (rs.next()) {
			int n = rs.getInt("no");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String address = rs.getString("address");
			findAddress = new Address(n, name, phone, address);

		} else {
			System.out.println(">>주소록 친구없다~~~");
		}
		rs.close();
		stmt.close();
		this.close(con);
		return findAddress;
	}

	public List<Address> selectAll() throws Exception {

		String selectSql = "select no,name,phone,address from address";
		/********************************************************************************/
		List<Address> addressList = new ArrayList<Address>();
		Connection con = getConnection();
		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery(selectSql);

		if (rs.next()) {
			// do while문 첫번째는 무조건 실행하고 while문에서 다음을 실행하지 결정
			do {

				int no = rs.getInt("no");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String addr = rs.getString("address");
				Address address = new Address(no, name, phone, addr);
				addressList.add(address);

			} while (rs.next());

		} else {
			System.out.println("친구가 없다");
		}

		rs.close();
		stmt.close();
		this.close(con);
		return addressList;
	}

}
