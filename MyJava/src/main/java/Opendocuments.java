
/**
 * @author vapparao
 *This class opens the documents from your operating system so that u can see its cont
 */
public class Opendocuments {
	public static void main(String args[])throws Exception{
		String fileName="C:/Documents and Settings/vapparao/Desktop/abc.xml";
		String doucmentName="cmd /c \""+fileName+"\"";
				
		Runtime.getRuntime().exec(doucmentName);
		System.out.println("done with opening");
	}

}
