<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<html>  
<body>  

<form>  
	<c:forEach var="imgName" items="${nameList}">
 	<img alt="" src="${imgName}" width="20%" height="20%">
 	</c:forEach>
</form>  
</body>  
</html> 