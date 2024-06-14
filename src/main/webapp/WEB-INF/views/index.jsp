<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file="template/title.jsp"%>
<link rel="stylesheet" href="/css/main_page_styles.css" />

<%@ include file="template/header.jsp"%>


<div class="bg-dark py-5" style="height: 600px;">
	<div class="container px-4 px-lg-5 my-5">
		<div class="text-center text-white">
			<h1 class="display-4 fw-bolder">추천 관광지 이미지</h1>
			<p class="lead fw-normal text-white-50 mb-0">관광지 3~4장소</p>
		</div>
	</div>
</div>

<!-- Icons Grid-->
<section class="features-icons bg-light text-center" style="padding: 50 



px 0;">
	<div class="container">
		<div class="row">
			<!-- 이 div 태그를 누르면 먹거리 화면으로 연결 -->
			<div class="col-lg-4">
				<div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
					<div class="features-icons-icon d-flex" style="margin-bottom: 20px !important;">
                     <img class="m-auto text-primary" src="/image/1.png"></img>
					</div>
					<h3>음식</h3>
				</div>
			</div>
			<!-- 이 div 태그를 누르면 볼거리 화면으로 연결 -->
			<div class="col-lg-4">
				<div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
					<div class="features-icons-icon d-flex" style="margin-bottom: 20px !important;">
                     <img class="m-auto text-primary" src="/image/2.png"></img>
					</div>
					<h3>명소</h3>
				</div>
			</div>
			<!-- 이 div 태그를 누르면 즐길거리 화면으로 연결 -->
		<div class="col-lg-4">
				<div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
					<div class="features-icons-icon d-flex" style="margin-bottom: 20px !important;">
                     <img class="m-auto text-primary" src="/image/3.png"></img>
                     </div>
					<h3>오락</h3>
				</div>
			</div>
		</div>
	</div>
</section>

<%@ include file="template/footer.jsp"%>
