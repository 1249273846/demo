<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>菜品管理</title>
<script type="text/javascript">

</script>
<!-- JSP 指令 （静态引入） -->
<%@ include file="easyuiLink.jsp"%>
</head>
<%
	String path = application.getContextPath();
%>
<body>
	<!-- 
		使用 easyui 的 datagrid 控件，以 AJAX 的方式查询数据 ，
		easyui 控件接收 JSON 格式的数据
	-->
	<table class="easyui-datagrid" title="用户管理"
		data-options="
				fit:true,
				pagination:true,
				pageList:[5,10,15,20,25],
				pageSize:5,
				singleSelect:true,
				url:'<%=path%>/resuser.servlet?op=finduser',
				method:'post',
				toolbar:'#tb'">
		<!-- page 页数     rows 行数 -->
		<thead>
			<tr>
				<th data-options="field:'userid',width:100">用户编号</th>
				<th data-options="field:'username',width:250">用户名</th>
				<th data-options="field:'pwd',width:250">用户密码</th>
				<th data-options="field:'email',width:250">用户邮箱</th>
			</tr>
		</thead>
	</table>
</body>
</html>