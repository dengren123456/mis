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
<title>学生页面</title>
<script type="text/javascript">
	var str=location.href;
	var cc = str.substr(str.indexOf("?")+1);
	$(function() {
		$("#show").empty();
		var html = '<h1>欢迎您，' + cc + '</h1>'
		$("#show").append(html);
	})
	$(function() {
		$.ajax({
			url : '${pageContext.request.contextPath}/planOfStudyAction_findAllPlan',
			type : 'POST',
			dataType : 'json',
			data : {ssn:cc},
			success : function(data) {
				$("#planCourse").empty();
				for (var i = 0; i < data.length; i++) {
					var c = data[i];
					var html = '<tr><td>'
						+ c.courseNo
						+ '</td><td>'
						+ c.courseName
						+ '</td><td>'
						+ c.credits
						+ '</td></tr>';
						$("#planCourse").append(html);
				}	
			}
		});
	})
	//查询所有已选课程
	$(function() {
		$.ajax({
			url : '${pageContext.request.contextPath}/sectionAction_getBySsn',
			type : 'POST',
			dataType : 'json',
			data : {ssn:cc},
			success : function(data) {
				$("#hasSection").empty();
				for (var i = 0; i < data.length; i++) {
					var s = data[i];
					var se ="'" + s.sectionNo + "'";
					var html = '<tr><td>'
						+ s.sectionNo
						+ '</td><td>'
						+ s.dayOfWeek
						+ '</td><td>'
						+ s.timeOfDay
						+ '</td><td>'
						+ s.room
						+ '</td><td>'
						+ s.professor
						+ '</td><td>'
						+ s.course
						+ '</td><td>'
						+ s.grade
						+ '</td><td><a href="javascript:void(0);"  onclick="addTranscript('+ se +')">退选</a></td></tr>';
						$("#hasSection").append(html);
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
					var se ="'" + s.sectionNo + "'";
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
						+ '</td><td><a href="javascript:void(0);"  onclick="addTranscript('+ se +')">选课</a></td></tr>';
						$("#allSection").append(html);
				}	
			}
		});
	})
	function addTranscript(val){
		$.ajax({
			url:'${pageContext.request.contextPath}/sectionAction_addTranscript',
			type:'POST',
			dataType : 'json',
			data:{ssn:cc,sectionNo:val},
			success:function(data){
				if(data.status=="ok"){
					alert("添加成功！");
					window.location.reload();
				}
			}
		});
	}

</script>
</head>
<body>
	<div class="container">
		<div id="show"></div>
		<hr/>
		<h2>PlanOfStudy</h2>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<td>courseNo</td>
					<td>courseName</td>
					<td>credits</td>
				</tr>
			</thead>
			<tbody id="planCourse">

			</tbody>
		</table>
		<h2>已选课程</h2>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<td>sectionNo</td>
					<td>dayOfWeek</td>
					<td>timeOfDay</td>
					<td>room</td>
					<td>professor</td>
					<td>course</td>
					<td>grade</td>
					<td></td>
				</tr>
			</thead>
			<tbody id="hasSection">
				
			</tbody>
		</table>
		<h2>All Section</h2>
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
	</div>
</body>
</html>