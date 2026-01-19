package Hashing;



public class HashingMainClass {
	public static void main(String args[]){
		
	//this is called composition. Creating another class object and Calling its method is known as compostion	
	HashingObject ho1=new HashingObject();
	
	HashingObject ho2=new HashingObject();
	
	ho1.setNativPlace("Vizag");
	ho1.setWrkingPlace("Hyd");
	ho2.setNativPlace("Vizag");
	ho2.setWrkingPlace("Delhi");
	/*int hashcode1=ho1.hashCode();
	int hashcode2=ho2.hashCode();*/
	//see the equals and hashcode methods results without overriding 
	System.out.println("two objects "+ho1.equals(ho2));
	System.out.println("hascode of ho1"+ho1.hashcode());
	System.out.println("hascode of ho2"+ho2.hashcode());
	//printing the padded binary string of length 8 bits using StringUtils class 
	//System.out.println(org.apache.commons.lang.StringUtils.leftPad(Integer.toBinaryString(5), 8, '0'));
	}	


}
