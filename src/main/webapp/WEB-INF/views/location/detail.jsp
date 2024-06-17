<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file="../template/title.jsp"%>

<%@ include file="../template/header.jsp"%>

<!-- Section-->
<section class="py-5">
	<style>
    table {
        border-collapse: collapse;
        width: 60%;
        margin-left: auto; margin-right: auto;
        text-align: center;
    }

    th, td {
        padding: 8px;
        text-align: left;

    }
    th{

    }
    tr:hover {
        background-color: lavender;
    }
    th{
        border-right: 1px solid #ddd;
    }
	</style>
	<table style="width: 60%;">	
			<tr>
				<td style="border: none;"><img class="card-img-top" src="${details.get(0)['firstimage'] }" width="500" height="500" alt="..." /></td>

				<td style="width: 300;">
					<div id="map" style="width:500px;height:500px;"></div>	
				</td>
			</tr>
	</table>
	<table>
			<tr>
				<th colspan="2" style="text-align: center">공통정보</th>
			</tr>
			<tr>
				<th style="width:7%">장소명</th>
				<td>${details.get(0)["title"] }</td>
			</tr>
			<tr>
				<th>위치</th>
				<td>${details.get(0)["addr1"]} ${details.get(0)["addr2"] }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${details.get(0)["overview"] }</td>
			</tr>
<!--		<tr>
				<th>좌표</th>
				<td>${details.get(0)["mapx"] },${details.get(0)["mapy"] }</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>${details.get(0)["tel"] }</td>
			</tr>
			<tr>
				<th>홈페이지</th>
				<td>${details.get(0)["homepage"] }</td>
			</tr>
		<tr>
			<th>사진2</th>
			<td><img class="card-img-top" src="${details.get(0)['firstimage2'] }" width="100%" height="100%" alt="..." /></td>
		</tr> -->
			<tr>
				<th colspan="2" style="text-align: center">컨텐츠타입정보</th>
			</tr>
			<c:forEach items="${details2.get(0).keySet() }" var="info">
				<tr>
					<th style="width:7%">${info }</th>
					<td>${details2.get(0)[info] }</td>
				</tr>
			</c:forEach>
		
	</table>
	
	<div id="map" style="width:100%;height:400px;"></div>

</section>

<script type="text/javascript" src="/js/api_key.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>

var map = null;
const NAVER_MAP_API = config.naver_map_key;
$.getScript("https://oapi.map.naver.com/openapi/v3/maps.js?ncpClientId="+NAVER_MAP_API, function(){
	

var HOME_PATH = window.HOME_PATH || '.';

var cityhall = new naver.maps.LatLng(${details.get(0)["mapy"]}, ${details.get(0)["mapx"]}),
    map = new naver.maps.Map('map', {
        center: new naver.maps.LatLng(${details.get(0)["mapy"]}, ${details.get(0)["mapx"]}),
        zoom: 15
    }),
    marker = new naver.maps.Marker({
        map: map,
        position: cityhall
    });

var contentString = [
        '<div class="iw_inner">',
        '	<h3>${details.get(0)["title"]}</h3>',        
        '   <p>${details.get(0)["tel"]} </p>',
        '   <p>${details.get(0)["homepage"]} </p>',
        '</div>'
    ].join('');

var infowindow = new naver.maps.InfoWindow({
    content: contentString
});

naver.maps.Event.addListener(marker, "click", function(e) {
    if (infowindow.getMap()) {
        infowindow.close();
    } else {
        infowindow.open(map, marker);
    }
});

infowindow.open(map, marker);
});
</script>


<%@ include file="../template/footer.jsp"%>
