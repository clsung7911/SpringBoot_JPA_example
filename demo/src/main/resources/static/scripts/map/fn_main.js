/**
 *   	Javascript Name  : fn_main.js
			Description      : HereIt 지도서비스 지도화면 관리
			Modification Information
 */

/********************************************
함수명 : fn_main
설 명 : HereIt 지도서비스 지도화면 관리
작성일 : 2022-04-11
작성자 : 이성준
수정일 수정자 수정내용
---------- ------ --------------
2022-04-11 이성준 최초작성
********************************************/
document.addEventListener("DOMContentLoaded", () => {
	const vworldImageUrl = 'http://xdworld.vworld.kr:8080/2d/Base/201612/{z}/{x}/{y}.png';
	let map = new ol.Map({
		target: 'map',
		layers: [
			new ol.layer.Tile({
				source: new ol.source.XYZ({
					url: 'http://xdworld.vworld.kr:8080/2d/Base/202002/{z}/{x}/{y}.png'
				})
			})
		],
		view: new ol.View({
			center: [14233127.961095788, 4321508.791022108],
			zoom: 8,
			minZoom: 8,
			maxZoom: 19
		}),
		controls: []
	});
});