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
	href="<c:url value="/res/css/index.css"/>">
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
		$('.navlist').children(":first").addClass('tabActive')
	</script>

	<div class="sc">
		<div class="indexPic">
			<img src="<c:url value="/res/images/index/1.png"/> ">
		</div>
		<div class="motto"
			style="background: url(<c:url value="/res/images/index/2.png"/>);">
			<div class="tname">栋栋梨教育</div>
			<div class="ttitle">带你走向更精彩的未来</div>
			<div class="tintro">
				栋栋梨的教育宗旨是让每一个学生的名字都充满神圣和庄严。栋栋梨不仅注重学习习惯和学习能力的培养，更注重学生人格的塑造。在栋栋梨，每一个学生的闪光点都会得到赞扬，每一个学生的潜能都会得到发掘。
			</div>
		</div>
	</div>
	<div class="teacher">
		<div class="teacherIco">
			<img src="<c:url value="/res/images/index/5.png"/>">

			<div>名师风采</div>
		</div>
		<div class="teacherIntro"
			style="">
			<img src="<c:url value="/res/images/index/4.png"/>">

			<div class="name">
				王老师
				<text>五年教龄的优秀老师</text>
			</div>
			<div class="slo">培养习惯，塑造人格</div>
		</div>
	</div>
	<div class="hbr">
		<img src="<c:url value="/res/images/index/7.png"/>">
	</div>

	<div class="news">
		<div class="newsIco">
			<img src="<c:url value="/res/images/index/6.png"/>">

			<div class="tx">资讯动态</div>
		</div>
		<div class="newsTitle">
			<table class="tb"
				style="border-collapse: separate; border-spacing: 5px;">
				<tr>
					<td>2015-06-15</td>
					<td><a class="news-a">虹口物华校区开班啦!</a></td>
				</tr>
				<tr>
					<td>2016-05-06</td>
					<td><a class="news-a">杨浦新江湾校区开班啦!</a></td>
				</tr>
				<tr>
					<td>2016-03-15</td>
					<td><a class="news-a">卢湾日月光校区开班啦!</a></td>
				</tr>
				<tr>
					<td>2016-02-28</td>
					<td><a class="news-a">浦东联洋校区开班啦!</a></td>
				</tr>
			</table>
		</div>
	</div>
	<div class="th">
		<div class="question">
			<img src="<c:url value="/res/images/index/8.png"/>">

			<div class="thtx">常见问题</div>
		</div>
		<div class="reason">
			<img src="<c:url value="/res/images/index/9.png"/>"
				style="margin-left: 8px">

			<div class="thtx">选择我们的理由</div>
		</div>
		<div class="campus">
			<img src="<c:url value="/res/images/index/10.png"/>">

			<div class="thtx">校区地址</div>
		</div>
	</div>

	<div class="fo"
		style="background: url(<c:url value="/res/images/index/11.png"/>)">
		<div class="fo-fi">
			<div class="q">Q：家长可以进来听课吗？</div>
			<div class="a">A：可以。而且我们非常鼓励家长旁听，这是对我们教师授课的一种监督，更是对学生学习效果的保障。</div>
			<div class="q">Q：栋栋梨数学的课程特色？</div>
			<div class="a">A：在涵盖学校内知识的同时，也不限于此，重在学生的数学逻辑思维的拓展训练。基础题型紧扣学校，提高题型提升思维，竞赛及自招题型关注考点以及笔试重点。所有的知识点呈螺旋式上升，温故而知新。</div>
			<div style="text-align: right; font-size: 19px; margin-top: 20px">
				<a href="about#qaa">More&nbsp;>></a>
			</div>
		</div>
		<div class="fo-sc">
			<div class="q">①&nbsp;成体系的教学</div>
			<div class="a">因材施教，分层教学</div>
			<div class="q">②&nbsp;家长旁听制度</div>
			<div class="a">感受精彩的课堂氛围</div>
			<div class="q">③&nbsp;精品的小班制度</div>
			<div class="a">8-10人一班</div>
			<div class="q">④&nbsp;顶级的教师团队</div>
			<div class="a">知名教育机构，名校毕业</div>
			<div style="text-align: right; font-size: 19px; margin-top: 33px">
				<a href="about#reason">More&nbsp;>></a>
			</div>
		</div>
		<div class="fo-th">
			<div class="q">浦东新区&nbsp;|</div>
			<div class="a">杨高中路2797号3号楼联洋市民中心8楼</div>
			<div class="q">虹口区&nbsp;|</div>
			<div class="a">物华路73号渡边物华园4层</div>
			<div class="a">8409/8410/8411室</div>
			<div class="q">杨浦区&nbsp;|</div>
			<div class="a">殷行路1286号嘉誉国际2栋506室</div>
			<div style="text-align: right; font-size: 19px; margin-top: 92px">
				<a href="about#campus">More&nbsp;>></a>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(function() {

			/* document.documentElement.style.overflowX = 'hidden'; */
			var r =  document.body.offsetWidth / window.screen.availWidth;
			/* if(r > 1)
				$(document.body).css({"-webkit-transform":"scaleX(" + 0.93 + ")"}); */
		});
		$(window).resize(function() {
			var r = document.body.offsetWidth / window.screen.availWidth;
			//$(document.body).css("-webkit-transform", "scale(" + r + ")");
		});
	</script>
	<%--footer--%>
	<%@ include file="footer.jsp"%>

</body>
</html>
