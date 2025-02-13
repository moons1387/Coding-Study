package kr.or.ddit.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

// 클라이언트는 서버에 접속하여 서버가 보내주는 파일을 d:/D_Other/down_files 폴더에 저장한다.
public class TcpFileClient {
	private Socket socket;
	private FileOutputStream fos;
	private DataInputStream dis;
	private DataOutputStream dos;
	private Scanner scan;

	public TcpFileClient() {
		scan = new Scanner(System.in);

	}

	public void clientStart() {

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		try {
			socket = new Socket("192.168.36.131", 7777);

			// 소켓접속이 성공하면 받고싶은 파일명을 보낸다.
			System.out.println("파일명>>");
			String fileName = scan.next();

			dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(fileName);

			dis = new DataInputStream(socket.getInputStream());

			String resultMsg = dis.readUTF();

			if (resultMsg.equals("OK")) {

				File downDir = new File("/Users/jeongmunseong/Desktop/DDIT/Java/down_files");

				if (!downDir.exists()) {
					downDir.mkdir();
				}

				File file = new File(downDir, fileName); // 저장을 위한 파일 객체 생성

				fos = new FileOutputStream(file);

				bis = new BufferedInputStream(socket.getInputStream());
				bos = new BufferedOutputStream(fos);

				int data = 0;
				while ((data = dis.read()) != -1) {
					bos.write(data);
				}

				System.out.println("파일 다운로드 완료");

			} else {
				System.out.println("resultMsg");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bis.close();
				bos.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new TcpFileClient().clientStart();
	}
	
}
