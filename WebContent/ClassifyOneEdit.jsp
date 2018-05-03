<%@page import="entity.ClassifyOne"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="edit.classify1" method="post">
	<table>
		<tr>
			<td>一级目录名称</td>
			<td><input type="text" name="classifyonename" id="classifyonename" value="<%
			ClassifyOne classifyone = (ClassifyOne)request.getAttribute("classifyone");
			out.println(classifyone.getClassifyonename()); %>"></td>
		</tr>
		
		<tr>
			<td><input type="hidden" name="cmd" value="edit_plus" /></td>
			<td><input type="hidden" name="userid" value="<%=classifyone.getClassifyoneid() %>" /></td>
			<td><button type="submit" name="submit" id="submit" >提交</button></td>			
		</tr>
	</table>
</form>
</body>
</html>