public class SearchRotatedSortedArray_21 {
    public static int rotatedBinarySearch(int array[],int l, int r, int key) {

        if (l > r) {
            return -1;
        }

        int mid = (l + r)/2;        
        if (array[mid] == key) {
            return mid;
        }
        
        if (array[mid] <= array[r]) {   // right side sorted
            if (array[mid] < key && key <= array[r]) {
                return rotatedBinarySearch(array, mid + 1, r, key);
            }
            else {
                return rotatedBinarySearch(array, l, mid - 1, key);
            }
        }
        else {            
            if (array[l] <= key && key < array[mid]) {
                return rotatedBinarySearch(array, l, mid - 1, key);
            }
            else {
                return rotatedBinarySearch(array, mid + 1, r, key);
            }            
        }        
    }

    public static void main(String[] args) {
        int [] array = {5,6,7,1,2,3,4};

        for (int i : array) {
            System.out.println(rotatedBinarySearch(array, 0, array.length - 1, i));
        }

        System.out.println(rotatedBinarySearch(array, 0, array.length - 1, 22));
    }
}
