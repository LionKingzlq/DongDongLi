<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="zh-CN" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html" ; charset="utf-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>栋栋梨教育——带你走向更精彩的未来</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/res/css/bootstrap.css"/>">
<link type="text/css" rel="stylesheet"
	href="<c:url value="/res/css/bootstrap-theme.css"/>">
<link type="text/css" rel="stylesheet"
	href="<c:url value="/res/css/apply.css"/>">
<script src="<c:url value="/res/js/jquery-1.9.1.min.js"/>"
	language="javascript"></script>
<script src="<c:url value="/res/js/jquery.SuperSlide.2.1.1.js"/>"
	language="javascript"></script>
<script src="<c:url value="/res/js/bootstrap.js"/>"
	language="javascript"></script>
<style type="text/css">
.c-red{
	color:red;	
} 
</style>
</head>

<body style="">
	<%--header--%>
	<%@ include file="header.jsp"%>
	<script>
		$(function() {
			if (window.screen.availWidth < 800) {
				window.location.href = "book2";
			} else {
				/* document.documentElement.style.overflowX = 'hidden';
				var r = document.body.offsetWidth / window.screen.availWidth;
				if (r > 1)
					$(document.body).css({
						"-webkit-transform" : "scaleX(" + 0.93 + ")"
					}); */

				$("#comfirmBtn").click(function() {
					$("#applyForm").submit();
				});
				$("#clearBtn").click(function() {
					document.getElementById('applyForm').reset();
				});
			}
		});
		$(function() {
			var campus = [ '奉贤八字桥路校区', '杨浦新江湾校区', '虹口物华路校区', '浦东联洋校区', '卢湾校区' ]
			var grades = [ '一年级', '二年级', '三年级', '四年级', '五年级', '六年级', '七年级',
					'八年级', '九年级' ]
			var classes = [ '数学' ]
			var cmp = document.getElementById('campus')
			var gd = document.getElementById('grade')
			var cls = document.getElementById('class')
			for (var i = 0; i < campus.length; i++) {
				$(
						"<option value='" + campus[i] + "'>" + campus[i]
								+ "</option>").appendTo(cmp);
			}
			for (var i = 0; i < grades.length; i++) {
				$(
						"<option value='" + grades[i] + "'>" + grades[i]
								+ "</option>").appendTo(gd);
			}
			for (var i = 0; i < classes.length; i++) {
				$(
						"<option value='" + classes[i] + "'>" + classes[i]
								+ "</option>").appendTo(cls);
			}
		});
		function add() {
			var data = {};
			data.campus = $("#campus").find("option:selected").val();
			data.grade = $("#grade").find("option:selected").val();
			data['course'] = $("#class").find("option:selected").val();
			data['teacher'] = $("#teacher").val();
			data['studentName'] = $("#studentName").val();
			data['parentName'] = $("#parentName").val();
			data['parentPhone'] = $("#parentPhone").val();
			data['studentId'] = $("#studentId").val();

			var re = /^(13[0-9]{9})|(15[089][0-9]{8})$/;
			if (!re.test(data.parentPhone)) {
				alert("手机号不正确");
			} else if (data.campus == '0' || data.grade == '0'
					|| data.course == '0' || data.studentName == ''
					|| data.parentName == '') {
				alert("标红为不填写，不能为空");
			} else {
				$.ajax({
					url : "/ddl/book/add",
					type : 'POST',
					data : data,
					dataType : 'json',
					success : function(data) {
						if(data.flag)
							alert("成功添加，请继续");
						else{
							alert("添加失败，请重试");
						}
					},
					error:function(data){
						alert("添加失败，请重试" + data);
					}
				});
			}
		}
	</script>

	<div class="bigPic">
		<img src="<c:url value="/res/images/apply/3.png"/>">
	</div>

	<div class="apply-Form">
		<div class="left-form">
			<div style="margin-left: 170px; margin-top: 10px">课程费用：120元/小时</div>
			<div style="margin-left: 170px">班级人数上限：10人</div>
			<form id="applyForm" class="applyForm" method="post">
				<div class="form-context">
					<label for="campus"><span class="c-red">*</span>校区:</label> <select
						id="campus" name="campus" type="text">
						<option>----请选择校区----</option>
					</select>
				</div>
				<div class="form-context">
					<label for="grade"><span class="c-red">*</span>年级:</label> <select
						id="grade" name="grade" type="text">
						<option>----请选择年级----</option>
					</select>
				</div>
				<div class="form-context">
					<label for="class"><span class="c-red">*</span>科目:</label> <select
						id="class" name="class" type="text">
						<option>----请选择科目----</option>
					</select>
				</div>
				<div class="form-context">
					<label for="teacherName">教师姓名:</label>
					<input id="teacherName" name="teacherName" type="text"
						placeholder="教师姓名">
				</div>
				<div class="form-context">
					<label for="studentName"><span class="c-red">*</span>学生姓名:</label>
					<input id="studentName" name="studentName" type="text"
						placeholder="学生姓名">
				</div>
				<div class="form-context">
					<label for="parentName"><span class="c-red">*</span>家长姓名:</label> <input id="parentName"
						name="parentName" type="text" placeholder="家长姓名">
				</div>
				<div class="form-context">
					<label for="parentPhone"><span class="c-red">*</span>家长电话:</label> <input id="parentPhone"
						name="parentPhone" type="text" placeholder="家长电话">
				</div>
				<div class="form-context">
					<label for="studentId">学生身份证号:</label> <input id="studentID"
						name="studentId" type="text" placeholder="学生身份证号">
				</div>
			</form>
			<div class="formBtn">
				<a class="a-btn" onclick="add();" style="float: left"> <img id="comfirmBtn" src="<c:url value="/res/images/apply/6.png"/>">
				</a> <a class="a-btn" type="reset" style="float: right"> <img
					id="clearBtn" class="clearBtn"
					src="<c:url value="/res/images/apply/7.png"/>">
				</a>
			</div>
		</div>
		<div class="sep">
			<img src="<c:url value="/res/images/apply/10.png"/>">
		</div>
		<div class="right-form">
			<img class="right-logo"
				src="<c:url value="/res/images/apply/8.png"/>">
			<div class="right-ddl">栋栋梨教育</div>
			<div class="right-til">专业&nbsp;&nbsp;一流&nbsp;&nbsp;领先的教育集团</div>
			<img class="right-QRcode"
				src="<c:url value="/res/images/apply/9.png"/>">
			<div class="right-phone">咨询电话：021-67182152</div>
		</div>
	</div>

	<%--footer--%>
	<%@include file="footer.jsp"%>
</body>
</html>