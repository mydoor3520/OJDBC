package update;

import java.sql.DriverManager;

public class UpdateNick {
	public static void main(String[] args) throws Exception{
//		로그인
		String id = "ghkddlsqls";
		String pw = "ghkddlsqls";
		
		TestUserDao tdao = new TestUserDao();
		
		if(tdao.login(id, pw)) {
			String nick = "황강사";
			
			tdao.changeNickname(id, pw, nick);			
			System.out.println("정보 수정이 완료되었습니다");
		}
		else {
			System.out.println("로그인 정보가 일치하지 않습니다");
		}
	}
}










