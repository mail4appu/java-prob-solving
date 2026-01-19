
public    class SampleClass {
	static double d=0.22;
	public static void main(String []args){
		d=3.50;
		changeMe(d);
		System.out.println("value of d is"+d);
		String s=" hi how r u ";
		String s1="how";
		if(s.contains(s1)){
			System.out.println("nice job");
		}
		
		if(s.indexOf("how")!=-1){
			System.out.println("good job");
		}
	}
	
public static void changeMe(double f){
	System.out.println("inside changeme");
	d=8.50;
}
}