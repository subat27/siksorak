<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!-- Footer-->
<footer class="footer bg-light">
	<div class="container">
		<div class="row">
			<div class="col-lg-6 h-100 text-center text-lg-start my-auto">
				<p class="text-muted small mb-4 mb-lg-0">&copy; Clover
					2023. All Rights Reserved.</p>
			</div>
			<div class="col-lg-6 h-100 text-center text-lg-end my-auto">
				<ul class="list-inline mb-0">
					<li class="list-inline-item me-4"><a href="#!"><i
							class="bi-facebook fs-3"></i></a></li>
					<li class="list-inline-item me-4"><a href="#!"><i
							class="bi-twitter fs-3"></i></a></li>
					<li class="list-inline-item"><a href="#!"><i
							class="bi-instagram fs-3"></i></a></li>
				</ul>
			</div>
		</div>
	</div>
</footer>


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!-- Bootstrap core JS-->
<script type="text/javascript" src="/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="/js/main_page_scripts.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".moveBtn").click(function() {
			let dest = $(this).attr("data-dest")
			location.href = "/list?page=" + dest;
		});
	});
</script>
</body>
</html>