<%-- 
1. 디렉티브(Directive)에 대하여...

	JSP페이지에 대한 설정정보를 지정할 때 사용된다. (page, taglib, include 등)

	'<%@'로 시작하고 그 뒤에 디렉티브 이름이 오고 필요에 따라 속성명이 올 수 있으며, 마지막에 '%>'로 끝난다.
	ex) <%@ 디렉티브이름 속성명="속성값" ... %>

2. 스크립트 요소에 대하여...
	 
	JSP에서 문서의 내용을 동적으로 생성하기 위해 사용된다.
	
	- 표현식(Expression) : 값을 출력결과에 포함시키고자 할 때 사용한다.
	ex) <%=값%>
	- 스크립트릿(Scriptlet) : 자바코드를 작성할 때 사용한다. 
	ex) <% 자바코드들... %>
	- 선언부(Declaration) : 스크립트릿이나 표현식에서 사용할 수 있는 메서드를 작성할 때 사용한다. 
	ex) <%! ~~~ %> 
	 
3. JSP 기본객체와 영영(SCOPE)
	
	- PAGE 영역 : 하나의 JSP페이지를 처리할 때 사용되는 영역 => pageContext
	- REQUEST 영역 : 하나의 HTTP요청을 처리할 때 사용되는 영역 => request
	- SESSION 영역 : 하나의 웹브라우저(사용자)와 관련된 영역 => session
	- APPLICATION 영역 : 하나의 웹애플리케이션과 관련된 영역 => application
		  
 --%>

<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%

	List<MemberVO> memlist = (List<MemberVO>)request.getAttribute("memlist");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>이름3</th>
			<th>전화번호</th>
			<th>주소</th>
		</tr>
<%
	int memSize = memlist.size();
	if(memSize > 0) {
		for(MemberVO mv : memlist) {
%>
		<tr>
			<td><%=mv.getMemId() %></td>
			<td><%=mv.getMemName() %></td>
			<td><%=mv.getMemTel() %></td>
			<td><%=mv.getMemAddr() %></td>
		</tr>
<%
		} // for 문
	} else {
%>
	<tr>
		<td colspan="4">회원정보가 존재하지 않습니다.</td>
	</tr>
<%
	} // if 문
%>
	<tr align="center">
		<td colspan="4"><a href="#">[회원 등록]</a></td>
	</tr>

	</table>

</body>
</html>