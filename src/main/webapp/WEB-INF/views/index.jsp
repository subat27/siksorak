<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file="template/title.jsp"%>
<link rel="stylesheet" href="/css/main_page_styles.css" />

<%@ include file="template/header.jsp"%>


<div class="bg-dark py-5">
	<div class="container px-4 px-lg-5 my-5">
		<div class="text-center text-white">
			<h1 class="display-4 fw-bolder">이미지 넣을 자리</h1>
			<p class="lead fw-normal text-white-50 mb-0">관광지 3~4장소</p>
		</div>
	</div>
</div>

<!-- Icons Grid-->
<section class="features-icons bg-light text-center">
	<div class="container">
		<div class="row">
			<!-- 이 div 태그를 누르면 먹거리 화면으로 연결 -->
			<div class="col-lg-4">
				<div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
					<div class="features-icons-icon d-flex">
						<i class="bi-window m-auto text-primary"></i>
					</div>
					<h3>음식</h3>
					<p class="lead mb-0">먹거리 화면으로 연결</p>
				</div>
			</div>
			<!-- 이 div 태그를 누르면 볼거리 화면으로 연결 -->
			<div class="col-lg-4">
				<div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
					<div class="features-icons-icon d-flex">
						<i class="bi-layers m-auto text-primary"></i>
					</div>
					<h3>명소</h3>
					<p class="lead mb-0">볼거리 화면으로 연결</p>
				</div>
			</div>
			<!-- 이 div 태그를 누르면 즐길거리 화면으로 연결 -->
			<div class="col-lg-4">
				<div class="features-icons-item mx-auto mb-0 mb-lg-3">
					<div class="features-icons-icon d-flex">
						<i class="bi-terminal m-auto text-primary"></i>
					</div>
					<h3>즐길거리</h3>
					<p class="lead mb-0">즐길거리 화면으로 연결</p>
				</div>
			</div>
		</div>
	</div>
</section>

<%@ include file="template/footer.jsp"%>
