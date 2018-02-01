<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<body>
	<br>
		<p0>
		Love Stock (너와 나의 궁합은 몇 점?)
		</p0>
		<!--  
		<br>#Master: </br>
		${master.getIsuKorAbbrv()} ${master.getPrevddClsprc()} ${master.getParval()}
		<br>#Price: </br> 
		${price.getOpnprc()} ${price.getHgprc()} ${price.getLwprc()}
		<br>#Trend: </br> 
		${trend.getCount()} ${trend.getValue()}
		-->
		
		
		<table>
  			<tr>
	    		<th><img src=${imageSrcPath} height="350px" width="350px"/></th>
			    <th><p00> ${friendly_score}%</p00></th>
			</tr>
		</table>
		
		
		<br></br>	
		
		
		
		<table>
  			<tr>
	    		<th><p2 class="jg"><br>손금보기 </br></p2></th>
			    <th></th>
			</tr>
			<tr>
				<p3 class="jg">
	    		<th class="jg">사용자명(${inputdata.getName()}), 회사명(${master.getIsuKorAbbrv()})</th>
			    <th class="jg">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${score0}</th>
			    </p3>
			</tr>
			<tr>
	    		<p3>
	    		<th class="jg">액면가(${master.getParval()}), 고가(${price.getHgprc()}), 저가(${price.getLwprc()})</th>
			    <th class="jg">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${score1}</th>
			    </p3>
			</tr>
			<tr>
	    		<p3>
	    		<th class="jg">전일종가(${master.getPrevddClsprc()}), 시가(${price.getOpnprc()})</th>
			    <th class="jg">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${score2}</th>
			    </p3>
			</tr>
			
			
		
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
		</table>
		
	</br>
	
</body>
</html>
