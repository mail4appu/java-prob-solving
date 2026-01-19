package algorithms.hcl;

public class PalindromeStringOneExcusedChar {
    public static void main(String[] args) {
        String str = "aibohphobia";
        System.out.println(checkPalindrome(str.toCharArray()));

    }

    private static boolean checkPalindrome(char[] chars) {

        int size = chars.length;
        int counter = 0;

        int indexTobeCompared=0;

        for (int i = size - 1; i>=size/2; i--) {
             indexTobeCompared = Math.abs(i - (size-1));
            if (chars[indexTobeCompared] != chars[i] ) {
                counter++;
            }
            if(counter>1){
                return false;
            }
            if(i==indexTobeCompared){
                return true;
            }



        }
        return true;
    }
}
