import java.util.ArrayList;

public class HeapBasics_35 {
    public static class Heap {
        private ArrayList<Integer> arr = new ArrayList<>();

        public void add(int val) {
            arr.add(val); // adding val to bottom of array

            int idx = arr.size() - 1;
            int parent = (idx - 1) / 2; // finding index of parent node

            while ((parent >= 0) && (arr.get(idx) < arr.get(parent))) { // incase of max heap use (arr.get(idx) >
                                                                        // arr.get(parent))
                int temp = arr.get(idx);
                arr.set(idx, arr.get(parent));
                arr.set(parent, temp);

                idx = parent;
                parent = (idx - 1) / 2;
            }
        }

        public int peek() {
            return arr.get(0);
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }

        private void heapify(int idx) {
            int left = idx * 2 + 1;
            int right = idx * 2 + 2;
            int minIdx = idx; // use maxIdx for max heap

            if (left < arr.size() && arr.get(minIdx) > arr.get(left)) { // for max heap use arr.get(minIdx) <
                                                                        // arr.get(left) same for right
                minIdx = left;
            }

            if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }

            if (minIdx != idx) {
                int temp = arr.get(idx);
                arr.set(idx, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        public void remove() {
            // swaping 0 and last element
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // removing the now last element
            arr.remove(arr.size() - 1);

            // heapify the remaining heap (due to swap the heap role has been broken)
            heapify(0);
        }

    }

    public static void heapify(int array[], int idx, int size) {
        int left = idx * 2 + 1;
        int right = idx * 2 + 2;
        int maxIdx = idx;

        if (left < size && array[maxIdx] < array[left]) {
            maxIdx = left;
        }
        if (right < size && array[maxIdx] < array[right]) {
            maxIdx = right;
        }

        if (maxIdx != idx) {
            int temp = array[idx];
            array[idx] = array[maxIdx];
            array[maxIdx] = temp;

            heapify(array, maxIdx, size);
        }
    }

    public static void heapSort(int arr[]) {
        int n = arr.length;
        // converting the array to a max heap
        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, i, n);
        }

        // after converting to max heap start taking out the top elmnt and storing in a
        // new array
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.add(4);
        heap.add(2);
        heap.add(1);
        heap.add(3);

        while (!heap.isEmpty()) {
            System.out.print(heap.peek() + " ");
            heap.remove();
        }
        System.out.println();
    }

}
