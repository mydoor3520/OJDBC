package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect_base {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.OracleDriver");

		// db종류 @ ip :port:버전(있는 그대로 쓰면 xe)
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:xe", "sw5", "sw5");

		con.close();
		
		System.out.println("완료");
	}

}
