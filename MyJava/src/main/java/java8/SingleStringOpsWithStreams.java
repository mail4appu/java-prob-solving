package java8;

import java.util.stream.Stream;

public class SingleStringOpsWithStreams {
    public static void main(String[] args) {
        //Check string has upperCase letter
        String input="niveDha";
        boolean upperCase=input.chars().anyMatch(ch->Character.isUpperCase(ch));
        System.out.println("Upper Case present in String: "+ upperCase);

        String numInput="12345";
        boolean allDigits = numInput.chars().anyMatch(ch -> (int) (ch - '0') >= 0);
        System.out.println("String has digits : "+allDigits);

        String numInput1="99999";
        boolean all9s= !numInput1.chars().anyMatch(ch->(int)(ch-'0')!=9);
        System.out.println("String has all 9s in it:  "+all9s);

        String strInput="NIVEDHA";
        boolean allUpperCase=strInput.chars().allMatch(ch->Character.isUpperCase(ch));
        System.out.println("String has all uppercase letters :"+allUpperCase);

        String str="I love Vizag";
        boolean contains= Stream.of(str.split(" ")).anyMatch(x->x.equals("Vizag"));
        System.out.println("String contains vizag : "+contains);
    }
}
