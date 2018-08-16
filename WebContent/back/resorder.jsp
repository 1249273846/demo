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
	<table class="easyui-datagrid" title="订单管理" id="orderGrid"
		data-options="
				fit:true,
				pagination:true,
				pageList:[5,10,15,20,25],
				pageSize:5,
				singleSelect:true,
				url:'<%=path%>/checkout.servlet?op=findorder',
				method:'post',
				toolbar:'#tb'">
		<!-- page 页数     rows 行数 -->
		<thead>
			<tr>
				<th data-options="field:'roid',width:80">订单编号</th>
				<th data-options="field:'userid',width:100">用户ID</th>
				<th data-options="field:'address',width:200">地址</th>
				<th data-options="field:'tel',width:150">电话</th>
				<th data-options="field:'deliverytime',width:150">配送时间</th>
				<th data-options="field:'ps',width:250">送餐方式</th>
				<th data-options="field:'status',width:200">订单备注</th>

			</tr>
		</thead>
	</table>
</body>
</html>

