package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect_base {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.OracleDriver");

		// db���� @ ip :port:����(�ִ� �״�� ���� xe)
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:xe", "sw5", "sw5");

		con.close();
		
		System.out.println("�Ϸ�");
	}

}
