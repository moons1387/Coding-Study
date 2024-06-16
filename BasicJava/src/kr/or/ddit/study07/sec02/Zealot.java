package kr.or.ddit.study07.sec02;

public class Zealot extends Unit {

	@Override
	public void move() {
		System.out.println("걸어서 이동");

	}
	
	@Override
	public void attack() {
		System.out.println("초당 5 데미지");
	}

}
