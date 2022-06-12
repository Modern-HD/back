package hotel;

public class Room {
	private String rno;
	private boolean isEmpty;
	private String checkIn;
	private String checkOut;
	
	
	public Room() {}
	public Room(String rno, boolean isEmpty, String checkIn, String checkOut) {
		this.rno = rno;
		this.isEmpty = isEmpty;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	public Room(String rno, boolean isEmpty) {
		this.rno = rno;
		this.isEmpty = isEmpty;
	}
	public String getRno() {
		return rno;
	}
	public void setRno(String rno) {
		this.rno = rno;
	}
	public boolean isEmpty() {
		return isEmpty;
	}
	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}
	public String getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	public String getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}
	
}
