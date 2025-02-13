package kr.or.ddit.basic.dao;

import java.util.List;

import kr.or.ddit.board.vo.BoardVO;

public interface IMyBatisBoardDao {

	public int insert(BoardVO bv);
	
	public int update(BoardVO bv);

	public int delete(int boardNo);

	public List<BoardVO> allBoard();
	
	public List<BoardVO> searchBoard(String boardName);
	
}
