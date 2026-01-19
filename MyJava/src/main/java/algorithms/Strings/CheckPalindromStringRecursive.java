package algorithms.Strings;

public class CheckPalindromStringRecursive {
   static int j=0;
    static int i=0;
    public static void main(String[] args) {
        String str="NITIN";
        System.out.println(checkPalindrome(str.toCharArray(), j));
    }

    private static boolean checkPalindrome(char[] chars, int j) {

        if(chars.length==j){
            return true;
        }
        boolean b = checkPalindrome(chars, j + 1);
        if(b==false){
            return false;
        }
        if(i<chars.length){
            if(chars[i]!=chars[j]){

               return false ;
            }
            i++;
        }

        return true;


    }
}
