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
<!-- Core theme JS-->
<script src="/js/main_page_scripts.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var sigunguCode = "${sigunguCode}";
		var contentType = "${contentType}";
		var keyword = "${keyword}";
		
		if (sigunguCode != "") {
			$("#sigunguCodeSelect").val("${sigunguCode}");
		}
		if (contentType != "") {
			$("#contentTypeSelect").val("${contentType}");
		}

		/* $(".moveBtn").click(function() {
			let dest = $(this).attr("data-dest")
			location.href = "/list?page=" + dest + "&keyword=${keyword }";
		}); */
		
		$(".pagenationBtn > button").click(function() {
			let dest = $(this).attr("data-dest")
			location.href = "/list?page=" + dest + "&sigunguCode=" + sigunguCode + "&keyword=" + keyword + "&contentType=" + contentType;
		});
		
		$(".keywordSearch").click(function() {
			keyword = $(".keywordValue").val();
			location.href = "/list?sigunguCode=" + sigunguCode + "&keyword=" + keyword + "&contentType=" + contentType;
		});
		
		$("div.col-lg-4").click(function() {
			var contentType = $(this).find('h3').html();
			location.href = "/list?sigunguCode=" + sigunguCode + "&keyword=" + keyword + "&contentType=" + contentType;			
		});

		$("#sigunguCodeSelect").change(function(){
			var sigunguCode = $("#sigunguCodeSelect").val();
			location.href = "/list?sigunguCode=" + sigunguCode + "&keyword=" + keyword + "&contentType=" + contentType;
		});

		$("#contentTypeSelect").change(function(){
			var contentType = $("#contentTypeSelect").val();
			location.href = "/list?sigunguCode=" + sigunguCode + "&keyword=" + keyword + "&contentType=" + contentType;
		});
	});
</script>

<script type="text/javascript">
	$(document).ready(function(){
		
		jjim();

	});
</script>
</body>
</html>