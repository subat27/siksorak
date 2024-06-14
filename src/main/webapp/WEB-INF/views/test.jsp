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


<c:forEach items="${member}" var="location">
<p>${location.location.title}</p>
</c:forEach>
</body>
</html>