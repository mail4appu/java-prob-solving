package test;

public class RegexTest {
    public static void main(String[] args) {
        String regex="^[a-zA-Z0-9_-]+$";
        String input="E5628EE2-C9C3-484F-B2D9-38E1F52D34B2";
        System.out.println(input.matches(regex));
    }
}
