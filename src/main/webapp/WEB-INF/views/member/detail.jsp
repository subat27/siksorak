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
<h2>My</h2>

<div class="card text-center" style="width: 40rem;">
  <div class="card-body">
    <h3 class="card-text">${member.name}</h3>
  </div>
  <ul class="list-group list-group-flush">
    <li class="list-group-item">나이: ${member.age}</li>
    <li class="list-group-item">국적: ${member.nation}</li>
    <li class="list-group-item">종교: ${member.religion}</li>
  </ul>  
    <p class="list-group-item" style="color: gray;">가입일: ${member.createDate}</p>

  
  <div class="card-body">
    <a style="text-decoration: none;" href="/member/update/${member.userid}" class="card-link">회원 정보 수정</a>
    <a style="text-decoration: none;" href="/member/update/password/${member.userid}" class="card-link">비밀번호 변경</a>
    <a style="text-decoration: none;" href="#" class="card-link">탈퇴</a>
  </div>
</div>

</div>

<form method="post" id="deleteForm"></form>

<script src="/js/member.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
		deleteMember("${member.userid}");
	});
</script>

</body>
</html>