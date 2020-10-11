<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<script>
function checking() {  /*제목이나 내용이 공백이나 null값이면 경고창이 나온다*/
	if (document.getElementById("title").value == "" || document.getElementById("title").value == null ||
		document.getElementById("content").value == "" || document.getElementById("content").value == null) {
		alert("빈 칸을 채워주십시오");
	} else {
		document.upd.action="./write"; /*제목이나 내용이 공백이나 null값이 아니면 gongji_write.jsp로 이동*/
		document.upd.submit();  /*upd 폼의 값을 넘긴다.*/
	}
}
</script>
</head>
<boby>
	<form method="post" name="upd">
	<table cellspacing=1 width=900 border=0 style="background-color:#FcFcFc;">
	<tr style="background-color:#F2F4F4;"> 
		<td style="text-align:center" width=150>번호</td> <!-- 폼의 값은 공지의 번호, 읽는것만 가능-->
		<td><input style="width:600px;" type="text" name="id" id="id" value="${updateGongji.id}" readonly></td>
	</tr>
	<tr style="background-color:#F2F4F4;"> 
		<td style="text-align:center" width=150>제목</td>  <!-- 폼의 값은 공지의 제목-->
		<td><input style="width:600px;" type="text" name="title" id="title" value="${updateGongji.title}"></td>
	</tr>
	<tr style="background-color:#F2F4F4;"> 
		<td style="text-align:center" width=150>일자</td>  
		<td><fmt:formatDate value="${updateGongji.date}" pattern="yyyy-MM-dd" /></td>  <!-- 공지의 날짜를 출력 -->
	</tr>
	<tr> 
		<td width=150 style="background-color:#F2F4F4; text-align:center">내용</td>	<!-- 폼의 값은 공지의 내용-->	
		<td height=300px><input style="overflow:scroll; width:600px; height:270px" type="text" name="content" id="content" value="${updateGongji.content}"></td>
	</tr>
	</table>	
	<table width=900>
		<tr>
			<td width=730></td> <!-- 취소 버튼을 누르면 gongji_list.jsp로 이동 -->
		<td><input type=button value="취소" Onclick="window.location='./gongji'"> 
		<!-- 쓰기 버튼을 누르면 checking 함수가 호출되어 공백과 null을 체크 , 없으면 gongji_write.jsp로 이동 -->
		<input type=button value="쓰기" Onclick="checking()"> 
		<input type=button value="삭제" Onclick="window.location='./delete?id=${updateGongji.id}'"></td>
	</tr>  <!-- 삭제 버튼을 누르면 해당 공지 번호의 gongji_delete.jsp로 이동 -->
	</table>
</body>
</html>