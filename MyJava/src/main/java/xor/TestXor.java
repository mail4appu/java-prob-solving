package xor;

public class TestXor {
	public static void main(String[] args) {
     int xorResult=0;
     for(int i=1;i<9;i++){
    	// System.out.println(xorResult+"   :  "+i);
    	 xorResult=xorResult^i;
    	 System.out.println(xorResult);
     }
     int a[]= {1,2,3,5,7};
     for(int i:a){
    	 System.out.print(i);
     }
     System.out.println("*******: "+(1^2^3^3^3^1));
	}
}
