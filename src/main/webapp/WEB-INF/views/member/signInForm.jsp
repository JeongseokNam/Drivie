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
<!-- 로그인체크 -->
<script type="text/javascript" src="resources/custom/js/signInCheck.js"></script>
</head>
<body>
	<!--헤더 -->
	<header>
		<c:import url="../layout/header.jsp" />
	</header>
	<!-- 로그인폼 -->
	<div class="container">
		<main class="form-signin">
			<form>
				<div class="d-flex justify-content-center">
					<img class="mb-4 ml-5" src="resources/images/header/logo.png">
				</div>
				<hr>
				<p class="fs-6 text-muted d-flex justify-content-center">아이디
					비밀번호를 입력하신후, 로그인 버튼을 클릭해 주세요.</p>
				<!-- id입력란 -->
				<div class="d-flex justify-content-center row">
					<div class="form-floating mt-3 mb-2 col-6">
						<input type="text" class="form-control" id="floatingInput" name="id"> <label
							for="floatingInput">아이디</label>
					</div>
				</div>
				<!-- pw입력란 -->
				<div class="d-flex justify-content-center row">
					<div class="form-floating col-6">
						<input type="password" class="form-control" id="floatingPassword" name="pw"> <label
							for="floatingPassword">비밀번호</label>
					</div>
				</div>
				<!-- id저장버튼입력란 -->
				<div class="row d-flex justify-content-center">
					<div class="col-6">
						<div class="checkbox mb-3 mx-auto">
							<label> <input type="checkbox" id="rememberIdBox">
								아이디 기억하기
							</label>
							<div class="invalid-feedback" id="fail_signIn">아이디 혹은 비밀번호가 일치하지 않습니다.</div>
						</div>
					</div>
				</div>
				<!-- 로그인버튼 -->
				<div class="row d-flex justify-content-center">
					<div class="col-6">
						<button class="w-100 btn btn-lg btn-danger" type="button" id="signIn_btn">로그인</button>
					</div>
				</div>
				<hr>
			</form>
		</main>

	</div>
	<!-- 풋터 -->
	<footer>
		<c:import url="../layout/footer.jsp" />
	</footer>
</body>
</html>