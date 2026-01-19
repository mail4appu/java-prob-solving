package Arrays.twod;

public class TwoDArrayMain {
    public static void main(String[] args) {
        String[] names={"raj","Maddy"};
        int[][] m=new int[3][]; //Its like 3 arrays
        m[0]=new int[]{1,2, 3};
        //m[0]={1,2,3}--> throws compile error . initilizaiton can not happen after declaraiton but they can happen
        //together like below
        //int [][] a= { {1,2,3}, {23,43,65} }

        m[1]= new int[]{89, 45, 21};
        m[2]= new int[]{12,34, 56};
        System.out.println(m.length);
        System.out.println(m);//Prints class name of type
        System.out.println(names);//Prints class name of type
        System.out.println(m[0]); //Prints class name of type

        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[i].length;j++){
                System.out.println(m[i][j]);
            }
        }



    }
}
