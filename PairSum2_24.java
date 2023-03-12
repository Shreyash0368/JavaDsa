public class PairSum2_24 {
    // check whether a pair is possible for given sum in the sorted and ROTATED array
    public static boolean pairSum2(int array[], int key) {
        // loop for finding pivot
        int right = 0, left = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[i + 1]) {
                right = i;
                left = i + 1;
                break;
            }
        }

        while (left != right) {
            if (array[left] + array[right] == key) {
                return true;
            } 
            else if (array[left] + array[right] < key) {
                left = (left + 1) % array.length;                
            }
            else {
                right = (right - 1 + array.length) % array.length;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int array[] = {6,7,8,1,2,3,4,5};
        System.out.println(pairSum2(array, 8));
        
    }

}
