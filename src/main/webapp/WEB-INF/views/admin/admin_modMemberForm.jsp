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
<!-- 카카오 주소찾기 API -->
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="resources/custom/js/adrCheck.js"></script>
</head>
<body>
	<!--헤더 -->
	<header>
		<c:import url="../layout/adminHeader.jsp" />
	</header>

	<div class="container row justify-content-md-center mx-auto mt-5">
		<div class="col-9 bg-dark text-white">
			<form class="row" action="admin_modMember" method="post">
				<div class="mb-3">
					<label class="form-label">아이디</label> <input type="text"
						class="form-control" id="id" name="id" readonly value="${memberInfo.id }">
				</div>
				<div class="mb-3">
					<label class="form-label">비밀번호</label> <input type="password"
						class="form-control" name="pw" readonly value="${memberInfo.pw }">
				</div>

				<div class="mb-3">
					<label class="form-label">이름</label>
					<div class="input-group has-validation">
						<input type="text" class="form-control" name="name"value="${memberInfo.name }">
						<div class="invalid-feedback" id="regDivName">이름을 입력해
							주세요.(한글만허용)</div>
					</div>
				</div>

				<div class="mb-3">
					<label for="email" class="form-label">이메일</label> <input
						type="email" class="form-control" name="email"
						value="${memberInfo.email }">
				</div>
				<div class="col-10 mb-3">
					<label class="form-label">주소</label> <input type="text"
						class="form-control" id="address" name="address"
						value="${memberInfo.address }">
				</div>
				<div class="col-2 mb-3">
					<button class="btn btn-danger" type="button"
						style="margin-top: 2rem" onclick="execDaumPostcode()">주소선택</button>
				</div>
				<div class="col-6 mb-3">
					<label class="form-label">상세주소</label> <input type="text"
						class="form-control" id="detailAddress" name="detailAddress"
						value="${memberInfo.detailAddress }">
				</div>
				<div class="col-6 mb-3">
					<label class="form-label">참고주소</label> <input type="text"
						class="form-control" id="extraAddress" name="extraAddress"
						value="${memberInfo.extraAddress }">
				</div>
				<div class="mb-3">
					<label class="form-label">전화번호</label> <input type="text"
						class="form-control" name="tel" value="${memberInfo.tel }">
				</div>
				<div class="mb-3">
					<label class="form-label">회원등급 [0:일반/1:매장관리자/2:시스템관리자]</label> <input
						type="text" class="form-control" name="grade"
						value="${memberInfo.grade }">
				</div>
				<div class="d-flex justify-content-md-center">
					<button type="submit" class="btn btn-outline-light">등록완료</button>
				</div>
			</form>
		</div>
	</div>

</body>
</html>