package kr.or.ddit.homework.service;

import java.util.List;

import kr.or.ddit.homewor.dao.IJavaBoardDao;
import kr.or.ddit.homewor.dao.JavaBoardDao;
import kr.or.ddit.homework.VO.JavaBoardVO;

public class JavaBoardService implements IJavaBoardService {
	
	private static JavaBoardService hws = new JavaBoardService();
	
	private IJavaBoardDao boardDao; 
	
	public static JavaBoardService getInstance() {
		return hws;
	}
	
	public JavaBoardService() {
		boardDao = JavaBoardDao.getInstance();
	}

	@Override
	public List<JavaBoardVO> boardList() {
		return boardDao.boardList();
	}

	@Override
	public int insert(JavaBoardVO jb) {
		return boardDao.insert(jb);
	}

	@Override
	public int delete(int no) {
		return boardDao.delete(no);
	}

	@Override
	public int update(JavaBoardVO jb) {
		return boardDao.update(jb);
	}

	@Override
	public List<JavaBoardVO> boardSearch(String title) {
		return boardDao.boardSearch(title);
	}
}
