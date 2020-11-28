<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="/WEB-INF/pager.tld" prefix="q"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<jsp:include page="/meta.jsp" />
	<title>公告列表</title>
	<jsp:include page="/link.jsp" />
</head>
<body>
	<jsp:include page="/top.jsp"></jsp:include>

	<!-- 公告列表 -->
	<div class="wrapper" style="min-height: 500px">
		<div class="panel" id="news_list">
			<div class="panel-heading">公告列表</div>
			<table class="table table-striped table-hover">
				<tbody>
					<c:forEach items="${newsPage.items}" var="n">
						<tr>
							<td><a href="${ctx}/news/detail?id=${n.id}">${n.title}</a> <br>
								<fmt:formatDate value="${n.pub_time}"
									pattern="yyyy-MM-dd HH:mm:ss" /></td>
							<td style="width: 180px;"><a
								href="${ctx}/news/detail?id=${n.id}">查看详细内容&gt;&gt;</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="panel-footer">
				<q:pager totalElements="${newsPage.totalElements}"
					number="${newsPage.number}" />
				<div style="clear: both;"></div>
			</div>
		</div>
	</div>
	<!-- /公告列表 -->

	<jsp:include page="/bottom.jsp"></jsp:include>

	<script src="${ctx}/zui/lib/jquery/jquery.js"></script>
	<script src="${ctx}/js/jquery.scrollUp.min.js"></script>
	<script src="${ctx}/zui/js/zui.js"></script>
	<script src="${ctx}/js/my.js"></script>
</body>
</html>