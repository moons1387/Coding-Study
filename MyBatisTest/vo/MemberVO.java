package kr.or.ddit.member.vo;

import java.time.LocalDate;

/**
 * DB테이블에 있는 컬럼명을 기준으로 멤버변수를 정의한다.
 * 
 * <P>
 * DB 테이블의 컬럼데이터와 VO 클레스의 멤버변수를 매핑하여 데이터를 관리한다.
 * </P>
 */
public class MemberVO {
	private String memId;
	private String memName;
	private String memTel;
	private String memAddr;

	private LocalDate regDt;

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemTel() {
		return memTel;
	}

	public void setMemTel(String memTel) {
		this.memTel = memTel;
	}

	public String getMemAddr() {
		return memAddr;
	}

	public void setMemAddr(String memAddr) {
		this.memAddr = memAddr;
	}

	public LocalDate getRegDt() {
		return regDt;
	}

	public void setRegDt(LocalDate regDt) {
		this.regDt = regDt;
	}

	@Override
	public String toString() {
		return "MemberVo [memId=" + memId + ", memName=" + memName + ", memTel=" + memTel + ", memAddr=" + memAddr
				+ "]";
	}
}
