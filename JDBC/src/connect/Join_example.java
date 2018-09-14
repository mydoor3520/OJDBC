package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Join_example {
	public static void main(String[] args) {
		/**
		 * testuser ���̺��� �׸��� �� 6��	(id, pw, nick, money, grade, joindate)
		 * ����ڿ��� �Է¹޴� �׸��� �� 3��	(id, pw, nick)
		 */
		try(Scanner s = new Scanner(System.in);){
			//�Է�
			System.out.println("���̵� �Է�");
			String id = s.nextLine();
			if(!Pattern.matches("^[a-z0-9]{8,20}$", id))
				throw new Exception("���̵�� 8~20�� ������ ������ �������� �Է��ϼ���");
			
			System.out.println("��й�ȣ �Է�");
			String pw = s.nextLine();
			if(!Pattern.matches("^[a-z0-9]{8,20}$", pw))
				throw new Exception("��й�ȣ�� 8~20�� ������ ������ �������� �Է��ϼ���");
			
			System.out.println("�г��� �Է�");
			String nick = s.nextLine();
			if(!Pattern.matches("^[��-�R]{2,6}$", nick))
				throw new Exception("�г����� 2~6�� �ѱ۷� �Է��ϼ���");
			
			//DB ó��
			Class.forName("oracle.jdbc.OracleDriver");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sw5", "sw5");
			
			String sql = "insert into testuser values(?, ?, ?, 0, '�Ϲ�', sysdate)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			ps.setString(3, nick);
			ps.execute();
			
			con.close();
			
			System.out.println("���� �Ϸ�");
		}
		catch(Exception e) {
			System.err.println("���� : "+e.getMessage());
		}
	}
}













