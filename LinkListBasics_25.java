public class LinkListBasics_25 {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }        
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);

        if (this.head == null) {
            this.head = tail = newNode;
            return;
        }

        newNode.next = this.head;
        this.head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);

        if (tail == null) {
            this.head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void printLL() {
        Node ptr = this.head;
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

    public void insertAtIndex(int data, int index) {
        Node newNode = new Node(data);
        if (this.head == null) {
            System.out.println("Empty array");
            this.head = tail = newNode;
            return;
        }
        Node ptr = this.head;

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

    public int sizeOfLL() {
        if (this.head == null) {
            return 0;
        }
        int count = 0;
        Node ptr = this.head;

        while (ptr != null) {
            ptr = ptr.next;
            count++;
        }
        return count;
    }

    public Node head;
    public Node tail;

    public static void main(String[] args) {
        LinkListBasics_25 ll = new LinkListBasics_25();
        
        
        ll.addFirst(5);
        ll.addLast(6);
        ll.addLast(7);
        ll.addLast(8);
        ll.printLL();
        ll.insertAtIndex(11, 2);
        ll.insertAtIndex(21, 4);
        ll.printLL();
        System.out.println(ll.sizeOfLL());
                

    }
}
