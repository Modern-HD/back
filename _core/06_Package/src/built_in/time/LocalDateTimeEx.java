package built_in.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeEx {

	public static void main(String[] args) {
		LocalDateTime todayNow = LocalDateTime.now();
		System.out.println(todayNow);
		
		System.out.println(todayNow.getHour());
		System.out.println(todayNow.getMinute());
		System.out.println(todayNow.getSecond());
		System.out.println(todayNow.getNano());
		// LocalDateTime은 LocalDate와 LocalTime을 모두 포함하는 구조입니다.
		
		String curr = todayNow.toString();
		System.out.println(curr.substring(curr.indexOf("T")+1));
		System.out.println(curr.substring(0, curr.lastIndexOf(".")));
		System.out.println(curr.replace("T", " ").substring(0, curr.lastIndexOf(".")));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH,mm,ss");
		System.out.println(dtf.format(todayNow));
	}
	
}
