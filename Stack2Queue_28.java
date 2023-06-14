//? using 2 stacks to make a queue
// we have to either modify the push operation to O(n) 
// if s1 is empty than push into s1, if not than first empty s1 into s2 then push the new data into s1
// now return content of s2 into s1 

import java.util.Stack;

public class Stack2Queue_28 {
    public static class Queue {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
    

        public boolean isEmpty() {
            return s1.isEmpty();
        }

        public void add(int data) {
            if (s1.isEmpty()) {
                s1.push(data);
                return;
            }
            else {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
                s1.push(data);
                while (!s2.isEmpty()) {
                    s1.push(s2.pop());
                }
            }
        }

        public int pop() {
            return s1.pop();
        }
    }

    public static void main(String[] args) {
        Queue q1 = new Queue();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.add(4);

        while (!q1.isEmpty()) {
            System.out.println(q1.pop());
        }
    }
    
}
