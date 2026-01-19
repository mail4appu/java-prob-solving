package algorithms.hcl;

public class TestClassII {

    public static void main(String[] args) {
       int input=15;

       for(int i=1;i<=15;i++){
           if(i%3==0 && i%5==0 ){
               System.out.println("fizz buzz");
           }
           else if(i%5==0){
               System.out.println("buzz");
           }
           else if(i%3==0){
               System.out.println("fizz");
           }
           else{
               System.out.println(i);
           }
       }
    }
}
