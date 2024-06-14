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
					2023. All Rights Reserved.</p>
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
		
		/* 찜목록 숫자 갱신 */
		if (login != ""){
			var uri = '/likes/countLikes';
			$.getJSON(uri, function(data){
				$(".likes-count").html(data);
			});
		}
		
		/* 페이지 버튼 클릭 */
		$(".pagenationBtn > button").click(function() {
			let dest = $(this).attr("data-dest")
			location.href = "/location/list?page=" + dest + "&sigunguCode=" + sigunguCode + "&keyword=" + keyword + "&contentType=" + contentType;
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
	});
</script>

<script type="text/javascript">
	$(document).ready(function(){
		
		jjim();

	});
</script>
</body>
</html>