<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
<script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>     
<title>选课系统登陆页面</title>
<script type="text/javascript">
	function login(){
		var ssn = $("#ssn").val();
		$.ajax({
			url:'${pageContext.request.contextPath}/userAction_login',
			type:'POST',
			dataType:'json',
			data:{ssn:ssn,password:$("#password").val(),type:$("select").val()},
			success:function(data){
				if(data.status=="ok"){
					if($("#select").val()=="Student"){
						window.location.href='${pageContext.request.contextPath}/student?'+ ssn +'';
					}else if($("#select").val()=="Professor"){
						window.location.href='${pageContext.request.contextPath}/professor?'+ ssn +''
					}else{
						window.location.href='${pageContext.request.contextPath}/admin';
					}
				}else{
					alert("账号或密码错误！或者身份错误！");
				}
			}
		}); 
		
	}
</script>
</head>
<body>
    <form action="login.php" method="post">
       <div class="mycenter">
        <div class="mysign">
            <div class="col-lg-11 text-center text-info">
                <h2>请登录</h2>
            </div>
            <div class="col-lg-10">
                <input type="text" class="form-control" id="ssn" placeholder="请输用户名" required autofocus/>
            </div>
            <div class="col-lg-10"></div>
            <div class="col-lg-10">
                <input type="password" class="form-control" id="password" placeholder="请输入密码" required autofocus/>
            </div>
            <div class="col-lg-10"></div>
            <div class="col-lg-10 mycheckbox checkbox">
                <select id="select">
                	<option>Student</option>
                	<option>Professor</option>
                	<option>admin</option>
                </select>
                <span>请选择身份</span>
            </div>
            <div class="col-lg-10"></div>
            <div class="col-lg-10">
                <button type="button" class="btn btn-success col-lg-12" onclick="login()">登录</button>
            </div>
        </div>
    </div>
   </form>
</body>
</html>