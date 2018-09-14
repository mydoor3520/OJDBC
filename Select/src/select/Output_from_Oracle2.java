package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Output_from_Oracle2 {
	public static void main(String[] args) throws Exception{
		String grade = "VIP";
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sw5", "sw5");

		String sql = "select * from testuser where grade=? order by money desc";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, grade);
		ResultSet rs = ps.executeQuery();
		
		List<TestUser> list = new ArrayList<>();
		
		while(rs.next()) {
			TestUser user = new TestUser();
			user.setId(rs.getString("id"));
			user.setPw(rs.getString("pw"));
			user.setNick(rs.getString("nick"));
			user.setMoney(rs.getInt("money"));
			user.setGrade(rs.getString("grade"));
			user.setJoindate(rs.getString("joindate"));
			list.add(user);
		}
		
		con.close();
		
		for(TestUser user : list) {
			System.out.println(user);
		}
		
	}
}










