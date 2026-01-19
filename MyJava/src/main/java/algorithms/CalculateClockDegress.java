package algorithms;

public class CalculateClockDegress {

	public CalculateClockDegress() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		int hr=12;
		int min=20;
		calculateAngle(hr,min);
		
	}
	private static void calculateAngle(int hr, int min) {
		//consider 12 as 0
	   double angle=Math.abs((30*hr-5.5*min));
	   System.out.println(angle+"   or "+(360-angle));
		
		
		
	}

}
