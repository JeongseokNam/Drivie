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
			location.href = 'admin_delFnT?no=' +no;
		}
	}
</script>
</head>
<body>
	<!--헤더 -->
	<header>
		<c:import url="../layout/adminHeader.jsp" />
	</header>

	<!-- 극장목록 및 관리-->

	<div class="container">
		<div class="row mt-5">
			<div class="col-6">
				<form action="admin_searchFnT" method="get">
					<div class="input-group mb-3">
						<input type="text" class="form-control" placeholder="극장별검색"
							name="searchWord">
						<button class="btn btn-dark" type="submit">검색</button>
					</div>
				</form>
			</div>
			<div class="col-6 d-flex justify-content-end"></div>
		</div>
		<div class="row mt-3">
			<table class="table col">
				<thead class="table-dark">
					<tr>
						<th class="col" scope="col">영화관</th>
						<th class="col" scope="col">사진</th>
						<th class="col" scope="col">메뉴</th>
						<th class="col" scope="col">가격</th>
						<th class="col-1" scope="col">삭제</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${FnTList }" var="FnTList">
						<tr>
							<td>${FnTList.theaterVO.theatername }</td>
							<th style="width: 200px; height: 300px;"><img
								src="resources/tmp/${FnTList.foodVO.photo }" id="img" alt="미리보기"
								style="width: 200px; height: 300px;"></th>
							<td>${FnTList.foodVO.foodname }</td>
							<td>${FnTList.foodVO.price }</td>
							<td>
								<button type="button" class="btn btn-dark"
									onclick="deleteChk('${FnTList.no }')">삭제</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div>
				<form action="admin_addFnT" method="post">
					<div class="input-group mb-3">
					<select class="form-select form-select-sm" name="theater_no">
							<option selected>극장선택</option>
							<c:forEach items="${theaterList }" var="theaterList">
							<option value=${theaterList.no }>${theaterList.theatername }</option>
							</c:forEach>
						</select>
						<select class="form-select form-select-sm" name="food_no">
							<option selected>음식선택</option>
							<c:forEach items="${foodList }" var="foodList">
							<option value=${foodList.no }>${foodList.foodname }</option>
							</c:forEach>
						</select>
						<button class="btn btn-dark" type="submit">추가</button>
					</div>
				</form>
			</div>
		</div>
	</div>


</body>
</html>