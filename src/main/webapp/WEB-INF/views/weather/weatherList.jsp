<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file="../template/title.jsp"%>

<%@ include file="../template/header.jsp"%>


<!-- Section-->
<section class="py-5">
	<div class="container px-4 px-lg-5 mt-2">
			
		<div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
			<table>
			<tr>
				<th>날짜</th>
				<th>시간</th>
				<th>날씨</th>
				<th>온도</th>
				<th>강수확률</th>
			</tr>
			<c:forEach items="${categories.keySet()}" var="date">
				<tr>
					<c:choose>
						<c:when test="${date.substring(8, 12) eq '0600' and date.substring(0, 8) eq today}">
							<td>${date.substring(0, 8) }</td>
						</c:when>
						<c:when test="${date.substring(8, 12) eq '0000' and date.substring(0, 8) ne today}">
							<td>${date.substring(0, 8) }</td>
						</c:when>
						<c:otherwise>
							<td></td>
						</c:otherwise>
					</c:choose>
				 	<td>${date.substring(8, 12) }</td>
				 	<td>
					 	<c:choose>
						 	<c:when test="${categories.get(date).categories.get('PTY') eq 0}">
						 		<c:choose>
							 		<c:when test="${categories.get(date).categories.get('SKY') eq 1}">
									<i class="bi-brightness-high-fill" style="color: orange;"></i>
									</c:when>
									<c:when test="${categories.get(date).categories.get('SKY') eq 3}">
										<i class="bi-cloud-sun-fill"></i>
									</c:when>
									<c:otherwise>
										<i class="bi-cloud-fog-fill"></i>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:when test="${categories.get(date).categories.get('PTY') eq 1}">
								<i class="bi-cloud-rain-fill"></i>
							</c:when>						
							<c:when test="${categories.get(date).categories.get('PTY') eq 2}">
								<i class="bi-cloud-sleet-fill"></i>
							</c:when>
							<c:when test="${categories.get(date).categories.get('PTY') eq 3}">
								<i class="bi-cloud-snowfill"></i>
							</c:when>
							<c:otherwise>
								<i class="bi-cloud-rain-heavy-fill"></i>
							</c:otherwise>
					 	</c:choose>
				 	</td>
				 	<td>${categories.get(date).categories.get('TMP') } ℃</td>
				 	<td>${categories.get(date).categories.get('POP') } %</td>
				</tr>
			</c:forEach>
			</table>
		</div>
	</div>
	

</section>
<%@ include file="../template/footer.jsp"%>