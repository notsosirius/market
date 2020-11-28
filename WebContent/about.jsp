<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <jsp:include page="/meta.jsp"/>
    <title>关于我们</title>
    <jsp:include page="/link.jsp"/>
</head>
<body>
    <jsp:include page="top.jsp"></jsp:include>
    
    <!-- 公告详情 -->
    <div class="wrapper" style="min-height: 500px">
       <div class="panel" id="news_detail">
		  <div class="panel-heading">
		  <h1>关于我们</h1>
		   <p>这是陈映衡的网络应用开发大作业</p>
		  </div>
		  <div class="panel-body">
		    ${news.content}
		  </div>
		</div>
    </div>    
    <!-- /公告详情 -->
    
    <jsp:include page="/bottom.jsp"></jsp:include>

    <script src="${ctx}/zui/lib/jquery/jquery.js"></script>
    <script src="${ctx}/js/jquery.scrollUp.min.js"></script>
    <script src="${ctx}/zui/js/zui.js"></script>
    <script src="${ctx}/js/my.js"></script>
</body>
</html>