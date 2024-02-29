package com.itwill.address;
/*
  Dao(Data Access Object)클래스
    - address 테이블에 CRUD(Create,Read,Update,Delete) 작업을하는 
      단위메쏘드를 가지고있는 클래스
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itwill.common.DataSource;

public class AddressDao {
	/*
	 * DataSource 객체를 멤버필드로가짐
	 * (Connection을 생성하고 해지하는객체)
	 */
	private DataSource dataSource;
	
	public AddressDao() throws Exception{
		dataSource=new DataSource();
	}
	/***************************Statement*******************************************
	public int insert(String name, String phone, String address) throws Exception {
		String insertSql = "insert into address values(address_no_seq.nextval,'" + name + "','" + phone + "','"
				+ address + "')";

		Connection con = dataSource.getConnection();
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(insertSql);
		stmt.close();
		dataSource.close(con);
		
		return rowCount;
	}

	public int insert(Address address) throws Exception {
		String insertSql = "insert into address values(address_no_seq.nextval,'" + address.getName() + "','"
				+ address.getPhone() + "','" + address.getAddress() + "')";
		Connection con = dataSource.getConnection();
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(insertSql);
		stmt.close();
		dataSource.close(con);
		return rowCount;
	}

	public int updateByNo(int no, String name, String phone, String address) throws Exception {
		String updateSql = "update address set name='" + name + "' ,phone='" + phone + "', address='" + address
				+ "' where no=" + no;
		Connection con = dataSource.getConnection();
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(updateSql);
		stmt.close();
		dataSource.close(con);
		return rowCount;
	}

	public int updateByNo(Address address) throws Exception {
		String updateSql = "update address set name='" + address.getName() + "' ,phone='" + address.getPhone()
				+ "', address='" + address.getAddress() + "' where no=" + address.getNo();
		Connection con = dataSource.getConnection();
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(updateSql);
		stmt.close();
		dataSource.close(con);
		return rowCount;
	}

	public int deleteByNo(int no) throws Exception {
		String deleteSql = "delete from address where no=" + no;
		Connection con = dataSource.getConnection();
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(deleteSql);
		// System.out.println(">> delete row count:" + rowCount);
		stmt.close();
		dataSource.close(con);
		return rowCount;
	}

	public Address selectByNo(int no) throws Exception {
		String selectSql = "select no,name,phone,address from address where no=" + no;
		Address findAddress = null;
		Connection con = dataSource.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectSql);
		if (rs.next()) {
			int n = rs.getInt("no");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String address = rs.getString("address");
			findAddress = new Address(n, name, phone, address);
		} else {
			findAddress = null;
		}
		rs.close();
		stmt.close();
		dataSource.close(con);
		return findAddress;
	}

	public List<Address> selectAll() throws Exception {
		String selectSql = "select no,name,phone,address from address";
		List<Address> addressList = new ArrayList<Address>();

		Connection con = dataSource.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectSql);
		if (rs.next()) {
			do {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String addr = rs.getString("address");
				Address address = new Address(no, name, phone, addr);
				addressList.add(address);
			} while (rs.next());
		}
		rs.close();
		stmt.close();
		dataSource.close(con);
		return addressList;
	}
	*/
	/***************************PreparedStatement*******************************************/
	public int insert(String name, String phone, String address) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(AddressSQL.ADDRESS_INSERT);
		pstmt.setString(1, name);
		pstmt.setString(2, phone);
		pstmt.setString(3, address);
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}

	public int insert(Address address) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(AddressSQL.ADDRESS_INSERT);
		pstmt.setString(1, address.getName());
		pstmt.setString(2, address.getPhone());
		pstmt.setString(3, address.getAddress());
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}

	public int updateByNo(int no, String name, String phone, String address) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(AddressSQL.ADDRESS_UPDATE);
		pstmt.setString(1, name);
		pstmt.setString(2, phone);
		pstmt.setString(3, address);
		pstmt.setInt(4, no);
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}

	public int updateByNo(Address address) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(AddressSQL.ADDRESS_UPDATE);
		pstmt.setString(1, address.getName());
		pstmt.setString(2, address.getPhone());
		pstmt.setString(3, address.getAddress());
		pstmt.setInt(4, address.getNo());
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}

	public int deleteByNo(int no) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(AddressSQL.ADDRESS_DELETE);
		pstmt.setInt(1, no);
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}

	public Address selectByNo(int no) throws Exception {
		Address findAddress = null;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(AddressSQL.ADDRESS_SELECT_BY_NO);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			int n = rs.getInt("no");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String address = rs.getString("address");
			findAddress = new Address(n, name, phone, address);
		} else {
			findAddress = null;
		}
		rs.close();
		pstmt.close();
		dataSource.close(con);
		return findAddress;
	}

	public List<Address> selectAll() throws Exception {
		List<Address> addressList = new ArrayList<Address>();
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(AddressSQL.ADDRESS_SELECT_ALL);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			do {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String addr = rs.getString("address");
				Address address = new Address(no, name, phone, addr);
				addressList.add(address);
			} while (rs.next());
		}
		rs.close();
		pstmt.close();
		dataSource.close(con);
		return addressList;
	}
}
