/**
 *   	Javascript Name  : fn_toolbar.js
			Description      : HereIt 지도서비스 지도제어 관리
			Modification Information
 */

/********************************************
함수명 : fn_toolbar
설 명 : HereIt 지도서비스 지도제어 관리
작성일 : 2022-04-11
작성자 : 이성준
수정일 수정자 수정내용
---------- ------ --------------
2022-04-11 이성준 최초작성
********************************************/
document.addEventListener("DOMContentLoaded", () => {

	/*************************************************************
	 * 툴박스 이벤트 모음
	 ************************************************************/

	const toolHome = document.getElementById("tool_home");
	const toolClear = document.getElementById("tool_clear");
	const toolDistance = document.getElementById("tool_distance");
	const toolArea = document.getElementById("tool_area");
	const toolPoint = document.getElementById("tool_point");
	const toolPolyline = document.getElementById("tool_polyline");
	const toolPolygon = document.getElementById("tool_polygon");
	const toolImgPrint = document.getElementById("tool_imgPrint");
	const toolImgSave = document.getElementById("tool_imgSave");
	const toolDaum = document.getElementById("tool_daum");
	const toolDaumSatelite = document.getElementById("tool_daumSatelite");
	const toolZoomUp = document.getElementById("tool_zoomup");
	const toolZoomDown = document.getElementById("tool_zoomdown");
	const toolPre = document.getElementById("tool_previous");
	const toolNext = document.getElementById("tool_next");

	//전체화면
	toolHome.addEventListener("click", function(e) {
		map.getView().animate({ center: [14233127.961095788, 4321508.791022108], zoom: 8, duration: 200 });
	});
	//초기화
	toolClear.addEventListener("click", function(e) {
		//모두지우기

	});
	//거리측정
	toolDistance.addEventListener("click", function(e) {
		// 해당 버튼 외에 다른게 클릭되어있으면 return
		if (toolArea.className.indexOf("_on") != -1 ||
			toolPoint.className.indexOf("_on") != -1 ||
			toolPolyline.className.indexOf("_on") != -1 ||
			toolPolygon.className.indexOf("_on") != -1) {
			alert('선택한 버튼을 해제하세요.');
			return;
		}

		if (this.className.indexOf("_on") != -1) {
			this.className = 'icon1 north icon1';
		} else {
			this.className = 'icon1 north icon1_on';
		}

		if (this.className.indexOf("_on") != -1) { // 클릭됬으면
			wavus.draw.addDraw('LineString').then(function(draw) {
				draw.on("drawend", function(e) {
					e.feature.setProperties({
						'feature_type': 'measure'
					});
					wavus.draw.removeDraw();
					tool_distance.className = 'icon1 north icon1';
				});
				wavus.measure.addMeasure(draw);
			});
		} else {
			wavus.draw.removeDraw();
		}
	});
	//면적측정
	toolArea.addEventListener("click", function(e) {
		// 해당 버튼 외에 다른게 클릭되어있으면 return
		if (toolDistance.className.indexOf("_on") != -1 ||
			toolPoint.className.indexOf("_on") != -1 ||
			toolPolyline.className.indexOf("_on") != -1 ||
			toolPolygon.className.indexOf("_on") != -1) {
			popupAlertConfirm('alert', 'alertChk', '선택한 버튼을 해제하세요.');
			return;
		}

		if (this.className.indexOf("_on") != -1) {
			this.className = 'icon2 north icon2';
		} else {
			this.className = 'icon2 north icon2_on';
		}

		if (this.className.indexOf("_on") != -1) { // 클릭됬으면
			wavus.draw.addDraw('Polygon').then(function(draw) {
				draw.on("drawend", function(e) {
					e.feature.setProperties({
						'feature_type': 'measure'
					});
					wavus.draw.removeDraw();
					toolArea.className = 'icon2 north icon2';
				});
				wavus.measure.addMeasure(draw);
			});
		} else {
			wavus.draw.removeDraw();
		}
	});
	//점
	toolPoint.addEventListener("click", function(e) {
		// 해당 버튼 외에 다른게 클릭되어있으면 return
		if (toolDistance.className.indexOf("_on") != -1 ||
			toolArea.className.indexOf("_on") != -1 ||
			toolPolyline.className.indexOf("_on") != -1 ||
			toolPolygon.className.indexOf("_on") != -1) {
			popupAlertConfirm('alert', 'alertChk', '선택한 버튼을 해제하세요.');
			return;
		}

		if (this.className.indexOf("_on") != -1) {
			this.className = 'icon3 north icon3';
		} else {
			this.className = 'icon3 north icon3_on';
		}

		if (this.className.indexOf("_on") != -1) { // 클릭됬으면
			wavus.draw.addDraw("Point").then(function(draw) {
				draw.on("drawend", function(e) {
					e.feature.setProperties({
						'feature_type': 'draw'
					});
					wavus.draw.removeDraw();
					toolPoint.className = 'icon3 north icon3';
				});
			});
		} else {
			wavus.draw.removeDraw();
		}

	});
	//선
	toolPolyline.addEventListener("click", function(e) {
		// 해당 버튼 외에 다른게 클릭되어있으면 return
		if (toolDistance.className.indexOf("_on") != -1 ||
			toolArea.className.indexOf("_on") != -1 ||
			toolPoint.className.indexOf("_on") != -1 ||
			toolPolygon.className.indexOf("_on") != -1) {
			popupAlertConfirm('alert', 'alertChk', '선택한 버튼을 해제하세요.');
			return;
		}

		if (this.className.indexOf("_on") != -1) {
			this.className = 'icon4 north icon4';
		} else {
			this.className = 'icon4 north icon4_on';
		}

		if (this.className.indexOf("_on") != -1) { // 클릭됬으면
			wavus.draw.addDraw("LineString").then(function(draw) {
				draw.on("drawend", function(e) {
					e.feature.setProperties({
						'feature_type': 'draw'
					});
					wavus.draw.removeDraw();
					toolPolyline.className = 'icon4 north icon4';
				});
			});
		} else {
			wavus.draw.removeDraw();
		}
	});
	//면
	toolPolygon.addEventListener("click", function(e) {
		// 해당 버튼 외에 다른게 클릭되어있으면 return
		if (toolDistance.className.indexOf("_on") != -1 ||
			toolArea.className.indexOf("_on") != -1 ||
			toolPoint.className.indexOf("_on") != -1 ||
			toolPolyline.className.indexOf("_on") != -1) {
			popupAlertConfirm('alert', 'alertChk', '선택한 버튼을 해제하세요.');
			return;
		}

		if (this.className.indexOf("_on") != -1) {
			this.className = 'icon5 north icon5';
		} else {
			this.className = 'icon5 north icon5_on';
		}

		if (this.className.indexOf("_on") != -1) { // 클릭됬으면
			wavus.draw.addDraw("Box").then(function(draw) {
				draw.on("drawend", function(e) {
					e.feature.setProperties({
						'feature_type': 'draw'
					});
					wavus.draw.removeDraw();
					toolPolygon.className = 'icon5 north icon5';
				});
			});
		} else {
			wavus.draw.removeDraw();
		}
	});
	//이미지인쇄
	toolImgPrint.addEventListener("click", function(e) {
		imgSavePrint("print");
	});
	//이미지저장
	toolImgSave.addEventListener("click", function(e) {
		imgSavePrint("image");
	});
	//배경지도-다음
	toolDaum.addEventListener("click", function(e) {
		wavus.controller.bgMapChange("daum");
	});
	//배경지도-위성
	toolDaumSatelite.addEventListener("click", function(e) {
		wavus.controller.bgMapChange("daumSatellite");
	});
	//확대
	toolZoomUp.addEventListener("click", function(e) {
		let view = wavus.map.getMap().getView();
		let zoom = wavus.map.getMap().getView().getZoom();

		view.setZoom(zoom + 1);
	});
	//축소
	toolZoomDown.addEventListener("click", function(e) {
		let view = wavus.map.getMap().getView();
		let zoom = wavus.map.getMap().getView().getZoom();

		view.setZoom(zoom - 1);
	});
	//이전
	toolPre.addEventListener("click", function(e) {
		wavus.controller.goPrevNext("prev");
	});
	//다음
	toolNext.addEventListener("click", function(e) {
		wavus.controller.goPrevNext("next");
	});


	// 툴바 중복 열기 제어
	let list = document.querySelectorAll('.right-area>ul a');
	[].forEach.call(list, function(e){
		e.addEventListener('click', click, false);
	});
	click = (e) =>{
		if(e.target.parentElement.classList.contains('on')){
			e.target.parentElement.classList.remove('on');
		}else{
			for(let i=0;i<e.target.parentElement.parentElement.childElementCount;i++){
				e.target.parentElement.parentElement.children[i].classList.remove('on');
			}
			e.target.parentElement.classList.add('on');
		}
	}

});

/* 이미지저장, 인쇄 관련 스크립트 ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ */
function imgSavePrint(actionType) {
	if (actionType == "image") {
		if (!confirm("이미지로 저장하시겠습니까?")) {
			return;
		}
		fnExcelDownLoadLog(actionType);
	}

	getMapImgUrl().then(function(_imgDataUrl) {
		if (actionType == "image") {

			var b64 = _imgDataUrl.replace("data:image/png;base64,", "");
			var obj = {
				dataUrl: b64
				, type: "map"
				, token: globalProperty.token
			};

			let form = document.createElement('form');
			form.name = 'formImgDownload';
			form.method = 'POST';
			form.action = '/biz/si/main/getMapCapture.do';

			let input1 = document.createElement('input');
			let input2 = document.createElement('input');
			let input3 = document.createElement('input');
			input1.type = 'hidden';
			input1.name = 'dataUrl';
			input1.value = b64;
			form.insertBefore(input1, null);
			input2.type = 'hidden';
			input2.name = 'type';
			input2.value = 'map';
			form.insertBefore(input2, null);
			input3.type = 'hidden';
			input3.name = 'token';
			input3.value = globalProperty.token;
			form.insertBefore(input3, null);

			document.body.insertBefore(form, null);
			form.submit();

		}
		else if (actionType == "print") {
			var printWindow = window.open('', '지도 출력', `width=${wavus.map.getMap().getSize()[0]}, height=${wavus.map.getMap().getSize()[1]}`);

			if (printWindow == null) {
				popupAlertConfirm('alert', 'alertChk', '팝업 차단을 해제 후 다시 시도해 주시기 바랍니다.');
				return;
			}
			fnExcelDownLoadLog(actionType);

			printWindow.document.write(`
			<html>
				<head>
					<style>
						.t-header_print{padding: 15px 20px;}
						.t-header_print>div{display: table-cell;vertical-align: middle;}
						.t-logo_print{padding-right: 20px;}
						.t-input_pirnt{height: 40px;width: 100%;}
						.t-input_pirnt>input{border: 0;border-bottom: 1px solid #e6e6e6;height: 28.5px;font-size: 14px;letter-spacing: -1px;width: 100%;}
						.t-button_print{white-space: nowrap;padding: 0 0 0 20px;}
						.t-button_print>button{min-width: 54px;height: 27px;display: inline-block;font-size:11px;font-weight: bold;background-color: #f5f5f5;border: 1px solid rgba(0,0,0,0.1);border-radius: 2px;box-sizing: content-box;padding: 0 8px;}'
						.t-button_print .t-print{background-color: #3B76F9;color: #fff;margin-left: 10px;}
					</style>
					<script>
						function fnPrint() {
							if(document.getElementById("printText").value == "") {
								alert("제목을 입력해주세요.");
							}else{
								document.getElementById("t-print").style.display = "none";
								document.getElementById("t-cancel").style.display = "none";
								window.print();
								self.close();
							}
						}
					</script>
				</head>
				<body style="width:100%; height:100%; margin:0px; padding:0px;">
					<div class="t-header_print" style="padding:15px 20px;">
						<div class="t-logo_print">
							<img src="../../../../images/layout/logo.png" alt="지역개발통합모니터링">
						</div>
						<div class="t-input_pirnt"><input type="text" id="printText" placeholder="여기에 제목을 입력해 주세요.">
						</div>
						<div class="t-button_print">
							<button type="button" class="t-cancel" id="t-cancel" onclick="self.close()" >취소</button>
							<button type="button" id="t-print" class="t-print" onclick="fnPrint()">인쇄</button>
						</div>
					</div>
					<img src="${_imgDataUrl}" style="border:solid 1px #999; width:calc(100% - 2px);"/>
				</body>
			</html>
			`);
		}
	});
}

/* 이미지저장, 인쇄 관련 스크립트 ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ */
//var getMapImgUrl = function(isCompress) {
//	var dfd = $.Deferred();
//	html2canvas($("#map .ol-viewport .ol-unselectable")[0]).then(
//		function(canvas) {
//			var _imgDataUrl = canvas.toDataURL('image/png');
//			if (isCompress == true) {
//				var _imageSize = Math.round((_imgDataUrl.length - ('data:image/png;base64,').length) * 3 / 4) / 1024;
//				var _qulity = 1;
//				while (_imageSize >= 1530) {
//					_imgDataUrl = canvas.toDataURL('image/jpeg', _qulity);
//					_imageSize = Math.round((_imgDataUrl.length - ('data:image/jpeg;base64,').length) * 3 / 4) / 1024;
//					_qulity -= 0.1;
//					if (_qulity < 1) break;
//				}
//			}
//			dfd.resolve(_imgDataUrl);
//		});
//	return dfd.promise();
//}
