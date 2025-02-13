package kr.or.ddit.util;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		
		try {
			// 1-1. XML설정 파일 읽어오기
			Charset charset = Charset.forName("UTF-8"); // 설정파일 인코딩정보 설정
			Resources.setCharset(charset);				// 한글을 읽기 위해서...
			
			Reader rd = Resources.getResourceAsReader("config/mybatis-config.xml");
			
			// 1-2. 위에서 읽어온 Reader객체를 이용하여 SqlSessionFactory 객체를 생성한다.
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(rd);
			
			rd.close(); // 스트림 닫기
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
	}
	/**
	 * SqlSession 객체를 제공하기 위한 팩토리 메서드
	 * @return SqlSession 객체
	 */
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
	/**
	 * SqlSession 객체를 제공하기 위한 팩토리 메서드
	 * @param autoCommit 오토커밋 여부
	 * @return SqlSession 객체
	 */
	public static SqlSession getSqlSession(boolean autoCommit) {
		return sqlSessionFactory.openSession(autoCommit);
	}
		
}
