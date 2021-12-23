/**
 * 
 */

let tempIdChk=true;
//중복체크여부
$(document).ready(function () {
	$("#idChk_btn").on('click', function() {
		idChk();
	})
});//중복체크버튼클릭시실행
	
function idChk() {
    $.ajax({
        url: "idChk",
        type: "POST",
        data: {id:$("#id").val()},//id유무체크 컨트롤러로
        success: function(tempId){
            if (tempId=="") {//동일한아이디없을시
            	if ($("#id").val().length<6) {//아이디길이체크
					alert("6글자이상 입력해 주세요")
				}else{//중복,길이 통과시.
					alert("사용가능한 ID입니다.")
					tempIdChk=true;
				}
			}else{
				alert("중복된 ID입니다. 다른아이디를 입력해 주세요");
			}
        },
        error: function(){
            alert("오류입니다. 관리자에게 문의하세요");
        }
  	});
}

let regidChk = /^[A-Za-z0-9]{6,15}$/;
let pwChk = /^[A-Za-z0-9]{6,20}$/;
let nameChk = /^[가-힣]+$/;

function signUpFormChk(form){
	let id = form.id.value;
	let pw = form.pw.value;
	let name = form.name.value;
	let sign = false;
	let sign2 = false;
	let sign3 = false;
	if (tempIdChk) {//중복체크 통과시
		if (!regidChk.test(id)) {//form유효성검사 , id pw name 각각 검사.
			document.getElementById("regDivId").style.display="block";
			sign = false;
		}else{
			document.getElementById("regDivId").style.display="none";
			sign = true;
		}
		if (!pwChk.test(pw)) {//pw유효성검사
			document.getElementById("regDivPw").style.display="block";
			sign2 = false;
		}else{
			document.getElementById("regDivPw").style.display="none";
			sign2 = true;
		}
		if (!nameChk.test(name)) {//name유효성검사
			document.getElementById("regDivName").style.display="block";
			sign3 = false;
		}else{
			document.getElementById("regDivName").style.display="none";
			sign3 = true;
		}
		if (sign&&sign2&&sign3) {//모두통과시 회원가입 submit
			return true;
		}else{
			return false;
		}
	}else{
		alert("ID중복체크를 해주세요");
		return false;
	}
}