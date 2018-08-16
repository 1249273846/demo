<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
</head>
<body>
<%-- index.jsp   跳转  show.jsp --%>
	<%request.getRequestDispatcher("resfood.servlet?op=query").forward(request,response); %>
</body>
</html>