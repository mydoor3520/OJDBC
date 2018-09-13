package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Send_insert_basic {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.OracleDriver");

		// db종류 @ ip :port:버전(있는 그대로 쓰면 xe)
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:xe", "sw5", "sw5");

		String sql = "insert into menu values('카페라떼',2000)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.execute();
		
		con.close();
		
		System.out.println("완료");
	}

}
