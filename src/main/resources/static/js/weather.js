function setWeatherCondition() {
	
	let uri = "/weather/nowData";
	
	$.getJSON(uri, function(data){
		if (data.PTY == 0) {
			if(data.SKY == 1){
				$("#weather_condition").attr("class", "bi-brightness-high-fill").attr("style", "color: orange;");				
			} else if (data.SKY == 3){
				$("#weather_condition").attr("class", "bi-cloud-sun-fill");
			} else {
				$("#weather_condition").attr("class",  "bi-cloud-fog-fill");
			}
		} else if (data.PTY == 1) {
			$("#weather_condition").attr("class") = "bi-cloud-rain-fill";
		} else if (data.PTY == 2){
			$("#weather_condition").attr("class") = "bi-cloud-sleet-fill";
		} else if (data.PTY == 3){
			$("#weather_condition").attr("class") = "bi-cloud-snow-fill";
		} else {
			$("#weather_condition").attr("class") = "bi-cloud-rain-heavy-fill";
		}

		$("#weather_tmp").html(data.TMP + "℃");
	});
	
	
}