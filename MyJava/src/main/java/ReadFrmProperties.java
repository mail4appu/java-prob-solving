/*import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import org.json.simple.JSONObject;


public class ReadFrmProperties {
public static void main(String[] args) {
	JSONObject json= new JSONObject();
		try {
			
			//String lang=LocaleContextHolder.getLocale().getLanguage();
			//String fileName="messages_"+lang+".properties";
			//BufferedReader br= new BufferedReader(new InputStreamReader( new FileInputStream(new File("/idrive/WEB-INF/"+fileName))));
			//TODO: the below line will be added further
			File file = new File("/home/Test/workspace/IDrive-I18N/resources/messages_fr.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();

			Enumeration enuKeys = properties.keys();
			//System.out.println(enuKeys);
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				//System.out.println(key);
				//if(key.equals("label.first.name")){
					json=continueToRead(enuKeys, properties);
					//break;
				//}
				
				//System.out.println(key + ": " + value);
			}
			System.out.println(json.toJSONString());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		//System.out.println("********"+json.toJSONString());
		
	}
private static JSONObject continueToRead(Enumeration enuKeys, Properties properties){
	JSONObject json= new JSONObject();
	while (enuKeys.hasMoreElements()) {
		String key = (String) enuKeys.nextElement();
		//if(key.equals("label.card.type")){
			//break;
		//}
		String value = properties.getProperty(key);
		json.put(key, value);
	}

	
	
	
	return  json;
	
}

}
*/