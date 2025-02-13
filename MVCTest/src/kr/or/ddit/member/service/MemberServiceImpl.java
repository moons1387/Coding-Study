package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImplWithJDBC;
import kr.or.ddit.member.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	
	private IMemberDao memDao;
	
	public MemberServiceImpl() {
		memDao = new MemberDaoImplWithJDBC();
	}

	@Override
	public int registerMember(MemberVO mv) {
		return memDao.insertMember(mv);
		
		// 회원에게 가입완료 메일 발송하기...
		
	}

	@Override
	public int modifyMember(MemberVO mv) {
		return memDao.updateMember(mv);
	}

	@Override
	public boolean checkMember(String memId) {
		return memDao.checkMember(memId);
	}

	@Override
	public int removeMember(String memId) {
		return memDao.deleteMember(memId);
	}

	@Override
	public List<MemberVO> getTotalMember() {
		return memDao.getAllMember();
	}
	
}
