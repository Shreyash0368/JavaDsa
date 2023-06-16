import java.util.*;


public class Deque_28 {
    public static void main(String[] args) {
        Deque<Integer> deq = new LinkedList<>();

        deq.addFirst(1);
        deq.addFirst(2);
        deq.addFirst(3);

        System.out.println(deq);
        deq.removeFirst();
        System.out.println(deq);
        
    }
}
