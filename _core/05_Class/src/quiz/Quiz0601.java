package quiz;

class Pet {
	String name = "";
	String breeds = "";
	int age = 0;
	
	void sound() {
		System.out.println(name + "이 처리했으니 안심하라고!");
	}
	int getOlder() {
		age++;
		return age;
	}
}

public class Quiz0601 {

	public static void main(String[] args) {
		// 아래의 조건을 참고 및 추리하여 코드를 작성해보세요.
		// a. 클래스 Pet 생성하기
		// b. Pet에 age, name, breeds 멤버 변수 초기화
		// c. Pet에 void sound() 메서드 생성
		// d. Pet에 getOlder() 메서드 생성, age 1씩 증가 후 리턴
		// e. 각 변수 값과 age의 증가를 출력
		
		Pet myPet = new Pet();
		myPet.name = "너굴맨";
		myPet.breeds = "라쿤";
		myPet.age = 1;
		myPet.sound();
		System.out.println(myPet.name + "의 나이는 " + myPet.age + "쨜");
		System.out.println(myPet.getOlder());
		System.out.println(myPet.name + "의 나이는 " + myPet.age + "쨜");
	}
	
}
