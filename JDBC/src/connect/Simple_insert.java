package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Simple_insert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴명, 가격 입력");
		String name = sc.next();
		int price = sc.nextInt();
		
		
		Class.forName("oracle.jdbc.OracleDriver");
		// db종류 @ ip :port:버전(있는 그대로 쓰면 xe)
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:xe", "sw5", "sw5");
		
		String sql = "insert into menu values('" + name + "',"+ price +")";
		System.out.println(sql);
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.execute();
		con.close();
		
		System.out.println("완료");
	}

}