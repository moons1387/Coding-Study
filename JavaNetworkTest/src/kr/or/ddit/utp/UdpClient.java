package kr.or.ddit.utp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpClient {
	private DatagramSocket ds;
	private DatagramPacket dp;

	private byte[] msg;

	public UdpClient() {

		msg = new byte[100];

		try {
			ds = new DatagramSocket();
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	public void start() throws IOException {
		InetAddress serverAddr = InetAddress.getByName("192.168.36.131");

		dp = new DatagramPacket(msg, 1, serverAddr, 8888);
		ds.send(dp); // 패킷 전송하기

		dp = new DatagramPacket(msg, msg.length);
		ds.receive(dp); // 패킷 수신하기

		System.out.println("현재 서버 시간 => " + new String(dp.getData()));
	}

	public static void main(String[] args) throws IOException {
		new UdpClient().start();
	}
}
