<%@page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>legends</title>
</head>
<body>
<h3>HelloWorld!</h3>
<table width="100%" border="1">
	<tr>
		<td>序号</td>
		<td>姓名</td>
		<td>描述</td>
		<td>职位</td>
	</tr>
	<c:forEach var="item" items="${list}" varStatus="status">
	<tr>
		<td>${status.count}</td>
		<td>${item.heroname}</td>
		<td>${item.herodesc}</td>
		<td>${item.position}</td>
	</tr>
	</c:forEach> 
</table>
<br>
<table width="100%" border="1">
	<tr>
		<td>主键</td>
		<td>姓名</td>
		<td>描述</td>
		<td>职位</td>
	</tr>
    <s:iterator value="legendsList">
    <tr>
    	<td><s:property value="id"/></td>
    	<td><s:property value="heroname"/></td>
    	<td><s:property value="herodesc"/></td>
    	<td><s:property value="position"/></td>
    </tr>
    </s:iterator>
</table>
<s:debug></s:debug>
</body>
</html>