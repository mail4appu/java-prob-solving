
/**
 * @author vapparao
 * this class opens the specified url in the operating sytems default browser
 * u can give any broswer and url in the following way
 */
public class OpenaBrowser {
	public static void main(String args[])throws Exception{
		String[] command={"C:/Program Files/Mozilla Firefox/firefox.exe", "http://202.67.6.27/PresenzaSouth/Login.aspx?txtUser=av00102272"};
		Runtime.getRuntime().exec(command);
		System.out.println();
	}

}
