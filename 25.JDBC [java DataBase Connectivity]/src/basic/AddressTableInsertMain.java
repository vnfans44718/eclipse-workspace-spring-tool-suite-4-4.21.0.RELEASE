package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AddressTableInsertMain {
	

	public static void main(String[] args) throws Exception{
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@124.198.47.195:1521:xe";
		String user = "jdeveloper39";
		String password = "jdeveloper39";

		String selectSql = "select deptno,dname,loc from dept";

		
		/*String insertSql="insert into address values(address_no_seq.nextval,'김경호','123-45657','서울시여러분')";
		
		
		
		
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
		
		
		
		int rowCount = stmt.executeUpdate(insertSql);
		System.out.println(">> insert row count :"+rowCount);
		
		stmt.close();
		con.close();*/
		
		String insertSql="insert into address values(address_no_seq.nextval,'김경호','123-4567','서울시여러분')";
		/*
		 1.Driver class loading
	     2.Connection 객체생성
		 3.Statement객체생성
		 4.SQL문전송(insert)
		 5.SQL문전송(insert)결과 영향받은행의수 반환
		 6.연결객체해지(resource해지) close
		 */
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url,user,password);
		Statement stmt=con.createStatement();
		/*
		 Executes the given SQL statement, 
		 which may be an INSERT, UPDATE, 
		 or DELETE statement or anSQL statement that returns nothing,
		 such as an SQL DDL statement. 
		 */
		int rowCount = stmt.executeUpdate(insertSql);
		System.out.println(">> insert row count:"+rowCount);
		
		stmt.close();
		con.close();
		
		
	
	}

}
