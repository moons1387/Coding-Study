<%@page import="kr.or.ddit.comm.vo.AtchFileDetailVO"%>
<%@page import="kr.or.ddit.comm.vo.AtchFileVO"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	MemberVO mv = (MemberVO) request.getAttribute("mv");

	AtchFileVO atchFileVO = (AtchFileVO) request.getAttribute("atchFileVO");
	
	out.println(1);
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 변경</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/member/update.do"
		method="post" enctype="multipart/form-data">
		<input type="hidden" name="memId" value="<%=mv.getMemId()%>">
		<input type="hidden" name="atchFileId" value="<%=mv.getAtchFileId()%>">
		<table>
			<tr>
				<td>I D:</td>
				<td><%=mv.getMemId()%></td>
			</tr>
			<tr>
				<td>이름:</td>
				<td><input type="text" name="memName"
					value="<%=mv.getMemName()%>"></td>
			</tr>
			<tr>
				<td>전화번호:</td>
				<td><input type="text" name="memTel"
					value="<%=mv.getMemTel()%>"></td>
			</tr>
			<tr>
				<td>주소:</td>
				<td><textarea name="memAddr"><%=mv.getMemAddr()%></textarea></td>
			</tr>
			<tr>
				<td>기존첨부파일:</td>
				<td>
<%
					if (atchFileVO != null) {
						for (AtchFileDetailVO detailVO : atchFileVO.getAtchFileDetailList()) {
%>
					<div>
						<a href="<%=request.getContextPath()%>/download.do?atchFileId=<%=detailVO.getAtchFileId()%>&fileSn=<%=detailVO.getFileSn()%>"><%=detailVO.getOrignlFileNm()%></a>
					</div> 
<%
 						}
 					}
%>
				</td>
			</tr>
			<tr>
				<td>신첨부파일</td>
				<td><input type="file" name="atchFile" multiple="multiple"></td>
			</tr>
		</table>
		<input type="submit" value="회원정보 수정">

	</form>
</body>
</html>