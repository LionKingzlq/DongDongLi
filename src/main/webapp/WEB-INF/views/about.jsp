<%--
  Created by IntelliJ IDEA.
  User: Me10ns
  Date: 2016/5/27
  Time: 12:01
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
	href="<c:url value="/res/css/about.css"/>">
<script src="<c:url value="/res/js/jquery-1.9.1.min.js"/>"
	language="javascript"></script>
<script src="<c:url value="/res/js/bootstrap.js"/>"
	language="javascript"></script>
</head>

<body style="">
	<%--header--%>
	<%@ include file="header.jsp"%>
	<script>
		$('.navlist').children(":first").next().addClass('tabActive');
		/* $(function() {
			document.documentElement.style.overflowX = 'hidden';
			var r = document.body.offsetWidth / window.screen.availWidth;
			if (r > 1)
				$(document.body).css({
					"-webkit-transform" : "scaleX(" + 0.93 + ")"
				});
		}); */
	</script>

	<div class="pic">
		<img src="<c:url value="/res/images/about/5.png"/>"
			style="width: 100%;" />
	</div>
	<div class="aboutDDL">
		<img src="<c:url value="/res/images/about/6.png"/>"
			style="width: 40%;">

		<div class="ab-con">
			<div class="ab-con-text">
				<div
					style="font-size: 18px; color: rgb(143, 194, 31); letter-spacing: 2px; margin-top: 20px;">
					栋栋梨教育,
					<div style="text-indent: 0">不仅注重学习习惯和学习能力的培养，更注重学生人格的塑造</div>
					<div
						style="font-size: 18px; color: rgb(143, 194, 31); letter-spacing: 2px; margin-top: 20px;">
						在栋栋梨，
						<div style="text-indent: 0">在栋栋梨，
							每一个学生的闪光点都会得到赞扬，每一个学生的潜能都会得到发掘。</div>
					</div>
					<div
						style="font-size: 18px; color: rgb(143, 194, 31); letter-spacing: 2px; margin-top: 20px;">
						栋栋梨的教育宗旨是：
						<div style="text-indent: 0">让每一个学生的名字都充满圣神和庄严。</div>
					</div>
				</div>
			</div>

			<div class="ab-con-pic">
				<img src="<c:url value="/res/images/about/7.png"/>" />
			</div>
		</div>

		<div class="rules">
			<img src="<c:url value="/res/images/about/3.png"/>"
				style="width: 100%;" /> <a name="bbzd"><div class="title-g"
					style="margin-top: 50px">&lt;报班制度&gt;</div> </a>
			<div class="content">
				<div class="rl">1） 家长同意栋栋梨教育因教学需要变更上课地点、时间及授课老师。</div>
				<div class="rl">2） 栋栋梨学员缴纳金额=120元×每次课时×总课次＋40元材料费。</div>
				<div class="rl">3） 插班：指开课后选择有剩余名额的班级报名，插班学员无试听。</div>
			</div>
			<div class="title-y">&lt;调课制度&gt;</div>
			<div class="content">
				<div class="rl">1） 调课仅限于同年份、同学期、同年级、同学科、同班次、总金额相同、</div>
				<div class="rl">总课次相同、剩余课次相同的班级之间互相办理。</div>
				<div class="rl">2） 办理调课时，必须携带原班学员听课证。</div>
				<div class="rl">3） 调课：必须在调入班级有名额的情况下可办理，每期最多办理3次。调课时，</div>
				<div class="rl">务必先与原老师请假，原老师会与调入班级老师进行沟通协调，后凭听课证即可正常上课。</div>
			</div>
			<a name="tfzd"><div class="title-g">&lt;退费制度&gt;</div> </a>
			<div class="content">
				<div class="rl">◇ 办理退费时，必须在原报名教学点办理。所退课次，以办理当天计算的剩余课次为准，</div>
				<div class="rl">同时必须出示本期学员听课证，凭听课证予以办理。</div>
				<div class="rl">◇
					栋栋梨数学课程，第一次课开课前退费，全额退费；第一次课开课后（含第一次课）退费，按剩余课次退费。</div>
				<div class="rl">◇ 栋栋梨数学课程上至本期课最后三次（含倒数第三次），不论学员上课与否，均不予退费。</div>
				<div class="rl">◇ 由于学员自身原因缺课，学校予以半小时补课，讲解重点，不予退费。</div>
				<div class="rl">如遇国家法定假日，学校会根据国家规定将上课时间做相应调整。最终解释权归栋栋梨教育所有。</div>
			</div>
			<a name="jzptzd"><div class="title-y">&lt;家长旁听制度&gt;</div> </a>
			<div class="content">
				<div class="rl">栋栋梨教育推行家长旁听制度，我们非常建议和欢迎家长来旁听。</div>
				<div class="rl">（1）让家长看到孩子实际的课堂表现，做到心中有数。</div>
				<div class="rl">（2）栋栋梨以“培优”为教学目标，课程设置难易结合，家长旁听便于了解课程难度。</div>
				<div class="rl">（3）家长旁听，对教学质量和老师授课也是一个促进。</div>
				<div class="rl">（4）家长可以了解到老师所讲的重要信息，包括学习方法和升学信息等。</div>
				<div class="rl">（5）便于老师及时和家长沟通，反映孩子情况。</div>
				<div class="rl">（6）家长旁听，解决了孩子上课时家长无处可去的问题。</div>
			</div>
		</div>
		<div class="question">
			<img src="<c:url value="/res/images/about/4.png"/>"
				style="width: 100%;" /> <a name="qaa"><div class="title-y"
					style="margin-top: 50px">&lt;栋栋梨Q&A&gt;</div> </a>
			<div class="content">
				<c:forEach var="faq" items="${faqs}">
					<div class="que">Q：${faq.question }</div>
					<div class="ans">A：${faq.answer }</div>
				</c:forEach>
			</div>
			<a name="reason"><div class="title-g">&lt;选择我们的理由&gt;</div> </a>
			<div class="content">
				<div class="que">（1）成体系的教学</div>
				<div class="ans">我们的教材都是精心设计和编排的，符合各种不同需求的孩子，因材施教，分层教学，</div>
				<div class="ans">不会让孩子觉得压力过大或者学无所获。巩固强化课内基础，加强课外训练。</div>
				<div class="que" style="margin-top: 10px">（2）家长旁听制度</div>
				<div class="ans">我们欢迎也鼓励家长随孩子一同进教室上课，感受精彩的课堂氛围。</div>
				<div class="que" style="margin-top: 10px">（3）精品的小班制度</div>
				<div class="ans">8-10人一班，大大加强了老师与学生的联系，关注度更高。</div>
				<div class="ans">规定老师每5次课与家长进行一次电话沟通，时刻掌握学生学校学习情况。</div>
				<div class="que" style="margin-top: 10px">（4）顶级的教师团队</div>
				<div class="ans">我们的老师都是知名教育机构的一线老师，所有老师均毕业于以下几所名校：</div>
				<div class="ans">北京大学、清华大学、复旦大学、同济大学、上海交通大学、华东师范大学。</div>
				<div class="ans">老师的授课水平都要经过严格的把关和数月的封闭式训练，以求做到每一节课都让孩子学有所获。</div>
			</div>
			<a name="campus"><div class="title-y">&lt;教学点地址&gt;</div> </a>
			<div class="content">
				<c:forEach var="address" items="${addresses }">
					<div class="rl">${address.location}</div>
				</c:forEach>
			</div>
		</div>
		<br />
		<%--footer--%>
		<%@ include file="footer.jsp"%>
</body>
</html>
