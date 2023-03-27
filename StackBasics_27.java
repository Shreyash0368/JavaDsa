import java.util.Stack;

public class StackBasics_27 {  
    public static void insertAtBottom(Stack<Integer> s, int digit) {
        if (s.isEmpty()) {
            s.push(digit);
            return;
        }

        int top = s.pop();
        insertAtBottom(s, digit);
        s.push(top);
    }
    
    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        
        int top = s.pop();
        reverseStack(s);
        insertAtBottom(s, top);
    }
    
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        System.out.println(stack);
        insertAtBottom(stack, 7);
        System.out.println(stack);
        reverseStack(stack);
        System.out.println(stack);


    }
}
