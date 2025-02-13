<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	MemberVO mv = (MemberVO) session.getAttribute("LOGIN_USER");
 %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	if(mv != null) { // 로그인 사용자라면...
%>
<p>환영합니다. <%=mv.getMemName() %>님! 여기는 메인페이지 입니다.</p>
<a href="<%=request.getContextPath() %>/logout.do">로그아웃</a>
<%
	} else {
%>
<p>아직 로그인을 하지 않으셨군요, 로그인 먼저 해 주세요... &nbsp;&nbsp;<a href=<%=request.getContextPath() %>"/login.do">로그인 화면으로 이동</a></p>
<%
	}
%>
</body>
</html>