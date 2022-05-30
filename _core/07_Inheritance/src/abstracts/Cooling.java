package abstracts;

public class Cooling {

	public static void main(String[] args) {
		// 냉장고 제작을 위한 시작
		// 추상화를 해보자!
		// 딤채를 만들어보자 => 냉장고 이기전에 전자제품이어야함
		
		KimchiRef dimchae = new Dimchae();
		dimchae.setButton(1);
		System.out.println(dimchae.getButton());
		System.out.println(dimchae.getFeature());
		
		KimchiRef kimchiRef = new KimchiRef() {
			@Override
			void buttonColor(String color) {
				// TODO Auto-generated method stub
				
			}
		};
	}
}

