package Arrays.twod;

import java.util.Scanner;

public class RotateMatrixBy90 {

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
        rotateBy90Result(matrix);



    }

    private static void rotateBy90Result(int[][] matrix) {
     //by reversing columns after transpose will give you 90 degree rotated array
     //i.e reversing each row ==> reversing multiple arrays one by one

        for( int i=0;i<matrix.length;i++){
            int left=0;
            int right=matrix[i].length-1;
            while(left<right){
                int temp=matrix[i][left];
                matrix[i][left]=matrix[i][right];
                matrix[i][right]=temp;
                left++;
                right--;
            }

        }

        System.out.println("Rotated by 90 =====================");
        printMatrix(matrix);


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
