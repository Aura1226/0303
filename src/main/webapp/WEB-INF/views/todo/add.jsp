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
	<form action="/todo/add" method='post'>
		<!--  <target='zero'> -->
		<!-- 		<input type='hidden' name='complete' value='true'> 제거가능-->
		<div>
			<input type='text' name='title' value='${todoDTO.title}'>
			<spring:hasBindErrors name="todoDTO">
				<c:if test="${errors.hasFieldErrors('title') }">
					<strong>Error.....Title...... ${errors.getFieldError( 'title' ).defaultMessage }</strong>
				</c:if>
			</spring:hasBindErrors>
		</div>

		<div>
			<button class="btn">SAVE</button>
		</div>
	</form>

	<!-- <iframe name='zero'></iframe> -->

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
		crossorigin="anonymous"></script>
	<script>
		function showResult() {
			alert("showResult")
			self.location = "/todo/list"
		}

		/* $(document).ready(function() {
			$(".btn").on("click", function(e) {
				e.preventDefault();
				/* $('form').submit(); */
		const data = {
			title : $("input[name='title']").val(),
			complete : false
		}
		console.log(data)
		$.post('/todo/add', data, function(result) {
			alert(result);
		})})
		})
	</script>
</body>
</html>