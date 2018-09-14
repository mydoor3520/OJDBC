package update;

/**
 *		DTO 클래스(Data Transfer Object) - 변환 객체 
 */
public class TestUserDto {
	private String id;
	private String pw;
	private String nick;
	private int money;
	private String grade;
	private String joindate;
	public TestUserDto() {
		super();
	}
	@Override
	public String toString() {
		return "TestUser [id=" + id + ", pw=" + pw + ", nick=" + nick + ", money=" + money + ", grade=" + grade
				+ ", joindate=" + joindate + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
}
