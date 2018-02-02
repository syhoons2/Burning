<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<style type="text/css">
@import url(//fonts.googleapis.com/earlyaccess/jejugothic.css);

.jg{font-family: 'Jeju Gothic', sans-serif;}

p0{
font-style: italic;
font-family: Fantasy;
font-weight: bold;
font-size: 50px;
color: #fe4365;
}
p00{
font-style: italic;
font-family: Fantasy;
font-weight: bold;
font-size: 50px;
color: #fc9d9a;
}
p{
font-family: Fantasy;
font-weight : bold;
font-size : 25px;
line-height: 1.9;
}
p2{
font-family: Fantasy;
font-weight : bold;
font-size : 20px;
line-height: 1.4;
}
p3{
font-family: Fantasy;
font-size : 15px;
line-height: 1.0;
}
table, th, td {
	color: #535353;
  	font-family: Jeju;
    text-align: left;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="font-family:Sans-Serif; font-size:20px;">
		<p0>
		Love Stock (너와 나의 궁합은 몇 점?)
		</p0>
		<h1></h1>
		<h1></h1>
	<!-- 
	<form modelAttribute="inputdata" action="/testinput" method="post" class="jg">
		이름 : <input type="text" name="name" value="표원일" /><br />
		생년월일 : <input type="text" name="birthday" value="910826" /><br />
		키워드 : <input type="text" name="keyword" value="핑크" /><br />
		
		기업코드: <input type="text" name="issue_code" value="005930" /><br />
		<h1></h1>
		<input type="submit" value="확인" />
	</form>
	-->
	 
	
	<form modelAttribute="inputdata" action="/testinput" method="post" class="jg">
	<table width = 400px>
	
  			 <!-- 
  			<tr>
	    		<th><p2 class="jg"><br>손금보기 </br></p2></th>
			    <th></th>
			</tr>
			 -->
			 <tr><h1></h1>
			 </tr>
			<tr>
			 </tr>
			
			
			<tr>
				<p3 class="jg">
	    		<th class="jg">이름       : </th>
			    <th class="jg"><input type="text" name="name" value="표원일" /><br /></th>
			    </p3>
			</tr>
			<tr>
	    		<p3>
	    		<th class="jg">생년월일 : </th>
			    <th class="jg"><input type="text" name="birthday" value="910826" /><br /></th>
			    </p3>
			</tr>
			<tr>
	    		<p3>
	    		<th class="jg">키워드    : </th>
			    <th class="jg"><input type="text" name="keyword" value="핑크" /><br /></th>
			    </p3>
			</tr>
			<tr>
	    		<p3>
	    		<th class="jg">기업코드  : </th>
			    <th class="jg"><input type="text" name="issue_code" value="005930" /><br /></th>
			    </p3>
			</tr>
			
			
			<!-- 
			<tr>
	    		<th><p2 class="jg"><br>발금보기 </br></p2></th>
			    <th></th>
			</tr>
			<tr>
	    		<p3>
	    		<th class="jg">트랜드수치(${trend.getValue()}, ${trend.getCount()})</th>
			    <th class="jg">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${bonus_score0}</th>
			    </p3>
			</tr>
			 -->
			 
		
		</table>
		
		 
		<input type="submit" value="확인" />
	</form>
 
</body>
</html>