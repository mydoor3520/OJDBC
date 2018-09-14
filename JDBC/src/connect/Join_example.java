package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Join_example {
	public static void main(String[] args) {
		/**
		 * testuser Å×ÀÌºíÀÇ Ç×¸ñÀº ÃÑ 6°³	(id, pw, nick, money, grade, joindate)
		 * »ç¿ëÀÚ¿¡°Ô ÀÔ·Â¹Ş´Â Ç×¸ñÀº ÃÑ 3°³	(id, pw, nick)
		 */
		try(Scanner s = new Scanner(System.in);){
			//ÀÔ·Â
			System.out.println("¾ÆÀÌµğ ÀÔ·Â");
			String id = s.nextLine();
			if(!Pattern.matches("^[a-z0-9]{8,20}$", id))
				throw new Exception("¾ÆÀÌµğ´Â 8~20ÀÚ ¿µ¹®°ú ¼ıÀÚÀÇ Á¶ÇÕÀ¸·Î ÀÔ·ÂÇÏ¼¼¿ä");
			
			System.out.println("ºñ¹Ğ¹øÈ£ ÀÔ·Â");
			String pw = s.nextLine();
			if(!Pattern.matches("^[a-z0-9]{8,20}$", pw))
				throw new Exception("ºñ¹Ğ¹øÈ£´Â 8~20ÀÚ ¿µ¹®°ú ¼ıÀÚÀÇ Á¶ÇÕÀ¸·Î ÀÔ·ÂÇÏ¼¼¿ä");
			
			System.out.println("´Ğ³×ÀÓ ÀÔ·Â");
			String nick = s.nextLine();
			if(!Pattern.matches("^[°¡-ÆR]{2,6}$", nick))
				throw new Exception("´Ğ³×ÀÓÀº 2~6ÀÚ ÇÑ±Û·Î ÀÔ·ÂÇÏ¼¼¿ä");
			
			//DB Ã³¸®
			Class.forName("oracle.jdbc.OracleDriver");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sw5", "sw5");
			
			String sql = "insert into testuser values(?, ?, ?, 0, 'ÀÏ¹İ', sysdate)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			ps.setString(3, nick);
			ps.execute();
			
			con.close();
			
			System.out.println("°¡ÀÔ ¿Ï·á");
		}
		catch(Exception e) {
			System.err.println("¿À·ù : "+e.getMessage());
		}
	}
}













