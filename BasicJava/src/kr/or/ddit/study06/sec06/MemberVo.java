package kr.or.ddit.study06.sec06;

public class MemberVo {
	static int year;
	private String id;
	private String pass;
	private String name;
	
	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", pass=" + pass + ", name=" + name + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MemberVo() {
		
	}
	
	public MemberVo(String id, String pass, String name) {
		this.id = id;
		this.pass = pass;
		this.name = name;
	}
}
