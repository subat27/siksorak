<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file="../template/title.jsp"%>

<%@ include file="../template/header.jsp"%>

<!-- Section-->
<section class="py-5">
	<div class="container px-4 px-lg-5 mt-2">
		<h3>관광지 목록</h3>
		<div class="row g-3 mb-3">
			<select class="form-select me-2" style="width: 25%; display: inline;" id="sigunguCodeSelectEvent">
				<option value="" selected>지역명</option>
				<option value="강남구">강남구</option>
				<option value="강동구">강동구</option>
				<option value="강북구">강북구</option>
				<option value="강서구">강서구</option>
				<option value="관악구">관악구</option>
				<option value="광진구">광진구</option>
				<option value="구로구">구로구</option>
				<option value="금천구">금천구</option>
				<option value="노원구">노원구</option>
				<option value="도봉구">도봉구</option>
				<option value="동대문구">동대문구</option>
				<option value="동작구">동작구</option>
				<option value="마포구">마포구</option>
				<option value="서대문구">서대문구</option>
				<option value="서초구">서초구</option>
				<option value="성동구">성동구</option>
				<option value="성북구">성북구</option>
				<option value="송파구">송파구</option>
				<option value="양천구">양천구</option>
				<option value="영등포구">영등포구</option>
				<option value="용산구">용산구</option>
				<option value="은평구">은평구</option>
				<option value="종로구">종로구</option>
				<option value="중구">중구</option>
				<option value="중랑구">중랑구</option>
			</select>
			<select class="form-select me-2" style="width: 25%; display: inline;" id="startMonthSelectEvent">
				<option value="" selected>시작월</option>
				<option value="6">6월</option>
				<option value="7">7월</option>
				<option value="8">8월</option>
				<option value="9">9월</option>
				<option value="10">10월</option>
				<option value="11">11월</option>
				<option value="12">12월</option>
			</select>
		</div>

		<div
			class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
			<c:forEach items="${paging.content}" var="location">

				<!-- 관광지 정보 -->
				<div class="col mb-5">
					<div class="card h-100">
						<!-- 관광지 이미지 -->
						<img class="card-img-top" src="${location.firstimage }"
							onerror="this.onerror=null; this.src='/image/noImage.png'"
							width="100%" height="200px" alt="..." />
						<!-- 관광지 상세 -->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- 관광지명 -->
								<h5 class="fw-bolder">${location.title }</h5>
								<!-- 관광지 간단한 설명-->
								${location.addr1 }
							</div>
						</div>
						<!-- 상세 페이지로 이동 -->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto"
									href="/location/detail?contentId=${location.contentid}">상세보기</a>
								<button class="btn btn-outline-dark mt-auto addLikeListBtn"
								data-contentId="${location.contentid}"><i class="bi-suit-heart" style="color: red;"></i><span></span></button>	
								
							</div>
							
						</div>
					</div>
				</div>
			</c:forEach>

		</div>
		<div class="d-flex justify-content-center">
			<jsp:include page="part_paging.jsp" />
		</div>
	</div>

</section>

<%@ include file="../template/footer.jsp"%>

