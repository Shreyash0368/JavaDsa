import java.util.*;

public class MaxAreaHistogram_27 {
    public static void prevSmaller(int arr[], int smaller[]) {
        Stack<Integer> temp = new Stack<>();
        temp.push(0);
        smaller[0] = -1;

        for (int i = 1; i < arr.length; i++) {
            while (temp.isEmpty() == false && arr[temp.peek()] >= arr[i]) {
                temp.pop();
            }

            if (temp.isEmpty()) {
                smaller[i] = -1;
            }
            else {
                smaller[i] = temp.peek();
            }

            temp.push(i);
        }
    }

    public static void nextSmaller(int arr[], int smaller[]) {
        Stack<Integer> temp = new Stack<>();
        temp.push(arr.length - 1);
        smaller[arr.length - 1] = arr.length;

        for (int i = arr.length - 2; i >= 0; i--) {
            while (temp.isEmpty() == false && arr[temp.peek()] >= arr[i]) {
                temp.pop();
            }

            if (temp.isEmpty()) {
                smaller[i] = arr.length;
            }
            else {
                smaller[i] = temp.peek();
            }

            temp.push(i);
        }
    }

    public static int maxAreaHistogram(int array[]) {
        int [] leftLimit = new int[array.length];
        int [] rightLimit = new int[array.length];

        prevSmaller(array, leftLimit);
        nextSmaller(array, rightLimit);
        int maxArea=0;

        for (int i = 0; i < array.length; i++) {
            int length = Math.abs(rightLimit[i] - leftLimit[i] - 1);
            int area = array[i] * length;
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;        
    }

    public static void main(String[] args) {
        int [] arr = {2,1,5,6,2,3};
        int[] smaller = new int[arr.length];
        
        prevSmaller(arr, smaller);
        for (int i = 0; i < smaller.length; i++) {
            System.out.print(smaller[i] + " ");
        }
        System.out.println();
        nextSmaller(arr, smaller);
        for (int i = 0; i < smaller.length; i++) {
            System.out.print(smaller[i] + " ");
        }
        System.out.println();
        
       System.out.println(maxAreaHistogram(arr));
    }

}
