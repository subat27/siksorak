<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file="../template/title.jsp"%>

<%@ include file="../template/header.jsp"%>

<!-- Section-->
<section class="py-5">
	<style>
/* 좌측 div */
.left-div {
	width: 50%;
	float: left;
}

/* 우측 div */
.right-div {
	width: 50%;
	float: right;
}

.left {
	width: 30%;
	float: left;
}

.right {
	width: 70%;
	float: right;
}

/* clear float를 사용하여 부모 요소의 높이를 설정합니다. */
.clearfix::after {
	content: "";
	display: table;
	clear: both;
}
</style>
	<div class="container px-3 px-lg-3 mt-2">
		<h3>찜 목록</h3>

		<div id="map" style="width: 50%; height: 800px;" class="left-div"></div>

		<div class=" right-dev">
			<div class="row row-cols-1 justify-content-center">
				<c:forEach items="${paging.content}" var="location">

					<!-- 관광지 정보 -->
					<div class="mb-3">
						<div class="row row-cols-1 card">

							

							<div class="col card-body">
								<!-- 관광지 이미지 -->
								<img class="row row-cols-2 card-img-left h-100 w-40 left"
								src="${location.firstimage }"
								onerror="this.onerror=null; this.src='/image/noImage.png'"
								alt="..." style="width: 200px; height: 200px;" />
								<!-- 관광지 상세 -->
								<div class="p-2">
									<div class="text-center">
										<!-- 관광지명 -->
										<h5 class="fw-bolder">${location.title }</h5>
										<!-- 관광지 간단한 설명-->
										${location.addr1 }
									</div>
								</div>


								<!-- 상세 페이지로 이동 -->

								<div class="text-center p-2">
									<a class="btn btn-outline-dark mt-auto"
										href="/test2?contentId=${location.contentid}">상세보기</a>

									<input class="lat" type="hidden" value="${location.mapy}">
									<input class="lng" type="hidden" value="${location.mapx}">
									
									<c:choose>
										<c:when test="${empty login}">
											<button id="jjimBtn" type="button"
												class="btn btn-outline-dark mt-auto" name="jjimBtn">
												<i class="bi-suit-heart me-1"></i>
											</button>

										</c:when>
										<c:otherwise>

											<button id="jjimBtn" type="button"
												class="btn btn-outline-dark mt-auto jjimBtn" name="jjimBtn"
												value="${location.id}">
												<i class="bi-suit-heart me-1"></i>
											</button>

										</c:otherwise>
									</c:choose>

								</div>
							</div>




						</div>
					</div>

				</c:forEach>

				<div class="d-flex justify-content-center">
					<jsp:include page="../member_location/jjim_paging.jsp" />
				</div>

			</div>

		</div>

	</div>


</section>
<script type="text/javascript" src="/js/api_key.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	var map = null;
	const NAVER_MAP_API = config.naver_map_key;
	$.getScript("https://oapi.map.naver.com/openapi/v3/maps.js?ncpClientId="
			+ NAVER_MAP_API, function() {

		var map = new naver.maps.Map('map', {
			center : new naver.maps.LatLng(37.3595704, 127.105399),
			zoom : 10
		});

		var coordinates = [ {
			lat : 37.3633324,
			lng : 129.1054988
		}, {
			lat : 37.3632916,
			lng : 129.1085015
		}, {
			lat : 37.3632507,
			lng : 129.1115043
		}, {
			lat : 37.3632097,
			lng : 129.114507
		}, {
			lat : 37.3631687,
			lng : 129.1175097
		}, {
			lat : 37.3597282,
			lng : 129.105422
		}, {
			lat : 37.3596874,
			lng : 129.1084246
		}, {
			lat : 37.3596465,
			lng : 129.1114272
		}, {
			lat : 37.3596056,
			lng : 129.1144298
		}, {
			lat : 37.3595646,
			lng : 129.1174323
		} ];

		function createMarkers(map, coordinates) {
			var markerList = [];
			for (var i = 0; i < coordinates.length; i++) {
				var marker = new naver.maps.Marker({
					position : new naver.maps.LatLng(coordinates[i].lat,
							coordinates[i].lng),
					map : map
				});
				markerList.push(marker);
			}
			return markerList;
		}

		// 마커 생성 함수 호출
		var markers = createMarkers(map, coordinates);
	});
</script>
<%@ include file="../template/footer.jsp"%>

