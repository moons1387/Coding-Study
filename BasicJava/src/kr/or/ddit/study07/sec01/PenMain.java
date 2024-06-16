package kr.or.ddit.study07.sec01;

public class PenMain {
	public static void main(String[] args) {
		BallPen ballPen = new BallPen();
		ballPen.setAmount(10);
		ballPen.setColor("red");
		
		System.out.println(ballPen.getAmount()+", "+ballPen.getColor());
	}
}
