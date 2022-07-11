/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eteptech.essentials;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ConfigFile{
    private String webbsiteurl;
    private String defaulturl;
    private String loginurl;
    private HttpServletRequest request;
    protected HttpServletResponse respone;
    private HttpSession session;
    
    //DB ConfigFile
    private String dbhost;
    private String dbname;
    private String dbuser;
    private String dbpsswsd;
    
    public String getDbhost() {
        return dbhost;
    }

    public void setDbhost(String dbhost) {
        this.dbhost = dbhost;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public String getDbuser() {
        return dbuser;
    }

    public void setDbuser(String dbuser) {
        this.dbuser = dbuser;
    }

    public String getDbpsswsd() {
        return dbpsswsd;
    }

    public void setDbpsswsd(String dbpsswsd) {
        this.dbpsswsd = dbpsswsd;
    }
    

    public String getWebbsiteurl() {
        return webbsiteurl;
    }

    public void setWebbsiteurl(String webbsiteurl) {
        this.webbsiteurl = webbsiteurl;
    }

    public String getDefaulturl() {
        return defaulturl;
    }

    public void setDefaulturl(String defaulturl) {
        this.defaulturl = defaulturl;
    }

    public String getLoginurl() {
        return loginurl;
    }

    public void setLoginurl(String loginurl) {
        this.loginurl = loginurl;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getRespone() {
        return respone;
    }

    public void setRespone(HttpServletResponse respone) {
        this.respone = respone;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }
    
        
}
