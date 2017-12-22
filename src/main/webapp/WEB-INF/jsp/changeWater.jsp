<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<html>  
<body>  

<form>  
	
 	
 	<c:forEach var="entry" items="${nameMap }">  
    	 ${ entry.key} : ${entry.value}  <br>  
	</c:forEach>
 	<span  style="font-weight:bold;font-size:100px; color:orange;" >↑ 就是你</span><br>
 <%-- 	<p  style="font-weight:bold;font-size:180px;" >${name} </p>
 	<p  style="font-weight:bold;font-size:100px; color:orange;" >哈哈哈哈哈哈哈哈哈 </p> --%>
 	
 	<button style="width:500px;height:200px;" onclick="/water/changeWater.htm"> 再来一次</button>
 	
</form>  
</body>  
</html> 