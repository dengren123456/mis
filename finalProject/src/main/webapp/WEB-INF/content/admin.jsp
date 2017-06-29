<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	rel="stylesheet">
<script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>管理员页面</title>
<script type="text/javascript">
	//查询所有课程
	$(function() {
		$.ajax({
			url : '${pageContext.request.contextPath}/courseAction_findAllCourse',
			type : 'POST',
			dataType : 'json',
			data : {},
			success : function(data) {
				$("#allCourse").empty();
				for (var i = 0; i < data.length; i++) {
					var c = data[i];
					var ca ="'" + c.courseNo + "'";
					var prerequisite = [];
					if(c.prerequisite.length!=0){
						prerequisite = c.prerequisite[0].courseNo;
					}
					var html = '<tr><td>'
						+ c.courseNo
						+ '</td><td>'
						+ c.courseName
						+ '</td><td>'
						+ c.credits
						+ '</td><td>'
						+ prerequisite
						+ '</td><td><a href="javascript:void(0);"  onclick="addSection('+ ca +')">addToSection</a>'
						+ '</td><td><a href="javascript:void(0);"  onclick="delectCourse('+ ca +')">delect</a></td></tr>';
						$("#allCourse").append(html);
				}	
			}
		});
	})
	//查询所有可选课程
	$(function() {
		$.ajax({
			url : '${pageContext.request.contextPath}/sectionAction_findAllSection',
			type : 'POST',
			dataType : 'json',
			data : {},
			success : function(data) {
				$("#allSection").empty();
				for (var i = 0; i < data.length; i++) {
					var s = data[i];
					var html = '<tr><td>'
						+ s.sectionNo
						+ '</td><td>'
						+ s.dayOfWeek
						+ '</td><td>'
						+ s.timeOfDay
						+ '</td><td>'
						+ s.room
						+ '</td><td>'
						+ s.seatingCapacity
						+ '</td><td>'
						+ s.professor
						+ '</td><td>'
						+ s.course
						+ '</td><td><a href="#">删除</a></td></tr>';
						$("#allSection").append(html);
				}	
			}
		});
	})
	//添加课程
	function addCourse(){
		$.ajax({
			url:'${pageContext.request.contextPath}/courseAction_addCourse',
			type:'POST',
			dataType : 'json',
			data:{courseNo:$("#courseNo").val(),courseName:$("#courseName").val(),credits:$("#credits").val(),prerequisite:$("#prerequisite").val()},
			success:function(data){
				if(data.status=="ok"){
					alert("添加成功！");
					window.location.reload();
				}
			}
		});
	}
	//删除课程
	function delectCourse(val){   
		$.ajax({
			url:'${pageContext.request.contextPath}/courseAction_deleteCourse',
			type:'POST',
			dataType : 'json',
			data:{courseNo:val},
			success:function(data){
				if(data.status=="ok"){
					alert("删除成功！");
					window.location.reload();
				}
			}
		}) 
	}
	//添加Section
	function addSection(val){
		window.location.href='${pageContext.request.contextPath}/addSection?' + val + '';
	}
</script>
</head>
<body>
	<div class="container">
		<table class="table table-bordered">
		<tr>
			<td><h2>Add Course</h2></td>
		</tr>
		<tr>
			<td>
				<div class="container">
					<div class="row">
						<div class="col-md-4">
						</div>
						<div class="form-group col-md-4">
							<label>courseNo:</label> 
							<input class="form-control" type="text" id="courseNo" />
							<label>courseName:</label> 
							<input class="form-control" type="text" id="courseName" /> 
							<label>credits:</label>
							<input class="form-control" type="text" id="credits" /> 
							<label>prerequisite:</label> 
							<input class="form-control" type="text" id="prerequisite" /><br />
							<button onclick="addCourse()" class="btn btn-default btn-lg btn-block">add</button>
						</div>
						<div class="col-md-4">
						</div>
					</div>
				</div>
			</td>
		</tr>
		<tr>
			<td><h2>All Course</h2></td>
		</tr>
		<tr>
			<td>
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<td>courseNo</td>
							<td>courseName</td>
							<td>credits</td>
							<td>prerequisite</td>
							<td></td>
							<td></td>
						</tr>
					</thead>
					<tbody id="allCourse">

					</tbody>
				</table>
			</td>
		</tr>
		<tr>
			<td><h2>All Section</h2></td>
		</tr>
		<tr>
			<td>
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<td>sectionNo</td>
							<td>dayOfWeek</td>
							<td>timeOfDay</td>
							<td>room</td>
							<td>seatingCapacity</td>
							<td>professor</td>
							<td>course</td>
							<td></td>
						</tr>
					</thead>
					<tbody id="allSection">
						
					</tbody>
				</table>
			</td>
		</tr>
	</table>
	</div>
</body>
</html>