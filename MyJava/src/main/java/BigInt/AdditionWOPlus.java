package BigInt;

public class AdditionWOPlus {
	public static void main(String[] args) {
		System.out.println(add(12,13));
	}

	private static int add(int a, int b){
		System.out.println("Binary value of first integer: "+Integer.toBinaryString(a));
		System.out.println("Binary value of Second integer: "+Integer.toBinaryString(b));
		while(b!=0){
			int temp=a&b;
			a=a^b;
			b=temp <<1;
		}
        System.out.println("Binary value of result: "+Integer.toBinaryString(a));
        
		return a;
	}
}
