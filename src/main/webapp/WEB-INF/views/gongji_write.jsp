<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>글 쓰기</title>
</head>
<body>
	<H2>${writeGongji.title}(이)가 수정되었습니다.</H2>
	<table width=650>
	<tr>
		<td width=550></td>  <!-- 목록 버튼을 누르면 gongji_list.jsp로 이동 -->
		<td><input type=button value="목록" Onclick="window.location='./gongji'"></td>
	</tr>
	</table>
</body>
</html>