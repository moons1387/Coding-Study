package kr.or.ddit.study06.sec05;

public class BigLoad {
	private static BigLoad instance;

	private BigLoad() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static BigLoad getIntance() {
		if (instance == null) {
			instance = new BigLoad();
		}
		return instance;
	}
	
}
