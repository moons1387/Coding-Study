package kr.or.ddit.basic.service;

import java.util.List;

import kr.or.ddit.board.vo.BoardVO;

public interface IMyBatisBoardService {

	public int insert(BoardVO bv);

	public int update(BoardVO bv);

	public int delete(int boardNo);

	public List<BoardVO> allBoard();

	public List<BoardVO> searchBoard(String name);

}
