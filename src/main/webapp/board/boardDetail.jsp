<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>게시판 상세화면</title>

<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<%@ include file="/include/jquery.jsp" %>    
<%@ include file="/include/commonCss.jsp" %> 
<script>
	$(function(){
		
		$('#setBoard_yn').click(function(){
			$('#frm').attr('action','${pageContext.request.contextPath}/setBoard_yn');
			$('#frm').attr('method','post');
			$('#frm').submit();
		})
	})

</script>

</head>

<body>

	<%@ include file="/layout/header.jsp" %>
	
	<div class="container-fluid">
		<form id="frm" class="form-horizontal" role="form" method="post">
			<input type="hidden" name="board_num" value="${boardVO.board_num }">
			<input type="hidden" name="board_vital_yn" value="${boardVO.board_vital_yn }">
			<div class="form-group">
				<label class="col-sm-2 control-label">게시판 번호</label>
				<div class="col-sm-10">
					<label class="control-label">${boardVO.board_num }</label>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">게시판 이름</label>
				<div class="col-sm-10">
					<label class="control-label">${boardVO.board_name }</label>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">만든사람ID</label>
				<div class="col-sm-10">
					<label class="control-label">${boardVO.mem_id }</label>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">만든날짜</label>
				<div class="col-sm-10">
					<label class="control-label">${boardVO.board_datetime }</label>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">삭제상태</label>
				<div class="col-sm-10">
					<label class="control-label">${boardVO.board_vital_yn }</label>
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="button" id="setBoard_yn" class="btn btn-default">사용여부 변경</button>
				</div>
			</div>
		</form>
	</div>

</body>
</html>
