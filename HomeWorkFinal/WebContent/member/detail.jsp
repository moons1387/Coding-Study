<%@page import="kr.or.ddit.comm.vo.AtchFileDetailVO"%>
<%@page import="kr.or.ddit.comm.vo.AtchFileVO"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    
    MemberVO mv = (MemberVO)request.getAttribute("mv");
	AtchFileVO atchFileVO = (AtchFileVO) request.getAttribute("atchFileVO");    

%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 상세</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>I D:</td>
			<td><%=mv.getMemId() %></td>
		</tr>
		<tr>
			<td>이름:</td>
			<td><%=mv.getMemName() %></td>
		</tr>
		<tr>
			<td>전화번호:</td>
			<td><%=mv.getMemTel() %></td>
		</tr>
		<tr>
			<td>주소:</td>
			<td><%=mv.getMemAddr() %></td>
		</tr>
			<td>첨부파일:</td>
			<td>
			<% 
				if(atchFileVO != null) {
					for(AtchFileDetailVO detailVO : atchFileVO.getAtchFileDetailList()) {
			%>
				<div>
					<a href="<%=request.getContextPath() %>/download.do?atchFileId=<%=detailVO.getAtchFileId() %>&fileSn=<%=detailVO.getFileSn() %>"><%=detailVO.getOrignlFileNm() %></a>
				</div>
			<%
					}
				}
			%>
			</td>
		<tr>
			<td colspan="2">
			<a href="<%=request.getContextPath() %>/member/list.do">[목록]</a>
			<a href="<%=request.getContextPath() %>/member/update.do?memId=<%=mv.getMemId() %>">[회원정보 수정]</a>
			<a href="<%=request.getContextPath() %>/member/delete.do?memId=<%=mv.getMemId() %>">[회원정보 삭제]</a>
			</td>
		</tr>
	</table>
</body>
</html>