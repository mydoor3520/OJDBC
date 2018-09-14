package HW0914;

import java.sql.SQLException;
import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
//	 	사용자에게 등록된 음원을 좋아요 순서대로 출력(순위도 표시)	

		MusicDao tdao = new MusicDao();
		MusicDto tdto = new MusicDto();
		System.out.println("love 순위!");
		
		try {
			tdao.rank_Love();
			System.out.println(tdto.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
