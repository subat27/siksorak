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
<h2>비밀번호 변경</h2>

<form method="post">
	기존 비밀번호: <input class="form-control" type="password" name="org_password"> <br>
	신규 비밀번호: <input  class="form-control"type="password" name="password"> <br>
	신규 비밀번호(확인): <input class="form-control" type="password" name="password2"> <br>
	
	<button class="btn btn-primary submit">비밀번호 변경</button>
</form>
</div>

</body>
</html>