package kr.or.ddit.comm.vo;

import java.time.LocalDate;
import java.util.List;

public class AtchFileVO {
	private long atchFileId = -1; /* 첨부파일ID */
	private LocalDate creatDt; /* 생성일시 */
	private String useAt; /* 사용여부 */
	private List<AtchFileDetailVO> atchFileDetailList; /* 세부첨부파일 목록 */

	public long getAtchFileId() {
		return atchFileId;
	}

	public void setAtchFileId(long atchFileId) {
		this.atchFileId = atchFileId;
	}

	public LocalDate getCreatDt() {
		return creatDt;
	}

	public void setCreatDt(LocalDate creatDt) {
		this.creatDt = creatDt;
	}

	public String getUseAt() {
		return useAt;
	}

	public void setUseAt(String useAt) {
		this.useAt = useAt;
	}

	public List<AtchFileDetailVO> getAtchFileDetailList() {
		return atchFileDetailList;
	}

	public void setAtchFileDetailList(List<AtchFileDetailVO> atchFileDetailList) {
		this.atchFileDetailList = atchFileDetailList;
	}
	
}
