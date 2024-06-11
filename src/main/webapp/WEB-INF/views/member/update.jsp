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

<h2>회원 정보 수정</h2>

<form method="post">
  <div class="mb-3">
    <label for="userid" class="form-label">아이디</label>
    <input class="form-control" id="userid" name="userid" value="${member.userid}">
  </div>
  
  <div class="mb-3">
    <label for="password" class="form-label">비밀번호</label>
    <input type="password" class="form-control" id="password" name="password">
  </div>
  
  <div class="mb-3">
    <label for="password2" class="form-label">비밀번호(확인)</label>
    <input type="password" class="form-control" id="password2" name="password2">
  </div>
  
  
  <div class="mb-3">
    <label for="name" class="form-label">이름</label>
    <input value="${member.name}" class="form-control" id="name" name="name">
  </div>
  
  <div class="mb-3">
    <label for="birth" class="form-label">나이</label>
    <input value="${member.age}" class="form-control" id="age" name="age">
  </div>
  
  <div class="mb-3">
    <label for="nation" class="form-label">국가</label>
    <input value="${member.nation}" class="form-control" id="nation" name="nation">
  </div>
  
  <div class="mb-3">
    <label for="religion" class="form-label">종교</label>
    <input value="${member.religion}" class="form-control" id="religion" name="religion">
  </div>
  

  <button type="submit" class="btn btn-primary submit">회원 정보 수정</button>
</form>

</div>


<script type="text/javascript" src="/js/member.js"></script>
<script type="text/javascript">
	$(document).ready(function(){

	});
</script>

</body>
</html>