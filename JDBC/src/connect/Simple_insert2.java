package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Simple_insert2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Scanner sc = new Scanner(System.in);
		System.out.println("�޴���, ���� �Է�");
		String name = sc.next();
		int price = sc.nextInt();
		
		
		Class.forName("oracle.jdbc.OracleDriver");
		// db���� @ ip :port:����(�ִ� �״�� ���� xe)
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:xe", "sw5", "sw5");
		
		String sql = "insert into menu values(?,?)";
		System.out.println(sql);
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, name);	//1�� ����ǥ�� name�� ���ڿ��� ������!
		ps.setInt(2, price);	//2�� ����ǥ�� price�� ��Ʈ�� ������!
		ps.execute();
		con.close();
		
		System.out.println("�Ϸ�");
	}

}