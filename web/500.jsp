<%@include file="inc/header.jsp"  %>
<%@page  isErrorPage="true" %>
<h1 style="background: #ff7124; color: #ff0306;  float: left contour; float: right">Server error</h1>
<%=exception.getMessage() %>
<%@include file="inc/footer.jsp"  %>
