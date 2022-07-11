
package com.eteptech.model;
import com.eteptech.essentials.ConfigFile;
import com.eteptech.essentials.DbEssentials;
import java.io.Serializable;
public class UserModel extends DbEssentials implements Serializable {
    //@Transient
    private ConfigFile c;
    private String fname;
    private String lname;
    private String uname;
    private String psswd;
    //@Column(unique = true)
    private String email;
    private String address;
    private String mobilenumber;
    private String dob;
    private String gender;
    //@Transient
    private String message;
    private String cpsswd;
    //@Transient
    private String checkOption;
    private String Remember;
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    //@Transient
    private String coverpic;
    //@Transient
    private String profilepic;
    
    
    public UserModel(){
    this.message="Welcome";
    this.checkOption="";
    
}

    public String getCheckOption() {
        return checkOption;
    }

    public void setCheckOption(String checkOption) {
        this.checkOption = checkOption;
    }

    public ConfigFile getC() {
        return c;
    }
    public void setC(ConfigFile c) {
        this.c = c;
    }
   

    public String getCpsswd() {
        return cpsswd;
    }

    public void setCpsswd(String cpsswd) {
        this.cpsswd = cpsswd;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPsswd() {
        return psswd;
    }

    public void setPsswd(String psswd) {
        this.psswd = psswd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

      public String getDob() {
        return dob;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getFullName(){
        return this.getFname() + " "+this.getLname();
    }

    public String getRemember() {
        return Remember;
    }

    public void setRemember(String Remember) {
        this.Remember = Remember;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    } 

    public String getCoverpic() {
        return coverpic;
    }

    public void setCoverpic(String coverpic) {
        this.coverpic = coverpic;
    }

    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }
    
}
