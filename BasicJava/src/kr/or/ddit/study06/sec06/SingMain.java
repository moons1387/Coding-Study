package kr.or.ddit.study06.sec06;

public class SingMain {
	public static void main(String[] args) {
		Sing s1 = new Sing();
		s1.setTitle("야간비행");
		s1.setLyrics("푸른 빛을 품은 그대를 찾아서\r\n" + 
					 "난 지금 어딘가로 야간비행\r\n" + 
					 "차가운 바람을 뚫고 날아가\r\n" + 
					 "전에 봤던 빛 그 꽃을 찾아서\r\n" + 
					 "난 지금 어딘가로 야간비행\r\n" + 
					 "확실한 게 없어도 난 달려가\r\n" + 
					 "또 해가 뜰 때쯤\r\n" + 
					 "내 힘이 사라진대도\r\n" + 
					 "그대의 찻잔에 띄워 놓고 싶은\r\n" + 
					 "아무도 모르는 그 꽃을 찾아서\r\n" + 
					 "그대 몰래 떠나는\r\n" + 
					 "나만의 야간비행\r\n" + 
					 "꿈에서 봤던 빛 그 꽃을 찾아서\r\n" + 
					 "난 지금 어딘가로 야간비행\r\n" + 
					 "내일이 없다고 해도 달려가\r\n" + 
					 "또 해가 뜰 때쯤\r\n" + 
					 "내 힘이 사라진대도\r\n" + 
					 "그대의 찻잔에 띄워 놓고 싶은\r\n" + 
					 "아무도 모르는 그 꽃을 찾아서\r\n" + 
					 "그대 몰래 떠나는\r\n" + 
					 "나만의");
		s1.setSinger("백예린");
		s1.setYear(2019);
		
		System.out.println(s1.getTitle()+s1.getLyrics()+s1.getSinger()+s1.getYear());
	}
}
