<%@page import="entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="edit.user" method="post">
	<table>
		<tr>
			<td>用户名</td>
			<td><input type="text" name="username" id="username" value="<%
			User user = (User)request.getAttribute("users");
			out.println(user.getUsername()); %>"></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input type="password" name="passwd" id="passwd" value="<%out.println(user.getPasswd()); %>"></td>
		</tr>
		<tr>
			<td>手机号</td>
			<td><input type="text" name="telnum" id="telnum" value="<%out.println(user.getTelnum()); %>"></td>
		</tr>
		<tr>
			<td>地址</td>
			<td><input type="text" name="address" id="address" value="<%out.println(user.getAddress()); %>"></td>
		</tr>
		<tr>
			<td><input type="hidden" name="cmd" value="edit_plus" /></td>
			<td><input type="hidden" name="userid" value="<%=user.getUserid() %>" /></td>
			<td><button type="submit" name="submit" id="submit" >提交</button></td>			
		</tr>
	</table>
</form>
</body>
</html>