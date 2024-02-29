package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddressTableSelectByNoMain {

	public static void main(String[] args) throws Exception {
		/*************************************************************/
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@124.198.47.195:1521:xe";
		String user = "jdeveloper39";
		String password = "jdeveloper39";
		/*************************************************************/
		
		String selectSql ="select no,name,phone,address from address where no=3";
		
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url,user,password);
		Statement stmt=con.createStatement();
		
		ResultSet rs= stmt.executeQuery(selectSql);
		
		/*
		 * ResultSet
		 * 
		 * 
		 * 
		 */
		//boolean isExist = rs.next();
		
		if(rs.next()) {
			
			int no = rs.getInt("no");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String address = rs.getString("address");
			System.out.println(no+"\t"+name+"\t"+phone+"\t"+address);
			
		}
		else {
			System.out.println(">>주소록 친구가 없다");
		}
		
		
		rs.close();
		stmt.close();
		con.close();
		

	}

}
