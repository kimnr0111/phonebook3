<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전화번호 리스트</h1>
	<p>입력한 정보 내역입니다.</p>
	${pageContext.request.contextPath }
	<c:forEach items="${pList }" var="vo" varStatus="status">
	<table border = "1">
		<colgroup>
			<col style="width: 120px;">
			<col style="width: 170px;">
		</colgroup>
		
		<tr>
			<td>이름(name)</td>
			<td>${vo.name }</td>
		</tr>
		<tr>
			<td>핸드폰(hp)</td>
			<td>${vo.hp }</td>
		</tr>
		<tr>
			<td>회사(company)</td>
			<td>${vo.company }</td>
		</tr>
		<tr>
			<td>
			<a href="/pb3/phone/updateForm?pid=${vo.personId }">수정</a>
			</td>
			<td><a href="/pb3/phone/delete?pid=${vo.personId }">삭제</a></td>
		</tr>
	</table>
	<br>
	</c:forEach>
	<br>
	<p>
		<a href="/pb3/phone/writeForm">추가번호 등록</a>
	</p>
	
	
</body>
</html>