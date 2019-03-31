<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>공지사항</title>
        <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
        <link rel="stylesheet" href="../resources/css/noticeList.css">
        
        <script type="text/javascript">
        	$(document).ready(function (){
        		if(!"${isAdmin}"){
        			$("#div_writeBtn").css("visibility","hidden");
        		}
        		
        		$("#btn_write").click(function(){
        			location.href="NoticeWrite";
        		});
        		
        	});
        	
        	function fn_viewPost(postNo){
        		location.href="NoticeView?post_no="+postNo;
        	}
        	
        </script>
    </head>
    <body>
    	<jsp:include page="loginHead.jsp" flush="false">
    		<jsp:param name="" value=""/>
    	</jsp:include>
    	<div style="height:100px;">
    		<span style="line-height:100px; font-size:25px; font-weight:bold;">공지사항</span>
    	</div>
    	<div id="div_writeBtn" style="text-align:right;">
    		<input type="button" value="글쓰기" id="btn_write">
    	</div>
    	<br>
    	<div>
        <table>
            <thead>
                <tr>
                    <th>글 번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>작성일</th>
                    <th>수정일</th>
                    <th>조회수</th>
                </tr>
            </thead>
            <tbody>
            	<c:if test="${fn:length(noticeList) < 1}">
            		<tr>
            			<td colspan="6">등록된 공지사항이 없습니다.</td>
            		</tr>
            	</c:if>
            	<c:forEach var="item" items="${noticeList}">
	            	<tr>
	            		<td>${item.postNo}</td>
	            		<td class="left"><label class="lb_title" onclick="fn_viewPost(${item.postNo});">${item.title}</label></td>
	            		<td>${item.writerNm}</td>
	            		<td>${item.regDt}</td>
	            		<td>${item.finMdfyDt}</td>
	            		<td>${item.viewCount}</td>
	            	</tr>
            	</c:forEach>
            </tbody>
        </table>
        <ul>
        	<c:if test="${startPage > 1}">
	        	<li><a href="NoticeList?page=1">&lt;&lt;</a></li>
	            <li><a href="NoticeList?page=${startPage - 1}">&lt;</a></li>
            </c:if>
            <c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
            	<c:choose>
            		<c:when test="${currPage == i}">
            			<li><a style="font-weight:bold;"href="NoticeList?page=${i}">${i}</a></li>
            		</c:when>
            		<c:otherwise>
            			<li><a href="NoticeList?page=${i}">${i}</a></li>
            		</c:otherwise>
            	</c:choose>
            </c:forEach>
            <c:if test="${pageAllCnt > endPage}">
	            <li><a href="NoticeList?page=${endPage + 1}">&gt;</a></li>
	            <li><a href="NoticeList?page=${pageAllCnt}">&gt;&gt;</a></li>
            </c:if>
        </ul>
        </div>
    </body>
</html>