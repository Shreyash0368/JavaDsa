public class StairCaseSearch {

    public static boolean stairCaseSearch(int [][] array, int key) {
        int i = 0;
        int j = array[0].length - 1;
        
        while (i >= 0 && i < array.length && j >= 0 && j < array[0].length) {
            if(array[i][j] == key) {
                System.out.println(key +" found at: "+ i +", "+ j);
                return true;
            }
            else if (array[i][j] > key) {
                j--;
            }
            else if (array[i][j] < key) {
                i++;
            }
        }

        System.out.println("key " + key + " not found");
        return false;
    }
    public static void main(String[] args) {
        int [][] array = {{10,20,30,40}, {15,25,35,45}, {27,29,37,48},{32,33,39,50}};
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                stairCaseSearch(array, array[i][j]);                
            }
        }
        
    }
}
