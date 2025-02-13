package kr.or.ddit.study06.sec02;

public class ScoreExample {
	public static void main(String[] args) {
		// 2명의 score 객체를 생성하고 국영수 값을 각각 넣어보세요.
		
		Score kim = new Score();
		kim.kor = 85;
		kim.eng = 80;
		kim.math = 88;
		
		Score park = new Score();
		park.kor = 77;
		park.eng = 90;
		park.math = 99;
		
		// 평균값 구하기
		
		kim.avg = (kim.kor+kim.eng+kim.math)/3.0;
		park.avg = (park.kor+park.eng+park.math)/3.0;
		System.out.println(kim.avg);
		System.out.println(park.avg);
		
	}
}	
