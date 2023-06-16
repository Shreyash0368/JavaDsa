// here the string is not passed entierly but 1 char at a time 


import java.util.*;

public class FirstNonRepeating_28 {
    public static void firstNonrepeatingLetter(String str) {
        Queue<Character> temp = new LinkedList<>();
        int [] frequencyChar = new int[26]; // array for maintaing total freq of each alphabet

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            frequencyChar[ch - 'a']++; // increment freq of the curr char
            temp.add(ch); 

            // if the freq of current char is greater than 1 that means its repeating
            // the only char in queue are the ones that have not been repeated and since we only need the first non repeating char 
            // we can return the last element of queue aka the first non repeating (element that came in first)
            while ((!temp.isEmpty()) && (frequencyChar[temp.peek() - 'a'] > 1)) {
                temp.remove();
            }

            if (temp.isEmpty()) {   // if queue empty that means all char are repeating in string
                System.out.println("-1");               
            }
            else { 
                System.out.println(temp.peek());
            }
        }
    }

    public static void main(String[] args) {
        String str = "hhhffvmvc";
        firstNonrepeatingLetter(str);
        
    }
}
