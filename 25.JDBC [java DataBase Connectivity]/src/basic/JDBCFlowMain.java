package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCFlowMain {

	public static void main(String[] args) throws Exception {

		/*
		 * 1. Driver class loading
		 *  A.Driver class 객체생성
		 *  B.DriverManager에 드라이버 객체 등록
		 */
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@124.198.47.195:1521:xe";
		String user = "jdeveloper09";
		String password = "jdeveloper09";

		String selectSql = "select deptno,dname,loc from dept";

		Class.forName(driverClass);
		System.out.println("1.diver class loading");

		/*
		 * 2. Connection 객체생성
		 * - DB Server와 연결객체
		 */

		Connection con = DriverManager.getConnection(url,user,password);
		System.err.println("2.Connection 객체생성"+con);

		/*
		 * 3.Statement 객체를 생성
		 * - SQL문 전송 객체
		 */
		
		Statement stmt = con.createStatement();
		System.err.println("3.Statement 객체를 생성"+stmt);
		
		
		/*
		 * 4.SQL문을 전송(select)
		 * 5.ResultSet 객체 얻기(select)
		 */
		
		ResultSet rs = stmt.executeQuery(selectSql);
		//dml이면 intger값
		System.err.println("4,5 Sql문 전송&ResultSet 객체 얻기(select문 실행결과)"+rs);
		
		while (rs.next()) {
			int deptno=rs.getInt("deptno");
			String dname = rs.getString("dname");
			String loc = rs.getString("loc");
			System.out.println(deptno+" "+dname+" "+loc);
		}
	
		/*
		 * 6. 연결객체 해지
		 */
		System.out.println("6.연결객체(resource)해지 close");
		rs.close();
		stmt.close();
		con.close();
		
		
		
	}

}
