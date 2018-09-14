package update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 	TestUser 테이블과 관련된 DB 처리를 담당하는 클래스
 * 	DAO(Data Access Object) 
 */
public class TestUserDao {
	
//	가입
	
//	목록
	
//	검색
	
//	연결
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sw5", "sw5");
		return con;
	}
	
//	로그인
	public boolean login(String id, String pw) throws ClassNotFoundException, SQLException {
		Connection con = this.getConnection();
		
		String sql = "select * from testuser where id=? and pw=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, pw);
		ResultSet rs = ps.executeQuery();
		
		boolean result = rs.next();
		
		con.close();
		
		return result;
	}
	public boolean login(TestUserDto user) throws ClassNotFoundException, SQLException {
		return login(user.getId(), user.getPw());
	}
	
//	닉네임수정
	public boolean changeNickname(String id, String pw, String nick) throws SQLException, ClassNotFoundException {
		Connection con = this.getConnection();
		
		String sql = "update testuser set nick=? where id=? and pw=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, nick);
		ps.setString(2, id);
		ps.setString(3, pw);
		int result = ps.executeUpdate();
		
		con.close();
		
		return result > 0;
	}
}













