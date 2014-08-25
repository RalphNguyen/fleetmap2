function doAjaxPost() {
	var name = $('#name').val();
	var gender = $('#gender').val();
	var email = $('#email').val();
	var phone = $('#phone').val();
	var city = $('#city').val();

	$.ajax({
		type : "Get",
		url : "hellotata.html",
		data : "name=" + name + "&gender=" + gender + "&email=" + email
				+ "&phone=" + phone + "&city=" + city,
		contentType : "application/json",
		dataType : "json",
		success : function(response) {
			// var a = JSON.parse(data);
			// $("#name1").val(a.name);
			var noOfActivatedRadio = response.datasets.data1;
			var noOfDeactivatedRadio = response.datasets.data2;
			var noOfUnassignedRadio = response.datasets.data3;
			// var data3 = [ item1, item2 ];

			var ctx = document.getElementById("canvas").getContext("2d");
			var data1 = [ 65, 59, 80, 81, 56, 55, 40 ];
			var data2 = [ 28, 48, 40, 19, 86, 27, 90 ];

			var data = {
				labels : [ "Zone 1 Analog", "Zone 1 Digital", "Zone 2 Analog",
						"Zone 2 Digital", "Zone 3 Analog", "Zone 3 Digital" ],
				datasets : [ {
					label : "Activated Radios",
					fillColor : "#2591d9",
					strokeColor : "rgba(220,220,220,0.8)",
					highlightFill : "rgba(220,220,220,0.75)",
					highlightStroke : "rgba(220,220,220,1)",
					data : noOfActivatedRadio
				}, {
					label : "Deactivated Radios",
					fillColor : "#d92543",
					strokeColor : "rgba(151,187,205,0.8)",
					highlightFill : "rgba(151,187,205,0.75)",
					highlightStroke : "rgba(151,187,205,1)",
					data : noOfDeactivatedRadio
				}, {
					label : "Unassigned Radios",
					fillColor : "#53cc2e",
					strokeColor : "rgba(151,187,205,0.8)",
					highlightFill : "rgba(151,187,205,0.75)",
					highlightStroke : "rgba(151,187,205,1)",
					data : noOfUnassignedRadio
				} ]
			};

			var myBarChart = new Chart(ctx).Bar(data, {
				responsive : true
			});

			// $("h1").html(item1);
			console.log(response);
			// var data1 = JSON.parse(response);
			// $("h1").html(data1);
		},
		error : function(e) {
			// var data1 = JSON.parse(e);
			alert('Error: ' + e);
		}
	});
}
