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
        height: 500px;
        float: right;
    }
        .left {
        width: 50%;
        float: left;
    }
        .right {
        width: 50%;
        float: right;
    }

    /* clear float를 사용하여 부모 요소의 높이를 설정합니다. */
    .clearfix::after {
        content: "";
        display: table;
        clear: both;
    }
</style>
	<div class="container px-4 px-lg-5 mt-2">
		<h3>찜 목록</h3>

		<div id="map" style="width: 50%; height: 500px;" class="left-div"></div>
		
		<div class=" right-dev">
		<div
			class="col gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
			<c:forEach items="${paging.content}" var="location">

				<!-- 관광지 정보 -->
				<div class="col mb-3">
					<div class="col card">
					
						<!-- 관광지 이미지 -->
						<img class="col card-img-left h-100 w-100 left" src="${location.firstimage }"
							onerror="this.onerror=null; this.src='/image/noImage.png'"
							 alt="..." />	
						
						<div class="col right">
						<!-- 관광지 상세 -->
						<div class="col card-body p-1">
							<div class="col text-center">
								<!-- 관광지명 -->
								<h5 class="fw-bolder">${location.title }</h5>
								<!-- 관광지 간단한 설명-->
								${location.addr1 }
							</div>
						</div>
							
						
						<!-- 상세 페이지로 이동 -->

							<div class="col text-center">
								<a class="btn btn-outline-dark mt-auto"
									href="/test2?contentId=${location.contentid}">상세보기</a>


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

		</div>
		</div>
		<div class="d-flex justify-content-center">
			<jsp:include page="../location/part_paging.jsp" />
		</div>

	</div>


</section>
<script type="text/javascript" src="/js/api_key.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>

var map = null;
const NAVER_MAP_API = config.naver_map_key;
$.getScript("https://oapi.map.naver.com/openapi/v3/maps.js?ncpClientId="+NAVER_MAP_API, function(){
	


var cityhall = new naver.maps.LatLng(37.3595704, 127.105399),
    map = new naver.maps.Map('map', {
        center: new naver.maps.LatLng(37.3595704, 127.105399),
        zoom: 15
    }),
    marker = new naver.maps.Marker({
        map: map,
        position: cityhall
    });

});
</script>
<%@ include file="../template/footer.jsp"%>

