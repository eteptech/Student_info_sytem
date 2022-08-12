<%@page import="com.eteptech.model.UserModel"%>
<%@page import="com.eteptech.controller.AccountController"%>
<%@page import="com.eteptech.essentials.HASH"%>
<%@page import="com.google.gson.Gson"%>
<%@include  file="../config.jsp" %>
<%
/**
error codes
200 = response.
401 = bad request.
500 = server error.
404 = file not found or resource not found.
*/
%>
<% 
    AccountController ac = new AccountController(c);
    try{
    if(request.getMethod().equals("POST")){
        Gson json = new Gson();
        users=json.fromJson(request.getParameter("USERDETAILS"), UserModel.class);
        users.setPsswd(HASH.encrypt(users.getPsswd()));
        users.setCpsswd(HASH.encrypt(users.getCpsswd()));
        ac.saveUser(users, c);
        
        //out.println("dob is: "+users.getGender());
    }else if(request.getMethod().equals("GET")){
        if(request.getParameter("VALUE").equals("USERNAME")){
        users.setUname(request.getParameter("OPTION"));
        ac.checkUsernameEmail(users);
        //out.println(request.getParameter("VALUE"));
        }else if(request.getParameter("VALUE").equals("MAIL")){
            users.setEmail(request.getParameter("OPTION"));
            ac.checkEmail(users);
        }
    }
    }catch(Exception e){
        users.setMessage(e.getMessage());
    }
    out.println(users.getMessage());
%>
