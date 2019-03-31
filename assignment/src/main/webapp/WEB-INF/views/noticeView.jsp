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
			var res = confirm("저장하시겠습니까?");
			
			if(res){
				$("#f").submit();
			}
		});
		
		$("#btn_list").click(function(){
			location.href="NoticeList";
		});
		
		$("#btn_update").click(function(){
			$("#f").attr("action","NoticeUpdate");
			$("#f").submit();
		});
		
		$("#btn_delete").click(function(){
			var res = confirm("삭제하시겠습니까?");
			
			if(res){
				$("#f").attr("action","NoticeDelete");
				$("#f").submit();
			}
		});
	});
</script>
</head>
<body>
	<div>
		<h2>
			<strong>공지사항 상세</strong>
		</h2>		
		<br>
		<form id="f" name="f" action="NoticeUpdate" method="POST">
			<input type="hidden" name="postNo" value="${post.postNo}">
			<table class="table">
				<tr align="right">
					<td colspan="2" style="font-size:10px;">등록일 : ${post.regDt}</td>
				</tr>
				<tr align="right">
					<td colspan="2" style="font-size:10px;">최종수정일 : ${post.finMdfyDt}</td>
				</tr>
				<tr>
					<td class="title">작성자</td>
					<td><input type="text" id="edt_writer" value="${post.writerNm}"
							style="width: 652px; height:22px;" readOnly/></td>
				</tr>
				<tr>
					<td class="title">제목</td>
					<td><input type="text" id="edt_title" name="title" value="${post.title}"
							style="width: 652px; height:22px;" readOnly/></td>
				</tr>
				<tr>
					<td class="title">내용</td>
					<td><textarea rows="10" cols="30" id="txt_contents" name="contents"
								style="width: 650px; height: 350px; resize:none;" readOnly>${post.contents}</textarea></td>
				</tr>
				<tr style="text-align:right;">
					<td colspan="2">
					<c:if test="${sessionScope.member.user_id == post.writer}">
						<input type="button" id="btn_update" value="수정"/>
						<input type="button" id="btn_delete" value="삭제"/>
					</c:if>
						<input type="button" id="btn_list" value="목록"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>