<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TJKim</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	$(document).ready(function(){
		$('#user_id').val("${saveId}");
		if($('#user_id').val()){
			$("input:checkbox[id='saveId']").prop("checked", true);
		}
		
		$("#btn_login").click(function(){
			$("#f").submit();
		});
		
		$("#user_pwd").keypress(function (e) {
			if (e.which == 13){		// 엔터
				$("#f").submit();
			}
		});
		
	});
	
</script>

<style>
	table { margin: 0 auto }
	h2 {     
		margin: 0 auto;
		text-align: center;
		line-height: 100px;
	}
	table .title {
		font-weight: bold;
		padding: 10px;
	}
	.form{
		margin:0 auto; 
		padding:10px;
	}
	.small_font{
		font-size: 11px;
	}
</style>
</head>
<body>
<div>
	<form id="f" action="login" method="POST">
		<div id="wrap" style="text-align:center;">
		<h2>Login</h2>
		
			<div class="form">
				<table>
					<tr>
						<td style="text-align:left;">
							<label class="title">아이디</label>
						</td>
						<td>
						<input type="text" name="user_id" id="user_id">
						</td>
					</tr>
					<tr>
						<td style="text-align:left;">
							<label class="title">비밀번호</label>
						</td>
						<td>
							<input type="password" name="user_pwd" id="user_pwd">
						</td>
					</tr>
				</table>
			</div>
			
			<input type="button" id="btn_login" value="로그인">
			
			<br>
			<br>
			<div class="form">
				<label class="small_font"><input type="checkbox" id="saveId" name="saveId">아이디 저장</label> 
			</div>
		</div>
	</form>
</div>
</body>
</html>