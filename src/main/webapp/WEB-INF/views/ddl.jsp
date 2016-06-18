<%--
  Created by IntelliJ IDEA.
  User: Me10ns
  Date: 2016/3/11
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div style="width: 1349px;height: 538px;margin-top: 50px;margin-left: auto; margin-right: auto;margin-bottom: 19px;">
    <div style="width: 493px;height: 538px;float: left;background: url(<c:url
            value="/res/images/teacher/3.png"/>);font-size: 17px">
        <div class="icona" style="width: 270px;height: 123px;margin-top: 120px;margin-left: auto;margin-right: auto">
            <a style="float: left"><img src="<c:url value="/res/images/teacher/kcap.png"/>">
                <div style="text-align: center">课程安排</div>
            </a>
            <a href="about#jzptzd" style="float: right"><img src="<c:url value="/res/images/teacher/jzpt.png"/>">
                <div style="text-align: center">家长旁听</div>
            </a>
        </div>
        <div class="icona" style="width: 270px;height: 123px;margin-top: 10px;margin-left: auto;margin-right: auto">
            <a style="float: left"><img src="<c:url value="/res/images/teacher/msfc.png"/>">
                <div style="text-align: center">名师风采</div>
            </a>
            <a href="about#bbzd" style="float: right"><img src="<c:url value="/res/images/teacher/bmxz.png"/>">
                <div style="text-align: center">报名须知</div>
            </a>
        </div>
        <div class="icona" style="width: 270px;height: 123px;margin-top: 10px;margin-left: auto;margin-right: auto;text-align: left">
            <a href="about#tfzd" style="float: left"><img src="<c:url value="/res/images/teacher/tfzd.png"/>">
                <div style="text-align: center">退费制度</div>
            </a>
        </div>
    </div>
    <div class="teachers" style="width: 841px;height: 538px;float: left;background: url(<c:url
            value="/res/images/teacher/4.png"/>);margin-left: 15px">
        <div class="bd">
            <ul class="picList" style="color: rgb(79,79,79)">
                <li>
                    <div class="pic"><a href="" target="_blank"><img
                            src="<c:url value="/res/images/teacher/2.png"/>"/></a></div>
                    <div class="title"><a href="" style="color: rgb(79,79,79)" target="_blank">王老师</a></div>
                </li>
                <li>
                    <div class="pic"><a href="" target="_blank"><img
                            src="<c:url value="/res/images/teacher/2.png"/>"/></a></div>
                    <div class="title"><a href="" style="color: rgb(79,79,79)" target="_blank">王老师</a></div>
                </li>
                <li>
                    <div class="pic"><a href="" target="_blank"><img
                            src="<c:url value="/res/images/teacher/2.png"/>"/></a></div>
                    <div class="title"><a href="" style="color: rgb(79,79,79)" target="_blank">王老师</a></div>
                </li>
                <li>
                    <div class="pic"><a href="" target="_blank"><img
                            src="<c:url value="/res/images/teacher/2.png"/>"/></a></div>
                    <div class="title"><a href="" style="color: rgb(79,79,79)" target="_blank">王老师</a></div>
                </li>
                <li>
                    <div class="pic"><a href="" target="_blank"><img
                            src="<c:url value="/res/images/teacher/2.png"/>"/></a></div>
                    <div class="title"><a href="" style="color: rgb(79,79,79)" target="_blank">王老师</a></div>
                </li>
                <li>
                    <div class="pic"><a href="" target="_blank"><img
                            src="<c:url value="/res/images/teacher/2.png"/>"/></a></div>
                    <div class="title"><a href="" style="color: rgb(79,79,79)" target="_blank">王老师</a></div>
                </li>
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
    .icona a{color:rgb(79,79,79)}
    .icona a:hover{color: rgb(79,79,79)}
</style>
<%--自动轮播js--%>
<script id="jsID" type="text/javascript">
    jQuery(".teachers").slide({
        mainCell: ".bd ul", autoPlay: true, effect: 'leftMarquee', vis: 3, interTime: 25, opp: false, pnLoop: true
        , trigger: 'click', mouseOverStop: true
    });

</script>