package kr.or.ddit.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MultiChatClient {

	public void clientStart() throws IOException {

		Socket socket = new Socket("192.168.36.131", 7777);

		System.out.println("멀티 챗 서버에 접속되었습니다.");

		// 송신용 스레드 생성 및 실행
		ClientSender sender = new ClientSender(socket);
		sender.start();

		// 수신용 스레드 생성 및 실행
		ClientReceiver receiver = new ClientReceiver(socket);
		receiver.start();

	}

	class ClientSender extends Thread {

		private DataOutputStream dos;
		private Scanner scan;

		public ClientSender(Socket socket) {

			scan = new Scanner(System.in);

			try {
				dos = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {

			try {
				if (dos != null) {
					// 시작하자 마자 자신의 대화명을 서버로 전송한다.
					System.out.print("대화명>> ");
					dos.writeUTF(scan.nextLine());

				}

				// 다음부터 보내는 메시지는 채팅메시지...
				while (dos != null) {
					dos.writeUTF(scan.nextLine());
				}

			} catch (IOException e) {

			}
		}
	}

	class ClientReceiver extends Thread {

		private DataInputStream dis;

		public ClientReceiver(Socket socket) {
			
			try {
				dis = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			while (dis != null) {
				
				try {
					// 서버에서 보내주는 메시지 콘솔에 출력하기...
					System.out.println(dis.readUTF());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		new MultiChatClient().clientStart();
		
	}
	
}
