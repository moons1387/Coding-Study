package kr.or.ddit.study06.sec05;

public class SingleTon {

	private static SingleTon instance;

	private SingleTon() {

	}

	// 파일을 로드하는데 시간이 오래 걸릴 경우
	// DB접속
	public static SingleTon getInstance() {
		if (instance == null) {
			instance = new SingleTon();
		}
		return instance;
	}
}
