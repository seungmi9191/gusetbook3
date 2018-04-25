<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="/guestbook3/insert" method="post">
	<br>
	<table border=1 width=500>
		<tr>
			<td>이름</td><td><input type="text" name="name"></td>
			<td>비밀번호</td><td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td colspan=4><textarea name="content" cols=60 rows=5></textarea></td>
		</tr>
		<tr>
			<td colspan=4 align=right><input type="submit" value="확인 "></td>
		</tr>
	</table>
	</form>
	<br/>
	
	
	<!-- Http요청 파라미터로 보낼 때 사용 -->
	<%-- <c:forEach items="${list}" var="guestVo">
		<table width=510 border=1>
			<tr>
				<td>${guestVo.no}</td>
				<td>${guestVo.name}</td>
				<td>${guestVo.regDate}</td>
				<td><button type="button" onclick="location.href='./deleteform?no=${guestVo.no}'">삭제</button></td>
			</tr>
			<tr>
				<td colspan=4>${guestVo.content}</td>
			</tr>
		</table>
        <br/>
     </c:forEach> --%>
     
     <!-- URL에 쿼리스트링 대신 URL패스로 보낼 때 사용 -->
     <c:forEach items="${list}" var="guestVo">
		<table width=510 border=1>
			<tr>
				<td>${guestVo.no}</td>
				<td>${guestVo.name}</td>
				<td>${guestVo.regDate}</td>
				<td><button type="button" onclick="location.href='./deleteform/${guestVo.no}'">삭제</button></td>
			</tr>
			<tr>
				<td colspan=4>${guestVo.content}</td>
			</tr>
		</table>
        <br/>
     </c:forEach>
	
</body>
</html>