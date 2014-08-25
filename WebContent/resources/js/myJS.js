function drawSmartZone() {
	$
			.ajax({
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
						labels : [ "Zone1-Analog", "Zone1-Digital",
								"Zone2-Analog", "Zone2-Digital",
								"Zone3-Analog", "Zone3-Digital" ],
						datasets : [ {
							fillColor : "#ffbf6b",
							strokeColor : "rgba(151,187,205,1)",
							pointColor : "green",
							pointstrokeColor : "yellow",
							data : noOfSmartZoneDeactivatedRadio,
							title : "Deacvivated Radios"
						}, {
							fillColor : "#d92543",
							strokeColor : "rgba(220,220,220,1)",
							pointColor : "rgba(220,220,220,1)",
							pointstrokeColor : "yellow",
							data : noOfSmartZoneActivatedRadio,
							title : "Acvivated Radios"
						}, {
							fillColor : "#53cc2e",
							strokeColor : "rgba(151,187,205,1)",
							pointColor : "green",
							pointstrokeColor : "yellow",
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
						graphTitle : "SmartZone Radio Usage",
						graphTitleFontSize : 30,
						legend : true,
						legendBlockSize : 30,
						inGraphDataShow : true,
						inGraphDataXPosition : 2,
						inGraphDataYPosition : 3,
						inGraphDataFontColor : "#000000",
						inGraphDataFontSize : 12,
						annotateDisplay : true,
						responsive : true
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
					alert('Error: ' + e);
				}
			});
}

function drawP25() {
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
				crossText : [ "P25 Zone 1\n" + sumP25Zone1 ],
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

			var p25Zone2Crosstxt = {
				crossText : [ "P25 Zone 2\n" + sumP25Zone2 ],
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

			var p25Zone3Crosstxt = {
				crossText : [ "P25 Zone 3\n" + sumP25Zone3 ],
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

			var ctx = document.getElementById("p25Zone1").getContext("2d");
			var myBarChart = new Chart(ctx).Doughnut(p25Zone1Data,
					p25Zone1Crosstxt);
			var ctx = document.getElementById("p25Zone2").getContext("2d");
			var myBarChart = new Chart(ctx).Doughnut(p25Zone2Data,
					p25Zone2Crosstxt);
			var ctx = document.getElementById("p25Zone3").getContext("2d");
			var myBarChart = new Chart(ctx).Doughnut(p25Zone3Data,
					p25Zone3Crosstxt);

		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
}

function drawSummaryAll() {
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
					fillColor : "#ffbf6b",
					strokeColor : "rgba(151,187,205,1)",
					pointColor : "green",
					pointstrokeColor : "yellow",
					data : analogRadios,
					title : "Analog Radios"
				}, {
					fillColor : "#d92543",
					strokeColor : "rgba(220,220,220,1)",
					pointColor : "rgba(220,220,220,1)",
					pointstrokeColor : "yellow",
					data : digitalRadios,
					title : "Digital Radios"
				}, {
					fillColor : "#53cc2e",
					strokeColor : "rgba(151,187,205,1)",
					pointColor : "green",
					pointstrokeColor : "yellow",
					data : p25Radios,
					title : "P25 Radios"
				} ]
			}

			var startWithDataset = 1;
			var startWithData = 1;

			var entitySummaryStackedBarOpt = {
				scaleFontColor : "#000000",
				animationStartWithDataset : startWithDataset,
				animationStartWithData : startWithData,
				animationSteps : 80,
				graphTitle : "Entity Radio Usage",
				graphTitleFontSize : 30,
				legend : true,
				legendBlockSize : 30,
				inGraphDataShow : true,
				inGraphDataXPosition : 2,
				inGraphDataYPosition : 3,
				inGraphDataFontColor : "#000000",
				inGraphDataFontSize : 12,
				annotateDisplay : true,
				responsive : true
			}
			var ctx = document.getElementById("entitySummaryChart").getContext(
					"2d");
			var myBarChart = new Chart(ctx).Bar(
					entitySummaryStackedBarData, entitySummaryStackedBarOpt);
		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
}