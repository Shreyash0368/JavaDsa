import java.util.Scanner;

// the goal is to convert aabbbccd -> a2b3c2d 
// incase a letter only occurs a single time then no need to append the number

public class StringCompression_17 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        Integer counter = 1; 
        // intializing the counter as Integer instead of int creates a counter 'object' instead of counter 'variable'
        // we do this because toString() function is only applicable to objects

        StringBuilder temp = new StringBuilder(); // string builder cause they are mutatable unlike strings
        temp = temp.append(s1.charAt(0));  // using s1[0] does not work in java
        // string concatenation is not applicable to stringbuilder, we can only use append 

        for (int i = 1; i < s1.length(); i++) {
            if (s1.charAt(i) == s1.charAt(i- 1)) {
                counter++;
            }
            else {
                if (counter > 1) { // if counter is > 1, only then append counter 
                    temp.append(counter.toString()); 
                }                        
                temp.append(s1.charAt(i)); // apend the next char after appending counter 
                counter = 1;                
            }
        }

        if (counter > 1) { // counter for the last char appended
            temp.append(counter.toString());
        }

        System.out.println(temp);
        sc.close();


    }
}
