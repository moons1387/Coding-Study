package kr.or.ddit.basic;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * 서블릿 3부터 지원하는 Part 인터페이스를 이용한 파일 업로드 예제
 */

@MultipartConfig(
		fileSizeThreshold = 1024*1024*3, // 메모리 임계크기(이 크기가 넘어가면 레파지토리 위치에 임시파일로 저장됨.) 
		maxFileSize = 1024*1024*40, 	 // 파일 1개당 최대 크기
		maxRequestSize = 1024*1024*50)	 // 요청파일 최대 크기
@WebServlet("/uploadTest")
public class T10ServletUploadTest extends HttpServlet {

	private static final String UPLOAD_DIR = "upload_files";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("==================================================================================");
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
//		String readLine = "";
//		while((readLine = br.readLine()) != null) {
//			System.out.println(readLine);
//		}
//		
//		System.out.println("==================================================================================");

		req.setCharacterEncoding("UTF-8");

		// Multipart 파싱전 파라미터 정보 가져오기
		System.out.println("Multipart 파싱 전 sender : " + req.getParameter("sender"));

		String uploadPath = req.getServletContext().getRealPath("/") + File.separator + UPLOAD_DIR;
//		String uploadPath = req.getServletContext().getRealPath("/") + File.separator + UPLOAD_DIR;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		try {
			String fileName = "";
			for (Part part : req.getParts()) {
				System.out.println(part.getHeader("Content-Disposition"));
//				fileName = getFileName(part);
				
				fileName = part.getSubmittedFileName();
				
				if (fileName != null && !fileName.equals("")) {
					
					part.write("/Users/jeongmunseong/eclipse-workspace/ServletTest/src/main/webapp" + fileName);
//					part.write(uploadPath + File.separator + fileName);
					
					System.out.println("업로드 처리 완료...");
					System.out.println(uploadPath + File.separator);
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Part 객체 파싱하여 파일이름 추출하기
	 * 
	 * @param part 파일이름 파싱할 Part객체
	 * @return 파일명 : 파일명이 존재하지 않으면 null값 리턴
	 */
	private String getFileName(Part part) {

		// Content-Disposition : form-data; name="multiPartServlet";
		// filename="안유진.jpg"
		for (String content : part.getHeader("Content-Disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf("=") + 1).trim().replace("\"", "");
			}
		}

		return null;
	}

}
