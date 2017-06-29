<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>  
<title>addSection</title>
<script type="text/javascript">
	//查询所有教师
	$(function() {
		$.ajax({
			url : '${pageContext.request.contextPath}/personAction_findAllProfessor',
			type : 'POST',
			dataType : 'json',
			data : {},
			success : function(data) {
				$("#allProfessor").empty();
				for (var i = 0; i < data.length; i++) {
					var p = data[i];
					var ps ="'" + p.ssn + "'";
					var html = '<tr><td>'
						+ p.ssn
						+ '</td><td>'
						+ p.name
						+ '</td><td>'
						+ p.title
						+ '</td><td>'
						+ p.department
						+ '</td><td><a href="javascript:void(0);"  onclick="updateProfessor('+ ps +')">updateProfessor</a>'
						+ '</td><td><a href="javascript:void(0);"  onclick="delectProfessor('+ ps +')">delect</a></td></tr>';
						$("#allProfessor").append(html);
				}	
			}
		});
	})
	//添加教师
	function addProfessor(){
		$.ajax({
			url:'${pageContext.request.contextPath}/personAction_addProfessor',
			type:'POST',
			dataType : 'json',
			data:{ssn:$("#ssn").val(),name:$("#name").val(),title:$("#title").val(),department:$("#department").val()},
			success:function(data){
				if(data.status=="ok"){
					alert("添加成功！");
					window.location.reload();
				}
			}
		});
	}
	//删除教师
	function delectProfessor(val){   
		$.ajax({
			url:'${pageContext.request.contextPath}/personAction_deleteProfessor',
			type:'POST',
			dataType : 'json',
			data:{ssn:val},
			success:function(data){
				if(data.status=="ok"){
					alert("删除成功！");
					window.location.reload();
				}
			}
		}) 
	}
</script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4">
			</div>
			<div class="form-group col-md-4">
				<h1>Add Section</h1>
				<label>ssn:</label> 
				<input class="form-control" type="text" id="ssn" />
				<label>name:</label> 
				<input class="form-control" type="text" id="name" /> 
				<label>title:</label>
				<input class="form-control" type="text" id="title" />
				<label>department:</label>
				<input class="form-control" type="text" id="department" /><br />
				<button onclick="addProfessor()" class="btn btn-default btn-lg btn-block">add</button>
			</div>
			<div class="col-md-4">
			</div>
		</div>
		<h2>All Professor</h2>
		<table class="table table-bordered">
			<thead>
				<tr>
					<td>ssn</td>
					<td>name</td>
					<td>title</td>
					<td>department</td>
					<td></td>
					<td></td>
				</tr>
			</thead>
			<tbody id="allProfessor">
			
			</tbody>
			
		</table>
	</div>
</body>
</html>