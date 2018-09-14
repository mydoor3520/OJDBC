package HW0914;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import select.MusicDto;

/**
 * 	MusicDto ���̺�� ���õ� DB ó���� ����ϴ� Ŭ����
 * 	DAO(Data Access Object) 
 */
public class MusicDao {
	
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:xe", "sw5", "sw5");
		return con;
	}
	
// 	����ڿ��� ��ϵ� ������ ���ƿ� ������� ���(������ ǥ��)	
	public void rank_Love() throws SQLException, ClassNotFoundException {
		Connection con = this.getConnection();
		
		String sql = "select rownum, A.* from (select * from music order by LOVE desc)A";
		PreparedStatement ps = con.prepareStatement(sql);
		
		con.close();
	}
//	��±���
	public void print() {
	String grade = "VIP";
	
	Class.forName("oracle.jdbc.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sw5", "sw5");

	String sql = "select * from MusicDto where grade=? order by money desc";
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setString(1, grade);
	ResultSet rs = ps.executeQuery();
	
	List<MusicDto> list = new ArrayList<>();
	
	while(rs.next()) {
		MusicDto user = new MusicDto();
		user.setId(rs.getString("id"));
		user.setPw(rs.getString("pw"));
		user.setNick(rs.getString("nick"));
		user.setMoney(rs.getInt("money"));
		user.setGrade(rs.getString("grade"));
		user.setJoindate(rs.getString("joindate"));
		list.add(user);
	}
	
	con.close();
	
	for(MusicDto user : list) {
		System.out.println(user);
	}
}

//	����ڰ� �Է��� ���̵��� ���ƿ� Ƚ���� 1����
	public boolean lovethis(int id) throws SQLException, ClassNotFoundException {
		Connection con = this.getConnection();
		
		String sql = "update music set love = love+1 where ID = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);

		boolean result = ps.execute();
		
		con.close();
		
		return result;
	}
	
//	�뷡���
	public boolean enroll(String title, String artist) throws SQLException, ClassNotFoundException {
		Connection con = this.getConnection();
		
		String sql = "insert into music values(music_seq.nextval, ?, ?, 0)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, title);
		ps.setString(2, artist);
		
		boolean result = ps.execute();
		
		con.close();
		
		return result;
	}
}













