<%@page import="com.eteptech.controller.AccountController" %>
<%@include file="inc/header.jsp" %> 
<% 
    response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
    AccountController.protectedPage(true, users);
        
%>
    <h1>Profile setting</h1>
<%@include file="inc/footer.jsp"%>
