<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memForm.jsp</title>
</head>
<body>
	<form name="frm" action="model.htm" method="post">
		<p>
			<input type="text" name="name" placeholder="이름 입력" />
		</p>
		<p>
			<input type="text" name="age" placeholder="나이 입력" />
		</p>
		<p>
			<input type="submit" value="send" />
		</p>
	</form>
</body>
</html>