<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
   
<%@ include file="../template/title.jsp"%>

<%@ include file="/WEB-INF/views/template/header.jsp" %>

<div class="container" style="width: 30%">

<h2>회원 가입</h2>

<form method="post">
  <div class="mb-3">
    <label for="userid" class="form-label">아이디</label>
    <input class="form-control" id="userid" name="userid" value="${member.userid}">
    <span id="checkUseridResult">아이디 중복 검사를 실행해 주세요.</span>
    <button class="btn btn-primary" id="checkUseridBtn" type="button">아이디 중복 검사</button>
  </div>
  
  <div class="mb-3">
    <label for="password" class="form-label">비밀번호</label>
    <input value="${member.password}" type="password" class="form-control" id="password" name="password">
  </div>
  
  <div class="mb-3">
    <label for="password2" class="form-label">비밀번호(확인)</label>
    <input value="${member.password2}" type="password" class="form-control" id="password2" name="password2">
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
  

  <button type="submit" class="btn btn-primary submit">회원가입</button>
 
</form>
</div>



<script type="text/javascript" src="/js/member.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		checkUserid();
		
 		$(".submit").click(function(){
			let result = validateMember();
			
			
			if(result){
				$("form").submit();
			}else{
				alert("필수 정보를 입력해주세요.");
			}
		});
	});
</script>

<%@ include file="/WEB-INF/views/template/footer.jsp" %>