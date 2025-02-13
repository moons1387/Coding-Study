package kr.or.ddit.basic;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
	public static void main(String[] args) throws UnknownHostException {
		// InetAddress 클래스 => IP주소 정보를 다루기 위한 클래스
		
		// getByName()은 www.naver.com 또는 SEM-PC 등과 같은 머신이름이나 IP주소를 통해 
		// 유효한 InetAddress 객체를 제공한다. IP주소 자체를 넣으면 주소 구성 자체의 
		// 유효성정도만 체크해 준다.
		
		// 네이버 사이트의 IP정보 가져오기
		
		InetAddress naverIp = InetAddress.getByName("www.naver.com");
		System.out.println("Host Name => " +naverIp.getHostName());
		System.out.println("Host Address => " +naverIp.getHostAddress());
		System.out.println();
		
		// 자기 자신의 IP주소 정보 가져오기
		InetAddress localIp = InetAddress.getLocalHost();
		System.out.println("내 컴퓨터의 Host Name => " + localIp.getHostName());
		System.out.println("내 컴퓨터의 Host Address => " + localIp.getHostAddress());
		
		// IP 주소가 여러개인 호스트의 정보 가져오기
		InetAddress[] naverIps = InetAddress.getAllByName("www.naver.com");
		for (InetAddress iAddr : naverIps) {
			System.out.println(iAddr.toString());
		}
	}
}
