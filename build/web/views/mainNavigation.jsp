<%
   request.setAttribute("page", "exams.jsp");
%>
<%@page import="com.eteptech.essentials.ConfigFile"%>
<nav id="topMenu">
        <ul>
	    <a href="<%=pageContext.getServletContext().getContextPath()%>/home.jsp"> <li>Home</li></a>
            <a href="<%=pageContext.getServletContext().getContextPath()%>/profile.jsp"><li>Profile</li></a>
            <a href="<%=pageContext.getServletContext().getContextPath()%>/studentregistration.jsp"><li>Registration</li></a>
            <a href="<%=pageContext.getServletContext().getContextPath()%>/profileSettings.jsp"><li>profile settings</li></a>
	    <a href="<%=pageContext.getServletContext().getContextPath()%>/exams.jsp" ><li>Examination</li></a>
        </ul>    
</nav>
