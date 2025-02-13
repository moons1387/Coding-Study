package kr.or.ddit.comm.service;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.http.Part;

import kr.or.ddit.comm.dao.AtchFileDaoImpl;
import kr.or.ddit.comm.dao.IAtchFileDao;
import kr.or.ddit.comm.vo.AtchFileDetailVO;
import kr.or.ddit.comm.vo.AtchFileVO;

public class AtchFileServiceImpl implements IAtchFileService {
	
	private static IAtchFileService fileService = new AtchFileServiceImpl();

	private static final String UPLOAD_DIR = "upload_files";

	private IAtchFileDao fileDao;

	public AtchFileServiceImpl() {
		fileDao = AtchFileDaoImpl.getInstance();
	}
	
	public static IAtchFileService getInstance() {
		return fileService;
	}

	@Override
	public AtchFileVO saveAtchFileList(Collection<Part> parts) {

		String uploadPath = "/Users/jeongmunseong/Desktop/DDIT/Java" + UPLOAD_DIR;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		AtchFileVO atchFileVO = null;

		boolean isFistFile = true; // 첫번째 파일 여부...

		for (Part part : parts) {

			String fileName = part.getSubmittedFileName(); // 업로드 파일명 추출

			if (fileName != null && !fileName.equals("")) {

				if (isFistFile) { // 첫번째 업로드파일인지 체크...
					isFistFile = false;

					atchFileVO = new AtchFileVO();
					
					fileDao.insertAtchFile(atchFileVO); // ATCH_FILE에 insert하기

				}
				// 확장자 추출
				String fileExtention = fileName.lastIndexOf(".") < 0 ? ""
						: fileName.substring(fileName.lastIndexOf(".") + 1);

				long fileSize = part.getSize(); // 파일 크기
				String saveFileName = UUID.randomUUID().toString().replace("-", "") + "." + fileExtention; // 저장파일 이름
				String saveFilePath = uploadPath + "/" + saveFileName; // 저장파일 경로


				try {					
					// 업로드파일 저장하기
					part.write(saveFilePath);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				AtchFileDetailVO atchFileDetailVO = new AtchFileDetailVO();
				atchFileDetailVO.setAtchFileId(atchFileVO.getAtchFileId());
				atchFileDetailVO.setStreFileNm(saveFileName);
				atchFileDetailVO.setFileSize(fileSize);
				atchFileDetailVO.setOrignlFileNm(fileName);
				atchFileDetailVO.setFileStreCours(saveFilePath);
				atchFileDetailVO.setFileExtsn(fileExtention);
				
				fileDao.insertAtchFileDetail(atchFileDetailVO); // 파일세부정보 저장
				
				try {
					// 임시 업로드 파일 삭제처리 하기
					part.delete();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return atchFileVO;
	}

	@Override
	public AtchFileVO getAtchFile(AtchFileVO fileVO) {

		return fileDao.getAtchFile(fileVO);
	}

	@Override
	public AtchFileDetailVO getAtchFileDetail(AtchFileDetailVO atchFileDetailVO) {

		return fileDao.getAtchFileDetail(atchFileDetailVO);
	}

	public void daoTest() {
		
		boolean isFistFile = true;
		AtchFileVO atchFileVO = null;		
		
		if (isFistFile) { // 첫번째 업로드파일인지 체크...
			isFistFile = false;
			
			atchFileVO = new AtchFileVO();
			
			fileDao.insertAtchFile(atchFileVO); // ATCH_FILE에 insert하기

		}
		
		String fileName = "abc.jpg";

		long fileSize = 10000; // 파일 크기
		String saveFileName = UUID.randomUUID().toString().replace("-", ""); // 저장파일 이름
		String saveFilePath = "/Users/jeongmunseong/Desktop/DDIT/Java" + "/" + saveFileName; // 저장파일 경로

		// 확장자 추출
		String fileExtention = fileName.lastIndexOf(".") < 0 ? ""
				: fileName.substring(fileName.lastIndexOf(".") + 1);
		
		AtchFileDetailVO atchFileDetailVO = new AtchFileDetailVO();
		atchFileDetailVO.setAtchFileId(atchFileVO.getAtchFileId());
		atchFileDetailVO.setStreFileNm(saveFileName);
		atchFileDetailVO.setFileSize(fileSize);
		atchFileDetailVO.setOrignlFileNm(fileName);
		atchFileDetailVO.setFileStreCours(saveFilePath);
		atchFileDetailVO.setFileExtsn(fileExtention);
		
		fileDao.insertAtchFileDetail(atchFileDetailVO); // 파일세부정보 저장
		
	}
	
	public static void main(String[] args) {
		
		new AtchFileServiceImpl().daoTest();
		System.out.println("성공!!!");
	}

}
