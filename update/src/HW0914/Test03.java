package HW0914;

import java.sql.SQLException;
import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
//	 	����ڿ��� ��ϵ� ������ ���ƿ� ������� ���(������ ǥ��)	

		MusicDao tdao = new MusicDao();
		MusicDto tdto = new MusicDto();
		System.out.println("love ����!");
		
		try {
			tdao.rank_Love();
			System.out.println(tdto.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
