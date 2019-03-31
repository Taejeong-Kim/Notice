<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<style>
	table { margin: 0 auto }
	h2 {     
		width: 698px;
		margin: 0 auto;
		text-align: center;
		line-height: 100px;
	}
	.table .title {
		font-weight: bold;
	}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		$("#btn_save").click(function(){
			// 제목
			if(!$("#edt_title").val()){
				alert("제목을 입력해주세요.");
				$("#edt_title").focus();
				return false;
			}
			// 내용
			if(!$("#txt_contents").val()){
				alert("내용을 입력해주세요.");
				$("#txt_contents").focus();
				return false;
			}
			// 비밀번호
			if(!$("#edt_postPwd").val()){
				alert("비밀번호를 입력해주세요.");
				$("#edt_postPwd").focus();
				return false;
			}
			
			// 공지사항 수정인 경우
			if('${mode}' == "mdfy"){
				// 비밀번호 불일치
				if($("#edt_postPwd").val() != '${post.postPwd}'){
					alert("비밀번호가 일치하지 않습니다.");
					$("#edt_postPwd").focus();
					return false;
				}
				
				$("#f").attr("action","NoticeUpdate_Ok");
			}
			
			var res = confirm("저장하시겠습니까?");
			
			if(res){
				$("#f").submit();
			}
		});
		
		$("#btn_list").click(function(){
			location.href="NoticeList";
		});
	});
</script>
</head>
<body>
	<div>
		<h2>
			<c:choose>
			<c:when test="${mode == 'mdfy'}">
				<strong>공지사항 수정</strong>
			</c:when>
			<c:otherwise>
				<strong>공지사항 등록</strong>
			</c:otherwise>
			</c:choose>
		</h2>		
		<br>
		<form id="f" name="f" action="NoticeInsert" method="POST">
		<c:if test="${mode == 'mdfy' }">
			<input type="hidden" name="postNo" value="${post.postNo}">
		</c:if>
			<table class="table">
				<tr>
					<td class="title">제목</td>
					<td><input type="text" id="edt_title" name="title"
							style="width: 652px; height:22px;" value="${post.title}"/></td>
				</tr>
				<tr>
					<td class="title">내용</td>
					<td><textarea rows="10" cols="30" id="txt_contents" name="contents"
								style="width: 650px; height: 350px; resize:none;">${post.contents}</textarea></td>
				</tr>
				<tr>
					<td class="title">비밀번호</td>
					<td><input type="password" id="edt_postPwd" name="postPwd"
							style="width: 100px; height:22px;" maxlength="20"/></td>
				</tr>
				<tr style="text-align:right;">
					<td colspan="2">
					<input type="button" id="btn_save" value="저장"/> 
					<input type="button" id="btn_list" value="목록"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>