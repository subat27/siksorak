<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>간단한 지도 표시하기</title>
    <script type="text/javascript" src="js/api_key.js"></script>
        
</head>
<body>
<div id="map" style="width:100%;height:400px;"></div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>


var map = null;
const NAVER_MAP_API = config.naver_map_key;
$.getScript("https://oapi.map.naver.com/openapi/v3/maps.js?ncpClientId="+NAVER_MAP_API, function(){
	var mapOptions = {
		    center: new naver.maps.LatLng(37.3595704, 127.105399),
		    zoom: 10
		};
	
	map = new naver.maps.Map('map', mapOptions);
	

	var marker = new naver.maps.Marker({
	    position: new naver.maps.LatLng(37.3595704, 127.105399),
	    map: map
	});
	
	});

</script>
</body>
</html>