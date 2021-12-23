<%@page import="javax.swing.text.Document"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<nav class="navbar navbar-expand-lg navbar-light"
	style="background-image: url(resources/images/header/bg_header.gif); padding-top: 1.1rem !important;
    padding-bottom: 1.1rem !important;">
	<div class="container">
		<div class="collapse navbar-collapse justify-content-md">
			<h1><!-- 로고 -->
				<a href="home"><img src="resources/images/header/logo_size1.png"
					alt="DRV" /></a>
			</h1>
			<div class="mx-auto"><!-- 컬쳐플렉스이미지 -->
				<div class="d-flex flex-column justify-content-center">
					<h2 class="my-0 mx-auto">
						<img alt="CULTUREPLEX"
							src="resources/images/header/h2_cultureplex.png">
					</h2>
				</div>
				<div class="d-flex flex-column justify-content-center">
					<ul class="navbar-nav"><!-- 메뉴리스트 -->
						<li class="nav-item mx-2"><a class="nav-link fs-4 fw-bolder" href="reserveTicketForm">예약</a></li>
						<li class="nav-item mx-2"><a class="nav-link fs-4 fw-bolder" href="reserveChk">예약확인</a></li>
						<li class="nav-item mx-2" id="noSessionMenu"><a class="nav-link fs-4 fw-bolder" href="signin">로그인</a></li>
						<li class="nav-item mx-2" id="noSessionMenu2"><a class="nav-link fs-4 fw-bolder" href="signup">회원가입</a></li>
						<li class="nav-item mx-2" id="sessionMenu"style="display: none;"><a class="nav-link fs-4 fw-bolder" href="memberInfo">회원정보</a></li>
						<li class="nav-item mx-2" id="sessionMenu2"style="display: none;"><a class="nav-link fs-4 fw-bolder" href="logout">로그아웃</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</nav>
<!-- 세션 유무에따른 메뉴변경 -->
<script type="text/javascript">
	let id = '<%=(String)session.getAttribute("id")%>';
	if (id!='null') {
		document.getElementById("noSessionMenu").style.display="none";
		document.getElementById("noSessionMenu2").style.display="none";
		document.getElementById("sessionMenu").style.display="list-item";
		document.getElementById("sessionMenu2").style.display="list-item";
	}else {
		document.getElementById("noSessionMenu").style.display="list-item";
		document.getElementById("noSessionMenu2").style.display="list-item";
		document.getElementById("sessionMenu").style.display="none";
		document.getElementById("sessionMenu2").style.display="none";
	}
</script>