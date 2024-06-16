package kr.or.ddit.study07.sec01;

public class IPhone extends SmartPhone {
	
	public void appstore() {
		System.out.println("앱스토어 사용");
	}
	@Override
	public void camera() {
		// TODO Auto-generated method stub
		System.out.println("1000만 화소 카메라");
		super.camera();
	}
}
