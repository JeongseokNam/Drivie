<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container">
		<div class="collapse navbar-collapse justify-content-md">
			<h1><!-- 로고 -->
				<a href="admin"><img src="resources/images/header/logo_admin.png"
					alt="DRV" /></a>
			</h1>
			<div class="mx-auto">
				<div class="d-flex flex-column justify-content-center">
					<ul class="navbar-nav"><!-- 메뉴리스트 -->
						<li class="nav-item mx-2" id="grade2Menu1"><a class="nav-link fs-4 fw-bolder" href="adminMovie">영화관리</a></li>
						<li class="nav-item mx-2" id="grade2Menu2"><a class="nav-link fs-4 fw-bolder" href="adminTheater">극장관리</a></li>
						<li class="nav-item mx-2" id="grade2Menu3"><a class="nav-link fs-4 fw-bolder" href="adminFood">음식관리</a></li>
						<li class="nav-item mx-2" id="grade2Menu4"><a class="nav-link fs-4 fw-bolder" href="adminMember">회원관리</a></li>
						<li class="nav-item mx-2" id="grade1Menu1"><a class="nav-link fs-4 fw-bolder" href="admin_movieInTheater">상영영화관리</a></li>
						<li class="nav-item mx-2" id="grade1Menu2"><a class="nav-link fs-4 fw-bolder" href="admin_FoodInTheater">판매음식관리</a></li>
						<li class="nav-item mx-2" ><a class="nav-link fs-4 fw-bolder" href="">예약관리</a></li>
						<li class="nav-item mx-2" ><a class="nav-link fs-4 fw-bolder" href="logout">로그아웃</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</nav>
<!-- 회원등급에따른 메뉴변경 -->
<script type="text/javascript">
	let grade = '<%=(Integer)session.getAttribute("grade")%>';
	if (grade==1) {
		document.getElementById("grade1Menu1").style.display="list-item";
		document.getElementById("grade1Menu2").style.display="list-item";
		document.getElementById("grade2Menu1").style.display="none";
		document.getElementById("grade2Menu2").style.display="none";
		document.getElementById("grade2Menu3").style.display="none";
		document.getElementById("grade2Menu4").style.display="none";
	}else {
		document.getElementById("grade1Menu1").style.display="none";
		document.getElementById("grade1Menu2").style.display="none";
		document.getElementById("grade2Menu1").style.display="list-item";
		document.getElementById("grade2Menu2").style.display="list-item";
		document.getElementById("grade2Menu3").style.display="list-item";
		document.getElementById("grade2Menu4").style.display="list-item";
	}
</script>