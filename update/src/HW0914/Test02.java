package HW0914;

import java.sql.SQLException;
import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
//		사용자가 입력한 아이디의 좋아요 횟수를 1증가

		MusicDao tdao = new MusicDao();
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디 입력");
		int id = sc.nextInt();

		sc.close();
		try {
			if(tdao.lovethis(id));
			System.out.println("좋아요!");
		} catch (Exception e) {
			System.out.println
			("숫자로 된 아이디를 입력하셔야합니다. 등록된 아이디가 아닐 수도 있습니다.");
			e.printStackTrace();
		}
		
	}

}
