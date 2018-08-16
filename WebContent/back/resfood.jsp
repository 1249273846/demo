<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>菜品管理</title>
<script type="text/javascript">
	function fmtDo(value,row,index){
		var s = '<a href="#" onclick="openEdit('+index+')">修改</a>';
		s +="&nbsp;&nbsp;";
		s +='<a href="#" onclick="openDelete('+index+')">删除</a>';
		return s;
	}
	
	function fmtFphoto(value, row, index) {
		return "<img height='50px' src='../images/"+value+"'>";
	}
	function openEdit(index){
		//打开窗口
		$("#editWin").dialog('open');
		
		if(index != null){
			//获取表格里面的数据
			var data = $("#foodGrid").datagrid('getData');
			var row = data.rows[index];
			var va = data.rows[index]["fphoto"];
			var id = data.rows[index]["fid"];
			//表单加载数据
			$("#form1").form('load',row);
			var path;
			path = "http://localhost:8080/OrderFood/images/" + va;
			$("#fimage").attr("src",path);
			$("#id").attr("value",id);
			$("#op").attr("value", "mod");
		} else {
			// 表单清空数据
			$("#form1").form('load',{
				fname : "",
				normprice : "",
				dealprice : "",
				detail : "",
				fphoto : ""
			});
		}
	}
	
	function openDelete(index){
		// 打开窗口
		$("#editdelete").dialog('open');
		// 得到对应的index及id
		var data = $("#foodGrid").datagrid('getData');
		var id = data.rows[index]["fid"];
		$("#delid").attr("value",id);
	}
	
	function deletes(){
		$("#form2").form( 'submit', {
		    success:function(data){
		   		// 使用eval函数将 json 字符串转成 对象 d
				eval("var d =" + data);
				if(d.code == "1"){
					alert(d.data);
					$("#editdelete").dialog('close');
					$("#foodGrid").datagrid('reload');
				} else {
					alert(d.data);
				} 
		    }
		});
	}
	
	// 保存
	function save(){
		$("#form1").form( 'submit', {
		    success:function(data){
		   		// 使用eval函数将 json 字符串转成 对象 d
				eval("var d =" + data);
				if(d.code == "1"){
					alert(d.data);
					$("#editWin").dialog('close');
					$("#foodGrid").datagrid('reload');
				} else {
					alert(d.data);
				} 
		    }
		});
	}
	// 上传图片
	function uploadImg(){
		// 创建表单提交对象
		var fd = new FormData();
		// 添加上传的图片，值原生的HTML对象
		fd.append("fphoto", $("#file")[0].files[0]);
		// 调用jquery ajax 方法
		$.ajax({
			url:"/OrderFood/uploadImg.s",
			type:"post",
			data:fd,
			processData:false,  // 禁止jquery处理参数
			success:function(data){
				if(data){
					// 设置显示的图片路径
					fimage.src = "/OrderFood" + data;
					// 将上传的图片路径写到 fphoto
					fphoto.value = data;
				} else {
					alert("图片上传失败！");
				}
			}
		});
	}
	
	
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
	
	<table class="easyui-datagrid" title="菜品管理" id="foodGrid"
		data-options="
				fit:true,
				pagination:true,
				pageList:[5,10,15,20,25],
				pageSize:5,
				singleSelect:true,
				url:'<%=path%>/resfood.servlet?op=query&ajax=1',
				method:'post',
				toolbar:'#tb'">
		<!-- page 页数     rows 行数 -->
		<thead>
			<tr>
				<th data-options="field:'fid',width:80">菜品编号</th>
				<th data-options="field:'fname',width:100">菜品名</th>
				<th data-options="field:'normprice',width:80,align:'right'">原价</th>
				<th data-options="field:'realprice',width:80,align:'right'">现价</th>
				<th data-options="field:'detail',width:250">菜品描述</th>
				<th data-options="field:'fphoto',formatter:fmtFphoto">菜品图片</th>
				<th data-options="field:'dofid',formatter:fmtFphoto,formatter:fmtDo">操作</th>
			</tr>
		</thead>
	</table>

	<div id="tb" style="padding: 5px; height: auto">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
				onclick="openEdit()">新增菜品</a>
	</div>

	<div id="editWin" class="easyui-dialog" title="Basic Dialog"
		style="width: 400px; height: 500px; padding: 10px" 
		data-options="iconCls:'icon-save',closed:true,modal:true">
		<form action="<%=path %>/resfood.servlet" id="form1">
			<input type="hidden" name="op" id="op" value="add">
			 <input type="hidden" id="id" name="fid" value="">
		<table>
			<tr>
				<td>菜品名：</td>
				<td width="250px">
					<input class="easyui-textbox" name="fname" style="width: 100%">
				</td>
			<tr>
				<td>原价：</td>
				<td>
					<input class="easyui-numberbox" name="normprice" style="width: 100%">
				</td>
			</tr>
			<tr>
				<td>现价：</td>
				<td>
					<input class="easyui-numberbox" name="realprice" style="width: 100%">
				</td>
			</tr>
			<tr>
				<td>菜品描述：</td>
				<td>
					<input class="easyui-textbox" name="detail" style="width: 100%">
				</td>
			</tr>
			<tr>
				<td>
					点击图片<br>上传：
				</td>
				<td>
					<input type="hidden" name="fphoto" id="fphoto" >
					<!-- 图片控件，用于显示图片 -->
					<img id="fimage" alt="请上传菜品图片" width="250px" src="<%=path %>/images/noimg.gif"
						onclick="file.click();">
					<!-- 文件上传控件，用于上传图片。采用AJAX上传方式，将该控件隐藏 -->
					<input id="file" type="file" style="display: none;" onchange="uploadImg();">
				</td>
			</tr>
			<tr>
				<td align="right" colspan="3">
					<a class="easyui-linkbutton" data-options="iconCls:'icon-save'" style="width: 100px"
							onclick="save()">保存</a>
					<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" style="width: 100px"
							onclick='$("#editWin").dialog("close");'>取消</a>
				</td>
			</tr>
		</table>
		</form>
	</div>

	<div id="editdelete" class="easyui-dialog" title="Basic Dialog"
		style="width: 400px; height: 500px; padding: 10px"
		data-options="iconCls:'icon-save',closed:true,modal:true">
		<form action="<%=path%>/resfood.servlet" id="form2">
			<input type="hidden" id="op" name="op" value="del"> <input
				type="hidden" id="delid" name="fid" value="">
			<table>
				<tr>
					<td align="center">您确定要删除此菜品吗？</td>
				</tr>
				<tr>
					<td align="right" colspan="3">
					<a class="easyui-linkbutton"
						data-options="iconCls:'icon-save'" style="width: 100px"
						onclick="deletes()">确定</a> <a class="easyui-linkbutton"
						data-options="iconCls:'icon-cancel'" style="width: 100px"
						onclick='$("#editWin").dialog("close");'>取消</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>

