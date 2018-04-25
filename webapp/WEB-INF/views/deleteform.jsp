<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>삭제</title>
</head>
<body>
	<form method="post" action="/guestbook3/delete">


	<table>
		<tr>
			<td><input type="hidden" name="no" value=${no}></td>
			<td>비밀번호</td>
			<td><input type="password" name="password"></td>
			<td><input type="submit" value="확인"></td>
			
			<td><a href="/guestbook3/list">메인으로 돌아가기</a></td>
		</tr>
	</table>
	</form>
</body>
</html>