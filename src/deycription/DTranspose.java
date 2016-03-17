package deycription;

import java.util.ArrayList;
import java.util.List;


// For decryption we must shift the column first.

public class DTranspose {

    static int k = 0, m = 0;
    String plain;
    List dictionary;
    boolean found;
    public DTranspose() {
        dictionary = new ArrayList();
        found = false;
        fillDictionary();
    }
    
    private void fillDictionary(){
        dictionary.add("NAME");
        dictionary.add("123456789");
        dictionary.add("FACTORIAL");
        dictionary.add("CIPHER");
        dictionary.add("ALGORITHM");
        dictionary.add("PRISON");
        dictionary.add("SHENOUDA");
        dictionary.add("PROGRAMMER");
        dictionary.add("HAVE");
        dictionary.add("NO");
        dictionary.add("LIFE");
        
        
    }

    private boolean isPrime(int num){
        for(int i = 2 ; i <= num / 2 ; i++ )
            if(num % i == 0)
                return false;
        return true;
    }
    
    public String decryptDTranspose(String cipherText) {
        // 'My Name is shenoudaa'
        List factors = new ArrayList();

        int cipherLen = cipherText.length();
        if(isPrime(cipherLen)){
            cipherLen++;
            cipherText += " ";
        }
        factors = getFactors(cipherLen);

//Reapeated part.
        List<MatDimention> matDimentions = createMatrix(cipherLen, factors); // get list of all possible dimensions.
        for (int i = 0; i < matDimentions.size(); i++) {

            char[][] matrix = fillMatrix(cipherText, matDimentions.get(i));
            shiftColumn(matrix);
            if(found == true)
                break;
            // for decryption.
            //shiftRow(matrix); // for encryption.
            //String dis = displayMatrix(matrix);
            //System.out.println(dis);
            //shiftColumn(matrix);
        }
        
        System.out.println("Test Shuffling");
//        char[][] matArr = {
//            {'n','a'},
//            {'m', 'e'}
//        };
//        char[][] matArr = {
//            {'f','a', 'c'},
//            {'t', 'o','r'},
//            {'i','a','l'}
//        };
//        char[][] matArr = {
//            {'a','f', 'c'},
//            {'o', 't','r'},
//            {'a','i','l'}
//        };
//        char[][] matArr = {
//            {'1','4', '7'},
//            {'2', '5','8'},
//            {'3','6','9'}
//        };
        char[][] matArr = {
            {'9','7', '8'},
            {'3', '2','1'},
            {'6','4','5'}
        };

//        char[][] matArr = {
//            {'1','3'},
//            {'2', '4'}
//            
//        };
        
//        char[][] matArr = {
//            {'e','m'},
//            {'a', 'n'}
//            
//        };
        //shiftRow(matArr);
        //shiftColumn(matArr);
        
        String fac = "";
        for (int i = 0; i < factors.size(); i++) {
            fac += factors.get(i) + " ";
        }
        //System.out.println(dis);
        return fac;
    }
    
    private void shiftRow(char[][] matrix){
        
        int rowLen = matrix[0].length;
        int numOfRow = matrix.length;
        char [] tempRow = new char[rowLen];
        String test;
        for(int i = 0 ; i < numOfRow ; i++){
            for(int j = 0 ; j < numOfRow ; j++){
                if(i == j)
                    continue;
                for(int k = 0 ; k < rowLen ; k++){
                    tempRow[k] = matrix[i][k];
                    matrix[i][k] = matrix[j][k];
                    matrix[j][k] = tempRow[k];
                }
                //shiftColumn(matrix);
                test = displayMatrix(matrix);
                //System.out.println(test);
                if(isFounded(test) == true && found == false){
                    System.out.println(test);
                    found = true;
                    return;
                }
            }
        }
    }
    
    private void shiftColumn(char [][] matrix){
        char[] tempColumn = new char[matrix.length];
        int numOfColumn = matrix[0].length;
        
        for(int i = 0 ; i < numOfColumn  ; i++){
            for(int j = 0 ; j < numOfColumn ; j++){
                if(i == j)
                    continue;
                for(int k = 0 ; k < matrix.length ; k++){
                    tempColumn[k] = matrix[k][i];
                    matrix[k][i] = matrix[k][j];
                    matrix[k][j] = tempColumn[k];
                }
                shiftRow(matrix);
                if(found == true)
                    return;
                //String test = displayMatrix(matrix);
                //System.out.println(test);
            }
        }// end of outer for loop.
    }// end of shiftColumn method.

    private List getFactors(int num) {
        List factors = new ArrayList();
        //System.out.println("getFactors Start");
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                factors.add(i);
            }
        }
        //factors.add(num);
        //System.out.println("getFactors END");
        return factors;
    }

    private List<MatDimention> createMatrix(int num, List factors) {
        List<MatDimention> matDimentions = new ArrayList<>();

        // the num and it's factor.
        //System.out.println("createMatrix Start");
        
        int n1 ;
        int n2 ;
        for (int i = 0; i < factors.size() ; i++) {
            for (int j = 0; j < factors.size(); j++) {
                n1 = (int) factors.get(i);
                n2 = (int) factors.get(j);

                if (n1 * n2 == num) {
                    if(n1 != n2){
                        matDimentions.add(new MatDimention(n1, n2)); // this list contatin all possible dimension of matrix.
                        //matDimentions.add(new MatDimention(n2, n1)); // this list contatin all possible dimension of matrix.
                    }
                    else
                        matDimentions.add(new MatDimention(n2, n1)); // this list contatin all possible dimension of matrix.

                } // end of outer if.
            }// end of innner for

        }// end of outer for.
        //System.out.println("createMatrix END");
        return matDimentions;
    }

    private char[][] fillMatrix(String cipherText, MatDimention matDimention) {
        char[][] matrix = new char [matDimention.getRow()][matDimention.getColumn()];
        //System.out.println("fillMatrix Start");
        int k = 0;
        for (int i = 0; i < matrix.length; i++) // for every row
        {
            for (int j = 0; j < matrix[i].length; j++) { // for every column.
                matrix[i][j] = cipherText.charAt(k);
                k++;
            }
        }

        //System.out.println("fillMatrix END");
        return matrix;
    }

    private String displayMatrix(char[][] matrix) {
        StringBuilder bulBuilder = new StringBuilder();
        //System.out.println("displayMatrix Start");
        for (int i = 0; i < matrix.length; i++) { // for every row
            for (int j = 0; j < matrix[i].length; j++) // for every column.
            {
                bulBuilder.append(matrix[i][j]);
            }
            //bulBuilder.append("\n");
        }
        //System.out.println("displayMatrix END");
        //System.out.println();
        return bulBuilder.toString().toUpperCase();
    }

    class MatDimention {

        int column, row;

        private MatDimention(int column, int row) {
            this.column = column;
            this.row = row;
        }

        private int getColumn() {
            return this.column;
        }

        private int getRow() {
            return this.row;
        }

    }
    
    private boolean isFounded(String str){
        String [] tokens = str.split(" ");
        if(dictionary.contains(tokens[0]))
            return true;
        else
            return false;
    }
}
