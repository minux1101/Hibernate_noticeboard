<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
</head>
<boby>
	<table cellspacing=1 width=900 border=0 style="background-color:#FcFcFc;">
	<tr style="background-color:#c4c4c4;"> 
		<td width=100><p align=center>번호</p></td>
		<td width=650><p align=center>제목</p></td>
		<td width=150><p align=center>등록일</p></td>
	</tr>
	<c:choose>
		<c:when test="${empty gongjiList}">
			<tr>
				<td colspan=3>
					<spring:message code="common.gongjiListEmpty"/>
				</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${gongjiList}" var="gongji">
				<tr>
					<td width=50><p align=center>${gongji.id}</p></td>
					<td width=500><p align=center><a href="./view?id=${gongji.id}">${gongji.title}</a></p></td>
					<td width=100><p align=center><fmt:formatDate value="${gongji.date}" pattern="yyyy-MM-dd" /></p></td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	</table>
	<table width=900>
		<tr>
			<td width=850></td>
		<td><input type=button value="신규" Onclick="window.location='./insert'"></td>
	</tr>
	</table>
</boby>
</html>