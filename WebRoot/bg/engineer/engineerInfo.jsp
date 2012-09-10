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
													<td width="6%" height="19">
														<div align="center">
															<img src="bg/images/tb.gif" width="14" height="14" />
														</div>
													</td>
													<td width="94%">
														<span class="STYLE1">工程师信息列表</span>
													</td>
												</tr>
											</table>
										</td>
										<td>
											<div align="right">
												<span class="STYLE1"> <a href="bg/engineer/addEngineer.jsp"
													style="text-decoration: none; color: #e1e2e3"><img
															src="bg/images/add.gif" width="10" height="10" />添加</a>
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
									<span class="STYLE10">姓名</span>
								</div>
							</td>
							<td width="15%" height="20" bgcolor="d3eaef" class="STYLE6">
								<div align="center">
									<span class="STYLE10">电话</span>
								</div>
							</td>
							<td width="14%" height="20" bgcolor="d3eaef" class="STYLE6">
								<div align="center">
									<span class="STYLE10">邮箱</span>
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
								<td width="4%" height="20" class="STYLE19">
									<div align="center">
										${one.id }
									</div>
								</td>
								<td height="20" class="STYLE19">
									<div align="center">
										<span class="STYLE19"> ${one.name }</span>
									</div>
								</td>
								<td height="20" class="STYLE19">
									<div align="center">
										<span class="STYLE19"> ${one.phone }</span>
									</div>
								</td>
								<td height="20" class="STYLE19">
									<div align="center">
										<span class="STYLE19"> ${one.email }</span>
									</div>
								</td>
								<td height="20">
									<div align="center" class="STYLE21">
										<span><a href="EngineerAction!queryById.action?engineer.id=${one.id}&forword=updatePage">修改</a>
										</span> |
										<span><a
											href="EngineerAction!deleteById.action?engineer.id=${one.id }&page.pageNo=${page.pageNo}"
											onclick="return confirm('你正在执行的操作将使得本工程师信息不再可用,你确定要执行?')">删除</a>
										</span> |
										<span><a href="EngineerAction!queryById.action?engineer.id=${one.id}&forword=detailPage">详细</a></span>
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
													href="EngineerAction!queryAll.action?page.pageNo=1" class="STYLE13">首页</a>
												</span>
											</div>
										</td>
										<c:if test="${page.pageNo!='1' }">
											<td width="49">
												<div align="center">
													<span class="STYLE22"><a
														href="EngineerAction!queryAll.action?page.pageNo=${page.pageNo-1}"
														class="STYLE13">上一页</a>
													</span>
												</div>
											</td>
										</c:if>

										<c:if test="${page.pageNo < page.allPage}">
											<td width="49">
												<div align="center">
													<span class="STYLE22"><a
														href="EngineerAction!queryAll.action?page.pageNo=${page.pageNo+1}"
														class="STYLE13">下一页</a>
													</span>
												</div>
											</td>
										</c:if>
										<td width="49">
											<div align="center">
												<span class="STYLE22"><a
													href="EngineerAction!queryAll.action?page.pageNo=${page.allPage}"
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
