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
    function submit(){
	    	$.ajax({
	    		url:'${pageContext.request.contextPath}/guitarAction_search',
		    	type:'POST',
				dataType:'json',
				data:{numStrings:$("#numStrings").val(),builder:$("#builder").val(),model:$("#model").val(),type:$("#type").val(),backWood:$("#backWood").val(),topWood:$("#topWood").val()},
				success:function(data){
						$("#guitar").empty();
							for(var i=0;i<data.length;i++){
								var g=data[i];
								var html='<tr><td>'+g['serialNumber'] + '</td><td>' + g['price'] + '</td><td>' +g['builder']+ '</td><td>' +g['model']+'</td><td>' +g['type']+'</td><td>' +g['backWood']+'</td><td>' +g['topWood']+'</td><td>'+g['numStrings']+'</td><td><a href="${pageContext.request.contextPath}/guitarAction_delect?serialNumber='+ g['serialNumber'] +'">删除</a></td></tr>';
								$("#guitar").append(html);
							}
				},
	    	})
	    }
    function add(){
    	window.open("${pageContext.request.contextPath}/add");
    }
    </script>     
</head>
<body>
<div class="container ">
	<div class="row">
		<div class="col-xs-6">
			<h1>搜索：</h1>
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
			<button class="btn  btn-lg btn-block" onclick="submit()" type="button">搜索</button>
			
		</div>
		<div class="col-xs-6">
			<h1>搜索结果：</h1>
			<table border="5" width="100%">
				<tr>
					<td>serialNumber</td>
					<td>price</td>
					<td>builder</td>
					<td>model</td>
					<td>type</td>
					<td>numStrings</td>
					<td>backWood</td>
					<td>topWood</td>
					<td></td>
				</tr>
			</table>
			<table border="1" width="100%" id="guitar">
				
			</table>
			<h1>&nbsp;</h1>
			<h1>&nbsp;</h1>
			<h1>&nbsp;</h1>
			<button class="btn  btn-lg btn-block" onclick="add()" type="button">添加吉他</button>
		</div>
	</div>
</div>
</body>
</html>