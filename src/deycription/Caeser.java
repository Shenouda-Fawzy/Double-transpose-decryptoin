/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deycription;

import java.util.regex.Pattern;

/**
 *
 * @author Amazing
 */
public class Caeser {
    
    private final String inputString = "([a-zA-Z])*"; // be sure that it's a number.
    private Pattern pattern;
    String plainText;
    String cipherText;
    int key;
    
    // [65 - 90] [A - Z]
    // [97 - 122]
    
    public Caeser(){
    
    }
    
    public Caeser(String plainText , int key){
        plainText = this.plainText;
        this.key = key;
    }
    
    public String encrypt(String plainText , int key){
        String plain = plainText.toUpperCase();
        
        // (Input - 65) % 25 --> res + 65    [65 - 90]
        StringBuilder builder = new StringBuilder();
        
        for(int i  = 0 ; i < plain.length() ; i++){
            
            char pchar = plain.charAt(i);
            if(pchar == ' '){
                continue;
            }
            int pInt = (int)pchar;
            int cInt = (pInt - 65 + key) % 26;
            char cipherChar = (char)(cInt + 65);
            builder.append(cipherChar);
        }
        //this.cipherText = builder.toString();
        return builder.toString();
    }
    
    public String decrypt(String cipherText , int key){
        String cipher = cipherText.toUpperCase();
        
        // (Input - 65) % 25 --> res + 65    [65 - 90]
        StringBuilder builder = new StringBuilder();
        
        for(int i  = 0 ; i < cipher.length() ; i++){
            char pchar = cipher.charAt(i);
            int pInt = (int)pchar;
            int mInt = (pInt - 65 - key);
            int cInt = 0;
            if(mInt < 0){
                mInt += 26;
                cInt = mInt % 26;
            }
            else
                cInt = mInt % 24;
            char cipherChar = (char)(cInt + 65);
            builder.append(cipherChar);
        }
        //this.cipherText = builder.toString();
        return builder.toString();
    }
    
    public String getCipherd(){
        return cipherText ;
    }
    
    public String getPlainText(){
        return plainText;
    }
    
    
    public void setCipherText(String cipher){
        this.cipherText = cipher;
    }
    
    public void setPlainText(String plainText){
        this.plainText = plainText;
    }
    
}
