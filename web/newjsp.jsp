<%-- 
    Document   : newjsp
    Created on : Sep 14, 2021, 7:08:22 PM
    Author     : erastus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@page  errorPage="500.jsp" %>
 <sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:8080/test" user="root" password=""/>
<sql:query var="rs" dataSource="${db}"> select * from admin </sql:query>
<c:forEach items="${rs.rows}" var="u">
   <br/> <c:out value="${u.username}"> </c:out>  <c:out value="${u.password}"> </c:out>
</c:forEach > 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
        <h1>Hello World!</h1>
    </body>
</html>
