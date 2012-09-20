<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title></title>
		<link rel="stylesheet" href="bg/css/base.css" />
		<style type="text/css">
<!--
.checkfalse{
	font-weight:bold;
}
	
-->
</style>
		<script src="js/jquery.js" type="text/javascript"></script>
		<script type="text/javascript">
			$(function(){
			//	alert("loading");
			});
		</script>
	</head>

	<body>
	<%@include file="../prompt.jsp"%> 
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td height="30">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="24" bgcolor="#353c44">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td>
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td width="6%" height="19" >
														<div align="center">
															<img src="bg/images/tb.gif" width="14" height="14" />
														</div>
													</td>
													<td width="94%" >
														<span class="STYLE1">机床错误信息列表</span>
													</td>
												</tr>
											</table>
										</td>
										<td>
											<div align="right">
												<span class="STYLE1"> <a href="bg/record/addRecord.jsp"
													style="text-decoration: none; color: #e1e2e3"><img
															src="bg/images/add.gif" width="10" height="10" />手动添加</a>
													&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
												</span>
											</div>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="1"
						bgcolor="#a8c7ce">
						<tr>
							<td width="4%" height="20" bgcolor="d3eaef" class="STYLE10">
								<div align="center">
									编号
								</div>
							</td>
							<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6">
								<div align="center">
									<span class="STYLE10">报警号</span>
								</div>
							</td>
							<td width="15%" height="20" bgcolor="d3eaef" class="STYLE6">
								<div align="center">
									<span class="STYLE10">机床编号</span>
								</div>
							</td>
							<td width="14%" height="20" bgcolor="d3eaef" class="STYLE6">
								<div align="center">
									<span class="STYLE10">是否已解决</span>
								</div>
							</td>
							<td width="14%" height="20" bgcolor="d3eaef" class="STYLE6">
								<div align="center">
									<span class="STYLE10">日期</span>
								</div>
							</td>
							<td width="14%" height="20" bgcolor="d3eaef" class="STYLE6">
								<div align="center">
									<span class="STYLE10">操作</span>
								</div>
							</td>
						</tr>
						<c:forEach items="${list }" var="one" varStatus="status">
							<tr
								<c:choose>
				<c:when test="${status.count%2==0}">bgcolor="#e2e2e2"</c:when>
				<c:otherwise>bgcolor="#f2f2f2"</c:otherwise></c:choose>>
								<td width="4%" height="20" class="STYLE19  check${one.check}">
									<div align="center">
										${one.id }
									</div>
								</td>
								<td height="20" >
									<div align="center">
										<span class="STYLE19 check${one.check}"> ${one.solution.id }</span>
									</div>
								</td>
								<td height="20" >
									<div align="center">
										<span class="STYLE19  check${one.check}"> ${one.machine.id }</span>
									</div>
								</td>
								<td height="20" class="STYLE19 check${one.check}">
									<div align="center">
										<c:choose>
											<c:when test="${one.solved ==true}">以解决</c:when>
											<c:otherwise>未解决</c:otherwise>
										</c:choose>
									</div>
								</td>
								<td height="20">
									<div align="center">
										<span class="STYLE19  check${one.check}"> ${one.date }</span>
									</div>
								</td>
								<td height="20">
									<div align="center" class="STYLE21  check${one.check}">
										<c:if test="${one.solved ==false }">
										<span><a href="AlarmRecord!solvedMark.action?record.id=${one.id}&page.pageNo=${page.pageNo}">标记为已解决</a>
										</span> |
										</c:if>
										<span><a href="AlarmRecord!queryById.action?record.id=${one.id}&forword=updatePage">修改</a>
										</span> |
										<span><a
											href="AlarmRecord!deleteById.action?record.id=${one.id }&page.pageNo=${page.pageNo}"
											onclick="return confirm('你正在执行的操作将使得本记录不再可用,你确定要执行?')">删除</a>
										</span> |
										<span><a href="AlarmRecord!queryById.action?record.id=${one.id}&forword=detailPage">详细</a></span>
									</div>
								</td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
			<tr>
				<td height="30">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="33%">
								<div align="left">
									<span class="STYLE22">&nbsp;&nbsp;&nbsp;&nbsp;共有<strong>
											${page.allRecord }</strong> 条记录，当前第<strong> ${page.pageNo}</strong>
										页，共 <strong>${page.allPage}</strong> 页</span>
								</div>
							</td>
							<td width="67%">
								<table width="312" border="0" align="right" cellpadding="0"
									cellspacing="0">
									<tr>
										<td width="49">
											<div align="center">
												<span class="STYLE22"><a
													href="${action}?page.pageNo=1" class="STYLE13">首页</a>
												</span>
											</div>
										</td>
										<c:if test="${page.pageNo!='1' }">
											<td width="49">
												<div align="center">
													<span class="STYLE22"><a
														href="${action}?page.pageNo=${page.pageNo-1}"
														class="STYLE13">上一页</a>
													</span>
												</div>
											</td>
										</c:if>

										<c:if test="${page.pageNo < page.allPage}">
											<td width="49">
												<div align="center">
													<span class="STYLE22"><a
														href="${action}?page.pageNo=${page.pageNo+1}"
														class="STYLE13">下一页</a>
													</span>
												</div>
											</td>
										</c:if>
										<td width="49">
											<div align="center">
												<span class="STYLE22"><a
													href="${action}?page.pageNo=${page.allPage}"
													class="STYLE13">末页</a>
												</span>
											</div>
										</td>
										<td width="37" class="STYLE22">
											<div align="center"></div>
										</td>
										<td width="22">
											<div align="center">

											</div>
										</td>
										<td width="22" class="STYLE22">
											<div align="center"></div>
										</td>
									</tr>

								</table>
							</td>
						</tr>
					</table>
	</body>
</html>
