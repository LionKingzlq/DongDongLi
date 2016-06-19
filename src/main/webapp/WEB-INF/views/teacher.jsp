<%--
  Created by IntelliJ IDEA.
  User: Me10ns
  Date: 2016/3/11
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

<body style="">
	<%--header--%>
	<%@ include file="header.jsp"%>
	<script>
		$('.navlist').children(":first").next().next().addClass('tabActive');
		/* $(function() {

			document.documentElement.style.overflowX = 'hidden';
			//var r = window.screen.availWidth / document.body.offsetWidth;
			$(document.body).css({
				"-webkit-transform" : "scaleX(" + 0.93 + ")"
			});
		}); */
	</script>


	<div class="pic">
		<img src="<c:url value="/res/images/teacher/1.png"/>" style="width:100%;" />
	</div>

	<div class="info">
		<div class="info-pic">
			<img src="<c:url value="/res/images/teacher/2.png"/>"
				style="margin-left: 98px; width: 359px; height: 359px; -webkit-border-radius: 50em; -moz-border-radius: 50em; border-radius: 50em;">
		</div>
		<div class="info-intro">
			<div class="info-name">${teacher.name}</div>
			<div class="info-title">${teacher.position}</div>
			<c:if test="${!flag}">
				<div class="info-quote1">
					<img src="/ddl/res/images/teacher/s.JPG"
						style="margin-left: 30px; margin-right: 35px; vertical-align: super">${teacher.motto}
					<img src="<c:url value="/res/images/teacher/x.JPG"/>"
						style="margin-left: 30px; margin-right: 35px; vertical-align: super">
				</div>
			</c:if>
			<c:if test="${flag}">
				<div class="info-quote1">
					<img src="<c:url value="/res/images/teacher/s.JPG"/>"
						style="margin-left: 30px; margin-right: 35px; vertical-align: super">${ mottoes[0] }
				</div>
				<div class="info-quote2">
					${ mottoes[1]}<img src="<c:url value="/res/images/teacher/x.JPG"/>"
						style="vertical-align: sub; margin-left: 30px;">
			</c:if>
		</div>
	</div>
	</div>
	<div class="intro">
		${teacher.content}
	</div>
	<%@ include file="ddl.jsp"%>
	<%@ include file="footer.jsp"%>
</body>
</html>
