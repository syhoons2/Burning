<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


</head>
<body>
	<br> Intro start - love stock</br>
	
	<form modelAttribute="inputdata" action="/testinput" method="post">
		이름 : <input type="text" name="name" value="표원일" /><br />
		생년월일 : <input type="text" name="birthday" value="910826" /><br />
		키워드 : <input type="text" name="keyword" value="핑크" /><br />
		기업코드: <input type="text" name="issue_code" value="005930" /><br />
		<input type="submit" value="확인" />
	</form>
 
</body>
</html>