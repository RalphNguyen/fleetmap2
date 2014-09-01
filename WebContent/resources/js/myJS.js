// to save png image of the charts
function download_image() {
	// Canvas2Image.saveAsPNG(canvas);
	var canvas = document.getElementById("entitySummaryChart");
	var image = canvas.toDataURL("image/png").replace("image/png",
			"image/octet-stream"); // here is the most important part because
	// if you dont replace you will get a DOM 18
	// exception.
	window.location.href = image;
}

// to get exported data for entity
function exportDashboardEntity() {
	$.ajax({
		type : "Get",
		url : "exportdashboard.html",
		contentType : "text/csv; charset=utf-8",
		data : {
			"type" : "entity"
		},
		success : function() {
		},
		error : function(e) {
			alert('Error: ' + e +' \n Click OK to return');
		}
	});
}

function disableButton1() {
	//alert("I am cool");
	$("#exportButton1").removeAttr("disabled")
}

function disableButton2() {
	//alert("I am cool");
	$("#exportButton2").removeAttr("disabled")
}

// to draw smartZone Radio Usage chart
function drawSmartZone() {
	$.ajax({
				type : "Get",
				url : "drawSmartZone.html",
				contentType : "application/json",
				dataType : "json",
				success : function(response) {

					var noOfSmartZoneActivatedRadio = response.datasets.smartZoneActivatedRadios;
					var noOfSmartZoneDeactivatedRadio = response.datasets.smartZoneDeactivatedRadios;
					var noOfSmartZoneUnassignedRadio = response.datasets.smartZoneUnassignedRadios;

					var smartZone1 = response.datasets.smartZone1;
					var smartZone2 = response.datasets.smartZone2;
					var smartZone3 = response.datasets.smartZone3;

					sumSmartZone1 = smartZone1[0] + smartZone1[1]
							+ smartZone1[2];
					sumSmartZone2 = smartZone2[0] + smartZone2[1]
							+ smartZone2[2];
					sumSmartZone3 = smartZone3[0] + smartZone3[1]
							+ smartZone3[2];

					var smartZoneStackedBarData = {
						labels : [ "Z1-Analog", "Z1-Digital", "Z2-Analog",
								"Z2-Digital", "Z3-Analog", "Z3-Digital" ],
						datasets : [ {
							fillColor : "#ffbf6b",
							strokeColor : "#ffbf6b",
							pointColor : "#ffbf6b",
							pointstrokeColor : "#ffbf6b",
							data : noOfSmartZoneDeactivatedRadio,
							title : "Deacvivated Radios"
						}, {
							fillColor : "#d92543",
							strokeColor : "#d92543",
							pointColor : "#d92543",
							pointstrokeColor : "#d92543",
							data : noOfSmartZoneActivatedRadio,
							title : "Acvivated Radios"
						}, {
							fillColor : "#53cc2e",
							strokeColor : "#53cc2e",
							pointColor : "#53cc2e",
							pointstrokeColor : "#53cc2e",
							data : noOfSmartZoneUnassignedRadio,
							title : "Unassigned Radios"
						} ]
					}

					var startWithDataset = 1;
					var startWithData = 1;

					var smartZoneStackedBarOpt = {
						scaleFontColor : "#000000",
						animationStartWithDataset : startWithDataset,
						animationStartWithData : startWithData,
						animationSteps : 80,
						legend : true,
						legendBlockSize : 30,
						inGraphDataShow : true,
						inGraphDataXPosition : 2,
						inGraphDataYPosition : 3,
						inGraphDataFontColor : "#000000",
						inGraphDataFontSize : 10,
						annotateDisplay : true,
						responsive : true,
						scaleOverride : true,
						scaleStartValue : 0,
						scaleSteps : 6,
						scaleStepWidth : 5000
					}

					var ctx = document.getElementById("smartZoneStackedBar")
							.getContext("2d");
					var myBarChart = new Chart(ctx).StackedBar(
							smartZoneStackedBarData, smartZoneStackedBarOpt);

					// draw smart zone doughnuts
					var SmartZone1Data = [ {
						value : smartZone1[0],
						color : "#d92543",
						title : ""
					}, {
						value : smartZone1[1],
						color : "#ffbf6b",
						title : ""
					}, {
						value : smartZone1[2],
						color : "#53cc2e",
						title : ""
					} ];

					var SmartZone2Data = [ {
						value : smartZone2[0],
						color : "#d92543",
						title : ""
					}, {
						value : smartZone2[1],
						color : "#ffbf6b",
						title : ""
					}, {
						value : smartZone2[2],
						color : "#53cc2e",
						title : ""
					} ];

					var SmartZone3Data = [ {
						value : smartZone3[0],
						color : "#d92543",
						title : ""
					}, {
						value : smartZone3[1],
						color : "#ffbf6b",
						title : ""
					}, {
						value : smartZone3[2],
						color : "#53cc2e",
						title : ""
					} ];

					var smartZone1Crosstxt = {
						crossText : [ "SmartZone 1\n" + sumSmartZone1 ],
						crossTextIter : [ "all" ],
						crossTextOverlay : [ true ],
						crossTextFontSize : [ 18 ],
						crossTextFontColor : [ "black" ],
						crossTextRelativePosX : [ 2 ],
						crossTextRelativePosY : [ 2 ],
						crossTextAlign : [ "center" ],
						crossTextBaseline : [ "middle" ],
						inGraphDataShow : true,
						inGraphDataFontSize : 14,
						inGraphDataFontColor : "#000000"
					}

					var smartZone2Crosstxt = {
						crossText : [ "SmartZone 2\n" + sumSmartZone2 ],
						crossTextIter : [ "all" ],
						crossTextOverlay : [ true ],
						crossTextFontSize : [ 18 ],
						crossTextFontColor : [ "black" ],
						crossTextRelativePosX : [ 2 ],
						crossTextRelativePosY : [ 2 ],
						crossTextAlign : [ "center" ],
						crossTextBaseline : [ "middle" ],
						inGraphDataShow : true,
						inGraphDataFontSize : 14,
						inGraphDataFontColor : "#000000"
					}

					var smartZone3Crosstxt = {
						crossText : [ "SmartZone 3\n" + sumSmartZone3 ],
						crossTextIter : [ "all" ],
						crossTextOverlay : [ true ],
						crossTextFontSize : [ 18 ],
						crossTextFontColor : [ "black" ],
						crossTextRelativePosX : [ 2 ],
						crossTextRelativePosY : [ 2 ],
						crossTextAlign : [ "center" ],
						crossTextBaseline : [ "middle" ],
						inGraphDataShow : true,
						inGraphDataFontSize : 14,
						inGraphDataFontColor : "#000000"
					}

					var ctx = document.getElementById("smartZone1").getContext(
							"2d");
					var myBarChart = new Chart(ctx).Doughnut(SmartZone1Data,
							smartZone1Crosstxt);
					var ctx = document.getElementById("smartZone2").getContext(
							"2d");
					var myBarChart = new Chart(ctx).Doughnut(SmartZone2Data,
							smartZone2Crosstxt);
					var ctx = document.getElementById("smartZone3").getContext(
							"2d");
					var myBarChart = new Chart(ctx).Doughnut(SmartZone3Data,
							smartZone3Crosstxt);
				},
				error : function(e) {
					alert('Error: ' + e + ' \n Click OK to return');
				}
			});

}

// to draw P25 radio usage pie charts
function drawP25(pID,callback) {
	$.ajax({
		type : "Get",
		url : "drawP25.html",
		contentType : "application/json",
		dataType : "json",
		success : function(response) {

			var p25Zone1 = response.datasets.p25Zone1;
			var p25Zone2 = response.datasets.p25Zone2;
			var p25Zone3 = response.datasets.p25Zone3;

			sumP25Zone1 = p25Zone1[0] + p25Zone1[1] + p25Zone1[2];
			sumP25Zone2 = p25Zone2[0] + p25Zone2[1] + p25Zone2[2];
			sumP25Zone3 = p25Zone3[0] + p25Zone3[1] + p25Zone3[2];

			// draw smart zone doughnuts
			var startWithDataset = 1;
			var startWithData = 1;

			var p25Zone1Data = [ {
				value : p25Zone1[0],
				color : "#d92543",
				title : ""
			}, {
				value : p25Zone1[1],
				color : "#ffbf6b",
				title : ""
			}, {
				value : p25Zone1[2],
				color : "#53cc2e",
				title : ""
			} ];

			var p25Zone2Data = [ {
				value : p25Zone2[0],
				color : "#d92543",
				title : ""
			}, {
				value : p25Zone2[1],
				color : "#ffbf6b",
				title : ""
			}, {
				value : p25Zone2[2],
				color : "#53cc2e",
				title : ""
			} ];

			var p25Zone3Data = [ {
				value : p25Zone3[0],
				color : "#d92543",
				title : ""
			}, {
				value : p25Zone3[1],
				color : "#ffbf6b"
			}, {
				value : p25Zone3[2],
				color : "#53cc2e"
			} ];

			var p25Zone1Crosstxt = {
				crossText : [ "Total:" + sumP25Zone1 + "\nActivated:"
						+ p25Zone1[0] + "\nDeactivated:" + p25Zone1[1]
						+ "\nAvailable:" + p25Zone1[2] ],
				crossTextIter : [ "all" ],
				crossTextOverlay : [ true ],
				crossTextFontSize : [ 14 ],
				crossTextFontColor : [ "#000000" ],
				crossTextRelativePosX : [ 2 ],
				crossTextRelativePosY : [ 2 ],
				crossTextAlign : [ "center" ],
				crossTextBaseline : [ "middle" ],
				inGraphDataShow : false,
				inGraphDataFontSize : 10,
				inGraphDataFontColor : "#000000",
				footNote : "P25 Zone-1",
				footNoteFontSize : 20
			}

			var p25Zone2Crosstxt = {
				crossText : [ "Total:" + sumP25Zone2 + "\nActivated:"
						+ p25Zone2[0] + "\nDeactivated:" + p25Zone2[1]
						+ "\nAvailable:" + p25Zone2[2] ],
				crossTextIter : [ "all" ],
				crossTextOverlay : [ true ],
				crossTextFontSize : [ 14 ],
				crossTextFontColor : [ "#000000" ],
				crossTextRelativePosX : [ 2 ],
				crossTextRelativePosY : [ 2 ],
				crossTextAlign : [ "center" ],
				crossTextBaseline : [ "middle" ],
				inGraphDataShow : false,
				inGraphDataFontSize : 14,
				inGraphDataFontColor : "#000000",
				footNote : "P25 Zone-2",
				footNoteFontSize : 20
			}

			var p25Zone3Crosstxt = {
				crossText : [ "Total:" + sumP25Zone3 + "\nActivated:"
						+ p25Zone3[0] + "\nDeactivated:" + p25Zone3[1]
						+ "\nAvailable:" + p25Zone3[2] ],
				crossTextIter : [ "all" ],
				crossTextOverlay : [ true ],
				crossTextFontSize : [ 14 ],
				crossTextFontColor : [ "#000000" ],
				crossTextRelativePosX : [ 2 ],
				crossTextRelativePosY : [ 2 ],
				crossTextAlign : [ "center" ],
				crossTextBaseline : [ "middle" ],
				inGraphDataShow : false,
				inGraphDataFontSize : 14,
				inGraphDataFontColor : "#000000",
				footNote : "P25 Zone-3",
				footNoteFontSize : 20
			}

			var ctx = document.getElementById("p25Zone1").getContext("2d");
			var myBarChart = new Chart(ctx).Doughnut(p25Zone1Data,
					p25Zone1Crosstxt);
			var ctx = document.getElementById("p25Zone2").getContext("2d");
			var myBarChart = new Chart(ctx).Doughnut(p25Zone2Data,
					p25Zone2Crosstxt);
			var ctx = document.getElementById("p25Zone3").getContext("2d");
			var myBarChart = new Chart(ctx).Doughnut(p25Zone3Data,
					p25Zone3Crosstxt);
			callback.call();
		},
		error : function(e) {
			alert('Error: ' + e +' \n Click OK to return');
		}
	});
}

// to draw entity radio usage
function drawSummaryAll(pID,callback) {
	$.ajax({
		type : "Get",
		url : "drawSummaryAll.html",
		contentType : "application/json",
		dataType : "json",
		success : function(response) {
			var lable = response.datasets.lable;
			var analogRadios = response.datasets.analogRadios;
			var digitalRadios = response.datasets.digitalRadios;
			var p25Radios = response.datasets.p25Radios;

			var entitySummaryStackedBarData = {
				labels : lable,
				datasets : [ {
					fillColor : "#3498db",
					strokeColor : "#3498db",
					pointColor : "#3498db",
					pointstrokeColor : "#3498db",
					data : analogRadios,
					title : "Analog"
				}, {
					fillColor : "#3fff38",
					strokeColor : "#3fff38",
					pointColor : "#3fff38",
					pointstrokeColor : "#3fff38",
					data : digitalRadios,
					title : "Digital"
				}, {
					fillColor : "#ff0000",
					strokeColor : "#ff0000",
					pointColor : "#ff0000",
					pointstrokeColor : "#ff0000",
					data : p25Radios,
					title : "P25"
				} ]
			}

			var startWithDataset = 1;
			var startWithData = 1;

			var entitySummaryBarOpt = {
				scaleFontColor : "#000000",
				animationStartWithDataset : startWithDataset,
				animationStartWithData : startWithData,
				animationSteps : 80,
				legend : true,
				legendBlockSize : 30,
				inGraphDataShow : true,
				inGraphDataFontColor : "#000000",
				inGraphDataFontSize : 8.5,
				annotateDisplay : true,
				barValueSpacing : 10,
				responsive : true,
				savePng : true,
				savePngOutput : "Save"
			}
			var ctx = document.getElementById("entitySummaryChart").getContext(
					"2d");
			var myBarChart = new Chart(ctx).HorizontalBar(
					entitySummaryStackedBarData, entitySummaryBarOpt);
			callback.call();
		},
		error : function(e) {
			alert('Error: ' + e +' \n Click OK to return');
		}
	});
}
