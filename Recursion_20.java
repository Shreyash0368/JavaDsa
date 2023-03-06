public class Recursion_20 {
    static int i = 0;

    public static void printDecreasingOrder(int n) {
        System.out.print(n + " ");
        n--;
        if (n >= 1) {
            printDecreasingOrder(n);
        }        
    }

    public static void printIncreasingOrder(int n) {
        n--;
        if (n >= 1) {
            printIncreasingOrder(n);
        }

        System.out.print(n + 1 + " ");        
    }

    public static int sumOfNumbers(int n) {
        if(n == 1){
            return 1;
        }
        return n + sumOfNumbers(n - 1);
    }

    public static long fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static boolean checkArrayIfSorted(int array[], int i) {        
        if (i == array.length - 1) {
            return true;
        }
       if (array[i] > array[i+1]) {
            return false;
       }

       return checkArrayIfSorted(array, i+1);        
    }

    public static int checkFirstOccurence(int array[], int i, int key) {
        if (i == array.length - 1 && array[i] != key) {
            return -1;
        }

        if (array[i] == key) {
            return i;
        }

        return checkFirstOccurence(array, i+1, key);
    }

    public static int checkLastOccurence(int array[], int i, int key) {
        if (i == 0 && array[i] != key) {
            return -1;
        }

        if (array[i] == key) {
            return i;
        }

        return checkFirstOccurence(array, i-1, key);
    }

    public static long power(int x, int n) {
        if ( n == 0) {
            return 1;
        }

        return x * power(x, n - 1);
    }

    public static long optimizedPower(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }

        // 2^10 = 2^5 * 2^5 => x^n = x^n/2 * x^n/2     (incase n = even), here we only have to do half the required calculations
        // 2^11 = 2 * 2^5 * 2^5 => x^n = x * x^n/2 * x^n/2 (incase n = odd)

        if (n % 2 == 0) {
            return optimizedPower(x, n/2) * optimizedPower(x, n/2);
        }
        else {
            return x * optimizedPower(x, n/2) * optimizedPower(x, n/2);
        }
    }

    public static void reversestring(String s, int i) {
        if (i < s.length() - 1) {
            reversestring(s, i + 1);    
        }
        System.out.print(s.charAt(i));
    }

    public static String removeDuplicate(String s1, int i) {
        
        // flag is used to check whether a char was deleted or not, if char was deleted we donot need to increment i 
        boolean flag = false;
        StringBuilder temp = new StringBuilder(s1);
        
        if(i >= s1.length()) {
            return s1;
        }

        if (i > 0 && (temp.charAt(i - 1) == temp.charAt(i))) {
            flag = true;
            temp.deleteCharAt(i);
            if (i == temp.length()) {                
                return temp.toString();
            }
        }

        if (flag) {
            return removeDuplicate(temp.toString(), i);
        } 
        else {
            return removeDuplicate(temp.toString(), i+1);
        }
    }

    public static void main(String[] args) {
        
        // Printing in increaasing and decreasing order
        // printIncreasingOrder(10);
        // System.out.println();
        // printDecreasingOrder(10);
        // System.out.println();

        // sum of 1 to n
        // System.out.println(sumOfNumbers(10));

        // System.out.println(fibonacci(25));

        // checking if array is sorted 
        // int [] array = {1,2,3,4,5};
        // if (checkArrayIfSorted(array, 0)) {
        //     System.out.println("sorted");            
        // }
        // else {
        //     System.out.println("unsorted");
        // }
        
        // first occurence and last occurence 
        // int [] array2 = {8,3,6,9,5,10,2,5,3};
        // System.out.println(checkFirstOccurence(array2, 0, 11));
        // System.out.println(checkLastOccurence(array2, array2.length - 1, 11));

        // calculating
        // System.out.println(optimizedPower(5, 20));
        // System.out.println(power(5, 20));

        // reversestring("hello", 0);
        System.out.println(removeDuplicate("hhheeeellooo", 0));

        
    }
}
