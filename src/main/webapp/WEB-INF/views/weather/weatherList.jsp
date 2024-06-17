<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file="../template/title.jsp"%>

<%@ include file="../template/header.jsp"%>


<!-- Section-->
<section class="py-5">
	<div class="container px-4 px-lg-5 mt-2">
		<table class="table table-bordered border-primary border-opacity-50">
			<tr>
				<th></th>
				<th></th>
				<c:forEach var="i" begin="0" end="23">
					<th style="align-content: center; text-align: center;"><pre>${i }시</pre></th>
				</c:forEach>
			</tr>
			<tr>
				<th style="align-content: center; text-align: center;"><pre>오늘</pre></th>
				<th style="align-content: center; text-align: center;"><pre>날씨</pre> <pre>기온</pre> <pre>강수확률</pre></th>
				<c:forEach var="i" begin="0" end="5">
					<td style="align-content: center;"></td>
				</c:forEach>
				<c:forEach items="${categories.keySet()}" var="date" begin="0"
					end="17">
					<td style="align-content: center;">
						<c:choose>
						 	<c:when
									test="${categories.get(date).categories.get('PTY') eq 0}">
						 		<c:choose>
							 		<c:when
											test="${categories.get(date).categories.get('SKY') eq 1}">
									<pre><i class="bi-brightness-high-fill" style="color: orange;"></i></pre>
									</c:when>
									<c:when
											test="${categories.get(date).categories.get('SKY') eq 3}">
										<pre><i class="bi-cloud-sun-fill"></i></pre>
									</c:when>
									<c:otherwise>
										<pre><i class="bi-cloud-fog-fill"></i></pre>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:when test="${categories.get(date).categories.get('PTY') eq 1}">
								<pre><i class="bi-cloud-rain-fill"></i></pre>
							</c:when>						
							<c:when test="${categories.get(date).categories.get('PTY') eq 2}">
								<pre><i class="bi-cloud-sleet-fill"></i></pre>
							</c:when>
							<c:when test="${categories.get(date).categories.get('PTY') eq 3}">
								<pre><i class="bi-cloud-snowfill"></i></pre>
							</c:when>
							<c:otherwise>
								<pre><i class="bi-cloud-rain-heavy-fill"></i></pre>
							</c:otherwise>
					 	</c:choose>
					 	<pre>${categories.get(date).categories.get('TMP')}℃</pre>
					 	<pre>${categories.get(date).categories.get('POP')}%</pre>
					</td>
				</c:forEach>
			</tr>

			<tr>
				<th style="align-content: center; text-align: center;"><pre>내일</pre></th>
				<th style="align-content: center; text-align: center;"><pre>날씨</pre> <pre>기온</pre> <pre>강수확률</pre></th>
				<c:forEach items="${categories.keySet()}" var="date" begin="18"
					end="41">
					<td style="align-content: center;">
						<c:choose>
						 	<c:when
									test="${categories.get(date).categories.get('PTY') eq 0}">
						 		<c:choose>
							 		<c:when
											test="${categories.get(date).categories.get('SKY') eq 1}">
									<pre><i class="bi-brightness-high-fill" style="color: orange;"></i></pre>
									</c:when>
									<c:when
											test="${categories.get(date).categories.get('SKY') eq 3}">
										<pre><i class="bi-cloud-sun-fill"></i></pre>
									</c:when>
									<c:otherwise>
										<pre><i class="bi-cloud-fog-fill"></i></pre>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:when test="${categories.get(date).categories.get('PTY') eq 1}">
								<pre><i class="bi-cloud-rain-fill"></i></pre>
							</c:when>						
							<c:when test="${categories.get(date).categories.get('PTY') eq 2}">
								<pre><i class="bi-cloud-sleet-fill"></i></pre>
							</c:when>
							<c:when test="${categories.get(date).categories.get('PTY') eq 3}">
								<pre><i class="bi-cloud-snowfill"></i></pre>
							</c:when>
							<c:otherwise>
								<pre><i class="bi-cloud-rain-heavy-fill"></i></pre>
							</c:otherwise>
					 	</c:choose>
					 	<pre>${categories.get(date).categories.get('TMP')}℃</pre>
					 	<pre>${categories.get(date).categories.get('POP')}%</pre>
					</td>
				</c:forEach>
			</tr>

			<tr>
				<th style="align-content: center; text-align: center;"><pre>모레</pre></th>
				<th style="align-content: center; text-align: center;"><pre>날씨</pre> <pre>기온</pre> <pre>강수확률</pre></th>
				<c:forEach items="${categories.keySet()}" var="date" begin="18"
					end="41">
					<td style="align-content: center;"><c:choose>
						 	<c:when
									test="${categories.get(date).categories.get('PTY') eq 0}">
						 		<c:choose>
							 		<c:when
											test="${categories.get(date).categories.get('SKY') eq 1}">
									<pre><i class="bi-brightness-high-fill" style="color: orange;"></i></pre>
									</c:when>
									<c:when
											test="${categories.get(date).categories.get('SKY') eq 3}">
										<pre><i class="bi-cloud-sun-fill"></i></pre>
									</c:when>
									<c:otherwise>
										<pre><i class="bi-cloud-fog-fill"></i></pre>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:when test="${categories.get(date).categories.get('PTY') eq 1}">
								<pre><i class="bi-cloud-rain-fill"></i></pre>
							</c:when>						
							<c:when test="${categories.get(date).categories.get('PTY') eq 2}">
								<pre><i class="bi-cloud-sleet-fill"></i></pre>
							</c:when>
							<c:when test="${categories.get(date).categories.get('PTY') eq 3}">
								<pre><i class="bi-cloud-snowfill"></i></pre>
							</c:when>
							<c:otherwise>
								<pre><i class="bi-cloud-rain-heavy-fill"></i></pre>
							</c:otherwise>
					 	</c:choose>
					 	<pre>${categories.get(date).categories.get('TMP')}℃</pre>
					 	<pre>${categories.get(date).categories.get('POP')}%</pre>
					</td>
				</c:forEach>
			</tr>

		</table>

	</div>


</section>
<%@ include file="../template/footer.jsp"%>