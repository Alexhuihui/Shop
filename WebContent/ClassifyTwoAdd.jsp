<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="add.classify2" method="post">
		<table>
			<tr>
				<td>用户名</td>
				<td><input type="text" name="classifytwoname" id="classifytwoname"></td>
			</tr>
			<tr>
				<td>一级目录id号</td>
				<td><input type="text" name="classifyoneid" id="classifyoneid"></td>
			</tr>
			<tr>
				<td><input type="hidden" name="cmd" value="add_plus" /></td>
				<td><button type="submit" name="submit" id="submit" >添加二级目录</button></td>			
			</tr>
		</table>
	</form>
</body>
</html>