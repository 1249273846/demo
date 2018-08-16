<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我学我会管理系统</title>
	<link rel="stylesheet" type="text/css" href="/OrderFood/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="/OrderFood/easyui/themes/icon.css">
	<script type="text/javascript" src="/OrderFood/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="/OrderFood/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/OrderFood/easyui/locale/easyui-lang-zh_CN.js"></script>
	
	<style type="text/css">
		.easyui-linkbutton {
				margin-top: 5px;
				width: 90%;
		}
	</style>
	
<script type="text/javascript">

	function addTab(title, href) {
		// 判断标签页是否存在
		if ($('#tbs').tabs("exists", title) == false){
			var contentStr;
			// 创建显示内容的子框架(子window)
			if (href) {
				contentStr = '<iframe scrolling="no" frameborder="0" src="'
						+ href + '" style="width:100%;height:100%;"></iframe>';
			} else {
				contentStr = '无内容';
			}
			// 添加标签页
			$('#tbs').tabs("add",{
				title : title,
				closable : true,
				content : contentStr
			});
		} else {
			// 选择已经打开的标签页
			$('#tbs').tabs('select', title);
		}
	}
</script>
	
</head>
<body class="easyui-layout">
	<div data-options="region:'north'" style="overflow:hidden;">
		<table style="width: 100%">
			<tr>
				<td width="20px">
					<img alt="Logo" src="/OrderFood/easyui/themes/icons/large_chart.png">
				</td>
				<td>
					<h2 style="margin: 1px; color: #333">我学我会管理系统</h2>
				</td>
				<td align="right" style="padding: 5px 11px">
					欢迎: ${admin.raname }
					<a href="index.jsp">退出</a>	
				</td>
			</tr>
		</table>
	</div>
	<div class="easyui-accordion" data-options="region:'west',split:true" title="菜单"
	 style="width:200px;">
		<div title="营业数据" style="text-align:center">
			<a href="#" class="easyui-linkbutton" onclick="addTab(this.innerText,'/OrderFood/back/resfood.jsp')" data-options="iconCls:'icon-search'">菜单管理</a>
			<a href="#" class="easyui-linkbutton" onclick="addTab(this.innerText,'/OrderFood/back/resorder.jsp')" data-options="iconCls:'icon-print'">订单查询</a>
			<a href="#" class="easyui-linkbutton" onclick="addTab(this.innerText,'/OrderFood/back/resuser.jsp')" data-options="iconCls:'icon-reload'">用户查询</a>
		</div>
		<div title="系统管理" style="text-align:center">
			<a href="#" class="easyui-linkbutton" onclick="addTab(this.innerText)" data-options="iconCls:'icon-search'">管理员查询</a>
			<a href="#" class="easyui-linkbutton" onclick="addTab(this.innerText)" data-options="iconCls:'icon-print'">文件上传</a>
		</div>
		<div title="营业统计" style="text-align:center"></div>
	</div>
		<div id="tbs" class="easyui-tabs" data-options="region:'center',iconCls:'icon-ok'">
			<div title="管理首页"></div>
		</div>
	<div data-options="region:'south'" style="text-align: center; padding: 3px">
		<span>版权:源辰公司</span>
	</div>
</body>
</html>