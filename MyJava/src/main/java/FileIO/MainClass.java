package FileIO;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class MainClass {
	public static void main(String args[]){
	String dirname="C:/Default/Plugins";	
	File dir= new File(dirname);
	
	String[] filenames=dir.list(new FilenameFilter(){
		@Override
		public boolean  accept(File arg0, String arg1){
			System.out.println("arg0 contains"+arg0+"arg1 contains"+arg1);
			return arg1.endsWith(".class");
		}
		
	});
	System.out.println("filenames contain"+Arrays.toString(filenames));	
	}

}
