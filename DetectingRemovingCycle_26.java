public class DetectingRemovingCycle_26 {
    public static class Node {
        int data;
        Node next;

        Node (int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public boolean detecticngCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }                
        }

        return false;
    }

    public void removingCycle() {
        if (this.detecticngCycle() == false) {
            System.out.println("No cycle exists");
            return; 
        }

        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }                
        }
       
        slow = head;
        Node prev = null;
        
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;      
                         
        }
        
        prev.next = null;
    }

    public void printLL() {
        Node ptr = head;
        int n = 0;

        while (ptr != null & n < 10) {
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
            n++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DetectingRemovingCycle_26 ll = new DetectingRemovingCycle_26();

        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = temp;

        // 1->2->3->4->2

        System.out.println(ll.detecticngCycle());
        ll.printLL();
        ll.removingCycle();
        ll.printLL();
        ll.removingCycle();

        
    }
}
