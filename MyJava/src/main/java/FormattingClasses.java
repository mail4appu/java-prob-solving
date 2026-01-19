import java.net.InetAddress;
import java.text.DecimalFormat;


class FormattingClasses {
	public static void main(String args[])throws Exception{
		DecimalFormat df= new DecimalFormat("0.000");//specifies the no of digits after decimal
		double d=100550000.7;
		System.out.println(df.format(d));
		

	}

}
