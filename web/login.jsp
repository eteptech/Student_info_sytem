
<%@page import="com.eteptech.controller.AccountController"%>
<%@page  import="com.eteptech.essentials.HASH" %>
<%@page  import="com.eteptech.model.UserModel" %>

<%   
   UserModel u= new UserModel();
   u.setRequest(request); u.setResponse(response);
   AccountController.showLogin(u);
   String message="";
  if(request.getMethod().equals("POST")){
%>
    <%@include file="config.jsp"%>   
        <%
            users.setUname(request.getParameter("UNAME"));
            users.setPsswd(HASH.encrypt(request.getParameter("PASSWRD")));
            users.setRemember(request.getParameter("REMEMBER"));
            AccountController ac = new AccountController(c);
            ac.login(users);
            //users.setMessage(request.getParameter("REMEMBER"));
            out.print(users.getMessage());
            return;
    }else{
    %>
    <%@include file="config.jsp" %>
    <%
        if(request.getParameter("ID")!=null){
            if(request.getParameter("ID").equals("101")){
              message="You are not authorized to visit this page!";
        }else if(request.getParameter("ID").equals("111")){
            message=request.getParameter("user")+" Successfully logged out";
        }
    }
}
//out.println(config.getInitParameter("emmy"));
String fpassword=pageContext.getServletContext().getContextPath()+"/ChangePassword.jsp";
%>
<%@include file="inc/header.jsp" %>
<article id="registerArticle">
    <img  class="loginprogress"src="images/ajax-gif/ajax-loader (3).gif"/>
    <aside class="leftAsside">
        <img src="images/loginlogo.png"/>
    </aside>
    <aside class="rightAsside">   
        </span>
        <form  action="" method="POST">
        <table id="loginTable" cellspacing="5"  cellpadding="5">
            <tr>
                <td><h2>Student Login</h2></td>
            </tr>
            <tr>
                <td id="wid"></td>
                <td><span id="display">  <%=message %> </span</td>
            </tr>
            <tr>
                <td>Enter your username</td>
                <td><input type="text" id="txtusername" class="input" name="txtusername"/></td>
            </tr>
            <tr>
                <td>
                    Enter your Password
                </td>
                <td>
                    <input type="password" id="txtPassword"   name="txtPassword" class="input"/>
                </td>
            </tr>
            <tr>
                <td>
                    Remember me
                </td>
                <td>
                    <input type="checkbox" id="txtRemember" name="txtRemember"/>
                </td>
            </tr>
            <tr>
                <td>      
                </td>
                <td>
                    <input type="submit" id="loginbtn" class="loginbtn" value="Login"/>
                </td>
            </tr>
            <tr>
                <td>
                </td>
                <td><a Style="color: green"href="<%= fpassword %> " class="list-group-item-dark">Forgotten password?</a></td>
            </tr>
        </table>
    </form>
</aside>
</article>
<script type="text/javascript" src="js/accounts.js"/>
</script>
<%@include file="inc/footer.jsp" %>