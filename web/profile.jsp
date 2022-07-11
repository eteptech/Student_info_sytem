<%@page import="com.eteptech.controller.FileController"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.io.FilenameUtils"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.FileItemFactory"%>
<%@include file="inc/header.jsp" %> 

<%
  String fileName="";
   try{
        ServletContext con=getServletContext();
        String username= AccountController.getLoggInUser(users); 
        File coverimage= new File(con.getRealPath("images/coverPics/"+username+".jpg"));
        if(coverimage.exists()){
        
            out.println("exist");
            fileName="images/coverPics/"+username+".jpg";
        }else{
        out.println("File does not exist how?");
    }
   }catch(Exception e){
       //out.println("does not exist");
       fileName="images/coverPics/admin.jpg";
   }
   
%>
<%  
    response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Expires", "0");
    AccountController.protectedPage(true, users);      
%>

<img src="<%=fileName%>" alt=""  width="100%" ><br/><br/>
<%
    if(request.getMethod().equals("POST")){
        FileController fc = new FileController(c);
            fc .saveCover(users);
            out.println(users.getMessage());
    }
%>
    <p>
    <form action="" method="POST" enctype="multipart/form-data">
        <input type="file" name="coverpic" id="coverPIcs" multiple/>
        <input type="file" name="profilepic" id="profilePics"/>
        <input type="submit" value="upload" id="upload"/>
    </form> 
    </p>
     <div style="display: none; border-radius: 20px 50px 20px 50px; width: 400px; height: 300px" id="massage"></div>
    <script type="text/javascript" src="js/accounts.js"/>
    
    </script>
<%@include file="inc/footer.jsp"%>