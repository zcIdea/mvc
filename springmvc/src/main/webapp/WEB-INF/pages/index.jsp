<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://mytag.sf.net" prefix="myTag"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<body>
<h2>Hello World!</h2>
<h1>${springmvc }</h1>

<myTag:demo.Viewport northTitle="南" westTitle="西"></myTag:demo.Viewport>

</body>
</html>
