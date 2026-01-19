package algorithms.hcl;

import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        System.out.println("Enter a string");
        Scanner scanner= new Scanner(System.in);
        String input=scanner.nextLine();
        BalancedBrackets balancedBrackets= new BalancedBrackets();
        System.out.println(balancedBrackets.isBalanced(input));
    }

    public  boolean isBalanced(String input) {
        Stack<Character> characterStack= new Stack<>();

        if(Objects.nonNull(input)) {
            for (char ch : input.toCharArray()) {    //Push {, [, ( in stack
                if (ch == '{' || ch == '[' || ch == '(') {
                    characterStack.push(ch);
                } else if (ch == '}' || ch == ']' || ch == ')') {
                    if (characterStack.isEmpty()) { //=> No matching bracket found in stack
                        return false;
                    }
                    Character charRemoved = characterStack.pop(); //Removed char should match opposite bracket in below step
                    if ((charRemoved == '{' && ch != '}') || (charRemoved == '[' && ch != ']') || (charRemoved == '(' && ch != ')')) {
                        return false;
                    }
                } else { // non bracket input
                    return false;
                }
            }
        }

        return characterStack.empty();
    }
}
