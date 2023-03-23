import java.util.*;

public class ZigZagLL {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;            
        }        
    }
    private Node head;
    private Node tail;

    
    public void addFirst(int data) {        
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        
        Node newNode = new Node(data);

        if (tail == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void printLL() {
        Node ptr = head;
        if (ptr == null) {
            System.out.println("LL empty");
            return;
        }

        while (ptr != null) {
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }


    public void zigZagLL () {
        // get middle 
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // rotating 2nd half

        Node curr = slow.next;
        Node next, prev = null;
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        // seprating the two halfs
        Node leftHead = head;
        Node rightHead = prev;
        Node leftNext,rightNext;
        
        slow.next = null;

        // merging in zig zag        
        while (leftHead != null && rightHead != null) {            
            leftNext = leftHead.next;
            rightNext = rightHead.next;

            leftHead.next = rightHead;
            rightHead.next = leftNext;

            leftHead = leftNext;
            rightHead = rightNext;            
        }        
    } 

    public static void main(String[] args) {
        ZigZagLL ll = new ZigZagLL();
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);

        ll.printLL();
        ll.zigZagLL();
        ll.printLL();

        System.out.println();
        System.out.println("Java collection linked list");
        LinkedList<Integer> ll2 = new LinkedList<>();
        ll2.addFirst(1);
        ll2.addLast(2);
        ll2.addLast(2);
        ll2.addLast(2);
        System.out.println(ll2);

        
    }
}
