<%@page import="board.service.BoardService"%>
<%@page import="board.service.BoardServiceInf"%>
<%@page import="board.model.BoardVO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%@ include file="/include/jquery.jsp" %>   
<%@ include file="/include/commonCss.jsp" %> 

<script>
	$(function(){
		//게시판 a태그 click 이벤트 처리
		$("#board_num_li a").click(function(){
			//this : a
			var board_num = $(this).attr("board_num");
			$("#board_num").val(board_num);
			$("#getArticlePageListFrm").submit();
		});
		
	})
</script>

<title>Insert title here</title>
</head>
<body>
	<form id="getArticlePageListFrm" method="get" action="${pageContext.request.contextPath }/getArticlePageList">
		<input type="hidden" id="board_num" name="board_num">
	</form>
	<nav class="navbar navbar-inverse top-fixed">
	  <div class="container-fluid">
	    <div class="navbar-header">
	    	<span class="navbar-brand" href="#"><%=session.getAttribute("mem_id") %>님 환영합니다.</span>>
	      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
	        <span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>                        
	      </button>
	    </div>
	    <div class="collapse navbar-collapse" id="myNavbar">
	      <ul class="nav navbar-nav">
	        <li class="active"><a href="main.jsp">Home</a></li>
	        <li class="dropdown">
	          <a class="dropdown-toggle" data-toggle="dropdown" href="#">게시판<span class="caret"></span></a>
	          <ul id="board_num_li" class="dropdown-menu">
	            <c:forEach items="${boardList }" var="BoardVO" >
	            	<c:if test="${BoardVO.board_vital_yn=='n' }">
	            		<li><a board_num="${BoardVO.board_num }" href="#">${BoardVO.board_name }</a></li>
	            	</c:if>
	            </c:forEach>
	          </ul>
	        </li>
	        <li>
	          <a href="${pageContext.request.contextPath}/manageBoard">게시판 관리</a>
	        </li>
	      </ul>
	      <ul class="nav navbar-nav navbar-right">
	        <li><a id="logOut" href="logoutServlet"><span class="glyphicon glyphicon-log-in"></span> LogOut</a></li>
	      </ul>
	    </div>
	  </div>
	</nav>

</body>
</html>