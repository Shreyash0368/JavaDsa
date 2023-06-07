// public class QueueImplementation_28 {
//     public static class Queue {
//         private int [] array;
//         private int front;
//         private int rear;
//         private int size;

//         Queue (int size) {
//             array = new int[size];
//             this.size = size;
//             front = rear = -1;
//         }

//         public boolean isFull() {
//             return (rear + 1) % size == front;            
//         }

//         public boolean isEmpty() {
//             return rear == -1 && front == -1;
//         }

//         public void add (int data) {
//             if (isFull()) {
//                 System.out.println("queue full");
//                 return;
//             }

//             rear = (rear + 1) % size;
//             array[rear] = data;

//             if (front == -1) {
//                 front++;
//             }
//         }

//         public int remove() {
//             if (isEmpty()) {
//                 System.out.println("queue empty");
//                 return -1;
//             }

//             int top = array[front];
//             if (front == rear) {
//                 front = rear = -1;
//             }
//             else {
//                 front = (front + 1) % size;
//             }

//             return top;
//         }
//     }

//     public static void main(String[] args) {
//         Queue q1 = new Queue(6);
//         q1.add(1);
//         q1.add(2);
//         q1.add(3);
//         q1.add(4);

//         while (!q1.isEmpty()) {
//             System.out.println(q1.remove());
//         }
//         System.out.println(q1.remove());
//     }    
// }

import java.util.*;
public class QueueImplementation_28 {
    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<>(); //! queue in jcf is an innterface not a class

        q1.add(1);        
        q1.add(2);
        q1.add(3);
        q1.add(4);

        while (!q1.isEmpty()) {
            System.out.println(q1.remove());
        }
    }
}
