package abstracts;

public abstract class KimchiRef extends Cooler {

	@Override
	public boolean isPower() {
		// TODO Auto-generated method stub
		return super.isPower();
	}

	@Override
	public void setPower(boolean power) {
		super.setPower(power);
	}

	@Override
	public int getButton() {
		System.out.println("발효 버튼 추가");
		return super.getButton();
	}

	@Override
	public void setButton(int button) {
		super.setButton(button);
	}

	@Override
	public String getFeature() {
		return super.getFeature();
	}

	@Override
	public void setFeature(String feature) {
		System.out.println("발효 과학 추가");
		super.setFeature(feature);
	}
	
}
