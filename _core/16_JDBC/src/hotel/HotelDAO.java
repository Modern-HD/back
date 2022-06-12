package hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class HotelDAO {
	
	private Connection conn;
	private PreparedStatement pst;
	private String query = "";
	private SimpleDateFormat sdf;
	
	public HotelDAO() {
		DatabaseConnector dbc = DatabaseConnector.getInstance();
		conn = dbc.getConnection();
		sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh:mm");
	}
	
	public List<Integer> selectUsingRoom() {
		List<Integer> list = new ArrayList<>();
		query = "select rno from room where is_empty = 1";
		try {
			pst = conn.prepareStatement(query);
			ResultSet rs = 	pst.executeQuery();
			while (rs.next()) {
				list.add(Integer.valueOf(rs.getString("rno")));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Room selectOne(int rno) {
		query = "select * from room where rno = ?";
		try {
			Room room = null;
			pst = conn.prepareStatement(query);
			pst.setString(1, String.valueOf(rno));
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String rnoGet = rs.getString("rno");
				boolean isEmpty = (rs.getInt("is_empty") > 0 ? true : false);
				java.sql.Timestamp checkInTime = rs.getTimestamp("check_in_time");
				java.sql.Timestamp checkOutTime = rs.getTimestamp("check_out_time");
				room = new Room(rnoGet, isEmpty, sdf.format(checkInTime), sdf.format(checkOutTime));
			}
			return room;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Room selectOneEmpty(int rno) {
		query = "select is_Empty from room where rno = ?";
		try {
			Room room = new Room();
			pst = conn.prepareStatement(query);
			pst.setString(1, String.valueOf(rno));
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				boolean isEmpty = (rs.getInt("is_empty") > 0 ? true : false);
				room.setEmpty(isEmpty);
			}
			return room;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean insert(int rno, int plusDays, User user) {
		query = "insert into room(rno, guest_name, guest_tel, "
				+ "guest_age, guest_gen, is_empty, check_in_time, check_out_time) "
				+ "values(?, ?, ?, ?, ?, ?, now(), date_add(now(),interval ? day))";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, String.valueOf(rno));
			pst.setString(2, user.getName());
			pst.setString(3, user.getTel());
			pst.setInt(4, user.getAge());
			pst.setInt(5, (user.isGen() ? 1 : 0));
			pst.setInt(6, 1);
			pst.setInt(7, plusDays);
			return pst.executeUpdate() > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public User selectOneUser(int rno) {
		query = "select * from room where rno = ?";
		try {
			User user = null;
			user = new User();
			pst = conn.prepareStatement(query);
			pst.setString(1, String.valueOf(rno));
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				boolean gen = (rs.getInt("guest_gen") > 0 ? true : false);
				user = new User(rs.getString("guest_name"), rs.getString("guest_tel"), rs.getInt("guest_age"), gen);
			}
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean delete(int rno) {
		query = "delete from room where rno = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, String.valueOf(rno));
			return pst.executeUpdate() > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
