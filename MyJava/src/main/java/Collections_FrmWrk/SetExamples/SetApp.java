package Collections_FrmWrk.SetExamples;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Generating set out of a String
 *
 * This is just 2 line code in case of Python
 *
 * myset=set("myString")
 * print(myset)
 *
 * similarly with list too
 *
 */
public class SetApp {
    public static void main(String[] args) {
        Set myset=new HashSet();
        char[] chars = "myString".toCharArray();
        for(char ch:chars){
            myset.add(ch);
        }
        System.out.println(myset);
    }

}
