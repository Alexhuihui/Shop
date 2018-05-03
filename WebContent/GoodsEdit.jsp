<%@page import="entity.Goods"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="edit.goods" method="post">
	<table>
		<tr>
			<td>商品名称</td>
			<td><input type="text" name="goodsname" id="goodsname" value="<%
			Goods goods = (Goods)request.getAttribute("goods");
			out.println(goods.getGoodsname()); %>"></td>
		</tr>
		<tr>
			<td>商品价格</td>
			<td><input type="text" name="goodsprice" id="goodsprice" value="<%
			out.println(goods.getGoodsprice()); %>"></td>
		</tr>
		<tr>
			<td>一级目录id号</td>
			<td><input type="text" name="classifyoneid" id="classifyoneid" value="<%
			out.println(goods.getClassifyoneid()); %>"></td>
		</tr>
		<tr>
			<td>二级目录id号</td>
			<td><input type="text" name="classifytwoid" id="classifytwoid" value="<%
			out.println(goods.getClassifytwoid()); %>"></td>
		</tr>
		<tr>
			<td><input type="hidden" name="cmd" value="edit_plus" /></td>
			<td><input type="hidden" name="goodsid" value="<%=goods.getGoodsid() %>" /></td>
			<td><button type="submit" name="submit" id="submit" >提交</button></td>			
		</tr>
	</table>
</form>	
</body>
</html>