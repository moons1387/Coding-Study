package kr.or.ddit.utp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpFileReceiver {
	private DatagramSocket ds;
	private DatagramPacket dp;

	private byte[] buffer;

	public UdpFileReceiver(int port) {

		try {
			ds = new DatagramSocket(port);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 패킷 데이터 수신하기
	 * 
	 * @return 수신한 바이트배열 데이
	 * @throws IOException
	 */
	public byte[] receiveData() throws IOException {
		buffer = new byte[65507]; // 버퍼 초기화
		dp = new DatagramPacket(buffer, buffer.length);
		ds.receive(dp);

		return dp.getData();
	}

	public void start() throws IOException {

		long fileSize = 0;
		long totalReadBytes = 0;

		int readBytes = 0;

		System.out.println("파일 수신 대기중...");

		String str = new String(receiveData()).trim();

		if (str.equals("start")) {
			// 전송 파일명 받기
			str = new String(receiveData()).trim();
			FileOutputStream fos = new FileOutputStream("/Users/jeongmunseong/Desktop/DDIT/Java/down_files/"+str);

			// 전송 파일크기 받기
			str = new String(receiveData()).trim();
			fileSize = Long.parseLong(str);

			long startTime = System.currentTimeMillis();

			while (true) {
				byte[] data = receiveData();
				readBytes = dp.getLength();// 받은 데이터의크기
				fos.write(data, 0, readBytes);

				totalReadBytes += readBytes;

				System.out.println("진행상태 : " + totalReadBytes + "/" + fileSize + " byte(s) ("
						+ (totalReadBytes * 100 / fileSize) + " %)");

				if (totalReadBytes >= fileSize) {
					break;
				}

			}
			
			long endTime = System.currentTimeMillis();
			long diffTime = endTime - startTime;
			double transferSpeed = fileSize/diffTime;
			
			System.out.println("걸린 시간 : " + diffTime +"(ms)");
			System.out.println("평균 수신속도 : " + transferSpeed + "(bytes/s)");
			
			System.out.println("수신완료...");
			
			fos.close();
			ds.close();
			
		} else {
			System.out.println("비정상 데이터 발견...");
			ds.close();
		}

	}
	
	public static void main(String[] args) throws IOException {
		new UdpFileReceiver(8888).start();
	}

}
