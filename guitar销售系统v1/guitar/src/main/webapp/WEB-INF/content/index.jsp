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
	    		url:'${pageContext.request.contextPath}/guitarAction_searchGuitar.action',
		    	type:'POST',
				dataType:'json',
				data:{price:$("#price").val(),builder:$("#builder").val(),guitarModel:$("#guitarModel").val(),type:$("#type").val(),backWood:$("#backWood").val(),topWood:$("#topWood").val()},
				success:function(data){
						$("#guitar").empty();
							for(var i=0;i<data.length;i++){
								var g=data[i];
								var html='<tr><td>'+g['serialNumber'] + '</td><td>' + g['price'] + '</td><td>' +g['builder']+ '</td><td>' +g['model']+'</td><td>' +g['type']+'</td><td>' +g['backWood']+'</td><td>' +g['topWood']+'</td></tr>';
								$("#guitar").append(html);
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
			<div class="form-group">
			<label>价格</label><input class="form-control" name="price" id="price"/>
			</div>
			<div class="form-group">
			<label>制造商</label><input class="form-control" name="builder" id="builder"/>
			</div>
			<div class="form-group">
			<label>型号</label><input class="form-control" name="guitarModel" id="guitarModel"/>
			</div>
			<div class="form-group">
			<label>类型</label><input class="form-control" name="type" id="type"/>
			</div>
			<div class="form-group">
			<label>后面板木头</label><input class="form-control" name="backWood" id="backWood"/>
			</div>
			<div class="form-group">
			<label>琴头木头</label><input class="form-control" name="topWood" id="topWood"/>
			</div>
			<button class="btn  btn-lg btn-block" onclick="submit()" type="button">搜索</button>
		</div>
		<div class="col-xs-6">
			<table border="5" width="100%">
				<tr>
					<td>编号</td>
					<td>价格</td>
					<td>制造商</td>
					<td>型号</td>
					<td>类型</td>
					<td>背面板木头</td>
					<td>琴头木头</td>
				</tr>
			</table>
			<table border="1" width="100%" id="guitar">
				
			</table>
		</div>
	</div>
</div>
</body>
</html>