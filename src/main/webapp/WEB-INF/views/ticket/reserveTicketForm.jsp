<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*,java.text.*"%>
<html>
<head>
<title>Drivie!</title>

<!-- 제이쿼리 -->
<script type="text/javascript" src="resources/jquery-3.6.0.min.js"></script>
<!-- 부트스트랩 -->
<link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="resources/bootstrap/js/bootstrap.js"></script>
<!-- 브레이크포인트 -->
<link href="resources/custom/css/breakpoint.css" rel="stylesheet">
<!-- 예약스크립트 -->
<script type="text/javascript"
	src="resources/custom/js/reservationTicket.js?ver=1.4"></script>
<script type="text/javascript">
</script>
</head>
<body style="background-color: #fdfcf0">
	<!--헤더 -->
	<header>
		<c:import url="../layout/header.jsp" />
	</header>
<input type="hidden" id="sessionID" value="<%=(String)session.getAttribute("id")%>">
	<!-- 영화/극정/날짜/시간 선택창 -->
	<div class="container mt-4" id="step1">
		<div class="row text-white bg-dark text-center fw-bold py-1">
			<div class="col-4 border-end border-secondary">영화</div>
			<div class="col-4 border-end border-secondary">극장</div>
			<div class="col-4 border-end border-secondary">날짜/시간</div>
		</div>
		<div class="row" style="background-color: #f2f0e5">
			<div class="col-4 border-end border-secondary"
				style="overflow: auto; height: 560px;">
				<ul class="list-group list-group-flush" id="movieArea">
					<c:forEach items="${movieList }" var="movieList">
						<a id="movieTitle" href="#"
							onclick="selectMovie(this,${movieList.no})"
							class="list-group-item link-dark"
							style="text-decoration: none; background-color: transparent;">${movieList.title }</a>
					</c:forEach>
				</ul>
			</div>
			
			<div class="col-4 border-end border-secondary" style="overflow: auto; height: 560px;">
				<ul class="list-group list-group-flush" id="theaterArea">
				</ul>
			</div>
			
			<div class="col-4" style="overflow: auto; height: 560px;">
				<ul class="list-group list-group-flush" id="showTimeArea">
				</ul>
			</div>
			
			
		</div>
	</div>
	
	
	<!-- 좌석선택창 -->
	<div class="container mt-4" id="step2" style="display: none;">
		<div class="row text-white bg-dark text-center fw-bold py-1">
			<div class="col">관람위치선택</div>
		</div>
		<div style="height: 560px;">
			<div class="row" style="background-color: #f2f0e5;">
				<div class="col-5">
					
				</div>
				<div class="col"></div>
			</div>
			<div class="row" style="background-color: #f2f0e5">
				<div class="col-11 border-end border-secondary">
					<div class="mx-auto d-flex justify-content-center mt-4"
						style="background-color: gray; width: 652px;">
						<span><img src="resources/images/reservation/screen_text.png"></span>
					</div>
					<div class="mx-auto text-center" id="seatArea">
					</div>
				</div>
				<div class="col-1">
					<div>붉은색은 선택불가 좌석입니다</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 음식선택+결제창 -->
	<div class="container mt-4" id="step3" style="display: none;">
		<div class="row text-white bg-dark text-center fw-bold py-1">
			<div class="col">음식추가선택/결제</div>
		</div>
		<div style="height: 560px;overflow: auto;background-color: #f2f0e5;">
			<div class="row text-center ">
				<div class="col" id="foodArea">
					<div class="row">
						<div class="col-3">
						<img alt="" src="">
						</div>
						<div class="col-2">
						이름
						</div>
						<div class="col-2">
						가격
						</div>
						<div class="col-3">
							<select class="form-select form-select-sm " name="theater_no">
								<option selected>수량</option>
								<c:forEach begin="1" end="10" var="idx">
									<option value="idx">${idx }</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-2">
							<button class="btn btn-dark" type="button">추가</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 결제/영화정보창 -->
	<div class="container-fluid bg-dark">
		<div
			class="container row mx-auto text-white justify-content-md-center align-items-center">
			<div class="col-auto">
				<a href="#"><img src="resources/images/reservation/selectMovie_btn.png" style="display: none;" id="selectMovieBtn"onclick="backStep1()"></a>
				<a href="#"><img src="resources/images/reservation/backSelectSeat_btn.png" style="display: none;" id="backSeatBtn"onclick="backStep2()"></a>
			</div>
			<div class="col-auto border-end  border-secondary">
				<img src="resources/images/reservation/selectMovie_holder.png"
					id="selectMovieHolder"> <img id="selectMoviePhoto" src=""
					style="width: 78px; height: 108px; display: none;">
					<span id="selectMovieTitle"></span>
			</div>
			<div class="col-auto border-end  border-secondary">
				<img src="resources/images/reservation/selectTheater_holder.png" id="selectTheaterHolder">
				<span id="selectTheaterName"></span><br>
				<span id="selectShowTime"></span>
			</div>
			<div class="col-auto border-end  border-secondary">
				<img src="resources/images/reservation/selectSeat_holder.png" id="selectSeatHolder">
				<span id="selectSeatName"></span>
			</div>
			<div class="col-auto border-end  border-secondary">
				<img src="resources/images/reservation/patment_holder.png" id="payHolder">
				<span id="payPrice"></span>
			</div>
			<div class="col-auto">
				<a href="#"> <img src="resources/images/reservation/selectSeat_btn1.png" onclick="goStep2()" id="selectSeatBtn"></a>
				<a href="#"> <img src="resources/images/reservation/selectFood_btn.png" onclick="goStep3()" id="selectFoodBtn" style="display: none;"></a>
				<a href="#"> <img src="resources/images/reservation/selectPay_btn.png" onclick="goStep4()" id="selectPayBtn" style="display: none;"></a>
			</div>
		</div>
	</div>

	<!-- 풋터 -->
	<footer>
		<c:import url="../layout/footer.jsp" />
	</footer>
</body>
</html>