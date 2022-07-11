
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.FileItemFactory"%>
<img src="images/?Pngtree?login and sign in user_6151555.png" alt=""/>
<%@page  import="controllers.accountsControllers" %>
<%@include file="inc/header.jsp" %> 
<%
   try{
    String uploadDir="/home/erastus/Com.ugbemTech/web/images/coverPics/";
    if(request.getMethod().equals("POST")){
        FileItemFactory factory= new DiskFileItemFactory();
        ServletFileUpload upload= new ServletFileUpload(factory);
        List items=null;
        items=upload.parseRequest(request);
        Iterator itr = items.iterator();
        while(itr.hasNext()){
            FileItem item = (FileItem) itr.next();
            if(item.getFieldName().equals("coverpic")){
                 if(!item.getName().equals("")){
                    String itemName = item.getName();
                    String fileName = FilenameUtils.getName(itemName).toLowerCase();
                    if(fileName.endsWith(".png")||fileName.endsWith(".jpg")){
                        if(item.getSize()<=200000){
                            if(getServletContext().getMimeType(itemName).equals("image/jpg") || 
                                getServletContext().getMimeType(itemName).equals("image/png")){
                                item.write(new File(uploadDir+fileName.toString()));
                                out.println(fileName+" Cover photo sucessfully!");
                            }else{
                                out.println("File extension not supported");
                            }
                        }else{
                            out.println("Selectd file is too large [Max 2MB]");
                        }
                    }else{
                        out.println("The selected file is not an image!");
                    }
                 }else{
                   out.println("please select a file to upload");  
                 } 
            }    
        }
    }
    }catch(Exception e){
        out.println(e.getMessage());
    }
%>
<% 
    accountsControllers.protectedPage(true, users);
        
%>
<h1>Welcome to profile page</h1>
<img alt="" src="images/adminback.jpg" style="width: 100%"/>
    <p>
    <form action="" method="POST" enctype="multipart/form-data">
        <input type="file" name="coverpic" multiple/>
        <input type="file" name="profiepic"/>
        <input type="submit" value="upload"/>
    </form> 
       
    </p>
    <%
    try{
    String uploadDir="/home/erastus/Com.ugbemTech/web/images/coverPics/";
    if(request.getMethod().equals("POST")){
        FileItemFactory factory= new DiskFileItemFactory();
        ServletFileUpload upload= new ServletFileUpload(factory);
        List items=null;
        items=upload.parseRequest(request);
        Iterator itr = items.iterator();
        while(itr.hasNext()){
            FileItem item = (FileItem) itr.next();
            if(item.getFieldName().equals("coverpic")){
                 if(!item.getName().equals("")){
                    String itemName = item.getName();
                    String fileName = FilenameUtils.getName(itemName).toLowerCase();
                    if(fileName.endsWith(".png")||fileName.endsWith(".jpg")){
                        if(item.getSize()<=200000){
                            if(getServletContext().getMimeType(itemName).equals("image/jpg") || 
                                getServletContext().getMimeType(itemName).equals("image/png")){
                                item.write(new File(uploadDir+fileName.toString()));
                                out.println(fileName+" Cover photo sucessfully!");
                            }else{
                                out.println("File extension not supported");
                            }
                        }else{
                            out.println("Selectd file is too large [Max 2MB]");
                        }
                    }else{
                        out.println("The selected file is not an image!");
                    }
                 }else{
                   out.println("please select a file to upload");  
                 } 
            }    
        }
    }
    }catch(Exception e){
        out.println(e.getMessage());
    }
               
%>
<%@include file="inc/footer.jsp"%>
