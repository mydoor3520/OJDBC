package update;

import java.sql.DriverManager;

public class UpdateNick {
	public static void main(String[] args) throws Exception{
//		�α���
		String id = "ghkddlsqls";
		String pw = "ghkddlsqls";
		
		TestUserDao tdao = new TestUserDao();
		
		if(tdao.login(id, pw)) {
			String nick = "Ȳ����";
			
			tdao.changeNickname(id, pw, nick);			
			System.out.println("���� ������ �Ϸ�Ǿ����ϴ�");
		}
		else {
			System.out.println("�α��� ������ ��ġ���� �ʽ��ϴ�");
		}
	}
}










