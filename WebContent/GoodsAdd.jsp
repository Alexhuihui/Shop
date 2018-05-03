<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="add.goods" method="post">
		<table>
			<tr>
				<td>商品名称</td>
				<td><input type="text" name="goodsname" id="goodsname"></td>
			</tr>
			<tr>
				<td>商品图片</td>
				<td><input type="text" name="goodsimage" id="goodsimage"></td>
			</tr>
			<tr>
				<td>商品价格</td>
				<td><input type="text" name="goodsprice" id="goodsprice"></td>
			</tr>
			<tr>
				<td>一级目录id号</td>
				<td><input type="text" name="classifyoneid" id="classifyoneid"></td>
			</tr>
			<tr>
				<td>二级目录id号</td>
				<td><input type="text" name="classifytwoid" id="classifytwoid"></td>
			</tr>
			<tr>
				<td><input type="hidden" name="cmd" value="add_plus" /></td>
				<td><button type="submit" name="submit" id="submit" >添加商品</button></td>			
			</tr>
		</table>
	</form>
</body>
</html>