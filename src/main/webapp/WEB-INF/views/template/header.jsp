
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<style>
#google_translate_element>div>div {
	position: relative;
	min-width: 200px;
	height: 10px;
}

#google_translate_element>div>div>select::-ms-expand {
	display: none;
}

#google_translate_element>div>div:after {
	content: '>'; /* 목록 펼침 아이콘 */
	font: 20px "Consolas", monospace;
	color: #333;
	transform: rotate(90deg);
	right: 11px;
	top: 8px;
	padding: 0 0 2px;
	border-bottom: 1px solid #999;
	position: absolute;
	pointer-events: none;
}

#google_translate_element>div>div>select {
	-webkit-appearance: none;
	-moz-appearance: none;
	appearance: none;
	display: block;
	width: 100%;
	max-width: 320px;
	height: 30px;
	float: right;
	margin: 5px 0px;
	padding: 0px 24px;
	font-size: 16px;
	line-height: 1.75;
	color: #333;
	border: 1px solid #cccccc;
	-ms-word-break: normal;
	word-break: normal;
	border-radius: 10px;
}
</style>

</head>
<body>
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container px-4 px-lg-5">

			<a class="navbar-brand" href="/"
				style="font-family: 'Freesentation-6SemiBold'; font-weight: 100;">식소락
			</a>
			<!-- 웹페이지 사이즈가 작아 졌을 때 햄버거 버튼으로 변환 -->
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">테마별</a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item"
								href="/location/list?contentType=음식&sigunguCode=&keyword=">음식</a></li>
							<li><a class="dropdown-item"
								href="/location/list?contentType=명소&sigunguCode=&keyword=">명소</a></li>
							<li><a class="dropdown-item"
								href="/location/list?contentType=오락&sigunguCode=&keyword=">오락</a></li>
							<li><a class="dropdown-item" href="/event/list">진행중인 축제/행사</a></li>
						</ul></li>


					<li class="nav-item"><a class="nav-link" aria-current="page"
						href="weather/allData">날씨</a></li>

				</ul>

				<c:choose>
					<c:when test="${empty login}">
						<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
							<li><a class="dropdown-item" href="/member/login">로그인</a></li>
						</ul>
						<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
							<li><a class="dropdown-item" href="/member/insert">회원가입</a></li>
						</ul>
					</c:when>
					<c:otherwise>
						<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
							<li><a class="dropdown-item" aria-current="page"
								href="/member/logout">로그아웃</a></li>
						</ul>
						<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
							<li><a class="dropdown-item" aria-current="page"
								href="/member/detail/${login.userid}">My</a></li>
						</ul>
					</c:otherwise>
				</c:choose>


				

				<div class="ms-3 d-flex">
					<i id="weather_condition"></i> <label class="ms-1" id="weather_tmp"></label>
				</div>


				<!-- 구글 번역 API -->
				<div class="ms-5 me-5" id="google_translate_element"></div>

				<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
					<li><button class="btn btn-outline-dark likes-list-btn"
							type="button">
							<i class="bi-suit-heart-fill me-1"></i> 찜목록 <span
								class="badge bg-dark text-white ms-1 rounded-pill likes-count">0</span>
						</button></li>
				</ul>

			</div>


			<!-- <ul style="list-style:none;"><li id="google_translate_element"></li></ul> -->
			<script
				src="https://translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
			<script type="text/javascript">
				function googleTranslateElementInit() {
					new google.translate.TranslateElement({
						pageLanguage : 'ko',
						autoDisplay : false
					}, 'google_translate_element');
				}

				// 페이지 로드 시에 초기화
				window.onload = function() {
					initTranslationTool(); // 페이지 로드 시 초기화
					initializePageChangeDetection(); // 페이지 이동 감지 초기화
				};

				// 페이지 이동 시에도 번역 도구를 유지하는 함수
				function initTranslationTool() {
					if (typeof google !== 'undefined'
							&& typeof google.translate !== 'undefined') {
						googleTranslateElementInit();
					} else {
						setTimeout(initTranslationTool, 500); // 500ms마다 확인
					}
				}

				// 페이지 이동 감지 초기화
				function initializePageChangeDetection() {
					// 페이지 이동 시 History API를 사용하여 페이지 변경 감지
					window.onpopstate = function(event) {
						initTranslationTool(); // 페이지 변경 시 번역 도구 다시 초기화
					};
				}

				// 페이지 이동 시에도 History API를 사용하여 이동 이력을 관리하여 브라우저 히스토리에 기록
				function navigateTo(url) {
					window.history.pushState(null, null, url);
					initTranslationTool(); // 페이지 이동 시 번역 도구 다시 초기화
				}
			</script>
			<!-- 구글 번역 API 끝 -->

		</div>

	</nav>