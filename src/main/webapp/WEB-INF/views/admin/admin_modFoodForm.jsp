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
			<form action="admin_modFood" method="post"
				enctype="multipart/form-data">
				<input type="hidden" name="no" value="${foodInfo.no }">
				<div class="mb-3">
					<label class="form-label">음식이름</label> <input type="text"
						class="form-control" name="foodname" value="${foodInfo.name }">
				</div>
				<div class="mb-3">
					<label class="form-label">가격</label> <input type="text"
						class="form-control" name="price" value="${foodInfo.price }">
				</div>
				<div class="mb-3">
					<label for="formFile" class="form-label">사진(*!주의 수정시 꼭이미지 넣어주세요!)</label> <input
						class="form-control" type="file" name="file" id="inputImg">
				</div>
				<div class="mb-3">
					<img src=""id="img" alt="미리보기" style="width: 200px; height: 300px;">
				</div>
				<div class="d-flex justify-content-md-center">
					<button type="submit" class="btn btn-outline-light">수정완료</button>
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