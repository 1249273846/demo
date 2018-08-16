<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/mytld.tld" prefix="mt"%>
<!DOCTYPE html>
<HTML>
<HEAD>
<TITLE>网上订餐系统</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<link rel="stylesheet" href="./css/styles.css" type="text/css" />

<SCRIPT language=JavaScript type=text/JavaScript>
<!--

-->
</SCRIPT>

</HEAD>
<BODY leftMargin=0 topMargin=0 marginheight="0" marginwidth="0">
<table cellSpacing=0 cellPadding=0 width=776 align=center border=0>
	<tr>
		<td width="220" rowspan="3"><img src="images/jb_logo.jpg"
			width="200"></td>
		<td width="556" height="36">&nbsp;</td>
	</tr>
	<tr>
		<TD
			style="FONT-SIZE: 24pt; FILTER: blur(add=1, direction=120, strength=5); WIDTH: 100%; COLOR: #000000; FONT-FAMILY: arial; POSITION: relative"
			noWrap><B><span class="STYLE1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 我学我会 </span>
		网上订餐系统&nbsp;&nbsp;&nbsp;&nbsp;欢迎您 ${resuser.username }&nbsp;&nbsp;&nbsp;
		<c:if test="${sessionScope.username!=null }">
		<a href="resuser.servlet?op=logout" style="FONT-SIZE: 24pt;COLOR: RED;" >${ msg}[注销]</a>
		</c:if>
		</B></TD>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
</table>

<TABLE cellSpacing=0 cellPadding=0 width=776 align=center border=0>
	<TBODY>
		<TR>
			<TD background="images/001.gif" height=42>
			<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
				<TBODY>
					<TR>
						<TD width=0 height=20></TD>
						<TD align=middle><FONT
							style="FONT-SIZE: 13px; COLOR: #000000">&nbsp;|&nbsp;</FONT><A
							href="index.jsp" target=_self><FONT
							style="FONT-SIZE: 13px; COLOR: #000000">网站首页</FONT></A><FONT
							style="FONT-SIZE: 13px; COLOR: #000000">&nbsp;|&nbsp;</FONT><A
							href="#" target=_self><FONT
							style="FONT-SIZE: 13px; COLOR: #000000">关于我们</FONT></A><FONT
							style="FONT-SIZE: 13px; COLOR: #000000">&nbsp;|&nbsp;</FONT><A
							href="#" target=_self><FONT
							style="FONT-SIZE: 13px; COLOR: #000000">定餐帮助</FONT></A><FONT
							style="FONT-SIZE: 13px; COLOR: #000000">&nbsp;|&nbsp;</FONT><A
							href="#" target=_self><FONT
							style="FONT-SIZE: 13px; COLOR: #000000">网上定餐</FONT></A><FONT
							style="FONT-SIZE: 13px; COLOR: #000000">&nbsp;|&nbsp;</FONT><A
							href="#" target=_self><FONT
							style="FONT-SIZE: 13px; COLOR: #000000">客服中心</FONT></A><FONT
							style="FONT-SIZE: 13px; COLOR: #000000">&nbsp;|&nbsp;</FONT><A
							href="/OrderFood/ManageLogin.jsp" target=_self><FONT
							style="FONT-SIZE: 13px; COLOR: RED">*管理员登录*</FONT></A><FONT
							style="FONT-SIZE: 13px; COLOR: #000000">&nbsp;&nbsp;</FONT></TD>
					</TR>
				</TBODY>
			</TABLE>
			</TD>
		</TR>
	</TBODY>
</TABLE>
<TABLE cellSpacing=0 cellPadding=0 width=776 align=center border=0>
	<TBODY>
		<TR vAlign=top>
			<TD width=181 background="images/002.gif">
			<TABLE cellSpacing=0 cellPadding=0 width=181 border=0>
				<TBODY>
					<TR>
						<TD><IMG height=234 src="images/left_top.jpg" width=181></TD>
					</TR>
				</TBODY>
			</TABLE>
			<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
				<TBODY>
					<TR>
						<TD align=middle height=30><FONT color=#000000> <SCRIPT
							language=javascript src="images/DateTime2.js"></SCRIPT> <SCRIPT
							language=javascript>tick('cn');</SCRIPT> </FONT></TD>
					</TR>
				</TBODY>
			</TABLE>
			<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
				<TBODY>
					<TR>
						<TD>&nbsp;</TD>
					</TR>
					<TR>
						<TD background="images/003.gif" height=4></TD>
					</TR>
					<TR>
						<TD>&nbsp;</TD>
				</TBODY>
			</TABLE>
			<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
				<TBODY>
					<TR>
						<TD>&nbsp;</TD>
					</TR>
					<TR>
						<TD background="images/003.gif" height=4></TD>
					</TR>
					<TR>
						<TD align=middle>
						<TABLE cellSpacing=0 cellPadding=0 width="94%" border=0>
							<TBODY>
								<TR>
									<TD>&nbsp;</TD>
								</TR>
							</TBODY>
						</TABLE>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			</TD>
			<TD>
			<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
				<TBODY>
					<TR>
						<TD><IMG height=72 src="images/001.jpg" width=595></TD>
					</TR>
				</TBODY>
			</TABLE>
			<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
				<TBODY>
					<TR>
						<TD width="90%">
						<div class='cnt'><marquee
							style="FONT-SIZE: 13px; COLOR: #0000FF" scrollamount='5'
							direction='left'><IMG height=15 src="images/tp009.gif"
							width=15> 欢迎您使用 我学我会 网上订餐系统，祝您用餐愉快！</marquee></div>
						&nbsp;&nbsp;</TD>
					</TR>
				</TBODY>
			</TABLE>
	
			<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
				<TBODY>
											<c:if test="${sessionScope.username==null }">
												<TD width=50% align="left">
													<a href="login.jsp" style="FONT-SIZE: 16pt;COLOR: BLUE;">[登录]</a>&nbsp;&nbsp;&nbsp;
													<a href="register.jsp" style="FONT-SIZE: 16pt;COLOR: BLUE;">[注册]</a>
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													<a href="login.jsp" style="FONT-SIZE: 16pt;COLOR: RED;">${ msg10}${msg11 }</a>
												</TD>
											</c:if>
											<c:if test="${sessionScope.username!=null}">
												<TD width=50% align="left">
												<span>${resfood.fname} ${msg3 }</span>
												<span>${msg4 }</span>
												</TD>
											</c:if>
					<TR>
						<TD align=right background="images/004.gif" height=19>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			<TABLE cellSpacing=0 cellPadding=0 width="96%" align=center border=0>
				<TBODY>
					<TR>
						<TD>

						<TABLE cellSpacing=1 cellPadding=1 width="100%" align=center
							bgColor=#c0c0c0 border=0>
							<TBODY>
								<TR bgColor=#dadada>

									<TD width="100%" align="right"><a href="resshopcart.servlet?op=check"><img
										src="images/lcart_cn.gif" border=0></a></TD>
								</TR>
							</TBODY>
						</TABLE> 
						<BR>
						<TABLE cellSpacing=2 cellPadding=1 width="100%" align=center
							border=0>
							<TBODY>
								<!-- 菜品展示开始     vs  是循环的状态字段 -->
								<c:forEach items="${list}" var="v" varStatus="vs">
								
								<%--一行显示两个菜品  需要对  tr  标签生成进行判断 --%>
								<c:if test="${vs.index % 2 == 0 }">
									<TR>
								</c:if>
									<TD>
									<TABLE height="100%" cellSpacing=1 cellPadding=2 border=0>
										<TBODY>
													<TR>
														<TD vAlign=top width=90 height=90><a href="resfood.servlet?op=find&fid=${v.fid }"
															target=_blank><IMG height=80 alt=点击图片查看内容
									 						src="/OrderFood/images/${v.fphoto }" width=80 border=0></a></TD>
														<TD vAlign=top>
														<TABLE cellSpacing=1 cellPadding=0 width="100%" align=center
														 border=0>
														 <TBODY>
														<TR>
															<TD><A href=# target=_blank name="fname"><STRONG>${v.fname }</STRONG></A></TD>
														</TR>
														<TR>
															<TD height=21><FONT color=#ff0000>现价：人民币${v.realprice }元</FONT><BR>
															<a href=".resfood.servlet?op=find&fid=${v.fid }">${v.detail }</a>！</TD>
														</TR>
													</TBODY>
												</TABLE>
												</TD>
											</TR>	
											<TR>
												<TD height=28>编号: ${v.fid }</TD>
												<TD>
												<TABLE cellSpacing=1 cellPadding=0 width=145 border=0>
													<TBODY>
														<TR>
									<TD align="middle" width="70">
									
									<a href="resshopcart.servlet?op=shopcart&fid=${v.fid }"><img
																src="images/buy_cn.gif" border="0"
																longdesc="shoppingCart.html">
																</a>
											
																</TD>
															<TD align=middle width=70><A href="resfood.servlet?op=find&fid=${v.fid }" target=_blank><IMG
																src="images/detail_cn.gif" border=0></A></TD>
														</TR>
													</TBODY>
												</TABLE>
												</TD>
											</TR>
										</TBODY>
									</TABLE>
									</TD>
									<c:if test="${vs.index % 2 == 1 }">
									</TR>
									</c:if>
								</c:forEach>
								<!-- 菜品展示结束 -->
							<mt:Pages href="resfood.servlet?op=query" rows="6" />
							</TBODY>
						</TABLE>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			<%
				
			%>
		
			</TD>
		</TR>
	</TBODY>
</TABLE>
<TABLE cellSpacing=0 cellPadding=0 width=776 align=center border=0>
	<TBODY>
		<TR>
			<TD background="images/005.gif" height=8></TD>
		</TR>
	</TBODY>
</TABLE>
<TABLE cellSpacing=0 cellPadding=0 width=776 align=center border=0>
	<TBODY>
		<TR>
			<TD bgColor=#eeeeee>
			<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
				<TBODY>
					<TR>
						<TD align=middle><BR>
						<P align=center><FONT color=#000000>Copyright &copy;
						2007&nbsp;&nbsp;&nbsp;&nbsp; 源辰信息</FONT></P>
						<P align=center>&nbsp;</P>
						<BR>
						<BR>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			</TD>
		</TR>
	</TBODY>
</TABLE>
</BODY>
</HTML>
