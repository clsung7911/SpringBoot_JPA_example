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
const vworldImageUrl = 'http://api.vworld.kr/req/wmts/1.0.0/2FAB18A9-218A-3525-BB87-D8E0683C1E83/Base/{z}/{y}/{x}.png'
const satelliteImageUrl = 'http://api.vworld.kr/req/wmts/1.0.0/2FAB18A9-218A-3525-BB87-D8E0683C1E83/Satellite/{z}/{y}/{x}.jpeg'
const hybridImageUrl = 'http://api.vworld.kr/req/wmts/1.0.0/2FAB18A9-218A-3525-BB87-D8E0683C1E83/Hybrid/{z}/{y}/{x}.png'
let map;

document.addEventListener("DOMContentLoaded", () => {
	map = new ol.Map({
		target: 'map',
		layers: [
			new ol.layer.Tile({
				id: 'vworld',
				source: new ol.source.XYZ({
					url: vworldImageUrl
				})
			}),
			new ol.layer.Tile({
				id: 'satellite',
				source: new ol.source.XYZ({
					url: satelliteImageUrl
				}),
			}),
			new ol.layer.Tile({
				id: 'hybrid',
				source: new ol.source.XYZ({
					url: hybridImageUrl
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

	// 배경지도 start
	map.getLayers().forEach((v, i) => {
		v.get('id') == 'satellite' || v.get('id') == 'hybrid' ? v.setVisible(false) : v.setVisible(true);
	});
});