<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title> 메인 페이지</title>

<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<%@ include file="/include/jquery.jsp" %>   
<%@ include file="/include/commonCss.jsp" %> 


<script>
	$(function(){
		//게시판 tr태그 click 이벤트 처리
		$("#boardList tr").click(function(){
			//this : tr
			var board_num = $(this).find("td:eq(0)").text();
			$("#getBoard_num").val(board_num);
			$("#getBoardFrm").submit();
		});
		//게시판 등록버튼 click 이벤트 처리
		$("#boardBtn").click(function(){
			$("#insertFrm").submit();
		});
	})
</script>

</head>
<body>
	
	<%@include file="/layout/header.jsp" %>

  	  <div class="container-fluid">
          <h2 class="sub-header">시작화면 입니다.</h2>
          
	</div>

</body>
</html>
