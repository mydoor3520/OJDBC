package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Output_from_Oracle {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		
		String sql = "select * from menu order by price asc";
	
		//dbó��
		Class.forName("oracle.jdbc.OracleDriver");
		// db���� @ ip :port:����(�ִ� �״�� ���� xe)
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:xe", "sw5", "sw5");
		
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery(); //select�� ����� ����
		
		//rs.next(); �� �̵� ���(������)
		//rs.get???(); �������� ����
		while(rs.next()) {
//		System.out.println(rs.next()); //boolean ������ ���� ��� ����� ���ÿ� ���� �ٷ� �� (�� ó������ �� ����� �����ؾ� ����)
		System.out.println(rs.getString("name"));
		System.out.println(rs.getString(1));
		System.out.println(rs.getInt("price"));
		System.out.println(rs.getInt(2));
		}
		
		con.close();
		System.out.println("�Ϸ�");
		
	}

}