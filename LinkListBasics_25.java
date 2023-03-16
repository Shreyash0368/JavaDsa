public class LinkListBasics_25 {
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
    private int size = 0;
    

    public void addFirst(int data) {
        size++;
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }    
    public void addLast(int data) {
        size++;
        Node newNode = new Node(data);

        if (tail == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }
    public void insertAtIndex(int data, int index) {
        size++;
        Node newNode = new Node(data);
        if (head == null) {
            System.out.println("Empty array");
            head = tail = newNode;
            return;
        }
        Node ptr = head;

        for (int i = 0; i < index - 1; i++) {
            ptr = ptr.next;
            if (ptr.next == null) {
                System.out.println("LL length insufficient, inserting at tail");
                ptr.next = newNode;
                tail = newNode;
                return;
            }
        }

        newNode.next = ptr.next;
        ptr.next = newNode;        
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
    public int sizeOfLL() {        
        return size;
    }

    public int deleteFirst() {
        
        if (head == null) {
            System.out.println("LL empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
        // newNode.
    }

    public int deleteLast() {
        if (tail == null) {
            System.out.println("LL empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = tail.data;
            head = tail = null;
            size--;
            return val;
        }

        Node ptr = head, prev = head;
        while (ptr.next != null) {
            prev = ptr;
            ptr = ptr.next;
        }
        int val = ptr.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
        
    }

    public void reverseLL() {

        if (size == 0 || size == 1) {
            return;
        }

        Node next = head, curr = head, prev = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        tail = head;
        head = prev;
    }

    public Node findMiddlenNode() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public boolean isLLPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }

        // 1 find middle element
        Node middle = findMiddlenNode();

        // 2 reverse the 2nd half of LL
        Node prev = null;
        Node curr = middle;
        Node next = middle;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // iterate simul from both sides and compare data till mid is reached
        Node leftHead = head;
        Node rightHead = prev;

        while (rightHead != null) {
            if (leftHead.data != rightHead.data) {
                return false;
            }
            rightHead = rightHead.next;
            leftHead = leftHead.next;
        }

        return true;

    }


    public static void main(String[] args) {
        LinkListBasics_25 ll = new LinkListBasics_25();       
        
        // ll.addFirst(5);
        // ll.addLast(6);
        // ll.addLast(7);
        // ll.addLast(8);
        // ll.printLL();
        // ll.insertAtIndex(11, 2);
        // ll.insertAtIndex(21, 4);
        // ll.printLL();
        // System.out.println(ll.sizeOfLL());
        // ll.reverseLL();
        // ll.printLL();
        // System.out.println(ll.sizeOfLL());
        // System.out.println(ll.deleteFirst());
        // System.out.println(ll.deleteLast());
        // ll.printLL();
        // System.out.println(ll.sizeOfLL());

        // ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(2);
        // ll.addLast(1);
        ll.printLL();
        System.out.println(ll.isLLPalindrome());
        
                

    }
}
