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
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Dashboard Template for Bootstrap</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>

<script src="${pageContext.request.contextPath}/SE2/js/HuskyEZCreator.js"></script>
<script type="text/javascript">
var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.

$(document).ready(function() {
	// Editor Setting
	nhn.husky.EZCreator.createInIFrame({
		oAppRef : oEditors, // 전역변수 명과 동일해야 함.
		elPlaceHolder : "smarteditor", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
		sSkinURI : "${pageContext.request.contextPath}/SE2/SmartEditor2Skin.html", // Editor HTML
		fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
		htParams : {
			// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseToolbar : true,
			// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseVerticalResizer : true,
			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
			bUseModeChanger : true, 
		}
	});

	// 전송버튼 클릭이벤트
	$("#savebutton").click(function(){
		if(confirm("저장하시겠습니까?")) {
			// id가 smarteditor인 textarea에 에디터에서 대입
			oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);

			// 이부분에 에디터 validation 검증
			if(validation()) {
				$("#editerFrm").submit();
			}
		}
	})
});

// 필수값 Check
function validation(){
	var contents = $.trim(oEditors[0].getContents());
	if(contents === '<p>&nbsp;</p>' || contents === ''){ // 기본적으로 아무것도 입력하지 않아도 <p>&nbsp;</p> 값이 입력되어 있음. 
		alert("내용을 입력하세요.");
		oEditors.getById['smarteditor'].exec('FOCUS');
		return false;
	}

	return true;
}

</script>

</head>
  <body>
	<%@include file="/layout/header.jsp" %>


    <div class="container-fluid">
          <h2 class="sub-header">글쓰기</h2>
          <div class="table-responsive">
            <table class="table table-striped table-hover">
				<form action="${pageContext.request.contextPath }/articleModify" method="post" id="editerFrm" enctype="multipart/form-data">
					<input type="hidden" name="board_num" size = "50" value="${articleVO.board_num }">
					<input type="hidden" name="article_num" size = "50" value="${articleVO.article_num }">
					<input type="hidden" name="mem_id" size = "50" value="<%=session.getAttribute("mem_id") %>">
					
					<tr>
						<td> 제목 </td>
						<td> <input type="text" name="article_title" size = "50" value="${articleVO.article_title }"> </td>
					</tr>
					<tr>
						<td> 내용 </td>
						<td><textarea name="smarteditor" id="smarteditor" rows="10" cols="100" style="width:766px; height:412px;">${articleVO.article_content }</textarea></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="button" id="savebutton" value="수정" />&nbsp;&nbsp; 
							<a href="getArticlePageList?board_num=${articleVO.board_num}">목록보기</a>
						</td>
					</tr>
				</form>
					
			</table>
		</div>
	</div>
</body>
</html>