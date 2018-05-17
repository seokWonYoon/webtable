<%@page import="user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>게시판 관리</title>

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
	<%@ include file="/layout/header.jsp" %>
	<form id="getBoardFrm" method="get" action="${pageContext.request.contextPath }/getBoard">
		<input id="getBoard_num" type="hidden" id="board_num" name="board_num">
	</form>
	
	<form id="insertFrm" method="post" action="${pageContext.request.contextPath }/boardForm">
	</form>
	<div class="container-fluid">
				<h2 class="sub-header">게시판 리스트</h2>
					<div class="table-responsive">
						<table class="table table-striped table-hover">
							<thead>
								<tr>
									<th>게시판 번호</th>
									<th>게시판 이름</th>
									<th>만든사람ID</th>
									<th>만든 날짜</th>
									<th>삭제여부</th>
								</tr>
							</thead>
							<tbody id="boardList">
								<c:forEach items="${boardList }" var="boardVO">
									<tr>
										<td>${boardVO.board_num }</td>
										<td>${boardVO.board_name }</td>
										<td>${boardVO.mem_id }</td>
										<td><fmt:formatDate value="${boardVO.board_datetime}" pattern="yyyy-MM-dd"/></td>
										<td>${boardVO.board_vital_yn }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					
					<button id="boardBtn" type="button" class="btn btn-default">게시판 등록</button>
					
					<!-- pageNavigation -->
					<%-- ${pageNav } --%>
	</div>

</body>
</html>
