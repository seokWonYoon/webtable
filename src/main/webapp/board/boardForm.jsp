<%@ page import="user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<%@ include file="/include/jquery.jsp" %>   
<%@ include file="/include/commonCss.jsp" %> 
<title>게시판 신규등록</title>

<script>
	$(function(){
		//boardBtn 게시판 신규 등록 버튼
		$("#boardBtn").click(function(){
			//validation
			if($("#board_name").val().trim() == ""){
				alert("게시판 이름을 입력하지 않았습니다.");
				$("#board_name").focus();
				return;
			}
			//submit
			$("#frm").submit();
		})
	});
</script>
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
</head>

<body>
<%@ include file="/layout/header.jsp" %>
	<div class="container-fluid">
		<form id="frm" action="${pageContext.request.contextPath }/insertBoard" method="post" class="form-horizontal" role="form">

			<div class="form-group">
				<label class="col-sm-2 control-label">아이디</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="mem_id" name="mem_id" value="${mem_id }" readonly>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">게시판 이름</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="board_name" name="board_name" placeholder="게시판 이름">
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button id="boardBtn" type="button" class="btn btn-default">게시판 등록</button>
				</div>
			</div>
		</form>
	</div>
	
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
