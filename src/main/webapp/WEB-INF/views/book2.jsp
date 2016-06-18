<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<head>
<meta charset="utf-8" />
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<title>栋栋梨教育——带你走向更精彩的未来</title>
<link href="css/bootstrap.css" rel="stylesheet" media="screen">
<script src="<c:url value="/res/js/jquery-1.9.1.min.js"/>"
	language="javascript"></script>
<style type="text/css">
form label {
	width: 30%;
	text-align: right;
	margin-right: 10px;
}
form div{
	margin-top: 15px;
} 
</style>
</head>

<body style="width: 100%;">
	<script type="text/javascript">
		$(function() {
			var campus = [ '奉贤八字桥路校区', '杨浦新江湾校区', '虹口物华路校区', '浦东联洋校区', '卢湾校区' ]
			var grades = [ '一年级', '二年级', '三年级', '四年级', '五年级', '六年级', '七年级',
					'八年级', '九年级' ]
			var classes = [ '数学' ];

			var cmp = document.getElementById('campus');
			var gd = document.getElementById('grade');
			var cls = document.getElementById('class');

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
	</script>
	<div data-role="page">
		<div data-role="header">
			<div
				style="font-size: 2em; width: 100%; text-align: center; background-image: url(images/apply/3.png);">预约报名</div>
		</div>
		<div data-role="content">
			<div style="color: #8fc21f; font-size: 1.2em; margin-left:20px;">
				<label style="font-size: 1em;">课程费用：120元/小时</label> <br /> <label
					style="font-size: 1em;">班级人数上限：10人</label>
			</div>
			<form method="post" action="" style="">
				<div style="position: relative;">
					<label for="fname" style="font-size: 1em; width: 30%;">校区:</label>
					<select id="campus" name="campus" type="text">
						<option>----请选择年级----</option>
					</select>
				</div>
				<div style="position: relative;">
					<label for="grade" style="font-size: 1em; width: 30%;">年级:</label>
					<select id="grade" name="grade" type="text">
						<option>----请选择科目----</option>
					</select>
				</div>
				<div style="position: relative;">
					<label for="grade" style="font-size: 1em; width: 30%;">年级:</label>
					<select id="grade" name="grade" type="text">
						<option>----请选择科目----</option>
					</select>
				</div>
				<div style="position: relative;">
					<label for="grade" style="font-size: 1em; width: 30%;">科目:</label>
					<select id="class" name="class" type="text">
						<option>----请选择科目----</option>
					</select>
				</div>
				<div style="position: relative;">
					<label for="teacherName">教师:</label> <input id="teacherName"
						name="teacherName" type="text" placeholder="教师姓名">
				</div>
				<div style="position: relative;">
					<label for="studentName">学生姓名:</label> <input id="studentName"
						name="studentName" type="text" placeholder="学生姓名">
				</div>
				<div style="position: relative;">
					<label for="parentName">家长姓名:</label> <input id="parentName"
						name="parentName" type="text" placeholder="家长姓名">
				</div>
				<div style="position: relative;">
					<label for="parentPhone">家长电话:</label> <input id="parentPhone"
						name="parentPhone" type="tel" placeholder="家长电话">
				</div>
				<div style="position: relative;">
					<label for="studentID">学生身份证号:</label> <input id="studentID"
						name="studentID" type="text" placeholder="学生身份证号">
				</div>
				<div style="margin-left: 10%;">
					<input type="reset" value="重置" style="width: 40%; margin-right: 10%; background-color:#8fc21f; font-size: 1.5em;" /> <input
						type="submit" value="在线报名" style="width: 40%; background-color: #fec61b; font-size: 1.5em;" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>