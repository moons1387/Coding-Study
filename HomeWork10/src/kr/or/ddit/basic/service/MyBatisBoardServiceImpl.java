package kr.or.ddit.basic.service;

import java.util.List;

import kr.or.ddit.basic.dao.IMyBatisBoardDao;
import kr.or.ddit.basic.dao.MyBatisBoardDaoImpl;
import kr.or.ddit.board.vo.BoardVO;

public class MyBatisBoardServiceImpl implements IMyBatisBoardService {

	IMyBatisBoardDao boardDao = MyBatisBoardDaoImpl.getInstance();

	private static IMyBatisBoardService myBatisBoardService = null;

	public MyBatisBoardServiceImpl() {

	}

	public static IMyBatisBoardService getInstance() {
		return myBatisBoardService = new MyBatisBoardServiceImpl();
	}

	@Override
	public int insert(BoardVO bv) {
		return boardDao.insert(bv);
	}

	@Override
	public int update(BoardVO bv) {
		return boardDao.update(bv);
	}

	@Override
	public int delete(int boardNo) {
		return boardDao.delete(boardNo);
	}

	@Override
	public List<BoardVO> allBoard() {
		return boardDao.allBoard();
	}

	@Override
	public List<BoardVO> searchBoard(String boardName) {
		return boardDao.searchBoard(boardName);
	}

}
