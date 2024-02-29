package dao.address.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * Dao(Data Access Object)클래스
  -address 테이블에 CRUD(Create,Read,Update,Delete) 작업을 하는 
  단위 메소드를 가지고 있는 클래스
   
 */

public class AddressDao1 {
	private String driverClass = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@124.198.47.195:1521:xe";
	private String user = "jdeveloper39";
	private String password = "jdeveloper39";

	public void insert() throws Exception {

		String insertSql = "insert into address values(address_no_seq.nextval,'김경호','123-4567','서울시여러분')";

		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();

		int rowCount = stmt.executeUpdate(insertSql);
		System.out.println(">> insert row count:" + rowCount);

		stmt.close();
		con.close();
	}

	public void updateByNo() throws Exception {

		String updateSql = "update address set name='김변경', phone= '888-8888', address='부산시여러분' where no=1";

		/***********************************/

		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();

		int rowCount = stmt.executeUpdate(updateSql);
		System.out.println(">> update row count :" + rowCount);

		stmt.close();
		con.close();
	}

	public void deleteByNO() throws Exception {

		String deleteSql = "delete from address where no=1";

		/***********************************/

		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();

		int rowCount = stmt.executeUpdate(deleteSql);
		System.out.println(">> delete row count :" + rowCount);

		stmt.close();
		con.close();
	}

	public void selectByNo() throws Exception {

		String selectSql = "select no,name,phone,address from address where no=3";

		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery(selectSql);

		/*
		 * ResultSet
		 * 
		 * 
		 * 
		 */
		// boolean isExist = rs.next();

		if (rs.next()) {

			int no = rs.getInt("no");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String address = rs.getString("address");
			System.out.println(no + "\t" + name + "\t" + phone + "\t" + address);

		} else {
			System.out.println(">>주소록 친구가 없다");
		}

		rs.close();
		stmt.close();
		con.close();
	}

	public void selectAll() throws Exception {

		String selectSql = "select no,name,phone,address from address";

		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery(selectSql);

		/*
		 * ResultSet
		 * 
		 * 
		 * 
		 */
		// boolean isExist = rs.next();
		if (rs.next()) {
			// do while문 첫번째는 무조건 실행하고 while문에서 다음을 실행하지 결정
			do {

				int no = rs.getInt("no");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				System.out.println(no + "\t" + name + "\t" + phone + "\t" + address);

			} while (rs.next());

		} else {
			System.out.println("친구가 없다");
		}

		rs.close();
		stmt.close();
		con.close();
	}

}
