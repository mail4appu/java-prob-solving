package algorithms
;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author evarapp
 * 
 * Here the trick z using stacks push and pop methods
 * When opening parenthesis is encountered, push it in stack and when closing parenthesis encountered pop from stack
 * {{()}}
 * above is balanced, because in the balanced order of opening and closing parenthesis are more important.
 * 
 * {{(})}--this is not balanced
 *
 */
public class BalancedParanthesis {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Plese enter a String");
		String input= sc.nextLine();
		System.out.println(checkBalanced(input));

	}

	private static String checkBalanced(String input) {
		Stack<Character> charStack=new Stack<Character>();
		for(int i=0;i<input.length();i++){
			char ch=input.charAt(i);
			if(ch=='(' || ch=='{' || ch=='['){
				charStack.push(ch);
			}
			else if(ch==')'){
				if(charStack.isEmpty())return "notbalanced";
				//this below statement states that, while traversing if ')', last/top element of statck should be opening parenthesis '('. 
				//if not return false. 
				if(charStack.pop()!='(') return "notbalanced";
			}
			else if(ch=='}'){
				if(charStack.isEmpty())return "notbalanced";
				if(charStack.pop()!='{') return "notbalanced";
			}
			else if(ch==']'){
				if(charStack.isEmpty())return "notbalanced";
				if(charStack.pop()!='[') return "notbalanced";
			}
		}
		return charStack.isEmpty()?"balanced":"notbalanced";
		
	}

	
}
