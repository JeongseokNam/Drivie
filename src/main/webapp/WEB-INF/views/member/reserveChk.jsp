<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Drivie!</title>
<!-- 부스트트랩 /제이쿼리-->
<link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="resources/jquery-3.6.0.min.js"></script>
<!-- 컨테이너 브레이크포인트 강제설정 -->
<link href="resources/custom/css/breakpoint.css" rel="stylesheet">
</head>
<body>
	<!--헤더 -->
	<header>
		<c:import url="../layout/header.jsp" />
	</header>
	<!-- 예약내역 -->
	<div class="container">
		<div class="row mt-5">
			<div class="col">
				<table class="table col">
					<thead class="table-dark">
						<tr>
							<th scope="col">예약번호</th>
							<th scope="col">영화</th>
							<th scope="col">극장</th>
							<th scope="col">상영시간</th>
							<th scope="col">주차장번호</th>
							<th scope="col">가격</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${reserveList }" var="list">
							<tr>
								<td>${list.reserveno }</td>
								<td>${list.movietitle }</td>
								<td>${list.theatername }</td>
								<td>${list.showtime }</td>
								<td>${list.seatname }</td>
								<td>${list.price }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<!-- 풋터 -->
	<footer>
		<c:import url="../layout/footer.jsp" />
	</footer>
</body>
</html>