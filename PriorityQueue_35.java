import java.util.*;

public class PriorityQueue_35 {
        // for a user class to be used in PQ we need to implement Comparable<Class> 
    public static class Student implements Comparable<Student> {
        int rollNo;
        String name;

        public Student(int rollNo, String name) {
            this.rollNo = rollNo;
            this.name = name;
        }

        @Override
        public int compareTo(Student s2) { // using s2 - this will give descending order (we can use any class attribute for comparison)
            return this.rollNo - s2.rollNo;
        }
    }

    public static void main(String[] args) {
        // min heap (default)
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        minPQ.add(3);
        minPQ.add(4);
        minPQ.add(1);
        minPQ.add(6);
        minPQ.add(2);

        while (!minPQ.isEmpty()) {
            System.out.print(minPQ.peek() + " ");
            minPQ.remove();
        }
        System.out.println();

        // max heap (using comparator)
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
        maxPQ.add(3);
        maxPQ.add(4);
        maxPQ.add(1);
        maxPQ.add(6);
        maxPQ.add(2);

        while (!maxPQ.isEmpty()) {
            System.out.print(maxPQ.peek() + " ");
            maxPQ.remove();
        }
        System.out.println();

        // PQ with class
        PriorityQueue<Student> studentPQ = new PriorityQueue<>(); // we can also use reverseOrder here
        studentPQ.add(new Student(4, "A"));
        studentPQ.add(new Student(3, "B"));
        studentPQ.add(new Student(1, "C"));
        studentPQ.add(new Student(2, "D"));

        while (!studentPQ.isEmpty()) {
            System.out.println(studentPQ.peek().name + " : " + studentPQ.peek().rollNo);
            studentPQ.remove();
        }
        // System.out.println();

    }


}
