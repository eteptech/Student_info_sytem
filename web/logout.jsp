<%@include  file="config.jsp" %>
<%
   String USER="";
    if(session.getAttribute("AUTHSESSION")!=null&&session.getAttribute("authID")!=null){
        USER=session.getAttribute("AUTHSESSION").toString();
        session.removeAttribute("authID");
        session.removeAttribute("AUTHSESSION");
}
response.sendRedirect("login.jsp?ID=111&user="+USER);
%>