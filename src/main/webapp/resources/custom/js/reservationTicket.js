/**
 * 
 */
let setMovieNo = 0;
let setTheaterNo = 0;
let setMnTNo = 0;
let setSeatName = null;
let payPrice = 20000;
let setFoodList = new Array();
let setFood = new Object();
function selectMovie(obj, movieNo) {
	// 선택영화색상변경
	$("#movieArea a").css("background-color", "transparent");
	$("#movieArea a").removeClass("link-light");
	$("#movieArea a").addClass("link-dark");
	$(obj).css("background-color", "black");
	$(obj).removeClass("link-dark");
	$(obj).addClass("link-light");
	// 영화번호기억
	setMovieNo = 0;
	setMovieNo += movieNo;
	// 영화타이틀넘기기
	var t = $(obj).html();
	$("#selectMovieTitle").text(t);
	printTheaterList(movieNo);
}
function printTheaterList(movieNo) {
	$
			.ajax({
				type : "get",
				url : "getTheaterListByMovie",
				data : {
					"movieNo" : movieNo
				},
				success : function(theaterList) {
					// let str = JSON.stringify(theaterList);
					// alert(str);
					let outTiltle = "";
					let outPhoto = "resources/tmp/";
					for ( let i in theaterList) {
						outTiltle += '<a class="list-group-item link-dark" onclick="selectTheater(this,'
						outTiltle += theaterList[i].theaterVO.no
						outTiltle += ')" href="#" style="text-decoration: none;background-color: transparent;">'
						outTiltle += theaterList[i].theaterVO.theatername
						outTiltle += '</a>'

					}
					$("#theaterArea").html(outTiltle);
					$("#selectMoviePhoto").attr("src",
							outPhoto + theaterList[0].movieVO.photo);
					$("#selectMovieHolder").attr("src", "");
					$("#selectMoviePhoto").css("display", "block");
				}
			})
}
function selectTheater(obj, theaterno) {
	$("#theaterArea a").css("background-color", "transparent");
	$("#theaterArea a").removeClass("link-light");
	$("#theaterArea a").addClass("link-dark");
	$(obj).css("background-color", "black");
	$(obj).removeClass("link-dark");
	$(obj).addClass("link-light");

	setTheaterNo = 0;
	setTheaterNo = theaterno;
	var t = $(obj).html();
	$("#selectTheaterName").text(t);
	$("#selectTheaterHolder").attr("src", "");
	printShowtimeList(setMovieNo, setTheaterNo);
}

function printShowtimeList(setMovieNo, setTheaterNo) {
	$
			.ajax({
				type : "get",
				url : "getShowTimeList",
				data : {
					"setMovieNo" : setMovieNo,
					"setTheaterNo" : setTheaterNo
				},
				success : function(showTimeList) {
					// let str = JSON.stringify(showTimeList);
					// alert(str);
					let outShowTime = "";
					for ( let i in showTimeList) {
						outShowTime += '<a class="list-group-item link-dark" onclick="selectShowTime(this,'
						outShowTime += showTimeList[i].no
						outShowTime += ')" href="#" style="text-decoration: none;background-color: transparent;">'
						outShowTime += showTimeList[i].showtime.substring(0, 4);
						outShowTime += '년 '
						outShowTime += showTimeList[i].showtime.substring(5, 7);
						outShowTime += '월 '
						outShowTime += showTimeList[i].showtime
								.substring(8, 10);
						outShowTime += '일 '
						outShowTime += showTimeList[i].showtime.substring(11,
								13);
						outShowTime += '시 '
						outShowTime += showTimeList[i].showtime.substring(14,
								16);
						outShowTime += '분 '
						outShowTime += '</a>'
					}
					$("#showTimeArea").html(outShowTime);
				}
			})
}

function selectShowTime(obj, mntno) {
	$("#showTimeArea a").css("background-color", "transparent");
	$("#showTimeArea a").removeClass("link-light");
	$("#showTimeArea a").addClass("link-dark");
	$(obj).css("background-color", "black");
	$(obj).removeClass("link-dark");
	$(obj).addClass("link-light");

	var t = $(obj).html();
	$("#selectShowTime").text(t);
	setMnTNo = 0;
	setMnTNo += mntno;
}

function goStep2() {
	if (setMovieNo == 0) {
		alert("영화를 선택해주세요")
	} else {
		if (setTheaterNo == 0) {
			alert("극장을 선택해주세요")
		} else {
			if (setMnTNo == 0) {
				alert("날짜,시간을 선택해주세요")
			} else {
				$("#step1").css("display", "none");
				$("#step2").css("display", "block");
				$("#selectSeatBtn").css("display", "none");
				$("#selectMovieBtn").css("display", "block");
				$("#selectFoodBtn").css("display", "block");
				printSeat(setMnTNo);
			}
		}
	}

}

function backStep1() {
	$("#step1").css("display", "block");
	$("#step2").css("display", "none");
	$("#selectSeatBtn").css("display", "block");
	$("#selectMovieBtn").css("display", "none");
	$("#selectPayBtn").css("display", "none");
}

function printSeat(setMnTNo) {
	$
			.ajax({
				type : "get",
				url : "getSeatList",
				data : {
					"setMnTNo" : setMnTNo
				},
				success : function(seatrowcol) {
					$
							.ajax({
								type : "get",
								url : "getSeatFlag",
								data : {
									"setMnTNo" : setMnTNo
								},
								success : function(flagList) {
									// let str = JSON.stringify(flagList);
									// alert(str);
									let outSeat = "";
									let seat1 = "A";
									let seat2 = 1;
									for (var i = 65; i < 65 + seatrowcol.seat_row; i++) {
										seat1 = String.fromCharCode(i);
										outSeat += '<div class="row">'
										for (var j = 1; j < seatrowcol.seat_col + 1; j++) {
											seat2 = j
											for (var k = 0; k < flagList.length; k++) {
												if (seat1 + seat2 == flagList[k].seat_name) {
													if (flagList[k].seat_flag == 0) {
														outSeat += '<div class="col border border-secondary px-0 py-4" id="id="selectableSeat">'
														outSeat += `<a class="link-dark" onclick="selectSeat(this,\'`
														outSeat += seat1
																+ seat2
														outSeat += `\')"href="#" style="text-decoration: none;background-color: transparent;">`
														outSeat += seat1
																+ seat2
														outSeat += '</a>'
														outSeat += '</div>'
													} else {
														outSeat += '<div class="col border border-secondary px-0 py-4 bg-danger text-white" id="nonSelectableSeat">'
														outSeat += '<a class="link-dark" onclick="selectSeat(this,"'
														outSeat += seat1
																+ seat2
														outSeat += '")" style="text-decoration: none;background-color: transparent;" >'
														outSeat += seat1
																+ seat2
														outSeat += '</a>'
														outSeat += '</div>'
													}
												}
											}
										}
										outSeat += '</div>'
									}
									$("#seatArea").html(outSeat);
								}
							})
				}
			})
}

function selectSeat(obj, seatName) {
	$("#seatArea div").css("background-color", "transparent");
	$("#seatArea div a").removeClass("link-light");
	$("#seatArea div a").addClass("link-dark");
	$(obj).parent().css("background-color", "black");
	$(obj).removeClass("link-dark");
	$(obj).addClass("link-light");
	$("#selectSeatName").text(seatName);
	$("#selectSeatHolder").attr("src", "");

	setSeatName = seatName;
}

function goStep3() {
	if (setSeatName == null) {
		alert("좌석을 선택해 주세요");
	} else {
		$("#step2").css("display", "none");
		$("#step3").css("display", "block");
		$("#selectFoodBtn").css("display", "none");
		$("#selectMovieBtn").css("display", "none");
		$("#backSeatBtn").css("display", "block");
		$("#selectPayBtn").css("display", "block");
		$("#payHolder").attr("src", "");
		printFood(setTheaterNo);
		$("#payPrice").text("결제금액:" + payPrice + "원");

	}
}

function backStep2() {
	$("#step3").css("display", "none");
	$("#step2").css("display", "block");
	$("#selectPayBtn").css("display", "none");
	$("#backSeatBtn").css("display", "none");
	$("#selectMovieBtn").css("display", "block");
	$("#selectFoodBtn").css("display", "block");
}

function printFood(setTheaterNo) {
	$
			.ajax({
				type : "get",
				url : "getFoodListByTheaterNo",
				data : {
					"setTheaterNo" : setTheaterNo
				},
				success : function(foodList) {
					let outFood = ""
					for (i in foodList) {
						outFood += '<div class="row"><div class="col-3">'
						outFood += `<img style="width: 78px; height: 108px;"alt="" src="resources/tmp/`
						outFood += foodList[i].photo
						outFood += `"></div><div class="col-2" id="foodname`
								+ i + `">`
						outFood += foodList[i].foodname
						outFood += '</div><div class="col-2" id="foodprice' + i
								+ '">'
						outFood += foodList[i].price
						outFood += '</div><div class="col-3">'
						outFood += '<select class="form-select form-select-sm " id="foodcnt'
								+ i + '">'
						outFood += '<option selected>수량</option>'
						outFood += '<option value=1>1</option>'
						outFood += '<option value=2>2</option>'
						outFood += '<option value=3>3</option>'
						outFood += '<option value=4>4</option>'
						outFood += '<option value=5>5</option></select>'
						outFood += '</div><div class="col-2">'
						outFood += '<button class="btn btn-dark" type="button" onclick="addFood('
								+ i + ')">추가</button></div></div>'
					}
					$("#foodArea").html(outFood);
				}
			})
}

function addFood(i) {
	setFood.foodname = $("#foodname" + i).text();
	setFood.foodcnt = $("#foodcnt" + i).val();
	setFoodList.push(setFood);
	let t
	let y
	t = parseInt($("#foodprice" + i).text());
	y = parseInt($("#foodcnt" + i).val());
	payPrice += t * y;
	$("#payPrice").text("결제금액:" + payPrice + "원");
}

function goStep4() {
	let reservation = new Object();
	reservation.movietitle =$("#selectMovieTitle").text();
	reservation.theatername =$("#selectTheaterName").text();
	reservation.showtime =$("#selectShowTime").text();
	reservation.seatname =$("#selectSeatName").text();
	reservation.price=$("#payPrice").text();
	reservation.memberid=$("#sessionID").val();
	$.ajax({
		type:"post",
		url:"addResrvatrion",
		data: JSON.stringify(reservation),
		contentType: "application/json; charset=utf-8",
		success: function(reno){
			alert("예약완료되었습니다. 예약내역은 예약환인 메뉴에서 해주세요")
			location.href="home"
			//setFood.reserveno=reno;
		    //setFoodList.push(setFood);
/*			$.ajax({
				type:"post",
				url:"addReserveFood",
				data:JSON.stringify(setFoodList),
				contentType: "application/json; charset=utf-8",
				success: function(reserveno){
					
				}
			})*/
		}
	})
	
}
