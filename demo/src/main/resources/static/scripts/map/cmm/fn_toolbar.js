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

let drawLayer;

document.addEventListener("DOMContentLoaded", () => {
	// 툴바 중복 열기 제어
	let list = document.querySelectorAll('.right-area>ul a');

	click = (e) => {
		if (e.target.parentElement.classList.contains('on')) {
			e.target.parentElement.classList.remove('on');
		} else {
			for (let i = 0; i < e.target.parentElement.parentElement.childElementCount; i++) {
				e.target.parentElement.parentElement.children[i].classList.remove('on');
			}
			e.target.parentElement.classList.add('on');
		}
	}

	[].forEach.call(list, function(e) {
		e.addEventListener('click', click, false);
	});


});
/**
 * 전체화면
 */
goHome = () => {
	map.getView().animate({ center: [14233127.961095788, 4321508.791022108], zoom: 8, duration: 200 });
}

/**
 * 초기화
 */
setClear = () => {

}

/**
 * 배경지도
 * params : daum - 일반지도
 * params : satelite - 위성지도
 */
setBaseMap = (params) => {
	map.getLayers().forEach((v, i) => {
		v.setVisible(false);
	});
	if (params == 'satellite') {
		getLayerId('hybrid').setVisible(true);
	}
	getLayerId(params).setVisible(true);
}

/**
 * 측정도구
 * params : distance - 거리측정
 * params : area - 면적측정
 */
setRange = (params, vthis) => {
	
}

/**
 * 그리기도구
 * params : point - 점
 * params : polyline - 선
 * params : polygon - 면
 */
setDraw = (params) => {

}

/**
 * 인쇄도구
 * params : image - 저장
 * params : print - 인쇄
 */
setPrint = (params) => {
	if (params == 'imgSave') {
		imgSavePrint("image");
	} else {
		imgSavePrint("print");
	}
}

/**
 * 확대축소
 * params : up - 확대
 * params : down - 축소
 */
setZoom = (params) => {
	if (params == 'up') {
		map.getView().setZoom(map.getView().getZoom() + 1);
	} else {
		map.getView().setZoom(map.getView().getZoom() - 1);
	}
}

/**
 * 지도이동
 * params : previous - 이전
 * params : next - 다음
 */
setMove = (params) => {

}

/**
 * 이미지저장, 인쇄
 */
function imgSavePrint(actionType) {
	if (actionType == "image") {
		if (!confirm("이미지로 저장하시겠습니까?")) {
			return;
		}
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
			var printWindow = window.open('', '지도 출력', `width=${map.getMap().getSize()[0]}, height=${map.getMap().getSize()[1]}`);

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
							<img src="../../../../images/layout/logo.png" alt="">
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
