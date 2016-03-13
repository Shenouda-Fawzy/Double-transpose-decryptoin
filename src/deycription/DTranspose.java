package deycription;

import java.util.ArrayList;
import java.util.List;

public class DTranspose {

    static int k = 0, m = 0;

    public DTranspose() {

    }

    public String decryptDTranspose(String cipherText) {
        // 'My Name is shenoudaa'
        List factors = new ArrayList();

        int cipherLen = cipherText.length();
        if (cipherLen % 2 != 0) {
            cipherLen += 1;
        }

        factors = getFactors(cipherLen);
    
//Reapeated part.
        
        
        char [][] matrix = createMatrix(cipherLen, factors);
        matrix = fillMatrix(cipherText, matrix);
        
        String dis = displayMatrix(matrix);
        String fac = "";
        for (int i = 0; i < factors.size(); i++) {
            fac += factors.get(i) + " ";
        }
        System.out.println(dis);
        return fac;
    }

    private List getFactors(int num) {
        List factors = new ArrayList();
        System.out.println("getFactors Start");
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                factors.add(i);
            }
        }
        System.out.println("getFactors END");
        return factors;
    }

    private char[][] createMatrix(int num, List factors) {
        List<MatDimention> matDimentions = new ArrayList<>();
        
        // the num and its factor.
        char matrix[][] = new char[1][1];
        System.out.println("createMatrix Start");
        int i = 0;
        int j = m;
        int n1 = 0;
        int n2 = 0;
        for (i  = k; i < factors.size() - 1; i++) {
            for (j = 1; j < factors.size(); j++) {
                n1 = (int) factors.get(i);
                n2 = (int) factors.get(j);

                if (n1 * n2 == num) {
                    matrix = new char[n1][n2];
                    
                    k = i;
                    m = j;
                    break;
                }
            }
            if(n1 * n2 == num)
                break;
        }// end of for.
        System.out.println("createMatrix END");
        return matrix;
    }
    
    private char [][] fillMatrix(String cipherText , char[][] matrix){
        System.out.println("fillMatrix Start");
        int k = 0;
        for(int i = 0 ; i < matrix.length ; i++) // for every row
            for(int j = 0 ; j < matrix[i].length ; j++){ // for every column.
                matrix[i][j] = cipherText.charAt(k);
                k++;
            }
                
        System.out.println("fillMatrix END");
        return matrix;
    }
    
    private String displayMatrix(char [][] matrix){
        StringBuilder bulBuilder = new StringBuilder();
        System.out.println("displayMatrix Start");
        for(int i = 0 ; i < matrix.length ; i++){ // for every row
            for(int j = 0 ; j < matrix[i].length ; j++) // for every column.
                bulBuilder.append(matrix[i][j]);
            bulBuilder.append("\n");
        }
        System.out.println("displayMatrix END");
        System.out.println();
        return bulBuilder.toString().toUpperCase();
    }
    
    class MatDimention{
        int column , row;
        private MatDimention(int column , int row){
            this.column = column;
            this.row = row;
        }
        
        private int getColumn(){
            return this.column;
        }
        
        private int getRow(){
            return this.row;
        }
        
        
        
    }
}
