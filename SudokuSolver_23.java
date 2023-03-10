public class SudokuSolver_23 {
    public static boolean isSafe(int sudoku[][], int row, int col, int digit) {
        // checking current col
        for (int i = 0; i <= 8; i++) {
            if (sudoku[i][col] == digit) {
                return false;
            }
        }
        
        // checking current row
        for (int j = 0; j <= 8; j++) {
            if (sudoku[row][j] == digit) {
                return false;
            }            
        }

        // checking current 3x3 matrix
        int startRow = (row/3) * 3;
        int startCol = (col/3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (sudoku[i][j] == digit) {
                    return false;
                }  
            }
        }

        return true;
    }

    public static boolean sudokuSolver(int sudoku[][], int row, int col) {
        // base case
        if (row == 9) { // we have reached the end of sudoku (only if all prev cells had a vlue inserted into them)
            return true;
        }

        // recusrions
        int nextRow = row, nextCol = col + 1;
        if (nextCol == 9) { // switch to next row after end of columns
            nextRow++;
            nextCol = 0;
        }

        if (sudoku[row][col] != 0) {
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        for (int digit = 1; digit <= 9; digit++) {           
            if (isSafe(sudoku, row, col, digit)) { // checking if digit can be placed in the current cell or not
                sudoku[row][col] = digit;
                if(sudokuSolver(sudoku, nextRow, nextCol)) { // if solution exists
                    return true;
                }      
                sudoku[row][col] = 0;                   
            }
                            
        } // if for a particular cell no value from 1-9 can be placed the its an unsolvable sudoku (either the prev inserted values are wrong (hence the back tracking) or the input itself is wrong)
        return false;
    }

    public static void printSudoku(int sudoku[][]) {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    
    public static void main(String[] args) {
        int sudoku[][] = { {3, 0, 6, 5, 0, 8, 4, 0, 0},
        {5, 2, 0, 0, 0, 0, 0, 0, 0},
        {0, 8, 7, 0, 0, 0, 0, 3, 1},
        {0, 0, 3, 0, 1, 0, 0, 8, 0},
        {9, 0, 0, 8, 6, 3, 0, 0, 5},
        {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
        {1, 3, 0, 0, 0, 0, 2, 5, 0},
        {0, 0, 0, 0, 0, 0, 0, 7, 4},
        {0, 0, 5, 2, 0, 6, 3, 0, 0} };

        if (sudokuSolver(sudoku, 0, 0)) {
            System.out.println("---------soln exists---------");
            printSudoku(sudoku);
        }
        else {
            System.out.println("---------no soln exists---------");
        }     
    
    }
}
