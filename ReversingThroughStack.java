import java.util.*;

// implementing stack using arrayList and LL is same as in cpp
public class ReversingThroughStack {
    public static void pushAtBottom(Stack<Integer> s, int digit) {
        if (s.isEmpty()) {
            s.push(digit);
            return;
        }

        int top = s.pop();
        pushAtBottom(s, digit);
        s.push(top);
    }

    public static String reverseString(String s) {
        Stack<Character> temp = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            temp.push(s.charAt(i));
        }

        StringBuilder newString = new StringBuilder();

        while (temp.isEmpty() == false) {
            newString.append(temp.pop());
        }

        return newString.toString();
    }

    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }

        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    public static void printStack(Stack<Integer> s) {
        while (s.isEmpty() == false) {
            System.out.println(s.pop() + " ");            
        }
        // System.out.println();
    }
    
    public static void main(String[] args) {

        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        // printStack(s);
        pushAtBottom(s, 5);
        printStack(s);

        String string = "hello";
        System.out.println(string);
        string = reverseString(string);
        System.out.println(string);

        Stack<Integer> s2 = new Stack<>();
        s2.push(1);
        s2.push(0);
        s2.push(2);
        s2.push(3);
        s2.push(4);

        reverseStack(s2);
        printStack(s2);
        
        
    }
}
