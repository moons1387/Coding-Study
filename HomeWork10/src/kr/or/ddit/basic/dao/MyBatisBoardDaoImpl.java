package kr.or.ddit.basic.dao;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.board.vo.BoardVO;

public class MyBatisBoardDaoImpl implements IMyBatisBoardDao {

	private static IMyBatisBoardDao myBatisBoardDao = null;
	SqlSessionFactory sqlSessionFactory = null;

	private MyBatisBoardDaoImpl() {

		try {
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			Reader rd = Resources.getResourceAsReader("config/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(rd);
			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static IMyBatisBoardDao getInstance() {
		return myBatisBoardDao = new MyBatisBoardDaoImpl();
	}

	@Override
	public int insert(BoardVO bv) {
		int cnt = 0;

		SqlSession session = sqlSessionFactory.openSession(false);
		
		try {
			
			cnt = session.update("board.insertBoard", bv);
			session.commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return cnt;
	}

	@Override
	public int update(BoardVO bv) {
		int cnt = 0;

		SqlSession session = sqlSessionFactory.openSession(false);
		
		try {
			
			cnt = session.update("board.updateBoard", bv);
			session.commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return cnt;
	}

	@Override
	public int delete(int boardNo) {
		int cnt = 0;

		SqlSession session = sqlSessionFactory.openSession(false);
		
		try {
			
			cnt = session.update("board.deleteBoard", boardNo);
			session.commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return cnt;
	}

	@Override
	public List<BoardVO> allBoard() {
		List<BoardVO> list = new ArrayList<BoardVO>();

		SqlSession session = sqlSessionFactory.openSession(false);
		
		try {
			
			list = session.selectList("board.selectAllBoard");
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public List<BoardVO> searchBoard(String boardName) {
		List<BoardVO> list = new ArrayList<BoardVO>();

		SqlSession session = sqlSessionFactory.openSession(false);
		
		try {
			
			list = session.selectList("board.searchBoard", boardName);
			session.commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return list;
	}

}
