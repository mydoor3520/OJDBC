package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Send_insert_basic {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.OracleDriver");

		// db���� @ ip :port:����(�ִ� �״�� ���� xe)
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:xe", "sw5", "sw5");

		String sql = "insert into menu values('ī���',2000)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.execute();
		
		con.close();
		
		System.out.println("�Ϸ�");
	}

}
