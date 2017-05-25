<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/Buttons/2.0.0/css/buttons.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>    
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>    
    <script src="https://cdn.bootcss.com/Buttons/2.0.0/js/buttons.min.js"></script>
    <title>吉他查询</title>
    <script type="text/javascript">
    function add(){
	    	$.ajax({
	    		url:'${pageContext.request.contextPath}/guitarAction_add',
		    	type:'POST',
				dataType:'json',
				data:{serialNumber:$("#serialNumber").val(),price:$("#price").val(),numStrings:$("#numStrings").val(),builder:$("#builder").val(),model:$("#model").val(),type:$("#type").val(),backWood:$("#backWood").val(),topWood:$("#topWood").val()},
				success:function(data){
					if(data.status=="ok"){
						alter("添加成功！");
					}
				},
	    	})
	    }
    </script>     
</head>
<body>
<div class="container ">
	<div class="row">
		<div class="col-xs-6">
			<h1>添加：</h1>
			<div class="form-group">
			<label>serialNumber</label><input class="form-control" name="serialNumber" id="serialNumber"/>
			</div>
			<div class="form-group">
			<label>price</label><input class="form-control" name="price" id="price"/>
			</div>
			<div class="form-group">
			<label>builder</label><input class="form-control" name="builder" id="builder"/>
			</div>
			<div class="form-group">
			<label>model</label><input class="form-control" name="model" id="model"/>
			</div>
			<div class="form-group">
			<label>type</label><input class="form-control" name="type" id="type"/>
			</div>
			<div class="form-group">
			<label>numStrings</label><input class="form-control" name="numStrings" id="numStrings"/>
			</div>
			<div class="form-group">
			<label>backWood</label><input class="form-control" name="backWood" id="backWood"/>
			</div>
			<div class="form-group">
			<label>topWood</label><input class="form-control" name="topWood" id="topWood"/>
			</div>
			<button class="btn  btn-lg btn-block" onclick="add()" type="button">添加</button>
			
		</div>
		<div class="col-xs-6">
		</div>
	</div>
</div>
</body>
</html>