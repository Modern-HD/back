package quiz;

import java.util.Scanner;

class Store {
	String[] items = new String[] {"","","","",""};

}

class item {
	String[] item = new String[] {"","","","",""};
	
	void setItem(String[] store) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < store.length; i++) {
			System.out.println((i+1)+ ". " + store[i]);
		}
		System.out.println("구입할 아이템을 입력하세요 > ");
		int select = sc.nextInt() - 1;
		System.out.print("현재 박스: ");
		viewItem();
		System.out.println("아이템을 보관할 위치를 입력하세요 > ");
		int select2 = sc.nextInt() - 1;
		item[select2] = store[select];
		System.out.println(store[select] + " 구입완료!");
	}
	
	void viewItem() {
		System.out.print("[");
		for (int i = 0; i<item.length; i++) {
			System.out.print(item[i] == "" ? "(" + (i+1) + " 비었음)" : item[i]);
			System.out.print(i == item.length-1 ? "" : ", ");
		}
		System.out.println("]");
	}
	
	String getItem(int num) {
		return item[num];
	};
}

public class Quiz0605 {

	
	public static void main(String[] args) {
		item myItem = new item();
		Scanner sc = new Scanner(System.in);
		boolean exit = true;
		Store phone = new Store();
		Store foods = new Store();
		Store game = new Store();
		phone.items = new String[] {"iPhone","Galauxy","Pixel","Nexus","Razer"};
		foods.items = new String[] {"치킨","피자","보쌈","삼겹살","쭈꾸미"};
		game.items = new String[] {"젤다의 전설","몬스터 헌터","GTA","마리오","헤일로"};
		
		do {
			System.out.println("1. 소유 아이템 리스트, 2. 아이템 구입, 3. 프로그램 종료");
			System.out.println("메뉴를 선택하여 주세요 > ");
			int menu = sc.nextInt();
			switch (menu) {
			case 1:
				System.out.print("현재 소유 중인 아이템: ");
				myItem.viewItem();
				break;
			case 2:
				System.out.println("1. 폰가게, 2. 식당, 3. 게임샵, other: 처음으로");
				System.out.println("메뉴를 선택하여 주세요 > ");
				menu = sc.nextInt();
				switch (menu) {
				case 1: myItem.setItem(phone.items); break;
				case 2: myItem.setItem(foods.items);break;
				case 3: myItem.setItem(game.items); break;
				default: System.out.println("처음 화면으로 돌아갑니다."); break;
				}
				break;
			case 3: exit = false; break;
			default: System.out.println("올바른 값을 입력해주세요"); break;
			}
			
		} while(exit);
		System.out.println("프로그램을 종료합니다.");
	}
}


