<%--
  Created by IntelliJ IDEA.
  User: Me10ns
  Date: 2016/3/11
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    html, body {
        position:relative;
        width: 1276px;
        margin: 0 auto;
        padding: 0px;
        overflow-x: auto;
        text-align: center;
        font-family: "Microsoft YaHei",monospace;
    }
    a:hover{cursor: pointer}

    .header {text-align: center;width: 100%;height: 145px;margin-left: auto;margin-right: auto}
    .header .header-left {width: 55%;height: auto;text-align: left;float: left}
    .header .header-left img{margin-left: 98px;margin-top:15px}
    
    .header .header-right{width: 45%;height: auto;float: left}
    .header-right form{width: auto;height: auto;margin-left: 47px;margin-top: 42px}
    .header-right form .inputText{position: relative;float:left; width: 200px; height: 33px; border: 2px solid rgb(143, 194, 31);}
    .header-right form a .search{position: relative;float: left;height: 33px;}
    .header-right form a .book{position: relative;height: 33px;margin-left: 17px;margin-left: -100px}
    .header-right .navlist .tabActive {
        color: rgb(143, 194, 31);
        font-size: 22px;
        font-weight: 500;
    }
    .header-right .navlist {position: relative;font-size: 15px;text-align: left;margin-top: 25px;}
    .header-right .navlist a {margin-left: 18px;margin-right: 18px; font-weight: lighter;color: #898989;text-decoration: none}
    .header-right .navlist a:hover {
        color: rgb(143, 194, 31);
    }

    .codeTab{width: 379px;height:206px;font-size: 18px;padding-top: 35px;float: right;display: none;margin-right: 22px}
    .sys{width:78px;color: #fff;float: left}
    .dt{width: 150px;float: left;color: #000;float: right}
</style>

<div class="header">
    <div class="header-left">
        <img src="<c:url value="/res/images/header/logo.jpg"/>">
    </div>
    <div class="header-right">
        <form>
            <input class="inputText" name="searchText" placeholder="搜索课程">
            <a onclick="javascript:searchClass()"><img class="search" style="vertical-align:top"
                                                       src="<c:url value="/res/images/header/searchIco.png"/>"></a>
            <a href="/ddl/book"><img class="book" style="vertical-align:top"
                             src="<c:url value="/res/images/header/bookIco.png"/>"></a>
        </form>
        <div class="navlist">
            <a href="/ddl" style="margin-left: 0">首页</a>|
            <a href="/ddl/about">关于栋栋梨</a>|
            <a href="/ddl/teacher">名师风采</a>|
            <a>学员荣誉</a>|
            <a id="/ddl/us" href="/ddl/contact">联系我们</a>
        </div>
    </div>
</div>

<div style="width: 100%;height: 206px;position: absolute">
    <div class="codeTab" style="background: url(<c:url value="/res/images/header/7.png"/>)">
        <div style="width: 240px;height: 25px;margin-left: auto;margin-right: auto;">
            <div class="sys" style="background: url(<c:url value="/res/images/header/8.png"/>)">扫一扫</div>
            <div class="dt">时刻关注最新动态</div>
        </div>
        <div style="width: 185px;float: left;text-align: center;margin-top: 8px">
            <div>
                <img src="<c:url value="/res/images/header/md-wbcode.png"/>">
            </div>
            <div>weibo</div>
        </div>
        <div style="width: 185px;float: right;text-align: center;margin-top: 8px">
            <div>
                <img src="<c:url value="/res/images/header/md-wxcode.png"/>">
            </div>
            <div>wechat</div>
        </div>
    </div>
</div>

<script>
    $('#us').hover(function(){
        //你要显示的层，div放到li里面。默认css属性是隐藏
        $('body').find('.codeTab').show();
    },function(){
        //你要显示的列表形式
        $('body').find('.codeTab').hide();
    });
    function searchClass(){
    	window.location.href="book";
    }
</script>