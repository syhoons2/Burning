<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br>
		결과가 나왔지롱
		<br>#Master: </br>
		${master.getIsuKorAbbrv()} ${master.getPrevddClsprc()} ${master.getParval()}
		<br>#Price: </br> 
		${price.getOpnprc()} ${price.getHgprc()} ${price.getLwprc()}
		<br>#Trend: </br> 
		${trend.getCount()} ${trend.getValue()}
		
	
	</br>
</body>
</html>
