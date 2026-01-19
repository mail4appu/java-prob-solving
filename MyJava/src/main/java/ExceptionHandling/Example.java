package ExceptionHandling;

public class Example {
	public static void main(String args[]){
		System.out.println("hi");
		try{
			int i=0;
			int j=10;
			int result=j/i;
		}catch(Exception ex){
			ex.printStackTrace();
			//throw new Exception("pls provide valid value for i");
			
		}
		
	}

}
