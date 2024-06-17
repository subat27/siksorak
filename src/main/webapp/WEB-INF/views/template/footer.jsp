<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!-- Footer-->
<footer class="footer bg-light">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 h-100 text-center text-lg-end my-auto">
				<p class="text-muted small mb-4 mb-lg-0">&copy; Clover
					2024. All Rights Reserved.</p>
			</div>
		</div>
	</div>
</footer>


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!-- Bootstrap core JS-->
<script type="text/javascript" src="/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="/js/member.js"></script>
<script type="text/javascript" src="/js/weather.js"></script>
<!-- Core theme JS-->
<script src="/js/main_page_scripts.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	var sigunguCode = "${sigunguCode}";
	var contentType = "${contentType}";
	var keyword = "${keyword}";
	var login = "${login}";
	
	/* 찜목록 버튼 내부 숫자 갱신 */
	if (login != ""){
		$.getJSON('/likes/countLikes', function(data){
			console.log(data.result);
			$(".likes-count").html(data.result);
		});
	}
	
	/* $(".addLikeListBtn").each(function(){
		var contentId = $(this).attr("data-contentId");
		$.getJSON('/likes/getMembers/'+contentId, function(data){
			console.log("login:" + login.memberId);
			console.log(data.result);
		});
	}); */
		
	/* 페이지 버튼 클릭 */
	$(".pagenationBtn > button").click(function() {
		let dest = $(this).attr("data-dest")
		location.href = "/location/list?page=" + dest + "&sigunguCode=" + sigunguCode + "&keyword=" + keyword + "&contentType=" + contentType;
	});
	
	/* 찜목록 페이지 버튼 클릭 */
	$(".pagenationBtnLikes > button").click(function() {
		let dest = $(this).attr("data-dest")
		location.href = "/likes/list?page=" + dest;
	});
	
	/* 키워드 검색 */
	$(".keywordSearch").click(function() {
		keyword = $(".keywordValue").val();
		location.href = "/location/list?sigunguCode=" + sigunguCode + "&keyword=" + keyword + "&contentType=" + contentType;
	});
	
	/* 메인화면에서 테마 선택 */
	$("div.col-lg-4").click(function() {
		var contentType = $(this).find('h3').attr("data-contentName");
		location.href = "/location/list?sigunguCode=" + sigunguCode + "&keyword=" + keyword + "&contentType=" + contentType;
	});

	/* 지역 선택 유지 */
	if (sigunguCode != "") {
		$("#sigunguCodeSelect").val("${sigunguCode}");
	}
	
	/* 테마 선택 유지 */
	if (contentType != "") {
		$("#contentTypeSelect").val("${contentType}");
	}

	/* 지역 선택 */
	$("#sigunguCodeSelect").change(function(){
		var sigunguCode = $("#sigunguCodeSelect").val();
		location.href = "/location/list?sigunguCode=" + sigunguCode + "&keyword=" + keyword + "&contentType=" + contentType;
	});

	/* 테마 선택 */
	$("#contentTypeSelect").change(function(){
		var contentType = $("#contentTypeSelect").val();
		location.href = "/location/list?sigunguCode=" + sigunguCode + "&keyword=" + keyword + "&contentType=" + contentType;
	});
	
	/* 찜목록 버튼 클릭 */
	$(".likes-list-btn").click(function() {
		location.href = "/likes/list"
	});
	
	/* 현재 날씨 상태 출력 */
	setWeatherCondition();
	
	/* 찜 버튼 클릭 이벤트 추가 */
	$(".addLikeListBtn").click(function() {
		var contentId = $(this).attr("data-contentId");
		var iTag = $(this).find("i");
		var spanTag = $(this).find("span");

		fetchAndDisplayData(contentId, iTag, spanTag);
				
	});
	
	
	/* 찜 개수 추가 */
});
</script>
</body>
</html>