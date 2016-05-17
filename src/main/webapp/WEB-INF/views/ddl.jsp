<%--
  Created by IntelliJ IDEA.
  User: Me10ns
  Date: 2016/3/11
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div
	style="width: 1349px; height: 538px; margin-top: 50px; margin-left: auto; margin-right: auto; margin-bottom: 19px;">
	<div
		style="width: 493px;height: 538px;float: left;background: url(<c:url
            value="/res/images/teacher/3.png"/>);font-size: 17px">
		<div
			style="width: 270px; height: 123px; margin-top: 120px; margin-left: auto; margin-right: auto">
			<img src="<c:url value="/res/images/teacher/kcap.png"/>"
				style="float: left"> <img
				src="<c:url value="/res/images/teacher/jzpt.png"/>"
				style="margin-left: 72px">

			<div style="margin-top: 3px; color: rgb(79, 79, 79); height: 25px">
				<div style="float: left; margin-left: 15px">课程安排</div>
				<div style="float: right; margin-right: 15px">家长旁听</div>
			</div>
		</div>
		<div
			style="width: 270px; height: 123px; margin-top: 10px; margin-left: auto; margin-right: auto">
			<img src="<c:url value="/res/images/teacher/msfc.png"/>"
				style="float: left"> <img
				src="<c:url value="/res/images/teacher/bmxz.png"/>"
				style="margin-left: 72px">

			<div style="margin-top: 3px; color: rgb(79, 79, 79); height: 25px">
				<div style="float: left; margin-left: 15px">名师风采</div>
				<div style="float: right; margin-right: 15px">报名须知</div>
			</div>
		</div>
		<div
			style="width: 270px; height: 123px; margin-top: 10px; margin-left: auto; margin-right: auto; text-align: left">
			<img src="<c:url value="/res/images/teacher/tfzd.png"/>">

			<div style="margin-top: 3px; color: rgb(79, 79, 79); height: 25px">
				<div style="float: left; margin-left: 15px">退费制度</div>
			</div>
		</div>
	</div>
	<div class="teachers"
		style="width: 841px;height: 538px;float: left;background: url(<c:url
            value="/res/images/teacher/4.png"/>);margin-left: 15px">
		<div class="bd">
			<ul class="picList" style="color: rgb(79, 79, 79)">
				<c:if test="${not empty teachers}">
					<c:forEach items="${teachers}" var="teacher" varStatus="vs">
						<li>
							<div class="pic">
								<a href="" target="_blank"><img
									src="${teacher.imgPath}" /></a>
							</div>
							<div class="title">
								<a href="" style="color: rgb(79, 79, 79)" target="_blank">${teacher.name}</a>
							</div>
						</li>
					</c:forEach>
				</c:if>
			</ul>
		</div>
	</div>
</div>

<%--自动轮播css--%>
<style>
.bd {
	margin: 130px 7px;
}

.bd ul {
	overflow: hidden;
	zoom: 1;
}

.bd ul li {
	margin: 0 18px;
	float: left;
	_display: inline;
	overflow: hidden;
	text-align: center;
}

.bd ul li .pic {
	text-align: center;
	width: 240px
}

.bd ul li .pic img {
	width: 240px;
	height: 300px;
	display: block;
	padding: 2px;
}

.bd ul li .pic a:hover img {
	
}

.bd ul li .title {
	line-height: 24px;
	font-size: 17px
}
</style>
<%--自动轮播js--%>
<script id="jsID" type="text/javascript">
	jQuery(".teachers").slide({
		mainCell : ".bd ul",
		autoPlay : true,
		effect : 'leftMarquee',
		vis : 3,
		interTime : 25,
		opp : false,
		pnLoop : true,
		trigger : 'click',
		mouseOverStop : true
	});
</script>