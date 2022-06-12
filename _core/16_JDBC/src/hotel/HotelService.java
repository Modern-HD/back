package hotel;

import java.util.List;

public class HotelService {
	HotelDAO dao;
	
	public HotelService() {
		dao = new HotelDAO();
	}

	public void roomsStatus(int dFloor, int dRoom) {
		List<Integer> list = dao.selectUsingRoom();
		printRooms(dFloor, dRoom, list);
	}
	

	public boolean isEmpty(int rno) {
		Room room = dao.selectOneEmpty(rno);
		if(!room.isEmpty()) {
			return true;
		}
		return false;
	}

	public void enter(int rno, int plusDays, User user) {
		boolean isOk = dao.insert(rno, plusDays, user);
		System.out.println("입력 " + (isOk ? "성공" : "실패"));
	}

	public void roomDetail(int rno) {
		Room room = dao.selectOne(rno);
		printRoomDetail(room);
	}
	
	public void userDetail(int rno) {
		User user = dao.selectOneUser(rno);
		printUserDetail(rno, user);
	}
	
	public void leave(int rno) {
		boolean isDel = dao.delete(rno);
		System.out.println("삭제 " + (isDel ? "성공" : "실패"));
	}
	
	private void printRooms(int dFloor, int dRoom, List<Integer> list) {
		for(int i = 1; i <= dFloor; i++) {
			for(int j = 1; j <= dRoom; j++) {
				int rno = i*100 + j;
				System.out.printf("%4d호: %s", rno, (list.contains(rno)? "사용중" : "빈 방"));
				System.out.print((j%5==0 ? "\n" : "\t"));
			}
			
		}
	}
	
	private void printRoomDetail(Room room) {
		System.out.println("====== " + room.getRno() + "호 조회 결과 ======");
		System.out.println("사용 여부: " + (room.isEmpty() ? "사용 중" : "빈 방"));
		System.out.println("입실 시간: " + room.getCheckIn());
		System.out.println("퇴실 예정: " + room.getCheckOut());
		System.out.println();
	}
	
	private void printUserDetail(int rno, User user) {
		System.out.println("====== " + rno + "호 고객 조회 결과 ======");
		System.out.println("대표자명: " + user.getName());
		System.out.println("전화번호: " + user.getTel());
		System.out.println("나이: " + user.getAge());
		System.out.println("성별: " + (user.isGen() ? "남성" : "여성"));
	}



}
