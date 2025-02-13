package kr.or.ddit.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Sender extends Thread {

	private Scanner sc;
	private String name;
	private DataOutputStream dos;

	public Sender(Socket socket) {
		
		name = "[" + socket.getLocalAddress() + " : " + socket.getLocalPort() + "]";

		sc = new Scanner(System.in);

		try {
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		
		while (dos != null) {
			
			try {
				dos.writeUTF(name + " >>> " + sc.nextLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
