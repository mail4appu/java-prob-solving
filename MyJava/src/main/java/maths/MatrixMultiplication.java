package maths;

public class MatrixMultiplication {
    public static void main(String[] args) {
        int m1[][]= {
                   {4,5,6},
                   {13,8,9}

                };

        int m2[][]={
                     {7,19},
                     {12,7},
                     {56,23}
                   };

        System.out.println(m1.length+ "  "+ m1[0].length);
        System.out.println(m2.length+ "  " +m2[0].length);

        int resultRows=m1.length;
        int resultColumns=m2[0].length;

        int pointer=m1[0].length;
        int sum=0;

        if(m1[0].length==m2.length){
            System.out.println("Matrix can be multiplied");

            int result[][]= new int[resultRows][resultColumns];

            for(int i=0;i<resultRows;i++){
                for (int j=0;j<resultColumns;j++){
                    for(int k=0;k<pointer;k++){
                      sum=sum+(m1[i][k]*m2[k][j]);
                    }
                    result[i][j]=sum;
                    sum=0;
                }

            }
           for(int[] row:result){
               for(int val:row){
                   System.out.print(val+"  ");
               }
               System.out.println();

            }


        }
        else{
            return;
        }





    }




}
