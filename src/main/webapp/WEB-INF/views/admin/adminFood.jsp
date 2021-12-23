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
<!-- 삭제확인 -->
<script type="text/javascript">
function deleteChk(no) {
	if (!confirm("정말 삭제하시겠습니까?")) {
    } else {
        location.href='admin_delFood?no='+no;
    }
}
</script>
</head>
<body>
	<!--헤더 -->
	<header>
		<c:import url="../layout/adminHeader.jsp" />
	</header>

	<!-- 영화목록 및 관리-->

	<div class="container">
		<div class="row mt-5">
			<div class="col-6">
				<form action="admin_searchFood" method="get">
					<div class="input-group mb-3">
						<input type="text" class="form-control" placeholder="이름검색"
							name="searchWord">
						<button class="btn btn-dark" type="submit">검색</button>
					</div>
				</form>
			</div>
			<div class="col-6 d-flex justify-content-end">
				<button type="button" class="btn btn-dark"
					onclick="location.href='admin_addFoodForm'">추가</button>
			</div>
		</div>
		<div class="row mt-3">
			<table class="table col">
				<thead class="table-dark">
					<tr>
						<th scope="col">사진</th>
						<th scope="col">음식이름</th>
						<th scope="col">가격</th>
						<th class="col-1" scope="col">수정/삭제</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${foodList }" var="list">
						<tr>
							<th style="width: 200px; height: 300px;"><img
								src="resources/tmp/${list.photo }" id="img" alt="미리보기"
								style="width: 200px; height: 300px;"></th>
							<td>${list.foodname }</td>
							<td>${list.price }</td>
							<td style="width: 100px;">
								<button type="button" class="btn btn-dark"
									onclick="location.href='admin_modFoodForm?no=${list.no}'">수정</button>
								<button type="button" class="btn btn-dark"
									onclick="deleteChk(${list.no})">삭제</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>



	
	
</body>
</html>