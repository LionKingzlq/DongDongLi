<%--
  Created by IntelliJ IDEA.
  User: Me10ns
  Date: 2016/3/11
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<style>
html, body {
	position: relative;
	margin: 0px;
	padding: 0px;
	width: 100%;
	overflow-x: auto;
	text-align: center;
	font-family: "Microsoft YaHei", monospace;
	margin-right: auto;
	margin-left: auto;
}

a:hover {
	cursor: pointer
}

.header {
	text-align: center;
	width: 1349px;
	height: 145px;
	margin-left: auto;
	margin-right: auto
}

.header .header-left {
	width: 705px;
	height: auto;
	text-align: left;
	float: left
}

.header .header-left img {
	margin-left: 98px;
	margin-top: 15px
}

.header .header-right {
	width: 644px;
	height: auto;
	float: left
}

.header-right form {
	width: auto;
	height: auto;
	margin-left: 47px;
	margin-top: 42px
}

.header-right form .inputText {
	position: relative;
	float: left;
	width: 277px;
	height: 33px;
	border: 2px solid rgb(143, 194, 31);
}

.header-right form a .search {
	position: relative;
	float: left;
	height: 33px;
}

.header-right form a .book {
	position: relative;
	height: 33px;
	margin-left: 17px;
	margin-left: -100px
}

.header-right .navlist .tabActive {
	color: rgb(143, 194, 31);
	font-size: 28px;
	font-weight: 500;
}

.header-right .navlist {
	position: relative;
	font-size: 17px;
	text-align: left;
	margin-top: 25px;
}

.header-right .navlist a {
	margin-left: 18px;
	margin-right: 18px;
	font-weight: lighter;
	color: #898989;
	text-decoration: none
}

.header-right .navlist a:hover {
	color: rgb(143, 194, 31);
}
</style>

<div class="header">
	<div class="header-left">
		<img src="<c:url value="/res/images/header/logo.jpg"/>">
	</div>
	<div class="header-right">
		<form>
			<input class="inputText" name="searchText" placeholder="搜索课程">
			<a onclick="javascript:searchClass()"><img class="search"
				style="vertical-align: top"
				src="<c:url value="/res/images/header/searchIco.png"/>"></a> <a
				href="#"><img class="book" style="vertical-align: top"
				src="<c:url value="/res/images/header/bookIco.png"/>"></a>
		</form>
		<div class="navlist">
			<a href="/ddl" style="margin-left: 0">首页</a>| <a href="#">关于栋栋梨</a>|
			<a href="teacher">名师风采</a>| <a href="#">学员荣誉</a>| <a href="#">联系我们</a>
		</div>
	</div>
</div>