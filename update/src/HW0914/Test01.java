package HW0914;

import java.sql.SQLException;
import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
//		사용자에게 입력받은 정보로 음원을 등록

		MusicDao tdao = new MusicDao();
		Scanner sc = new Scanner(System.in);
		System.out.println("노래제목");
		String title = sc.nextLine();
		System.out.println("가수");
		String artist = sc.nextLine();
		sc.close();
		try {
			if(tdao.enroll(title, artist));
			System.out.println("등록이 완료되었습니다");
		} catch (Exception e) {
			System.out.println("제목 한글 30자, 가수 한글 30자 이어야 합니다.");
			e.printStackTrace();
		}
	}

}
