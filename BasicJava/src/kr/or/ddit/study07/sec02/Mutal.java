package kr.or.ddit.study07.sec02;

public class Mutal extends Unit {

	@Override
	public void move() {
		System.out.println("날아서 이동");
	}
	
	@Override
	public void attack() {
		System.out.println("스플레시 3데미지");
	}
}
