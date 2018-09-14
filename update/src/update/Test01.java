package update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test01 {
	public static void main(String[] args) throws Exception{
//		로그인
		String id = "ghkddlsqls";
		String pw = "ghkddlsqls";
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sw5", "sw5");
		
		String sql = "select * from testuser where id=? and pw=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, pw);
		ResultSet rs = ps.executeQuery();
		
		boolean result = rs.next();
		
		con.close();
		
		if(result) {
//			System.out.println("로그인 성공!");
//			수정
			String nick = "황강사";
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sw5", "sw5");
			
			sql = "update testuser set nick=? where id=? and pw=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, nick);
			ps.setString(2, id);
			ps.setString(3, pw);
			ps.execute();
			
			con.close();
			
			System.out.println("정보 수정이 완료되었습니다");
		}
		else {
			System.out.println("로그인 정보가 일치하지 않습니다");
		}
		

	}
}










