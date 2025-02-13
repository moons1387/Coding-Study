package kr.or.ddit.homework.VO;

import java.time.LocalDate;

public class JavaBoardVO implements Comparable<JavaBoardVO> {
	private int no;
	private String title;
	private String writer;
	private LocalDate regDate;
	private String content;
	private int size;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "HomeWorkVO [no=" + no + ", title=" + title + ", writer=" + writer + ", regDate=" + regDate
				+ ", content=" + content + "]";
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public int compareTo(JavaBoardVO o) {
		return Integer.compare(this.getNo(), o.getNo());
	}

}
