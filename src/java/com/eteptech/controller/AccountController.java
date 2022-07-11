package com.eteptech.controller;

import com.eteptech.dao.dbContext;
import com.eteptech.essentials.ConfigFile;
import com.eteptech.essentials.ServletEssentials;
import com.eteptech.essentials.Validation;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import com.eteptech.model.CourseRegistration;
import com.eteptech.model.UserModel;
import java.lang.reflect.Array;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

public class AccountController  extends ServletEssentials{
    
    private final Connection con;
    private ServletEssentials essentials; 
    public AccountController(ConfigFile c){
       
       con=dbContext.con(c);
    }
    public void saveUser(UserModel users, ConfigFile c) throws IOException{
        if(this.validateUSerName(users)){
            if(this.isAvailability(users)){
                if(this.save(users)){
                    users.setMessage(users.getFullName() +" Registered successfully");
                   
                }
            }else{
                users.setMessage("ERROR: user name or email already exist.");
            }
        }
    }
    public boolean checkUsername(UserModel users){
        try{
            users.setQuery("SELECT 'stdid' FROM app.student WHERE `username`='"+users.getUname()+"'");
            users.setStmt(this.con.createStatement());
            users.setRs(users.getStmt().executeQuery(users.getQuery()));
            if(users.getRs().next()){
                return false;
            }
        }catch(SQLException e){
            users.setMessage(e.getMessage());
            return false;
        }
        return true;
    }
    private boolean validateUSerName(UserModel users){
        if(!Validation.FNAMEex(users.getFname())){
            users.setMessage("please write a valid first name");
            return false;
        }
        if(!Validation.lName(users.getLname())){
            users.setMessage("please enter a valid last name");
            return false;
        }
        if(!Validation.userName(users.getUname())){
            users.setMessage("Please enter a valid username.");
            return false;
        }
        if(!Validation.password(users.getPsswd())){
            users.setMessage("please create a Strong password");
            return false;
        }
        if(!users.getPsswd().equals(users.getCpsswd())){
            users.setMessage("password and confirm password do not  matched");
            return false;
        }
        if (!Validation.email(users.getEmail())){
            users.setMessage("please a valid  email address.");
            return false;
        }
        if(!Validation.mobileNumber(users.getMobilenumber())){
            users.setMessage("Please ennter a valid mobile number");
            return false;
        }
        if(!Validation.Dob(users.getDob())){
            users.setMessage("Please a valid date of birth.");
            return false;
        }
        /**if(!validation.address(users.getAddress())){
            users.setMessage("Please enter valid characters for address");
            return false;
        }*/
        return true;
    }
    private boolean isAvailability(UserModel users){
        users.setQuery("SELECT `stdid` FROM app.student WHERE `username`='"+users.getUname()+"' OR 'email_id'='"+users.getEmail()+"' OR 'phone_no'='"+users.getMobilenumber()+"'");
        try{
           users.setStmt(this.con.createStatement());
           users.setRs(users.getStmt().executeQuery(users.getQuery()));
           if(users.getRs().next()){
               return false;
           }return true;
        }catch(SQLException e){
            return false;
        }
    }
    private boolean save(UserModel users){
        users.setQuery("INSERT INTO `app`.`student`\n" +
" VALUES (NULL,'"+users.getFname()+"', "
        + "'"+users.getLname()+"',"
                + " '"+users.getUname()+"',"
                        + " '"+users.getPsswd()+"',"
                                + " '"+users.getEmail()+"',"
                                        + " '"+users.getAddress()+"',"
                                                + " '"+users.getMobilenumber()+"', "
                                                        + "'"+users.getDob()+"', "
                                                                + "'"+users.getGender()+"',"
                                                                        + " CURRENT_TIMESTAMP, '0');");
        //u.setQuery("INSERT INTO 'student' VALUES ('NULL','"+u.getFname()+"','"+u.getLname()+"','"+u.getUname()+"','"+u.getPsswd()+"','"+u.getEmail()+"','"+u.getPhone()+"','"+u.getDob()+"','"+u.getGender()+"','"+u.getAddress()+"','CURRENT_TIMESTAMP',0);");
        try{
        users.setPst(this.con.prepareStatement(users.getQuery()));
        users.getPst().execute();
        return true;
        }catch(SQLException e){
            //users.setMessage("ERROR:email or phone number has already been used previously.");
            users.setMessage(e.getMessage());
            return false;
        }
    }
    public String checkUsernameEmail(UserModel users){
            users.setQuery("SELECT `stdid` FROM app.student WHERE `username`='"+users.getUname()+"'");
            //System.out.println("username");
        try{
             users.setStmt(this.con.createStatement());
             users.setRs(users.getStmt().executeQuery(users.getQuery()));
             if(users.getRs().next()){
                users.setMessage("Username not available");
             }else{
                 users.setMessage("Username available");
             }
        }catch(SQLException e){
            users.setMessage(e.getMessage());
        }
        return "";
    }
    public String checkEmail(UserModel users){
             users.setQuery("SELECT `stdid` FROM app.student WHERE `email_id`='"+users.getEmail()+"'");
             //System.out.println("email")
        try{
             users.setStmt(this.con.createStatement());
             users.setRs(users.getStmt().executeQuery(users.getQuery()));
             if(users.getRs().next()){
                users.setMessage("Email not available");
             }else{
                 users.setMessage("Email available");
             }
        }catch(SQLException e){
            users.setMessage(e.getMessage());
        }
        return ""; 
    }
    public boolean login(UserModel users) throws IOException{
        if(this.isValidlogin(users)){
            if(this.isAuthentic(users)){
                isAuthorize(users);
            }
        }
        return true;
    }
    private boolean isAuthentic(UserModel users){
        users.setQuery("SELECT `stdid`,`first_name`,`last_name` FROM app.student WHERE `username`='"+users.getUname()+"' AND `passwd`='"+users.getPsswd()+"';");
        try{
            users.setStmt(this.con.createStatement());
            users.setRs(users.getStmt().executeQuery(users.getQuery()));
            if(users.getRs().next()){
                //users.setMessage(users.getPsswd());
                users.setFname(users.getRs().getString("first_name"));
                users.setLname(users.getRs().getString("last_name"));
                users.setUserId(users.getRs().getInt("stdid"));
                users.setRemember(users.getRemember());
                
                if(this.updateProfile(users))
                return true;
            }else{
                users.setMessage("username or password does't exist");
            }
        }catch(SQLException e){
             users.setMessage(e.getMessage());
            return false;
        } 
      return false;
    }
    private boolean isValidlogin(UserModel users){
        if(!Validation.userName(users.getUname())){
            users.setMessage("Invalid username.");
            return false;
        }
        if(!Validation.password(users.getPsswd())){
            users.setMessage("Invalid password");
            return false;
        }
        return true;
        
    }
    public void isAuthorize(UserModel users) throws IOException{
        
        
        users.getRequest().getSession().setAttribute("AUTHSESSION", users.getFullName().toLowerCase());
        users.getRequest().getSession().setAttribute("authID", users.getUserId());
        users.setMessage("SUCCESS");
           
    }
    public static void protectedPage(boolean isValid, UserModel users) throws IOException{
        if(isValid)
            isAthorized(users);
    }
    private  static void isAthorized(UserModel users) throws IOException{
        HttpSession session= users.getRequest().getSession();
        if(session.getAttribute("AUTHSESSION")==null){
            users.getResponse().sendRedirect("login.jsp?ID=101");
        }
    } 
    public static  String getLoggInUser(UserModel users){
        HttpSession session=users.getRequest().getSession();
        if(session.getAttribute("AUTHSESSION")!=null){
            return session.getAttribute("AUTHSESSION").toString();
        }else{
            return "";
        }
    }
    public static void showLogin(UserModel users) throws IOException{
        HttpSession session=users.getRequest().getSession();
        if(session.getAttribute("AUTHSESSION")!=null && session.getAttribute("authID")!=null){
            users.getResponse().sendRedirect("profile.jsp");
        }  
    }
    private boolean updateProfile(UserModel users){
        if(this.checkprofile(users)){
            try{
                users.setQuery("INSERT INTO app.profile VALUES (NULL,"+users.getUserId()+",0,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'');");
                users.setPst(this.con.prepareStatement(users.getQuery()));
                users.getPst().execute();
                this.checkprofile(users);
            }catch(SQLException e){
                users.setMessage(e.getMessage());
                return false;
            }
        }
        return true;
    }
    private boolean checkprofile(UserModel users){
        try{
            users.setQuery("SELECT `id` FROM app.profile WHERE `student_id`="+users.getUserId()+";");
            users.setStmt(this.con.createStatement());
            users.setRs(users.getStmt().executeQuery(users.getQuery()));
            if(users.getRs().next()){
                return false;
            }return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            users.setMessage(e.getMessage());
            return false;
        }
    }
//    private boolean cookie(UserModel users) throws IOException{
////        Cookie cookies=new Cookie("remember", users.getRemember());
////        if(!cookies.getName().equals("")){
////            if(cookies.getValue().equals("")){
////                
////            }
////            users.getResponse().addCookie(cookies);
////            //cookies.setMaxAge(20000);
////            return true;
////        }return false;
//    }
//    
   private boolean examsRegistration(  UserModel users, CourseRegistration courseRegistration){
       
        users.setQuery("INSERT INTO `exams` VALUES(NULL,`"+courseRegistration.getStudentName()+"`," + "`"+courseRegistration.getCouseName()+"`,`"+courseRegistration.getCourseFee()+"`,`CURRENT_TIMESTAMP`)");
        try{
            users.setPst(this.con.prepareStatement(users.getQuery()));
            users.getPst().execute();
            return true;
        }catch(SQLException e){
            users.setMessage(e.getMessage()); 
            return false; 
        } 
    }
   
   public void exams(UserModel users, CourseRegistration courseRegistration){
       if(this.examsRegistration(users, courseRegistration)){
           users.setMessage("Course registered successfully");
           
       }
   }
}
