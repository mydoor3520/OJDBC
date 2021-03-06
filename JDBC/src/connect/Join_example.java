package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Join_example {
	public static void main(String[] args) {
		/**
		 * testuser 테이블의 항목은 총 6개	(id, pw, nick, money, grade, joindate)
		 * 사용자에게 입력받는 항목은 총 3개	(id, pw, nick)
		 */
		try(Scanner s = new Scanner(System.in);){
			//입력
			System.out.println("아이디 입력");
			String id = s.nextLine();
			if(!Pattern.matches("^[a-z0-9]{8,20}$", id))
				throw new Exception("아이디는 8~20자 영문과 숫자의 조합으로 입력하세요");
			
			System.out.println("비밀번호 입력");
			String pw = s.nextLine();
			if(!Pattern.matches("^[a-z0-9]{8,20}$", pw))
				throw new Exception("비밀번호는 8~20자 영문과 숫자의 조합으로 입력하세요");
			
			System.out.println("닉네임 입력");
			String nick = s.nextLine();
			if(!Pattern.matches("^[가-힣]{2,6}$", nick))
				throw new Exception("닉네임은 2~6자 한글로 입력하세요");
			
			//DB 처리
			Class.forName("oracle.jdbc.OracleDriver");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sw5", "sw5");
			
			String sql = "insert into testuser values(?, ?, ?, 0, '일반', sysdate)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			ps.setString(3, nick);
			ps.execute();
			
			con.close();
			
			System.out.println("가입 완료");
		}
		catch(Exception e) {
			System.err.println("오류 : "+e.getMessage());
		}
	}
}













