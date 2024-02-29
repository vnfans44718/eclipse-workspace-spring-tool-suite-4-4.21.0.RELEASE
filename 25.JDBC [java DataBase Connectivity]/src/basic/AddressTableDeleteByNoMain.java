package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AddressTableDeleteByNoMain {

	public static void main(String[] args) throws Exception{
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@124.198.47.195:1521:xe";
		String user = "jdeveloper39";
		String password = "jdeveloper39";

		String selectSql = "select deptno,dname,loc from dept";

		
		String deleteSql="delete from address where no=1";
		
		
		/***********************************/

		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
		
		
		
		int rowCount = stmt.executeUpdate(deleteSql);
		System.out.println(">> delete row count :"+rowCount);
		
		stmt.close();
		con.close();

	}

}
