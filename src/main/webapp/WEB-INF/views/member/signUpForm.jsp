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
<!-- 카카오 주소찾기 API -->
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="resources/custom/js/adrCheck.js"></script>
<!-- 회원가입체크 -->
<script type="text/javascript" src="resources/custom/js/signUpCheck.js"></script>
</head>
<body style="background-color: #fdfcf0">
	<!--헤더 -->
	<header>
		<c:import url="../layout/header.jsp" />
	</header>
	<div class="container">
		<div class="col-lg-8 mx-auto">
			<h4 class="my-5 text-center">DRV 회원가입</h4>
			<form class="needs-validation" action="signUp" onsubmit="return signUpFormChk(this)" method="post">
				<div class="row g-3">
					<div class="col-10">
						<label class="form-label">아이디</label> <input type="text"
							class="form-control" id="id" name="id">
						<div class="invalid-feedback" id="regDivId">아이디를 입력을 확인해 주세요.(6-15글자[영어대소문자,숫자허용])
						</div>
					</div>
					<div class="col-2">
						<button class="btn btn-danger" type="button"
							style="margin-top: 2rem" id="idChk_btn">중복체크</button>
					</div>
					<div class="col-12">
						<label class="form-label">비밀번호</label> <input type="password"
							class="form-control" name="pw">
						<div class="invalid-feedback" id="regDivPw">비밀번호를 입력을 확인해 주세요.(6-20글자[영어대소문자,숫자허용])</div>
					</div>

					<div class="col-12">
						<label class="form-label">이름</label>
						<div class="input-group has-validation">
							<input type="text" class="form-control" name="name"
								placeholder="홍길동">
							<div class="invalid-feedback" id="regDivName">이름을 입력해 주세요.(한글만허용)</div>
						</div>
					</div>

					<div class="col-12">
						<label for="email" class="form-label">이메일 <span
							class="text-muted">(선택)</span></label> <input type="email"
							class="form-control" name="email" placeholder="you@example.com">
					</div>
					<div class="col-10">
						<label class="form-label">주소<span class="text-muted">(선택)</span></label>
						<input type="text" class="form-control" id="address" name="address">
					</div>
					<div class="col-2">
						<button class="btn btn-danger" type="button"
							style="margin-top: 2rem" onclick="execDaumPostcode()">주소선택</button>
					</div>
					<div class="col-6">
						<label class="form-label">상세주소<span class="text-muted">(선택)</span></label>
						<input type="text" class="form-control" id="detailAddress" name="detailAddress">
					</div>
					<div class="col-6">
						<label class="form-label">참고주소<span class="text-muted">(선택)</span></label>
						<input type="text" class="form-control" id="extraAddress" name="extraAddress">
					</div>
					<div class="col-12">
						<label class="form-label">전화번호 <span class="text-muted">(선택)</span></label>
						<input type="text" class="form-control"name="tel"
							placeholder="010-1234-1234">
					</div>

					<hr class="my-4">
					<button class="w-100 btn btn-danger btn-lg" type="submit">회원가입</button>
				</div>
			</form>
		</div>
	</div>
	<!-- 풋터 -->
	<footer>
		<c:import url="../layout/footer.jsp" />
	</footer>
</body>
</html>