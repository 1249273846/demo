<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<TITLE>网上订餐系统</TITLE>
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
		网上订餐系统&nbsp;&nbsp;&nbsp;&nbsp;欢迎您 ${resuser.username }&nbsp;&nbsp;&nbsp;</TD>
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
							style="FONT-SIZE: 13px; COLOR: #000000">&nbsp;|&nbsp;</FONT></TD>
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
							width=15> 欢迎您使用我学我会网上订餐系统，祝您用餐愉快！</marquee></div>
						&nbsp;&nbsp;</TD>
					</TR>
				</TBODY>
			</TABLE>
			<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
				<TBODY>
					<TR>
						<TD align=right background="images/004.gif" height=19></TD>
					</TR>
				</TBODY>
			</TABLE>
			<TABLE cellSpacing=0 cellPadding=0 width="96%" align=center border=0>
				<TBODY>
					<TR>
						<TD><BR>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			<table cellspacing=1 cellpadding=4 width="92%" border=0
				align="CENTER" bgcolor="#c0c0c0">
				<form method="POST" action="checkout.servlet?op=order" >
				<tr bgcolor="#dadada">
					<td colspan="5" height="25" align=center><font color="#000000">请确认支付和配送信息</font></td>
				</tr>
				<tr bgcolor="#ffffff">
					<td width="22%" align="RIGHT"><font color="#000000">订 餐
					人： </font></td>
					<td colspan=4 width="78%"><input type="text" name="name"
						size="46" maxlength="20" value="${resuser.username }"></td>
				</tr>
				<tr bgcolor="#ffffff">
					<td width="22%" align="RIGHT"><font color="#000000">送货地址：</font></td>
					<td colspan=4 width="78%"><input type="text" name="address"
						size="46" maxlength="200"></td>
				</tr>
				<tr bgcolor="#ffffff">
					<td width="22%" height="31" align="RIGHT"><font
						color="#000000">联系电话：</font></td>
					<td colspan=4 width="78%" height="31"><input type="text"
						name="tel" size="46" maxlength="13"></td>
				</tr>
				<tr bgcolor="#ffffff">
					<td width="22%" align="RIGHT"><font color="#000000">电子邮件：</font></td>
					<td colspan=4 width="78%"><input type="text" name="email"
						size="46" maxlength="50" value="${resuser.email }"></td>
				</tr>
				<tr bgcolor="#ffffff">
					<td width="22%" height="31" align="RIGHT"><font
						color="#000000">配送方式：</font></td>
					<td colspan=4 width="78%" height="31">
					<table width='100%' border='0' cellpadding='3' cellspacing='1'
						bgcolor='#c0c0c0'>
						<tr bgcolor='#ffffff'>
							<td align='center' width='20'><input type='radio'
								name='ps' value='送餐上门'></td>
							<td nowrap><font color='#000000'>&nbsp;送餐上门&nbsp;</font></td>
							<td><font color='#000000'>10元起送</font></td>
						</tr>
					</table>

					</td>
				</tr>
				<tr bgcolor="#ffffff">
					<td width="22%" height="36" align="RIGHT"><font
						color="#000000">支付方式：</font></td>
					<td colspan=4 width="78%" height="36">
					<table width='100%' border='0' cellpadding='3' cellspacing='1'
						bgcolor='#c0c0c0'>
						<tr bgcolor='#ffffff'>
							<td align='center' width='20'><input type='radio'
								name='payradio' value='餐到付款'></td>
							<td nowrap><font color='#000000'>&nbsp;餐到付款&nbsp;</font></td>
							<td><font color='#000000'>仅限北京3环内</font></td>
						</tr>
					</table>

					</td>
				</tr>
				<tr bgcolor="#ffffff">
					<td width="22%" height="31" align="right"><font
						color="#000000">订单附言：</font></td>
					<td colspan=4 width="78%" height="31"><textarea name="status"
						cols="45" rows="6"></textarea></td>
				</tr>
				<tr bgcolor="#dadada">
					<td colspan="5" height="12" align="center"><input type=submit
						value="确认以上信息无误,提交" name=Submit></td>
				</tr>
				</form>
			</table>
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
