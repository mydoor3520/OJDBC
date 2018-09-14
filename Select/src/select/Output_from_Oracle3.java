package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Output_from_Oracle3 {
	public static void main(String[] args) throws Exception{
		
//		���� : ���� ������Ŀ��� ?�� �����Ϳ��� ����
		
//		String search = "��";
//		String order = "money";
		
		Scanner s = new Scanner(System.in);
		System.out.println("�˻��� �Է�");
		String search = s.nextLine();
		System.out.println("1.���̵�� 2.�г��Ӽ� 3.�����ϼ� 4.���ϸ�����");
		int choice = s.nextInt();
		s.close();
		
		String[] arr = new String[] {"id","nick","joindate","money"};
		String order = arr[choice-1];
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sw5", "sw5");
		
		String sql = "select * from testuser "
						+ "where id like '%'||?||'%' or nick like '%'||?||'%' order by "+order+" asc";
		System.out.println(sql);
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, search);
		ps.setString(2, search);
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













