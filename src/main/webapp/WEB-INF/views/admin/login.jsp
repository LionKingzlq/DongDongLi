<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<script type="text/javascript" src="lib/PIE_IE678.js"></script>
<![endif]-->
<link href="/ddl/res/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="/ddl/res/css/H-ui.login.css" rel="stylesheet" type="text/css" />
<link href="/ddl/res/css/style.css" rel="stylesheet" type="text/css" />
<link href="/ddl/res/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<![endif]-->
<title>栋栋力后台登录</title>
<script type="text/javascript">
	function check(){
      var p = $("#passWord").val();
      if(p != ""){
        $("#passWord").val(md5(p));
        return true;
      }
      return false;
	}
</script>
</head>
<body>
<input type="hidden" id="TenantId" name="TenantId" value="" />
<div class="header">栋栋力后台数据管理系统</div>
<div class="loginWraper">
  <div id="loginform" class="loginBox">
    <form class="form form-horizontal" action="/ddl/j_spring_security_check" method="post" onsubmit="return check();">
      <div class="row cl">
        <label class="form-label col-3"><i class="Hui-iconfont">&#xe60d;</i></label>
        <div class="formControls col-8">
          <input id="name" name="j_username" type="text" placeholder="账户" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-3"><i class="Hui-iconfont">&#xe60e;</i></label>
        <div class="formControls col-8">
          <input id="passWord" name="j_password" type="password" placeholder="密码" class="input-text size-L">
        </div>
      </div>
      <div class="row">
        <div class="formControls col-8 col-offset-3">
          <label for="online">
            <input type="checkbox" name="online" id="online" value="">
            使我保持登录状态</label>
        </div>
      </div>
      <div class="row">
        <div class="formControls col-8 col-offset-3">
          <input name="" type="submit" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
          <input name="" type="reset" class="btn btn-default radius size-L" value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
        </div>
      </div>
    </form>
  </div>
</div>
<div class="footer">Copyright 栋栋力教育培训机构</div>
<script src="/ddl/res/lib/jquery/1.9.1/jquery.min.js"></script>
<script src="/ddl/res/lib/jquery/1.9.1/jquery.cookie.js"></script>
<script src="/ddl/res/js/H-ui.js"></script>
<script src="/ddl/res/js/md5.js"></script>
</body>
</html>