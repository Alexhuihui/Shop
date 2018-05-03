<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
</head>
<body>
	<form action="add.user" method="post">
		<table>
			<tr>
				<td>用户名</td>
				<td><input type="text" name="username" id="username"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="passwd" id="passwd"></td>
			</tr>
			<tr>
				<td>手机号</td>
				<td><input type="text" name="telnum" id="telnum"></td>
			</tr>
			<tr>
				<td>地址</td>
				<td><input type="text" name="address" id="address"></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><input type="radio" name="genderid" value="2">男</td>
				<td><input type="radio" name="genderid" value="3">女</td>
			</tr>
			<tr>
				<td>备注</td>
				<td><textarea></textarea></td>
			</tr>
			<tr>
			<td><input type="hidden" name="cmd" value="add_plus" /></td>
			<td><button type="submit" name="submit" id="submit" >提交</button></td>			
		</tr>
		</table>
	</form>
</body>
</html>