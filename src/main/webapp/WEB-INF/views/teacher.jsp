<%--
  Created by IntelliJ IDEA.
  User: Me10ns
  Date: 2016/3/11
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="zh-CN" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html" ; charset="utf-8">
    <title>栋栋梨教育——带你走向更精彩的未来</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/res/css/bootstrap.css"/>">
    <link type="text/css" rel="stylesheet" href="<c:url value="/res/css/bootstrap-theme.css"/>">
    <link type="text/css" rel="stylesheet" href="<c:url value="/res/css/teacher.css"/>">
    <script src="<c:url value="/res/js/jquery-1.9.1.min.js"/>" language="javascript"></script>
    <script src="<c:url value="/res/js/jquery.SuperSlide.2.1.1.js"/>" language="javascript"></script>
    <script src="<c:url value="/res/js/bootstrap.js"/>" language="javascript"></script>
</head>

<body style="margin-left: -35px;">
<%--header--%>
<%@ include file="header.jsp"%>
<script>
    $('.navlist').children(":first").next().next().addClass('tabActive');
    $(function() {

		//document.documentElement.style.overflowX = 'hidden';
		//var r = window.screen.availWidth / document.body.offsetWidth;
		$(document.body).css({"-webkit-transform":"scaleX(" + 0.93 + ")"});
	});
</script>


<div class="pic" >
    <img src="<c:url value="/res/images/teacher/1.png"/>">
</div>

<div class="info">
    <div class="info-pic">
        <img src="<c:url value="/res/images/teacher/2.png"/>" style="margin-left: 98px;width: 359px;height: 359px;
        -webkit-border-radius: 50em;
    -moz-border-radius: 50em;
    border-radius: 50em;">
    </div>
    <div class="info-intro">
        <div class="info-name">王老师</div>
        <div class="info-title">栋栋梨教育主要负责人之一</div>
        <div class="info-quote1">
            <img src="<c:url value="/res/images/teacher/s.JPG"/>"
                 style="margin-left: 44px;margin-right: 45px;vertical-align: super">培养习惯
        </div>
        <div class="info-quote2">塑造人格<img src="<c:url value="/res/images/teacher/x.JPG"/>"
                                       style="vertical-align: sub;margin-left: 45px">
        </div>
    </div>
</div>
<div class="intro">
    <p>王老师本科毕业于上海市同济大学，高中毕业于上海市建平中学。现栋栋梨教育主要负责人之一。原上海十佳民营教育机构“华询教育”东海2号校区负责人，原“星吧阁教育”数学学科负责人。</p>

    <p>
        王老师每年都有学生在中环杯、小机灵杯、亚太杯、走美杯等竞赛中获奖。四年级尖子班入围决赛率为70%，决赛获奖率超过50%。在校期间，获得同济大学“明日之师”授课比赛第2名。曾辅导多名学生进入兰生、存志、双语等杨浦区名校。</p>

    <p>王老师从事理科教育行业工作5年。对于上海考试大纲非常了解，重视对于良好学习习惯的培养，熟悉知识点的考察方式，能够根据不同考试给出针对性复习建议。对于“新题”“难题”有独到见解。</p>

    <p>
        王老师有丰富的小学高年级数学教学经验，注重因材施教，针对每个孩子的性格与学习状态，给出家长最有效的学习建议。授课思路清晰，擅于运用图形和生活实例将抽象的概念和知识点变得更易于孩子理解掌握。能够准确的把握住知识点和考察方式，将知识点深入浅出地教给学生，培养学生的逻辑能力和独立思考能力。</p>

</div>
<%@ include file="ddl.jsp" %>
<%@ include file="footer.jsp" %>
</body>
</html>
