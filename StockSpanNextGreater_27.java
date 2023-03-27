import java.util.Stack;

public class StockSpanNextGreater_27 {
    public static void stockSpan(int[] stock, int[] span) {
        Stack<Integer> temp = new Stack<>();
        temp.push(0);
        span[0] = 1;

        for (int i = 1; i < stock.length; i++) {
            while (temp.isEmpty() == false && stock[i] >= stock[temp.peek()]) {
                temp.pop();
            }

            if (temp.isEmpty()) {
                span[i] = i + 1;
            }
            else {
                int prevHigh = temp.peek();
                span[i] = i - prevHigh;
            }

            temp.push(i);
        }
    }
    
    public static void nextGreaterElement(int[] num, int[] greater) {
        Stack<Integer> temp = new Stack<>();
        temp.push(num[num.length - 1]);
        greater[greater.length - 1] = -1;

        for (int i = num.length - 2; i >=0; i--) {
            while (temp.isEmpty() == false && num[i] >= temp.peek()) {
                temp.pop();
            }

            if (temp.isEmpty()) {
                greater[i] = -1;
            }
            else {
                greater[i] = temp.peek();
            }

            temp.push(num[i]);
        }

    }

    public static void main(String[] args) {
        int[] stock = {100, 80, 60, 70, 60, 85, 100};
        int[] span = new int[stock.length]; 

        stockSpan(stock, span);

        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i] + " ");
        }
        System.out.println();

        
        int[] arr = {6,8,0,1,3};
        int[] greater = new int[arr.length];
        
        nextGreaterElement(arr, greater);
        for (int i = 0; i < greater.length; i++) {
            System.out.print(greater[i] + " ");
        }
        System.out.println();

    }
    
}
