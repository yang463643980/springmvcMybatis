<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'CountryList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.7.1.js"></script>


  </head>
  
  <body>
  
    <a href="country/preAdd.do">添加</a>
    <form action="country/select.do" method="post">
    	输入国家<input name="name" type="text"/><br/>
    	输入语言<input name="language" type="text"/><br/>
    	<input type="submit" value="查询"/>
    <table border="1">
    	<tbody>
    		<tr>
    			<th>名称</th>
    			<th>语言</th>
    			<th>操作</th>
    		</tr>
    		<c:if test="${!empty countryList}">
    			<c:forEach var="country" items="${countryList}">
    				<tr>
    					<td>${country.name}</td>
    					<td>${country.language}</td>
    					<td>
    						<a href="country/preUpdate.do?id=${country.id}">修改</a>
    						<a href="country/delete.do?id=${country.id }">删除</a>
    						<input type="hidden" value="${country.id}" name="id">
    					</td>
    				</tr>
    			</c:forEach>
    		</c:if>
    	</tbody>
    </table>
    </form>
  </body>
</html>