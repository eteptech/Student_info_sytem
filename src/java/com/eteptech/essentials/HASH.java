/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eteptech.essentials;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author era
 */
public class HASH {
    private static String MD5(String input){
        try{
        MessageDigest md=MessageDigest.getInstance("MD5");
        byte[] messageDigest=md.digest(input.getBytes());
            BigInteger numbber= new BigInteger(1,messageDigest);
            String hashText=numbber.toString(16);
            return hashText;
        }catch(NoSuchAlgorithmException e){
            throw new RuntimeException(e);
        }
        
    }
    private static String SHA1(String input){
         try{
        MessageDigest md=MessageDigest.getInstance("MD5");
        byte[] messageDigest=md.digest(input.getBytes());
            BigInteger numbber= new BigInteger(1,messageDigest);
            String hashText=numbber.toString(16);
            return hashText;
        }catch(NoSuchAlgorithmException e){
            throw new RuntimeException(e);
        } 
    }
    public static String encrypt(String input){
        return HASH.SHA1(HASH.SHA1(HASH.MD5(HASH.SHA1(HASH.MD5(input)))));
    }
}
