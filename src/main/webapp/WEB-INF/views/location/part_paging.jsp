<%@ page import="kr.co.clover.entity.Location"%>
<%@ page import="org.springframework.data.domain.Page"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
Page<Location> paging = (Page<Location>) request.getAttribute("paging");

int perLine = 5;
int number = paging.getNumber();
int totalPages = paging.getTotalPages();

int beginPageNum = (number / perLine) * perLine + 1;
int endPageNum = beginPageNum + perLine - 1;

if (endPageNum > totalPages) {
	endPageNum = totalPages;
}

pageContext.setAttribute("beginPageNum", beginPageNum);
pageContext.setAttribute("endPageNum", endPageNum);

pageContext.setAttribute("prevPage", 1);
pageContext.setAttribute("nextPage", endPageNum);

if (number > 1 && number < totalPages - 1) {
	pageContext.setAttribute("prevPage", number);
	pageContext.setAttribute("nextPage", number + 2);
}
%>



<c:if test="${paging.hasPrevious() }">
	<a href="/list?page=${paging.number }"></a>
</c:if>

<div>
	<button class="moveBtn btn btn-light" data-dest="${prevPage }">이전</button>
	<c:forEach begin="${beginPageNum}" end="${endPageNum}" var="page">
		<c:choose>
			<c:when test="${paging.getNumber()+1 == page}">
				<a class="btn btn-primary" href="/list?page=${page}">${page}</a>
			</c:when>
			<c:otherwise>
				<a class="btn btn-secondary" href="/list?page=${page}">${page}</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<button class="moveBtn btn btn-light" data-dest="${nextPage }">다음</button>
</div>

