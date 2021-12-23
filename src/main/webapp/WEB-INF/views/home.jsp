<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Drivie!</title>

<!-- 부트스트랩 -->
<link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="resources/bootstrap/js/bootstrap.js"></script>
<!-- 브레이크포인트 -->
<link href="resources/custom/css/breakpoint.css" rel="stylesheet">

</head>
<body style="background-color: #fdfcf0">
<!--헤더 -->
	<header>
		<c:import url="layout/header.jsp" />
	</header>
<!-- 캐러셀 -->
	<div class="container-fluid"
		style="background-image: url(resources/images/home/bg_c_bricks.png); background-repeat: repeat-x">
		<div class="container">
			<div id="carouselExampleIndicators"
				class="carousel slide carousel-fade" data-bs-ride="carousel">
				<div class="carousel-indicators ">
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="0" class="active" aria-current="true"
						aria-label="Slide 1"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="1" aria-label="Slide 2"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="2" aria-label="Slide 3"></button>
				</div>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="resources/images/home/carousel1.png"
							class="rounded mx-auto d-block">
					</div>
					<div class="carousel-item">
						<img src="resources/images/home/carousel2.png"
							class="rounded mx-auto d-block">
					</div>
					<div class="carousel-item">
						<img src="resources/images/home/carousel3.png"
							class="rounded mx-auto d-block">
					</div>
				</div>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>
			</div>
<!-- 무비셀렉션 & 유툽예고편 -->
			<div class="mx-5">
				<h3 class="mt-4 mb-3 text-center"
					style="background: url(resources/images/home/bg_h3_line.jpg) repeat-x 0 50%;">
					<img src="resources/images/home/h3_movie_selection.gif">
				</h3>
				<div class="ratio ratio-16x9">
					<iframe width="560" height="315"
						src="https://www.youtube.com/embed/egg3dUdD_Js"
						title="YouTube video player" frameborder="0"
						allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
						allowfullscreen></iframe>
				</div>
			</div>
		</div>
	</div>
<!-- 풋터 -->
	<footer>
		<c:import url="layout/footer.jsp"/>
	</footer>
</body>
</html>
