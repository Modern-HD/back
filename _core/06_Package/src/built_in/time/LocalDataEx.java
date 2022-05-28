package built_in.time;

import java.time.LocalDate;

public class LocalDataEx {

	public static void main(String[] args) {
		// 1.8 이전에서는 new Date()를 통해 구현했던 것을 => deprecated
		// 1.8 이후에서는 Calendar 혹은 LocalDate, LocalDateTime 을 사용한다.
		LocalDate today = LocalDate.now();
		System.out.println(today);
		
		System.out.println(today.getDayOfMonth());
		System.out.println(today.getDayOfYear());
		System.out.println(today.getMonthValue());
		System.out.println(today.getMonthValue());
		System.out.println(today.getYear());
		System.out.println(today.getMonth());
		System.out.println(today.plusYears(1L));
		LocalDate ago100 = today.minusYears(100L);
		System.out.println(ago100);
		
		String curr = today.toString();
		System.out.println(curr);
	}
	
}
