<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${appName}</title>
</head>
<body style="background-color: skyblue;">
  <h1>新規登録</h1>
	<form:form>
		ID: <input type="text" name="id"/><br>
		名前: <input type="text" name="name"/><br>
	    <input type="submit" value="保存"/>
	</form:form>
<br><br>
  <form action="./" method="GET">
  	<button type="submit">戻る</button>
  </form>
</body>
</html>