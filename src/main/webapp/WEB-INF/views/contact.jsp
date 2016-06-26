<%--
  Created by IntelliJ IDEA.
  User: Me10ns
  Date: 2016/5/27
  Time: 16:56
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
  <link type="text/css" rel="stylesheet" href="<c:url value="/res/css/contact.css"/>">
  <script src="<c:url value="/res/js/jquery-1.9.1.min.js"/>" language="javascript"></script>
  <script src="<c:url value="/res/js/bootstrap.js"/>" language="javascript"></script>
</head>

<body style="">
<%--header--%>
<%@ include file="header.jsp" %>

<script>
  $('.navlist').children(":first").next().next().next().next().addClass('tabActive');
  
/*   document.documentElement.style.overflowX = 'hidden';
	var r =  document.body.offsetWidth / window.screen.availWidth;
	if(r > 1)
		$(document.body).css({"-webkit-transform":"scaleX(" + 0.93 + ")"}); */
</script>

<div class="bg" style="background-image: url(/ddl/res/images/contact/4.png); background-size: 100% 100%;">
  <div style="width: 35%;height: 754px; position:absolute;">
    <div style="width: 90%;height: 674px;margin-top:60px;margin-left: auto;margin-right: auto">
      <div class="tx-hd">各校区</div>
      <div class="tx-shd">地址及联系方式</div>
      <div>
      	<div style="background-color: #4c4c4c; color:#ffffff; width:130px; font-size: 2em;">咨询电话</div>
      	<div style="text-align:left; font-size:2.5em;">021-67182152</div>
      </div>
      <div class="add-qu" style="margin-top: 50px">浦东新区|</div>
      <div class="add-det">杨高中路2797号3号楼联洋市民中心8楼</div>
      <div class="add-qu">虹口区|</div>
      <div class="add-det">物华路73号渡边物花园4层</div>
      <div class="add-det">8409/8410/8411室</div>
      <div class="add-qu">杨浦区|</div>
      <div class="add-det">殷行路1286号嘉誉国际2栋506室</div>
      <div class="add-qu">卢湾区|</div>
      <div class="add-det">肇嘉浜路108号6楼</div>
      <div class="add-qu">奉贤区|</div>
      <div class="add-det">八字桥路215号</div>
    </div>
  </div>
  <div style="width: 60%;float: right;">
    <div style="width: 700px;height: 150px;margin-left: auto;margin-right: auto;margin-top: 80px">
      <div class="tx-sys">扫一扫</div>
      <div class="tx-dt">时刻关注最新动态</div>
    </div>
    <div style="width: 600px;height:424px;margin-left: auto;margin-right: auto;margin-top: 100px">
      <div style="float: left;text-align: center">
        <img src="<c:url value="/res/images/contact/lg-wbcode.png"/>" style="width: 244px;">
        <div class="tx-code">官方微博账号</div>
      </div>
      <div style="float: right;text-align: center">
        <img src="<c:url value="/res/upload/data_2.png"/>" style="width: 244px;">
        <div class="tx-code">官方微信公众号</div>
      </div>
    </div>
  </div>
</div>

<div class="bpic" style="background-image: url(/ddl/res/images/contact/5.png); background-size: 100% 100%;"></div>

<%--footer--%>
<%@ include file="footer.jsp" %>

</body>
</html>