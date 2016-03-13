package deycription;

import java.util.ArrayList;
import java.util.List;

public class DTranspose {

    static int k = 0, m = 0;

    public DTranspose() {

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
        if (cipherLen % 2 != 0) {
            cipherLen += 1;
        }

        factors = getFactors(cipherLen);

//Reapeated part.
        List<MatDimention> matDimentions = createMatrix(cipherLen, factors); // get list of all possible dimensions.
        for (int i = 0; i < matDimentions.size(); i++) {

            char[][] matrix = fillMatrix(cipherText, matDimentions.get(i));
            String dis = displayMatrix(matrix);
            System.out.println(dis);
        }
        String fac = "";
        for (int i = 0; i < factors.size(); i++) {
            fac += factors.get(i) + " ";
        }
        //System.out.println(dis);
        return fac;
    }

    private List getFactors(int num) {
        List factors = new ArrayList();
        //System.out.println("getFactors Start");
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                factors.add(i);
            }
        }
        factors.add(num);
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
            bulBuilder.append("\n");
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
}
