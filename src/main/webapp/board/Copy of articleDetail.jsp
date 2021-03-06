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

    <title>테이블 내용보기 연습</title>

<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>

<%@ include file="/include/jquery.jsp"%>
<%@ include file="/include/commonCss.jsp"%>

<script type="text/javascript">
$(function() {
	// 게시글 삭제 이벤트 -post
	$('#deleteArticle').click(function() {
		//method : post - 서버상 변경이 있을 때
		//action : /deleteUser
		$('#detailfrm').attr('action', '${pageContext.request.contextPath }/deleteArticle');
		$('#detailfrm').submit();
	})
	// 수정 - get
	$('#articleModify').click(function() {
		
		//action : /modifyUser
		$('#detailfrm').attr('method', 'get');
		$('#detailfrm').attr('action', '${pageContext.request.contextPath }/articleModify');
		$('#detailfrm').submit();
	})
	
	
	// 수정 - get
	$('#articleReply').click(function() {
		
		//action : /modifyUser
		$('#detailfrm').attr('method', 'get');
		$('#detailfrm').attr('action', '${pageContext.request.contextPath }/articleReply');
		$('#detailfrm').submit();
	})
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////글 관련 버튼 ^
	
	 $("#writeReplyBtn").click( function(){
            var form = $("#writeReplyForm");
            
            form.attr("method", "POST");
            form.attr("action", "<c:url value="/doWriteReply" />");
 
            form.submit(); 
            
        });
        
        /*새로 생긴 엘리먼트에 접근하는 방법*/
        $("body").on("click", "#writeReplyBtn", function(){
            var form = $("#writeReplyForm");
            
            form.attr("method", "POST");
            form.attr("action", "<c:url value="/doWriteReply" />");
 
            form.submit(); 
 
        });
        
		$(".btn post-action__button").on("click", function() {
			 var form = $("#disqus_threadFrm");
			 form.attr("method", "POST");
            form.attr("action", "<c:url value="/commentWrite" />");
			form.submit(); 
		})
	
})

///////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	*  RECOMMENDED CONFIGURATION VARIABLES: EDIT AND UNCOMMENT THE SECTION BELOW TO INSERT DYNAMIC VALUES FROM YOUR PLATFORM OR CMS.
	*  LEARN WHY DEFINING THESE VARIABLES IS IMPORTANT: https://disqus.com/admin/universalcode/#configuration-variables*/
	
	
	var disqus_config = function () {
	this.page.url = PAGE_URL;  // Replace PAGE_URL with your page's canonical URL variable
// 	this.page.url = ${site.url }${ page.url };  // Replace PAGE_URL with your page's canonical URL variable
	this.page.identifier = PAGE_IDENTIFIER; // Replace PAGE_IDENTIFIER with your page's unique identifier variable
	};
	
	(function() { // DON'T EDIT BELOW THIS LINE
	var d = document, s = d.createElement('script');
	s.src = 'https://webboardtest.disqus.com/embed.js';
	s.setAttribute('data-timestamp', +new Date());
	(d.head || d.body).appendChild(s);
	})();
	</script>
	<noscript>Please enable JavaScript to view the <a href="https://disqus.com/?ref_noscript">comments powered by Disqus.</a></noscript>

</script>
</head>
  <body>
	<%@include file="/layout/header.jsp" %>

<%-- <form id="detailfrm" method="get" action="${pageContext.request.contextPath }/getUser"> --%>
<!-- 	<input type="hidden" name="mem_id" id="mem_id"> -->
<!-- </form> -->

    <div class="container-fluid">
    	<h2 class="sub-header">게시글 보기</h2>
       		<div class="responsive">
				<form id="detailfrm" class="form-horizontal" role="form" method="post">
					<input type="hidden" name="mem_id" value="${articleVO.mem_id }">
					<input type="hidden" name="article_num" value="${articleVO.article_num }">
					<input type="hidden" name="board_num" value="${articleVO.board_num }">
					<input type="hidden" name="article_title" value="${articleVO.article_title }">
					<input type="hidden" name="article_group_num" value="${articleVO.article_group_num }">
					
					<div class="form-group">
						<label for="mem_profile" class="col-sm-2 control-label">글번호</label>
						<div class="col-sm-4">
<%-- 							<img src="${pageContext.request.contextPath }/${userVO.mem_profile }" width="100px"> --%>
							<label class="control-label">${articleVO.article_num}</label>
						</div>
					</div>
					<div class="form-group">
						<label for="mem_profile" class="col-sm-2 control-label">그룹번호</label>
						<div class="col-sm-4">
<%-- 							<img src="${pageContext.request.contextPath }/${userVO.mem_profile }" width="100px"> --%>
							<label class="control-label">${articleVO.article_group_num }</label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">제목</label>
						<div class="col-sm-10">
							<label class="control-label">${articleVO.article_title}</label>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">작성자</label>
						<div class="col-sm-10">
							<label class="control-label">${articleVO.mem_id}</label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">일시</label>
						<div class="col-sm-10">
							<label class="control-label">${articleVO.article_datetime}</label>
						</div>
					</div>
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">내용</label>
						<div class="col-sm-10">
							<label class="control-label">${articleVO.article_content}</label>
						</div>
					</div>
					<c:forEach items="${attachFileList }" var="attachFileVO">
						<div class="form-group">
							<label for="pass" class="col-sm-2 control-label">첨부파일</label>
							<div class="col-sm-10">
								<label class="control-label">${attachFileVO.attach_file_real_name}</label>
								<a target="_blank" href="${pageContext.request.contextPath }/fileDownAbsolutePath?fileName=${attachFileVO.attach_file_name}">첨부파일 받기</a>
							</div>
						</div>
					</c:forEach>
					
				    
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button id="articleReply" type="button" class="btn btn-default">답변</button>
							<c:set var ="sessionId" value="${session.mem_id }" />
							    <c:if test="${sessionId == articleVO.mem_id }">    
									<button id="articleModify" type="button" class="btn btn-default">게시글 수정</button>
									<button id="deleteArticle" type="button" class="btn btn-default">게시글 삭제</button>
								</c:if>
						</div>
					</div>
				</form>
		</div>
		
    
    <!-- 
    	게시판 끝
    	
    	댓글 시작
     -->
     <form action="disqus_threadFrm"></form>
     	<div id="disqus_thread" class="form-group">
<!--      	<div class="responsive" id="disqus_thread"> -->
     		
     	</div>
	</div>
</body>
</html>