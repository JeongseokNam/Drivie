/**
 * 
 */

$(document).ready(function() {
	setForm();
	console.log("확인")
	$("#signIn_btn").on('click', function() {
		memberChk();
		rememberId();
	})
});// 로그인버튼클릭시 실행

function memberChk() { // id,pw체크
	$.ajax({
		url : "memberChk",
		type : "POST",
		data : {
			id : $("#floatingInput").val(),
			pw : $("#floatingPassword").val()
		},
		success : function(data) {
			if (data == "") {// 틀리면 안내문구 블록처리
				$("#fail_signIn").css("display", "block");
			} else {
				window.location.href = data;// 홈이동
			}
		}

	})
}

function rememberId() {// 아이디저장
	let id = $("#floatingInput").val();
	let useChkBox = $("#rememberIdBox").is(":checked"); // 리턴값 boolean

	if (useChkBox) {
		setCookie("idCookie", id);
	} else {
		deleteCookie("idCookie");
	}
}

function setCookie(cookieName, value) { // 쿠키저장
	document.cookie = cookieName + "=" + escape(value);
}
function getCookie(cookieName) {//쿠키가져오기
	cookieName = cookieName + '=';
	var cookieData = document.cookie;
	var start = cookieData.indexOf(cookieName);
	var cookieValue = '';
	if (start != -1) {
		start += cookieName.length;
		var end = cookieData.indexOf(';', start);
		if (end == -1)
			end = cookieData.length;
		cookieValue = cookieData.substring(start, end);
	}
	return unescape(cookieValue);
}

function deleteCookie(cooKieName) { // 쿠키삭제
	let expireDate = new Date();
	expireDate.setDate(expireDate.getDate() - 1);

	document.cookie = cooKieName + "= " + "; expires="
			+ expireDate.toGMTString();
}
function setForm() {
	let id = getCookie("idCookie");
	if (id!=null) {
		$("#floatingInput").val(id);
		$("#rememberIdBox").attr("checked",true);
	}else{
		alert("test");
	}
	
}