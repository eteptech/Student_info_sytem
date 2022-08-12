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
    AccountController.protectedPage(true, users);   
    String fileName="";
%>
<%
    if(request.getMethod().equals("POST")){
       try{
       FileController fc = new FileController(c);
        fc .saveCover(users);
            out.println(users.getMessage());
    }catch(Exception ex){
        out.println(ex.getMessage());
    }
           
    }
%>

<%
  
   try{
        ServletContext con=getServletContext();
        String username= AccountController.getLoggInUser(users); 
        File coverimage= new File(con.getRealPath("images\\coverPics\\"+username+".jpg"));
        if(coverimage.exists()){
            //out.println("exist");
            fileName="images\\coverPics\\"+username+".jpg";
        }else{
        
        fileName="images\\3.jpg";
    }
   }catch(Exception e){
       //out.println("does not exist");
       
   }
   
%>

<img src="<%=fileName%>" alt=""  width="100%"  min-height="300px" ><br/><br/>

    <p>
    <form action="" method="POST" enctype="multipart/form-data">
        <input type="file" name="cover" id="coverpics" multiple/>
        <input type="file" name="profilepics" id="profilepics" multiple/>
        <input type="submit" value="upload" id="upload"/>
    </form> 
    </p>
     <div style="display: none; border-radius: 20px 50px 20px 50px; width: 400px; height: 300px" id="massage"></div>
    <script type="text/javascript" src="js/accounts.js"/>
    
    </script>
<%@include file="inc/footer.jsp"%>