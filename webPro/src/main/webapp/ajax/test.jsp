<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	String result = request.getParameter("sendKey");
%>
    
<strong>요청정보(<%=result %>)</strong>