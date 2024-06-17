<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    

<%@ include file="../template/title.jsp"%>

<%@ include file="/WEB-INF/views/template/header.jsp" %>

<div class="container" style="width: 30%">
<h2>로그인</h2>

<form method="post">
	<div class="mb-3">
		아이디: <input class="form-control" name="userid"><br>
		비밀번호: <input class="form-control" type="password" name="password"> <br>
		<input type="submit" class="btn btn-primary submit" value="로그인">
	</div>
</form>
</div>

<%@ include file="/WEB-INF/views/template/footer.jsp" %>