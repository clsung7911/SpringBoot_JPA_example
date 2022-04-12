/**
 *   	Javascript Name  : fn_commons.js
			Description      : HereIt 지도서비스 지도공통 관리
			Modification Information
 */

/********************************************
함수명 : fn_commons
설 명 : HereIt 지도서비스 지도공통 관리
작성일 : 2022-04-11
작성자 : 이성준
수정일 수정자 수정내용
---------- ------ --------------
2022-04-11 이성준 최초작성
********************************************/

document.addEventListener("DOMContentLoaded", () => {


});
/**
 * 레이어 조회
 * _layer : id 명
 */

getLayerId = (_layer) => {
	let layer = null;
	map.getLayers().forEach((v, i) => {
		if (v.get('id') == _layer) {
			return layer = v;
		}
	});
	return layer;
}

getMeasureLayer = (params) =>{
	var source = new ol.source.Vector();
	var vector = new ol.layer.Vector({
		source: source,
		style: new ol.style.Style({
			fill: new ol.style.Fill({
				color: 'rgba(255, 255, 255, 0.2)'
			}),
			stroke: new ol.style.Stroke({
				color: '#ffcc33',
				width: 2
			}),
			image: new ol.style.Circle({
				radius: 7,
				fill: new ol.style.Fill({
					color: '#ffcc33'
				})
			})
		})
	});

	var sketch;
	var helpTooltipElement;
	var helpTooltip;
	var measureTooltipElement;
	var measureTooltip;
	var continuePolygonMsg = '지도를 클릭해주십시오.';
	var continueLineMsg = 'Click to continue drawing the line';
	var pointerMoveHandler = function(evt) {
		if (evt.dragging) {
			return;
		}
		var helpMsg = 'Click to start drawing';

		if (sketch) {
			var geom = (sketch.getGeometry());
			if (geom instanceof ol.geom.Polygon) {
				helpMsg = continuePolygonMsg;
			} else if (geom instanceof ol.geom.LineString) {
				helpMsg = continueLineMsg;
			}
		}

		helpTooltipElement.innerHTML = helpMsg;
		helpTooltip.setPosition(evt.coordinate);

		helpTooltipElement.classList.remove('hidden');
	};

	map.on('pointermove', pointerMoveHandler);

	map.getViewport().addEventListener('mouseout', function() {
		helpTooltipElement.classList.add('hidden');
	});

	var draw; 
	var formatLength = function(line) {
		var length = ol.Sphere.getLength(line);
		var output;
		if (length > 100) {
			output = (Math.round(length / 1000 * 100) / 100) +
				' ' + 'km';
		} else {
			output = (Math.round(length * 100) / 100) +
				' ' + 'm';
		}
		return output;
	};

	var formatArea = function(polygon) {
		var area = ol.Sphere.getArea(polygon);
		var output;
		if (area > 10000) {
			output = (Math.round(area / 1000000 * 100) / 100) +
				' ' + 'km<sup>2</sup>';
		} else {
			output = (Math.round(area * 100) / 100) +
				' ' + 'm<sup>2</sup>';
		}
		return output;
	};

	function addInteraction() {
		var type = (params == 'ploygon' ? 'Polygon' : params == 'ployline' ? 'LineString' : 'Point');
		draw = new ol.interaction.Draw({
			source: source,
			type: type,
			style: new ol.style.Style({
				fill: new ol.style.Fill({
					color: 'rgba(255, 255, 255, 0.2)'
				}),
				stroke: new ol.style.Stroke({
					color: 'rgba(0, 0, 0, 0.5)',
					lineDash: [10, 10],
					width: 2
				}),
				image: new ol.style.Circle({
					radius: 5,
					stroke: new ol.style.Stroke({
						color: 'rgba(0, 0, 0, 0.7)'
					}),
					fill: new ol.style.Fill({
						color: 'rgba(255, 255, 255, 0.2)'
					})
				})
			})
		});
		
		map.addInteraction(draw);
		createMeasureTooltip();
		createHelpTooltip();

		var listener;
		draw.on('drawstart',
			function(evt) {
				sketch = evt.feature;
				var tooltipCoord = evt.coordinate;

				listener = sketch.getGeometry().on('change', function(evt) {
					var geom = evt.target;
					var output;
					if (geom instanceof ol.geom.Polygon) {
						output = formatArea(geom);
						tooltipCoord = geom.getInteriorPoint().getCoordinates();
					} else if (geom instanceof ol.geom.LineString) {
						output = formatLength(geom);
						tooltipCoord = geom.getLastCoordinate();
					}
					measureTooltipElement.innerHTML = output;
					measureTooltip.setPosition(tooltipCoord);
				});
			}, this);

		draw.on('drawend',
			function() {
				measureTooltipElement.className = 'tooltip tooltip-static';
				measureTooltip.setOffset([0, -7]);
				sketch = null;
				measureTooltipElement = null;
				createMeasureTooltip();
				ol.Observable.unByKey(listener);
			}, this);
	}

	function createHelpTooltip() {
		if (helpTooltipElement) {
			helpTooltipElement.parentNode.removeChild(helpTooltipElement);
		}
		helpTooltipElement = document.createElement('div');
		helpTooltipElement.className = 'tooltip hidden';
		helpTooltip = new ol.Overlay({
			element: helpTooltipElement,
			offset: [15, 0],
			positioning: 'center-left'
		});
		map.addOverlay(helpTooltip);
	}

	function createMeasureTooltip() {
		if (measureTooltipElement) {
			measureTooltipElement.parentNode.removeChild(measureTooltipElement);
		}
		measureTooltipElement = document.createElement('div');
		measureTooltipElement.className = 'tooltip tooltip-measure';
		measureTooltip = new ol.Overlay({
			element: measureTooltipElement,
			offset: [0, -15],
			positioning: 'bottom-center'
		});
		map.addOverlay(measureTooltip);
	}

	addInteraction();
}