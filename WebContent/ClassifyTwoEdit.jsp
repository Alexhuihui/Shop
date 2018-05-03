<%@page import="entity.ClassifyTwo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="edit.classify2" method="post">
	<table>
		<tr>
			<td>二级目录名称</td>
			<td><input type="text" name="classifytwoname" id="classifytwoname" value="<%
			ClassifyTwo classifytwo = (ClassifyTwo)request.getAttribute("classifytwo");
			out.println(classifytwo.getClassifytwoname()); %>"></td>
		</tr>
		<tr>
			<td>一级目录id号</td>
			<td><input type="text" name="classifyoneid" id="classifyoneid" value="<%
			out.println(classifytwo.getClassifyoneid()); %>"></td>
		</tr>
		<tr>
			<td><input type="hidden" name="cmd" value="edit_plus" /></td>
			<td><input type="hidden" name="classifytwoid" value="<%=classifytwo.getClassifytwoid() %>" /></td>
			<td><button type="submit" name="submit" id="submit" >提交</button></td>			
		</tr>
	</table>
</form>
</body>
</html>