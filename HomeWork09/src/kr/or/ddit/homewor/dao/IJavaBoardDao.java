package kr.or.ddit.homewor.dao;

import java.util.List;

import kr.or.ddit.homework.VO.JavaBoardVO;

public interface IJavaBoardDao {
	/**
	 * 게시판의 모든 내용을 가져옴
	 * 
	 * @return List<HomeWorkVO>
	 */
	public List<JavaBoardVO> boardList();

	/**
	 * 게시판에 게시물을 입력함
	 * 
	 * @return 1 = 성공, 0 = 실패
	 */
	public int insert(JavaBoardVO jb);

	/**
	 * 게시판에 게시물을 삭제함
	 * 
	 * @return 1 = 성공, 0 = 실패
	 */
	public int delete(int no);

	/**
	 * 게시판에 게시물을 수정함
	 * 
	 * @return 1 = 성공, 0 = 실패
	 */
	public int update(JavaBoardVO jb);

	/**
	 * 게시판에 게시물을 검색함
	 * 
	 * @return List<HomeWorkVO>
	 */
	public List<JavaBoardVO> boardSearch(String title);

}