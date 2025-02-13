package kr.or.ddit.http;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.StringTokenizer;

/**
 * 간단한 웹 서버 예제
 * 
 * @author jeongmunseong
 */
public class MyHTTPServer {
	private final int PORT = 80;
	private final String ENCODING = "UTF-8";

	public void start() {
		System.out.println("HTTP 서버가 시작되었습니다.");

		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket(this.PORT);

			while (true) {
				Socket socket = serverSocket.accept();

				HttpHandler handler = new HttpHandler(socket);
				handler.start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * HTTP 요청 처리를 위한 스레드
	 */
	class HttpHandler extends Thread {
		private Socket socket;

		public HttpHandler(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			BufferedOutputStream out = null;
			BufferedReader br = null;

			try {
				out = new BufferedOutputStream(socket.getOutputStream());
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

				// 요청 헤더정보 파싱하기...

				// Request Line
				String reqLine = br.readLine(); // 첫줄은 요청라인...

				System.out.println("Request Line : " + reqLine);

				String reqPath = ""; // 요청 경로

				// 요청 페이지 정보 가져오기
				StringTokenizer st = new StringTokenizer(reqLine);

				while (st.hasMoreTokens()) {
					String token = st.nextToken();

					if (token.startsWith("/")) {
						reqPath = token;
						break;
					}
				}
				
				// URL 디코딩 처리(한글 깨짐문제 처리)
				reqPath = URLDecoder.decode(reqPath, ENCODING);

				String filePath = "./WebContent" + reqPath;

				// 해당 파일이름을 이용하여 Content-Type 정보 추출하기
				String contentType = URLConnection.getFileNameMap().getContentTypeFor(filePath);

				// CSS 파일인 경우 인식이 안되서 추가함.
				if (contentType == null && filePath.endsWith(".css"))
					contentType = "text/css";

				System.out.println("Content-Type : " + contentType);

				File file = new File(filePath);
				if (!file.exists()) {
					// 에러페이지 출력하기...
					return;
				}

				byte[] body = makeResponseBody(filePath);

				byte[] header = makeResponseHeader(body.length, contentType);

				//////////////////////////////////////////////////////////////////

				// 응답 해더정보 보내기
				out.write(header);

				// 응답 내용 보내기 전 반드시 Empty Line 보내기...
				out.write("\r\n\r\n".getBytes());

				// 응답 내용 보내기
				out.write(body);
				
				out.flush(); // 강제방출...

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					socket.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}

	}

	/**
	 * 응답내용 생성하기
	 * 
	 * @param filePath 응답으로 사용할 파일경로
	 * @return 바이트 배열 데이터
	 */
	private byte[] makeResponseBody(String filePath) {
		byte[] data = null;

		FileInputStream fis = null;

		try {

			File file = new File(filePath);
			data = new byte[(int) file.length()];

			fis = new FileInputStream(file);
			fis.read(data);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return data;
	}

	/**
	 * 응답 해더정보 생성하기
	 * 
	 * @param contentlength 응답내용 크기
	 * @param mimeType      컨텐츠 타입정보
	 * @return 해더정보 바이트배열
	 */
	private byte[] makeResponseHeader(int contentLength, String mimeType) {

		String header = "HTTP/1.1 200 OK\r\n"
				+ "Server: MyHTTPServer 1.0\r\n"
				+ "Content-Length: " + contentLength +"\r\n"
				+ "Content-Type: " + mimeType +"; charset=" + this.ENCODING;
		
		System.out.println("header => " + header);		
		

		return header.getBytes();
	}

	public static void main(String[] args) {
		new MyHTTPServer().start();
	}

}
