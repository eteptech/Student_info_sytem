
package com.eteptech.essentials;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Validation {
    private static final Pattern FnameExpression=Pattern.compile("^[A-Za-z]{3,20}$",Pattern.UNICODE_CASE);
    public static boolean FNAMEex(String name){
        Matcher matcher=FnameExpression.matcher(name);
        return matcher.find(); 
    }
    private static final Pattern lNameExpression=Pattern.compile("^[A-Za-z]{3,20}$",Pattern.UNICODE_CASE);
    public static boolean lName(String lname){
        Matcher matcher=lNameExpression.matcher(lname);
        return matcher.find();
    }
    private static final Pattern unameExpression=Pattern.compile("^[A-Za-z]{3,20}$",Pattern.UNICODE_CASE);
    public static boolean userName(String username){
        Matcher matcher=unameExpression.matcher(username);
        return matcher.find();
    }
    private static final Pattern passwordExpression=Pattern.compile("^[A-Za-z0-9]{8,250}$",Pattern.UNICODE_CASE);
    public static boolean password(String pass){
        Matcher matcher=passwordExpression.matcher(pass);
        return matcher.find();
    }
    private static final Pattern mobile=Pattern.compile("^[0]\\d{10}$",Pattern.UNICODE_CASE);
    public static boolean mobileNumber(String num){
        Matcher matcher=mobile.matcher(num);
        return matcher.find();
    }
    private static final Pattern DOB=Pattern.compile("^[0-9/]{0,20}$",Pattern.UNICODE_CASE);
    public static boolean Dob(String dob){
        Matcher matcher=DOB.matcher(dob);
        return matcher.find();
    }
    private static final Pattern eMail=Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$",Pattern.UNICODE_CASE);
    public static boolean email(String mail){
        Matcher matcher=eMail.matcher(mail);
        return matcher.find();
    }
   /** private static final Pattern Address=Pattern.compile("^[A-Za-z 0-9@.,/|{}()_+:;]{0,500}$");
    public static boolean address(String adds){
        Matcher matcher=Address.matcher(adds);
        return matcher.find();
    }*/
}
