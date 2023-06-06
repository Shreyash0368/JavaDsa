import java.util.Stack;

public class ParenthesisCheck_27 {
    public static boolean bracketCheck(char a, char b) {
        if (a == '(' && b == ')') {
            return true;
        }
        if (a == '{' && b == '}') {
            return true;
        }
        if (a == '[' && b == ']') {
            return true;
        }        
        return false;
    }

    public static boolean validParanthesis(String str) {
        Stack<Character> temp = new Stack<>();

        for (int i = 0; i < str.length(); i++) {            
            if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {
                temp.push(str.charAt(i));                
            }
            else if (str.charAt(i) == ')' || str.charAt(i) == ']' || str.charAt(i) == '}'){
                if (temp.isEmpty()) {
                    return false;
                }

                char x = temp.pop();
                if (bracketCheck(x, str.charAt(i))) {
                    continue;
                }else {
                    return false;
                }
            }
        }

        if (temp.isEmpty() == false) {            
            return false;
        }
        return true;
    }

    public static boolean duplicateParenthesis(String str) {
        Stack<Character> temp = new Stack<>();

        for (int i = 0; i < str.length(); i++) {            
            if (str.charAt(i) != ')' && str.charAt(i) != '}' && str.charAt(i) != ']') {
                temp.push(str.charAt(i));                
            }
            else if (str.charAt(i) == ')' || str.charAt(i) == ']' || str.charAt(i) == '}'){                                
                int count = 0;
                while ((temp.isEmpty() == false) && (temp.peek() != '(' && temp.peek() != '[' && temp.peek() != '{')) {
                    temp.pop();
                    count++;                    
                }
                
                if (temp.isEmpty()) {
                    return false;
                }

                char x = temp.pop();
                if (bracketCheck(x, str.charAt(i)) && count > 0) {
                    continue;
                }else {
                    return false;
                }
            }
        }

        if (temp.isEmpty() == false) {            
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        

        String str = "(a+b)+(c+d)";
        System.out.println(duplicateParenthesis(str));
        
    }
    
}
