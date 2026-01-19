
public class Casting_Example {
	public static void main(String args[])
    { 
		int a;
        class Foo 
        {
            public int i = 3;
        } 
        Object o = new Object();//gives class cast exception
        Object o1=new Integer(5);//here we chk whether integer is subclass
                                        // of Object . if not Class Cast Exception
       //Foo foo = (Foo)o;
        System.out.println("i = " );
        Object x = new Integer(0);
        float t=2.3f;
       
        
        
        //System.out.println((String)x);

    }

}
