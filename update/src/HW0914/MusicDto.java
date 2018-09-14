package HW0914;

/**
 *		DTO 클래스(Data Transfer Object) - 변환 객체 
 */
public class MusicDto {
	private int id;
	private String title;
	private String artist;
	private int love;
	public MusicDto() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	@Override
	public String toString() {
		return "TestUserDto [id=" + id + ", title=" + title + ", artist=" + artist + ", love=" + love + "]";
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public int getlove() {
		return love;
	}
	public void setlove(int love) {
		this.love = love;
	}
}
	