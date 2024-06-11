<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript" src="/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="/css/bootstrap.min.css">

</head>
<body>

<%@ include file="/WEB-INF/views/template/header.jsp" %>

<div class="container">
<h2>로그인</h2>

<form method="post">
	<div class="mb-3">
		아이디: <input class="form-control" name="userid"><br>
		비밀번호: <input class="form-control" type="password" name="password"> <br>
		<input type="submit" class="btn btn-primary submit" value="로그인">
	</div>
</form>
</div>

</body>
</html>