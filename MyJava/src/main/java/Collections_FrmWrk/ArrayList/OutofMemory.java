package Collections_FrmWrk.ArrayList;

import java.sql.SQLOutput;
import java.util.ArrayList;

/**
 * @author evarapp
 * The bset way to produce out of memory error
 *
 */
public class OutofMemory {

public static void main(String[] args) {
	ArrayList<String> strings= new ArrayList<String>();
	System.out.println(Runtime.getRuntime().maxMemory());
	try {
		Thread.sleep(30000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	while(true){
		strings.add("Life is beautiful");
		//System.out.println("life is beautiful");
		
	}
}

}
