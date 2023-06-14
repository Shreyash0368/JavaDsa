// ? using 2 queues to create a stack
// simm. to prev but here we will use pop as the o(n)

import java.util.*;
public class Queue2Stack_28 {
    public static class Stack {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        public boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        public void push(int data) {
            if (!q1.isEmpty()) {
                q1.add(data);
            }
            else {
                q2.add(data);
            }
        }

        public int pop() {            
            if (isEmpty()) {
                return -1;
            }
            
            int top = -1;
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) {
                        break;
                    }
                    q2.add(top);
                }
            }
            else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }
            }

            return top;
        }

    }

    public static void main(String[] args) {
        Stack s1 = new Stack();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(4);

       while (!s1.isEmpty()) {
        System.out.println(s1.pop());
       }

    }
    
}
