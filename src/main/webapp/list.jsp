<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>게시판 리스트 연습</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath }/bootstrap/css/dashboard.css" rel="stylesheet">
	<style type="text/css">
		.pagination{
			display: block;
			text-align: center;
		}
	
		.pagination > li > a {
			float : none;
			margin-left: -5px;
		}
	<%@ include file="/include/jquery.jsp"%>
	<%@ include file="/include/commonCss.jsp"%>
	</style>
</head>
<body>
	<%@include file="/layout/header.jsp" %>

<form id="frm" method="get" action="${pageContext.request.contextPath }/getUser">
	<input type="hidden" name="mem_id" id="mem_id">
</form>

    <div class="container-fluid">
          <h2 class="sub-header">사용자 리스트</h2>
          <div class="table-responsive">
            <table class="table table-striped table-hover">
				<tr>
					<td>번호</td>
					<td>이름</td>
					<td>제목</td>
					<td>날짜</td>
					<td>히트</td>
				</tr>
				<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.bId}</td>
					<td>${dto.bName}</td>
					<td>
						<c:forEach begin="1" end="${dto.bIndent}">-</c:forEach>
						<a href="content_view.do?bId=${dto.bId}">${dto.bTitle}</a></td>
					<td>${dto.bDate}</td>
					<td>${dto.bHit}</td>
				</tr>
				</c:forEach>
				<tr>
					<td colspan="5"> <a href="write_view.do">글작성</a> </td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>