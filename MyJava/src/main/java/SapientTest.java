import java.io.IOException;
import java.util.HashMap;

 class SapientTest {
public static void main(String[] args) {
	String str="abc";
	HashMap map= new HashMap();
	map.put("1", "two");
	map.put(2, "four");
	try{
		throw new IOException();
	}catch(Exception ex){
		
	}
	int x=2;
	final char j='2';
	switch (x) {
	case 1:
		System.out.println("1");
		break;
	case 2:
		System.out.println("10");
		break;
	case j:
		System.out.println("2");
		break;
	case 5:
		System.out.println("5");
		break;
	default:
		break;
	}
	
	
}
}
