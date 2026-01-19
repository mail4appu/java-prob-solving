package Arrays.twod;

import java.util.Scanner;


/**
 * Transforming the rows into columns is called matrix transpose
 *
 * ie FirstRow becomes First Column, Second Row becomes Second Column ..so on
 */
public class MatrixTranspose {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter row size ");
        int rowSize=sc.nextInt();
        System.out.println("Enter column size");
        int columnSize=sc.nextInt();
        int[][] matrix=new int[rowSize][columnSize];
        System.out.println("Enter matrix elements");
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                matrix[i][j]=sc.nextInt();
            }
        }

        printMatrix(matrix);
        printTranspose(matrix);



    }

    private static void printTranspose(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix[0].length;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;

            }
        }
        System.out.println("==========Transpose =================");
        printMatrix(matrix);

    }

    private static void printMatrix(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+"  ");
            }
            System.out.println();
        }

    }
}
