package HW0914;

import java.sql.SQLException;
import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
//		����ڰ� �Է��� ���̵��� ���ƿ� Ƚ���� 1����

		MusicDao tdao = new MusicDao();
		Scanner sc = new Scanner(System.in);
		System.out.println("���̵� �Է�");
		int id = sc.nextInt();

		sc.close();
		try {
			if(tdao.lovethis(id));
			System.out.println("���ƿ�!");
		} catch (Exception e) {
			System.out.println
			("���ڷ� �� ���̵� �Է��ϼž��մϴ�. ��ϵ� ���̵� �ƴ� ���� �ֽ��ϴ�.");
			e.printStackTrace();
		}
		
	}

}
