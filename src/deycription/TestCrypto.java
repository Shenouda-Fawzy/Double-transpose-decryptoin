/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deycription;


import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Amazing
 */
public class TestCrypto {
    static char[] alphabet;
    static Map<String , Character> alpha;
   
    
    public static void main(String[] args){
        Caeser caeser = new Caeser();
        
        // Key [0 - 24]
        String criptyed = caeser.encrypt("I am Shenouda", 1); // YZA
        System.out.println(criptyed);
        
        String decripyted = caeser.decrypt("JBNTIFOPVEB", 1);
        System.out.println(decripyted);
        
        System.out.println();
        System.out.println();
        DTranspose transpose = new DTranspose();
        String test = transpose.decryptDTranspose("Mytnametistshenoudaa");
        System.out.println(test);
        
        int [] x = {1 , 2 , 4};
        
        testArr(x);
        
        for(int i = 0 ; i < x.length ; i++)
            System.out.print(x[i] + " ");
        
        
        
    }
    
    private static void testArr(int[] arr){
        
        for(int i = 0 ; i < arr.length ; i++)
            arr[i]+=1;
    }
    
    private static void fillAlpha(){
        
        alpha = new HashMap<>();
        alpha.put("01", 'A');
        alpha.put("02", 'B');
        alpha.put("03", 'C');
        alpha.put("04", 'D');
        alpha.put("05", 'E');
        alpha.put("06", 'F');
        alpha.put("07", 'G');
        alpha.put("08", 'H');
        alpha.put("09", 'I');
        alpha.put("10", 'J');
        alpha.put("11", 'K');
        alpha.put("12", 'L');
        alpha.put("13", 'M');
        alpha.put("14", 'N');
        alpha.put("15", 'O');
        alpha.put("16", 'P');
        alpha.put("17", 'Q');
        alpha.put("18", 'R');
        alpha.put("19", 'S');
        alpha.put("20", 'T');
        alpha.put("21", 'U');
        alpha.put("22", 'V');
        alpha.put("23", 'W');
        alpha.put("24", 'X');
        alpha.put("25", 'Y');
        alpha.put("26", 'Z');
    }
    
    private static String encrypt(String message){
        StringBuffer buffer = new StringBuffer();
        for (int i = 0 ;i < message.length() ; i++){
            buffer.append(message.charAt(i));
        }
        
        return null;
    }
    
}
