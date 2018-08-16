<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>随便写</title>
</head>
<body>
	
	<form method="POST" name="loginForm" action="resadmin.servlet">
		<table style="margin: 100px auto">
			<tr>
				<td>用户名：</td>
				<td>
					<input name="name" value="">
				</td>
			</tr>
			<tr>
				<td>密码：</td>
				<td>
					<input name="pwd" type="password" value="">
				</td>
			</tr>
			<tr>
				<td align="right" colspan="2">
					<input type="submit" value="登录" >
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>