package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Output_from_Oracle {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		
		String sql = "select * from menu order by price asc";
	
		//db처리
		Class.forName("oracle.jdbc.OracleDriver");
		// db종류 @ ip :port:버전(있는 그대로 쓰면 xe)
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:xe", "sw5", "sw5");
		
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery(); //select의 결과값 나옴
		
		//rs.next(); 행 이동 명령(다음행)
		//rs.get???(); 데이터의 추출
		while(rs.next()) {
//		System.out.println(rs.next()); //boolean 값으로 나옴 명령 수행과 동시에 다음 줄로 감 (단 처음에는 이 명령을 수행해야 나옴)
		System.out.println(rs.getString("name"));
		System.out.println(rs.getString(1));
		System.out.println(rs.getInt("price"));
		System.out.println(rs.getInt(2));
		}
		
		con.close();
		System.out.println("완료");
		
	}

}