import java.util.Scanner;

public class ToUpperCase_17 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s1 = sc.nextLine();
        

        StringBuilder temp = new StringBuilder();
        temp.append(s1);
        temp.setCharAt(0, Character.toUpperCase(s1.charAt(0)));  
        // System.out.println(temp);    
        
        for (int i = 1; i < temp.length(); i++) {
            if (temp.charAt(i-1) == ' ') {
                temp.setCharAt(i, Character.toUpperCase(temp.charAt(i)));
            }
        }

        s1 = temp.toString();
        System.out.println(s1);

        sc.close();
    }

}
