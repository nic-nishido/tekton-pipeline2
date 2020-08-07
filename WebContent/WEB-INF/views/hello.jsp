<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${appName}</title>
</head>
<body style="background-color: pink;">
  <h1>${appName}</h1>
  <div>
    <p>現在時刻：${now}</p>
  </div>
  <form action="regist" method="GET">
  	<button type="submit">作成</button>
  </form>
  <table border="1">
  	<tr><th>No.</th><th>ID</th><th>名前</th></tr>
	<c:forEach var="obj" items="${sampleList}" varStatus="status">
	<tr>
　　	  <td><c:out value="${status.index}"/></td>
	　<td><c:out value="${obj.id}"/></td>
	　<td><c:out value="${obj.name}"/></td>
	</tr>
	</c:forEach>
  </table>
</body>
</html>
