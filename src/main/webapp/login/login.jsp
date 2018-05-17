<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Signin Template for Bootstrap</title>
<script>
	</script>

<!-- Bootstrap core CSS -->
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../bootstrap/css/signin.css" rel="stylesheet">

<%@ include file="/include/jquery.jsp"%>
<script>
    
	//event 핸들러 초기화
	function initEvent(){
		
		//signin btn 클릭 이벤트
		$("#signinbtn").on("click", function(){
			console.log("signinbtn");
			$("#frm").submit();
		})
	}
	
    //문서로딩
    	$(function(){
    		initEvent();
    	});
    </script>
</head>

<body>

	<div class="container">
		<!--       <form class="form-signin" action="/webtable/LoginServlet" method="post"> -->
		<form id="frm" class="form-signin" action="<%=request.getContextPath() %>/LoginServlet" method="post">
			<h2 class="form-signin-heading">Please sign in</h2>
			<label for="mem_id" class="sr-only">mem_id</label> 
			<input type="text" id="userId" name="mem_id" class="form-control" placeholder="아이디를 입력해주세요." required autofocus> 
			<label for="mem_pass" class="sr-only">Password</label> 
			<input type="password" id="mem_pass" name="mem_pass" class="form-control" placeholder="password" required>
			<button class="btn btn-lg btn-primary btn-block" id="signinbtn" type="button">Sign in</button>
		</form>

	</div>
	<!-- /container -->
</body>
</html>
