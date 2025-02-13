package kr.or.ddit.board.vo;

import java.time.LocalDate;

/**
 * DB테이블에 있는 컬럼명을 기준으로 멤버변수를 정의한다.
 * 
 * <P>
 * DB 테이블의 컬럼데이터와 VO 클레스의 멤버변수를 매핑하여 데이터를 관리한다.
 * </P>
 */
public class BoardVO implements Comparable<BoardVO>{
	private int bdNo;
	private String bdTitle;
	private String bdWriter;
	private LocalDate bdDate;
	private String bdContent;

	public int getBdNo() {
		return bdNo;
	}

	public void setBdNo(int bdNo) {
		this.bdNo = bdNo;
	}

	public String getBdTitle() {
		return bdTitle;
	}

	public void setBdTitle(String bdTitle) {
		this.bdTitle = bdTitle;
	}

	public String getBdWriter() {
		return bdWriter;
	}

	public void setBdWriter(String bdWriter) {
		this.bdWriter = bdWriter;
	}

	public LocalDate getBdDate() {
		return bdDate;
	}

	public void setBdDate(LocalDate bdDate) {
		this.bdDate = bdDate;
	}

	public String getBdContent() {
		return bdContent;
	}

	public void setBdContent(String bdContent) {
		this.bdContent = bdContent;
	}

	@Override
	public String toString() {
		return "BoardVO [bdNo=" + bdNo + ", bdTitle=" + bdTitle + ", bdWriter=" + bdWriter + ", bdDate=" + bdDate
				+ ", bdContent=" + bdContent + "]";
	}

	@Override
	public int compareTo(BoardVO o) {
		return Integer.compare(this.getBdNo(), o.getBdNo());
	}

}
