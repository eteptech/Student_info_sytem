
package com.eteptech.controller;

import com.eteptech.essentials.ConfigFile;
import com.eteptech.model.UserModel;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;


/**
 *
 * @author era
 */
public class FileController extends AccountController{
    private static String uploadDir="C:\\Users\\Premierhub_IT\\Documents\\NetBeansProjects\\studeninfo\\web\\images";
    public void saveCover(UserModel users) throws Exception{
      if (this.valid(users)){
          
      }
        
    }
    private  void upLoad(String fileName,FileItem item,UserModel users) throws Exception{
        String filePath=uploadDir + loggedInUser(users)+".jpg";
        item.write(new File(filePath));   
        
    }

    public FileController(ConfigFile c) {
        super(c);
    }
    private String loggedInUser(UserModel users){
         HttpSession session=users.getRequest().getSession();
        if(session.getAttribute("AUTHSESSION")!=null){
            return session.getAttribute("AUTHSESSION").toString();
        }else{
            return "";
        }
    }
    private boolean valid(UserModel users) throws FileUploadException, Exception{
        try{
                FileItemFactory factory= new DiskFileItemFactory();
                ServletFileUpload upload= new ServletFileUpload(factory);
                List items=null;
                items=upload.parseRequest((users.getRequest()));
                Iterator itr = items.iterator();
                if(itr.hasNext()){
                    FileItem item = (FileItem) itr.next();
                        if(item.getFieldName().equals("coverpic")){
                            if(!item.getName().equals("")){
                                String itemName = item.getName();
                                String fileName = FilenameUtils.getName(itemName).toLowerCase();
                                if(fileName.endsWith(".png")||fileName.endsWith(".jpg") || fileName.endsWith(".png")){
                                    if(item.getSize()<=500000){
                                        if(users.getRequest().getServletContext().getMimeType(itemName).equals("image/jpg") || 
                                            users.getRequest().getServletContext().getMimeType(itemName).equals("image/png")){
                                                this.upLoad(fileName, item, users);
                                                    users.setMessage(fileName+" Uploaded sucessfully!<br/><br/>");
                                                    return true;
                                        }else{
                                            users.setMessage("File extension not supported");
                                            return false;
                                        }
                                    }else{
                                        users.setMessage("Selected file is too large [Max 2MB]");
                                        return false;
                                    }       
                                }else{
                                    users.setMessage("The selected file is not an image!");
                                    return false;
                                }
                            }else{
                                users.setMessage("Please select a file to upload"); 
                                return false;
                            } 
                    } else{
                }  
            }
        }catch(Exception e){
            File coverimage= new File(users.getRequest().getServletContext().getRealPath("images/coverPics/"+AccountController.getLoggInUser(users)+".jpg"));
                if(coverimage.exists()){
                    FileItem item = null;
                    String uname=AccountController.getLoggInUser(users);
                    String filePath=uploadDir + loggedInUser(users)+".jpg";
                    this.upLoad(filePath, item, users);
                    item.write(new File(filePath.replace(uname, uname)));
                    return true;
                }
                users.setMessage(e.getMessage());
            return false;
        }
        return true;
    }
    public void overwrite(FileItem item,UserModel users) throws Exception{
        String uname=AccountController.getLoggInUser(users);
            String filePath=uploadDir + loggedInUser(users)+".jpg";
            this.upLoad(filePath, item, users);
            item.write(new File(filePath.replace(uname, uname)));
    }
}
