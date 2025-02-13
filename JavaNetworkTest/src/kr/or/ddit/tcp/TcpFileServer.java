package kr.or.ddit.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpFileServer {
	// 파일 서버는 접속한 클라이언트가 요청한 파일이 있는지 확인 후 존재하면 해당 파일을 클라리언트에게 전송한다.
	public void serverStart() {
		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("파일서버 준비 완료...");

			while (true) {
				Socket socket = serverSocket.accept();

				// 파일 전송 스레드 구동
				FileSender sender = new FileSender(socket);
				sender.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	class FileSender extends Thread {
		private Socket socket;
		private FileInputStream fis;
		private DataInputStream dis;
		private DataOutputStream dos;

		public FileSender(Socket socket) {
			this.socket = socket;

			try {
				dis = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;

			try {
				String downDir = "/Users/jeongmunseong/Desktop/DDIT/Java/";

				File file = new File(downDir + dis.readUTF());

				System.out.println("요청파일 존재여부 체크중...");

				if (!file.exists()) {
					System.out.println("요청파일 (" + file.getName() + ") 존재하지 않습니다.");
					dos.writeUTF("요청파일 (" + file.getName() + ") 존재하지 않습니다.");
				} else {
					dos.writeUTF("OK"); // 요청파일 존재함을 알려주기 위해 전송...

					System.out.println("요청파일 (" + file.getName() + ") 전송 시작...");

					fis = new FileInputStream(file);

					bis = new BufferedInputStream(bis);
					bos = new BufferedOutputStream(bos);

					int data = 0;

					while ((data = bis.read()) != -1) {
						bos.write(data);
					}
					System.out.println("요청파일 (" + file.getName() + ") 전송 완료...");
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					bis.close();
					bos.close();
					dis.close();
					dos.close();
					socket.close();

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
