package HW0914;

import java.sql.SQLException;
import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
//		����ڿ��� �Է¹��� ������ ������ ���

		MusicDao tdao = new MusicDao();
		Scanner sc = new Scanner(System.in);
		System.out.println("�뷡����");
		String title = sc.nextLine();
		System.out.println("����");
		String artist = sc.nextLine();
		sc.close();
		try {
			if(tdao.enroll(title, artist));
			System.out.println("����� �Ϸ�Ǿ����ϴ�");
		} catch (Exception e) {
			System.out.println("���� �ѱ� 30��, ���� �ѱ� 30�� �̾�� �մϴ�.");
			e.printStackTrace();
		}
	}

}
