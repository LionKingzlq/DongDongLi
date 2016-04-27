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
<meta http-equiv="Content-Type" content="text/html" ; charset="utf-8">
<title>栋栋梨教育——带你走向更精彩的未来</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/res/css/index.css"/>">
<link type="text/css" rel="stylesheet"
	href="<c:url value="/res/css/bootstrap.css"/>">
<link type="text/css" rel="stylesheet"
	href="<c:url value="/res/css/bootstrap-theme.css"/>">
<script src="<c:url value="/res/lib/jquery/1.9.1/jquery.min.js"/>"
	language="javascript"></script>
<script src="<c:url value="/res/js/bootstrap.js"/>"
	language="javascript"></script>

</head>

<body>

	<div class="header">
		<div class="header-left">
			<img src="<c:url value="/res/images/logo.png"/>">
		</div>
		<div class="header-right">
			<div style="height: 20%"></div>
			<form>
				<input class="inputText" name="searchText" placeholder="搜索课程">
				<a onclick="javascript:searchClass()"><img class="search"
					style="vertical-align: top"
					src="<c:url value="/res/images/searchIco.png"/>"></a> <a href="#"><img
					class="book" style="vertical-align: top"
					src="<c:url value="/res/images/bookIco.png"/>"></a>
			</form>
			<div class="navlist">
				<a class="tabActive" href="#">首页</a>| <a href="#">关于栋栋梨</a>| <a
					href="#">名师风采</a>| <a href="#">学院荣誉</a>| <a href="#">联系我们</a>
			</div>
			<div class="arr">
				<img src="<c:url value="/res/images/arrayIco.png"/>">
			</div>
		</div>
	</div>
	<div class="intro">
		<div class="intro-left">
			<img src="<c:url value="/res/images/indexPic.jpg"/>">
		</div>
		<div class="intro-right">
			<div
				style="margin-top: 5%; margin-left: 40%; width: 38%; text-align: right">
				<p style="font-size: 36px; font-weight: bold; color: #ffffff;">栋
					栋 梨 教 育</p>

				<p style="font-size: 24px; font-weight: 500; color: #ffffff">带你走向更精彩的未来</p>
			</div>
			<hr style="width: 58%">
			<div
				style="width: 55%; margin-left: 25%; margin-top: 5%; text-align: left">
				<p
					style="font-size: 18px; font-weight: 300; color: #ffffff; text-indent: 2em; line-height: 200%">
					栋栋梨的教育宗旨是让孩子学的更开心，在开心中学习，边学习边开心。什么的哈哈哈哈哈哈哈哈我也不太会写，随便扯扯点凑够四行吧。</p>
			</div>
		</div>
	</div>
	<div class="teacher">
		<div class="teacher-left">
			<img src="<c:url value="/res/images/teacherCol.png"/>">

			<h2>名师风采</h2>
		</div>
		<div class="teacher-right">
			<div>
				<img class="bg" src="<c:url value="/res/images/teacherBG.png"/>">
				<img class="tc" src="<c:url value="/res/images/teacherPic.png"/>">

				<div class="name">
					王佳栋<span style="font-size: 18px; font-weight: normal;">老师</span> <span
						style="font-size: 18px; font-weight: bold; color: rgb(231, 177, 12); margin-left: 35%">
						多年教龄的优秀老师</span>
				</div>
				<div class="word">这张照片总的看来挺帅的不过呢就是有点秃嘿嘿，之类的名人名言</div>
			</div>
		</div>
	</div>
	<div class="hbr">
		<img class="bg" src="<c:url value="/res/images/line.png"/>">
	</div>
	<div class="news">
		<div class="news-left">
			<img src="<c:url value="/res/images/newsIco.png"/>">

			<h2>资讯动态</h2>
		</div>
		<div class="news-right">
			<div>
				<table
					style="border-collapse: separate; border-spacing: 5px; margin-top: 3%; width: 100%; margin-left: 5%">
					<tr>
						<td class="time">2016-04-25</td>
						<td><a>网页设计终于开始了，大家都辛苦了！</a></td>
					</tr>
					<tr>
						<td class="time">2016-04-16</td>
						<td><a>资讯动态资讯动态资讯动态还是资讯动态全都是资讯动态还是。</a></td>
					</tr>
					<tr>
						<td class="time">2016-04-25</td>
						<td><a>网页设计终于开始了，大家都辛苦了！</a></td>
					</tr>
					<tr>
						<td class="time">2016-04-16</td>
						<td><a>资讯动态资讯动态资讯动态还是资讯动态全都是资讯动态还是。</a></td>
					</tr>
					<tr>
						<td class="time">2016-04-25</td>
						<td><a>网页设计终于开始了，大家都辛苦了！</a></td>
					</tr>
					<tr>
						<td class="time">2016-04-16</td>
						<td><a>资讯动态资讯动态资讯动态还是资讯动态全都是资讯动态还是还是。</a></td>
					</tr>
					<tr>
						<td class="time">2016-04-16</td>
						<td><a>资讯动态资讯动态资讯动态还是资讯动态全都是资讯动态还是还是。</a></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<div class="info">
		<div class="first">
			<div
				style="position: relative; width: 50%; height: 100%; float: left">
				<img src="<c:url value="/res/images/questionIco.png"/>">
			</div>
			<div
				style="position: relative; width: 50%; height: 100%; text-align: left; float: left">
				<h2>常见问题</h2>
			</div>
		</div>

		<div class="second">
			<div
				style="position: relative; width: 50%; height: 100%; float: left">
				<img src="<c:url value="/res/images/reasonIco.png"/>">
			</div>
			<div
				style="position: relative; width: 50%; height: 100%; text-align: left; float: left">
				<h2>选择我们的理由</h2>
			</div>
		</div>
		<div class="third">
			<div
				style="position: relative; width: 50%; height: 100%; float: left">
				<img src="<c:url value="/res/images/campusIco.png"/>">
			</div>
			<div
				style="position: relative; width: 50%; height: 100%; text-align: left; float: left">
				<h2>各校区地址</h2>
			</div>
		</div>
	</div>
	<div style="width: 100%;">
		<img src="<c:url value="/res/images/tharr.png"/> ">
	</div>
	<div class="answer">
		<div class="first">
			<div style="margin-top: 13%;">
				<div>Q:一加一为什么等于二呢？</div>
				<div>A:这个也算常见问题吗？</div>
			</div>
			<div>
				<div>Q:我的孩子学习不好怎么办？</div>
				<div>A:这个也算常见问题吗？</div>
			</div>
			<div>
				<div>Q:反正这里就是些常见问题和解答。</div>
				<div>A:哦。</div>
			</div>
		</div>
		<div class="second">
			<div style="margin-top: 13%">你问我为什么选择栋栋梨，</div>
			<div>没有理由！</div>
			<div>没有理由！</div>
			<div>没有理由！</div>
			<div>重要的事情说三遍。</div>
		</div>
		<div class="third">
			<div style="margin-top: 13%">杨浦区 |</div>
			<div>XX校区：XXXX路XXX号XXX楼</div>
			<div style="width: 50%">021-88888888</div>
			<div>XX校区：XXXX路XXX号XXX楼</div>
			<div style="width: 50%">021-88888888</div>
			<div>徐汇区 |</div>
			<div>XX校区：XXXX路XXX号XXX楼</div>
			<div style="width: 50%">021-88888888</div>
		</div>
	</div>
	<div class="footer">
		<div
			style="position: relative; float: left; width: 60%; height: 100%; text-align: center">
			<div
				style="height: 25%; width: 80%; margin-left: auto; margin-top: 5%; color: rgb(143, 194, 31)">
				<div
					style="float: left; text-align: left; height: 100%; width: 75%; font-size: 24px; font-weight: 600">课程介绍</div>
				<div
					style="float: left; text-align: left; height: 100%; width: 25%; font-size: 24px; font-weight: 600">加入我们</div>
			</div>
			<div
				style="height: 20%; width: 80%; margin-left: auto; color: #ffffff">
				<div
					style="float: left; text-align: left; height: 100%; width: 75%; font-size: 18px;">
					<a>一年级</a>| <a>二年级</a>| <a>三年级</a>| <a>四年级</a>| <a>五年级</a>| <a>初中</a>
				</div>
				<div
					style="float: left; text-align: left; height: 100%; width: 25%; font-size: 18px;">
					<a>应聘教师</a>| <a>其他</a>
				</div>
			</div>
			<div
				style="position: absolute; bottom: 0; right: 0; height: 20%; width: 85%; border: groove 4px rgb(52, 52, 52); color: #ffffff">
				copyright © 2016-20xx Dongdongli.All Rights
				Reserved.上海栋栋梨教育投资有限公司版权所有</div>
		</div>
		<div style="float: left; width: 10%; height: 100%"></div>
		<div style="float: left; width: 30%; height: 100%">
			<div
				style="float: left; height: 30%; width: 25%; margin-top: 10%; color: rgb(143, 194, 31)">
				<div
					style="float: left; text-align: left; height: 100%; width: 100%; font-size: 24px; font-weight: 600">关注我们
				</div>
			</div>
			<div style="float: right; height: 100%; width: 75%;">
				<div style="height: 100%; width: 100%;">
					<div
						style="float: left; height: 100%; width: 50%; text-align: center">
						<img src="<c:url value="/res/images/reasonIco.png"/>"
							style="height: 60%; width: 60%; margin-top: 15%">
						<div style="color: #ffffff; font-size: 18px; margin-top: 5%">weibo</div>
					</div>
					<div
						style="float: left; height: 100%; width: 50%; text-align: center">
						<img src="<c:url value="/res/images/reasonIco.png"/>"
							style="height: 60%; width: 60%; margin-top: 15%">
						<div style="color: #ffffff; font-size: 18px; margin-top: 5%">wechat</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
