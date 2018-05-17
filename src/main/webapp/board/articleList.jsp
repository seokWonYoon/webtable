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

    <title>게시판 리스트 연습</title>



<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>

<%@ include file="/include/jquery.jsp" %>   
<%@ include file="/include/commonCss.jsp" %>
 

	<style type="text/css">
		.pagination{
			display: block;
			text-align: center;
		}
	
		.pagination > li > a {
			float : none;
			margin-left: -5px;
		}
	</style>
<script type="text/javascript">
	$(function() {
		//회원 tr 태그 클릭 이벤트 처리
		$('#articleList tr').click(function() {
			if($(this).find('a').attr('yn')=='n'){
				var article_num = $(this).find('td:eq(1)').text();
				$('#article_num').val(article_num);
				$('#articleViewFrm').submit();
			} else {
				alert("삭제된 글입니다");
			}

		});
		
		//글쓰기 클릭 이벤트
		$('#articleList_to_writeBtn').click(function() {
// 			var board_num = $('#articleList tr:eq(0)').find('td:eq(0)').text(); // 값 넘어오는 것 확인
			var board_num = $('h2').attr('board_num'); // 값 넘어오는 것 확인
			$('#board_num2').val(board_num);
			$('#articleList_to_write').submit();
		});
	});
</script>   	
</head>
<body>
	<%@include file="/layout/header.jsp" %>
	<form id="articleList_to_write" method="get" action="${pageContext.request.contextPath }/articleList_to_write">
		<input type="hidden" id="board_num2" name="board_num">
	</form>
	<form id="articleViewFrm" method="get" action="${pageContext.request.contextPath }/getArticle">
		<input type="hidden" id="article_num" name="article_num">
	</form>
	
  	  <div class="container-fluid">
          <h2 class="sub-header" board_num="${board_num }">게시판 리스트</h2>
          <div class="table-responsive">
            <table class="table table-striped table-hover">
				<thead>
					<tr>
						<td>게시판번호</td>
						<td>글번호</td>
						<td>제목</td>
						<td>작성자</td>
						<td>날짜</td>
					</tr>
				</thead>
				<tbody id = "articleList">
					<c:forEach items="${articleList}" var="articleVO">
					<tr>
						<td>${articleVO.board_num}</td>
						<td>${articleVO.article_num}</td>
						<td>
								
									<c:forEach begin="1" end="${articleVO.level}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:forEach>
<%-- 									<c:forEach begin="1" end="${articleVO.article_group_num !=null?articleVO.article_group_num:0}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:forEach> --%>
									<a class="yn" yn="${articleVO.article_delete_yn}">${articleVO.article_delete_yn=='n'?articleVO.article_title:'삭제된 글입니다.'}</a></td>
<%-- 									<a class="yn" yn="${articleVO.article_delete_yn}" href="getArticle?article_num=${articleVO.article_num }">${articleVO.article_delete_yn=='n'?articleVO.article_title:'삭제된 글입니다.'}</a></td> --%>
						<td>${articleVO.mem_id}</td>
						<td><fmt:formatDate value="${articleVO.article_datetime}" pattern="yyyy-MM-dd"/></td>
					</tr>
					</c:forEach>
					<tr>
					</tr>
				</tbody>
						<td colspan="5">
							<button id="articleList_to_writeBtn" type="button" class="btn btn-default">등록</button>
						</td>
			</table>
		</div>
			${pageNav }
	</div>
</body>
</html>