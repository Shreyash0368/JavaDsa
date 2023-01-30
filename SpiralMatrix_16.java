public class SpiralMatrix_16 {
    public static void spiralprint(int [][] array) {
        int n = array.length;
        int m = array[0].length;
        int startRow = 0, endRow = n - 1, startCol = 0, endCol = m -1;
        while (startRow < endRow || startCol < endCol) {
            // int i = startRow;
            for (int j = startCol; j <= endCol; j++) {
                System.out.print(array[startRow][j] + " ");
            }

            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(array[i][endCol] + " ");
            }

            for (int j = endCol - 1; j >= startCol; j--) {
                System.out.print(array[endRow][j] + " ");
            }

            for (int i = endRow - 1; i >= startRow + 1; i--) {
                System.out.print(array[i][startCol] + " ");
            }

            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }  
        
    }

    public static void main(String[] args) {
        int [][] array = {{1,2,3, 11}, {4,5,6, 22}, {7,8,9, 33}, {2,3,5, 44}};
        spiralprint(array);

        
    }
}
