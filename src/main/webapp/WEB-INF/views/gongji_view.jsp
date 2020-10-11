<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
</head>
<boby>
	<table cellspacing=1 width=900 border=0 style="background-color:#FcFcFc;">
	<tr style="background-color:#F2F4F4;"> 
		<td style="text-align:center" width=150>번호</td>  
		<td>${oneView.id}</td>  <!-- 공지의 번호를 출력 -->
	</tr>
	<tr style="background-color:#F2F4F4;"> 
		<td style="text-align:center" width=150>제목</td>
		<td>${oneView.title}</td>  <!-- 공지의 제목을 출력 -->
	</tr>
	<tr style="background-color:#F2F4F4;"> 
		<td style="text-align:center" width=150>일자</td>
		<td><fmt:formatDate value="${oneView.date}" pattern="yyyy-MM-dd" /></td>   <!-- 공지의 날짜를 출력 -->
	</tr>
	<tr> 
		<td width=150 style="background-color:#F2F4F4; text-align:center">내용</td>
		<td style=overflow:scroll; height=300px>${oneView.content}</td><!-- 공지의 내용 출력 -->
	</tr>
	</table>
	<table width=900>
		<tr>
			<td width=730></td>  <!-- 목록 버튼을 누르면 gongji_list.jsp로 이동 -->
		<td><input type=submit value="목록" onclick="javascript:location.href='./gongji'"> 
		<input type=submit value="수정" onclick="javascript:location.href='./update?id=${oneView.id}'">
		<input type=submit value="삭제" onclick="javascript:location.href='./delete?id=${oneView.id}'"></td>
	</tr>  <!-- 수정 버튼을 누르면 해당 공지의 gongji_update.jsp로 이동 -->
	</table>
</body>
</html>