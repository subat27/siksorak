<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file="../template/title.jsp"%>

<%@ include file="../template/header.jsp"%>

<!-- Section-->
<section class="py-5">
	<table>
		<tr>
			<th>장소명</th>
			<td>${details.get(0)["title"] }</td>
		</tr>
		<tr>
			<th>위치</th>
			<td>${details.get(0)["addr1"]} ${details.get(0)["addr2"] }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${details.get(0)["overview"] }</td>
		</tr>
		<tr>
			<th>좌표</th>
			<td>${details.get(0)["mapx"] },${details.get(0)["mapy"] }</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>${details.get(0)["tel"] }</td>
		</tr>
		<tr>
			<th>홈페이지</th>
			<td>${details.get(0)["homepage"] }</td>
		</tr>
		<tr>
			<th>사진1</th>
			<td><img class="card-img-top" src="${details.get(0)['firstimage'] }" width="100%" height="100%" alt="..." /></td>
		</tr>
		<tr>
			<th>사진2</th>
			<td><img class="card-img-top" src="${details.get(0)['firstimage2'] }" width="100%" height="100%" alt="..." /></td>
		</tr>
	</table>

</section>

<%@ include file="../template/footer.jsp"%>
