package kr.or.ddit.basic;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.member.vo.MemberVO;

public class MyBatisTest {
	public static void main(String[] args) {
		// MyBatis를 이용하여 DB작업을 처리하는 작업 순서
		// 1. myBatis의 환경설정 파일을 읽어와 필요한 객체를 생성한다.
		
		SqlSessionFactory sqlSessionFactory = null;
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
		
		// 2. 실행할 SQL문에 맞는 쿼리문을 호출하여 원하는 작업을 수행한다.
		
		// 2. insert 작업 연습
		
		System.out.println("insert 작업 시작...");
		
		// 1) 저장할 데이터를 VO를 담는다
		MemberVO mv = new MemberVO();
		mv.setMemId("d001");
		mv.setMemName("강감찬");
		mv.setMemTel("222-2222");
		mv.setMemAddr("경상남도");
		
		// 2) sqlSesstion 객체를 이용하여 해당 쿼리문을 실행한다.
		SqlSession session = sqlSessionFactory.openSession(false); // autoCommit 여부 설정
		
		try {
			
			// 형식) insert ("namespace값.쿼리ID값", 파라미터객체);
			if(session.insert("memberTest.insertMember", mv) > 0) {
				System.out.println("insert 성공!");
				session.commit(); // 커밋 실시!!
			} else {
				System.out.println("insert 실패");
			}
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close(); // 커넥션풀에 사용한 커넥션 반납하기
		}
		
		// 2-2. update 연습
//		System.out.println("update 시작...");
//		
//		mv = new MemberVO();
//		mv.setMemId("d001");
//		mv.setMemName("김민강");
//		mv.setMemTel("222-2223");
//		mv.setMemAddr("부산");
//		
		session = sqlSessionFactory.openSession(); // autoCommit 기본값 false;
		
		try {
			if(session.update("memberTest.updateMember", mv) > 0) {
				System.out.println("update 성공");
				session.commit();
			} else {
				System.out.println("실패");
			}
		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		
		// 2-3) delete 연습
//		System.out.println("delete 시작...");
//		
		session = sqlSessionFactory.openSession();
		
		try {
			
			if(session.delete("memberTest.deleteMember", "d001") > 0) {
				System.out.println("성공");
				session.commit();
			} else {
				System.out.println("실패");
			}
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		
		//////////////////////////////////////////////////////////////////////////
		
		// 2-4) select 연습
		
		// 2-4-1) 응답의 결과가 여려개일 경우...
		System.out.println("select(여러개) 연습");
		
		session = sqlSessionFactory.openSession(true);
		
		try {
			List<MemberVO> memList = session.selectList("memberTest.selectAllMember");
				System.out.println("------------------------------------------------------");
			for (MemberVO mv2 : memList) {
				System.out.println(mv2);
				System.out.println("------------------------------------------------------");
			}
			System.out.println("전체 회원정보 출력 끝...");
			
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		System.out.println("------------------------------------------------------");

		
		// 2-4-2) 응답의 결과가 1개일 경우...
		
		System.out.println("select(한개) 연습");
		
		session = sqlSessionFactory.openSession(true);
		
		try {
			
			MemberVO mv3 = session.selectOne("memberTest.selectGetMember", "a001");
			System.out.println(mv3);
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		////////////////////////////////////////////////////////////////////////
		
		System.out.println("------------------------------------------------------------------");
		
		// VO가 아닌 Map을 이용한 방식 사용
		System.out.println("select(VO가 아닌 Map을 이용한 방식) 연습");
		
		session = sqlSessionFactory.openSession(true);
		
		try {
			
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("memId", "a001");
			
			Map<String, Object> resultMap = session.selectOne("memberTest.selectGetMember2", paramMap);
			
			System.out.println("ID   : " + resultMap.get("MEM_ID"));
			System.out.println("이름 : " + resultMap.get("MEM_NAME"));
			System.out.println("전화 : " + resultMap.get("MEM_TEL"));
			System.out.println("주소 : " + resultMap.get("MEM_ADDR"));
			
			System.out.println("------------------------------------------------------------------");
			
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
}
