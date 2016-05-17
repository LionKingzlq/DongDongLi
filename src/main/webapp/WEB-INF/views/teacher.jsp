<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="zh-CN" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html" ; charset="utf-8">
<title>栋栋梨教育——带你走向更精彩的未来</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/res/css/bootstrap.css"/>">
<link type="text/css" rel="stylesheet"
	href="<c:url value="/res/css/bootstrap-theme.css"/>">
<link type="text/css" rel="stylesheet"
	href="<c:url value="/res/css/teacher.css"/>">
<script src="<c:url value="/res/js/jquery-1.9.1.min.js"/>"
	language="javascript"></script>
<script src="<c:url value="/res/js/jquery.SuperSlide.2.1.1.js"/>"
	language="javascript"></script>
<script src="<c:url value="/res/js/bootstrap.js"/>"
	language="javascript"></script>
</head>

<body>
	<%--header--%>
	<%@ include file="header.jsp"%>
	<script>
		$('.navlist').children(":first").next().next().addClass('tabActive')
	</script>

	<div class="pic">
		<img src="<c:url value="/res/images/teacher/1.png"/>">
	</div>

	<div class="info">
		<div class="info-pic">
			<img src="${wang.imgPath}"
				style="margin-left: 98px; width: 359px; height: 359px;">
		</div>
		<div class="info-intro">
			<div class="info-name">${wang.name}</div>
			<div class="info-title">${wang.position}</div>
			<div class="info-quote1">
				<img src="<c:url value="/res/images/teacher/s.JPG"/>"
					style="margin-left: 44px; margin-right: 45px; vertical-align: super">${wang.motto}
			</div>
			<div class="info-quote2">
				塑造人格<img src="<c:url value="/res/images/teacher/x.JPG"/>"
					style="vertical-align: sub; margin-left: 45px">
			</div>
		</div>
	</div>
	<div class="intro">${wang.content}</div>
	<%@ include file="ddl.jsp"%>
	<%@ include file="footer.jsp"%>
</body>
</html>
