<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

</head>
<body>
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container px-4 px-lg-5">
			<a class="navbar-brand" href="/">서울시 관광정보</a>
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
							<li><a class="dropdown-item" href="#!">테마1</a></li>
							<li><a class="dropdown-item" href="#!">테마2</a></li>
							<li><a class="dropdown-item" href="#!">테마3</a></li>
						</ul></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">지역별</a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="#!">강동구</a></li>
							<li><a class="dropdown-item" href="#!">중랑구</a></li>
							<li><hr class="dropdown-divider" /></li>
							<li><a class="dropdown-item" href="#!">강서구</a></li>
							<li><a class="dropdown-item" href="#!">강남구</a></li>
						</ul></li>
					<li class="nav-item"><a class="nav-link" aria-current="page"
						href="#!">진행중인 축제/행사</a></li>
					<li class="nav-item"><a class="nav-link" aria-current="page"
						href="#!">날씨</a></li>
				</ul>
				<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
					<li class="nav-item">
					<c:choose>
						<c:when test="${empty login}">
							<a class="nav-link" aria-current="page"	href="/member/login">로그인</a>		
						</c:when>
		
						<c:otherwise>
							<a class="nav-link" aria-current="page"	href="/member/logout">로그아웃</a>
						</c:otherwise>
					</c:choose>
					</li>			
									
					<c:choose>
						<c:when test="${empty login}">
							<li class="nav-item"><a class="nav-link" aria-current="page"
							href="/member/insert">회원가입</a></li>						

						</c:when>
						<c:otherwise>
							<li class="nav-item"><a class="nav-link" aria-current="page"
							href="/member/detail/${login.userid}">My</a></li>						
						</c:otherwise>
					</c:choose>							

				</ul>
				<c:choose>
				<c:when test="${empty login}">
				</c:when>	
				<c:otherwise>	
				<form class="d-flex">
					<button class="btn btn-outline-dark" type="submit">
						<i class="bi-suit-heart-fill me-1"></i> 찜목록 <span
							class="badge bg-dark text-white ms-1 rounded-pill">0</span>
					</button>
				</form>
				</c:otherwise>
				</c:choose>
			</div>
		</div>
	</nav>
