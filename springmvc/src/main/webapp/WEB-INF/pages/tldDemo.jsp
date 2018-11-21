<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://mytag.sf.net" prefix="myTag"%> 
<%@ taglib uri="/formatNumber/fm" prefix="fm"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'tagtldDemo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
 
  </head>
  
  <body>
    This is my JSP page. <br>
    <myTag:demo.Viewport northTitle="南" westTitle="西"></myTag:demo.Viewport>
    <fm:formatNumber type="number" value="123321"></fm:formatNumber>
    <fm:formatNumber type="String" value="123321"></fm:formatNumber>
    
  </body>
</html>
