<%@page import="com.eteptech.controller.AccountController"%>
<%@page import="com.eteptech.model.UserModel"%>
<%@page import="com.eteptech.essentials.ConfigFile"%>
<%@page import="com.eteptech.dao.dbContext"%>


<% 
    
    String appUrl=pageContext.getServletContext().getContextPath();
    ConfigFile c = new ConfigFile();
    //AccountController ac=new AccountController(c);
    c.setWebbsiteurl("http://localhost:8080/"+appUrl);
    c.setDefaulturl("home.jsp");
    c.setLoginurl("login.jsp");
    //DB settings
    c.setDbhost("jdbc:mysql://localhost:3306");
    c.setDbname("app");
    c.setDbuser("root");
    c.setDbpsswsd("emmydavii");
    UserModel users = new UserModel();
    users.setRequest(request); users.setResponse(response);
    dbContext.con(c);
    //out.println(dbContext.message);
%>
                                                                                                         
                                                                               