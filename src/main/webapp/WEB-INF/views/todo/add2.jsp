<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Add2</h1>

	<form action="/todo/add" method='post'>

		<div>
			<input type='text' name='title' value='${todoDTO.title}'>
		</div>

		<div>
			<button class="btn">SAVE</button>
		</div>
	</form>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
		crossorigin="anonymous"></script>
	<script>
		function showResult() {
			alert("showResult")
			self.location = "/todo/list"
		}

		$(document).ready(function() {
			$(".btn").on("click", function(e) {
				e.preventDefault();
				const data = {
					title : $("input[name='title']").val(),
					complete : false
				}
				console.log(data)
				$.post('/todo/add2', data, function(result) {
					console.log(result);
				})
			})
		})
	</script>
</body>
</html>