<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Drivie!(admin)</title>

<!-- 부트스트랩 -->
<link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="resources/bootstrap/js/bootstrap.js"></script>
<!-- 제이쿼리 -->
<script type="text/javascript" src="resources/jquery-3.6.0.min.js"></script>
<!-- 브레이크포인트 -->
<link href="resources/custom/css/breakpoint.css" rel="stylesheet">

</head>
<body>
	<!--헤더 -->
	<header>
		<c:import url="../layout/adminHeader.jsp" />
	</header>

	<div class="container row justify-content-md-center mx-auto mt-5">
		<div class="col-9 bg-dark text-white">
			<form action="admin_addMovie" method="post"
				enctype="multipart/form-data">
				<div class="mb-3">
					<label class="form-label">제목</label> <input type="text"
						class="form-control" name="title" placeholder="제목">
				</div>
				<div class="mb-3">
					<label class="form-label">감독</label> <input type="text"
						class="form-control" name="director" placeholder="감독">
				</div>
				<div class="mb-3">
					<label class="form-label">주연</label> <input type="text"
						class="form-control" name="actor" placeholder="주연">
				</div>
				<div class="mb-3">
					<label class="form-label">줄거리</label>
					<textarea class="form-control" name="story" rows="5"></textarea>
				</div>
				<div class="mb-3">
					<label for="formFile" class="form-label">포스터</label> <input
						class="form-control" type="file" name="file" id="inputImg">
				</div>
				<div class="mb-3">
					<img src=""id="img" alt="미리보기" style="width: 200px; height: 300px;">
				</div>
				<div class="d-flex justify-content-md-center">
					<button type="submit" class="btn btn-outline-light">등록완료</button>
				</div>
			</form>
		</div>
	</div>
	<!-- 업로드 포스터 미리보기 -->
	<script type="text/javascript">
		$(document).ready(function() {
			$("#inputImg").on("change", function() {
				readURL(this,"#img");
			});
		});
		function readURL(input,expression) {
			if (input.files && input.files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {
					$(expression).attr('src', e.target.result);
				}
				reader.readAsDataURL(input.files[0]);
			}
		}
	</script>


</body>
</html>