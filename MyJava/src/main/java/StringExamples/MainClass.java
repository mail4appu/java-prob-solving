package StringExamples;

/**
 * @author vapparao
 * both string and StringBuffer have length() but StringBuffer/Builder has capacity. It comes with buffer size 16.
 *
 *
 */
public class MainClass {
 public static void main(String []args){
		String s="appu";
		
		String a="120";
		Integer.parseInt(a);
		StringBuffer sb=new StringBuffer("abcdefghijklmnopqrstuvwxyz");//the primary operations include in sb and sbldr are append and insert aprart from reverse
		sb.insert(3,"saleem");//the index at which string should be inserted
		StringBuilder sbldr= new StringBuilder("def");
		try{
		for(int i=0;i<10;i++){
		Thread.sleep(1000);	
		System.out.println("reversed buffer:   "+sb.reverse()+"   and its capacity: "+sb.capacity()+"--"+"string buffer length"+sb.length());
		}
		}
		catch(Exception ex){
		}
		}
		
	}

