
public class BackTrackingBasics_23 {
    public static void backTrackArray(int array[], int i) {
        // first traverse the array and assign the value of index + 1, i.e array = 1 2 3 4 5 (here)
        // after reaching the last index traverse the array again in reverse order and subtract 2 from each element
        // i.e. array = -1 0 1 2 3 (after complete function) 

        array[i] = i + 1;   
        if (i < array.length - 1) {
            backTrackArray(array, i + 1);
        } 
        array[i] = array[i] - 2;        
    }

    // select all possibe subsets from the given strings
    public static void stringSubset(String str, String ans, int i) {
        // iterate over each char of the string and have two recursion call based on whwether the char is selected or not,
        // we maintain an ans string which is created for each new function call  which store the current possoble combination of string 

        // base case,  after iterating when we go over the last char then print the ans string 
        if (i == str.length()) {
            System.out.println(ans);
            return;
        }

        // recursion
        // select char, if current char is selected than add it to ans string and switch to next char, else do not add the current char but still move to the next char  
        stringSubset(str, ans + str.charAt(i), i+1);
        // dont select char
        stringSubset(str, ans, i+1);
    }

    public static void stringPermutation(String str, String ans) {
        
        // base case 
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        // recursion
        for (int j = 0; j < str.length(); j++) {
            char currentChar = str.charAt(j);
            String newStr = str.substring(0, j) + str.substring(j+1, str.length());
            stringPermutation(newStr, ans+ currentChar);
        }

    }

    // *grid ways,
    //  given and n*m 2D array, find the no of possible paths that a point from 0,0 to n-1,m-1.
    // we can move in only two directions either right or down

    public static int gridWays(int array[][], int x, int y) {
        if (x == array.length - 1 || y == array[0].length - 1) {  // if we are in the last row or column then there is only 1 possible path to reach the end point
            return 1;
        } else if (x == array.length || y == array[0].length) { // out of bounds .i.e. no possible way
            return 0;
        }

        return gridWays(array, x+1, y) + gridWays(array, x, y+1); // for a point x,y the no of possible ways are equal to the sum of possible ways of the cell at adjacent right and adjacent down
    }

    public static void main(String[] args) {
        // int [] array = new int[5];
        // backTrackArray(array, 0);

        // for (int i = 0; i < array.length; i++) {
        //     System.out.print(array[i] + " ");
        // }
        
        int n = 3;
        int array[][] = new int[n][n];

        String ans = new String();
        // stringSubset("abc", ans, 0);
        stringPermutation("abc", ans);

        System.out.println(gridWays(array, 0, 0));

    }
}
