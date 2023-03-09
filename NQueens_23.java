public class NQueens_23 {
    static int count = 0;


    public static void printBoard(char board[][]) {
        System.out.println("-----board-----");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isQueenSafe(char board[][], int row, int j) {           
        // check vertical up
        for (int i = row-1, tempJ = j; i >= 0; i--) {
            if (board[i][tempJ] == 'Q') {
                return false;
            }
        }                
        // check left up diagonal        
        for (int i = row-1, tempJ = j - 1; i >= 0 & tempJ >= 0; i--, tempJ--) {
            if (board[i][tempJ] == 'Q') {
                return false;
            }
        }          
        // check right up diagonal        
        for (int i = row-1, tempJ = j + 1; i >= 0 & tempJ < board.length; i--, tempJ++) {
            if (board[i][tempJ] == 'Q') {
                return false;
            }
        }        
        return true;
    }


    public static void nQueens(char board[][], int row) {
        // base
        if (row == board.length) {
            // printBoard(board); if u want to print the correct board sequence
            count++; // only for maintianing count of the possible solutions
            return;
        }
        // recursion
        for (int j = 0; j < board.length; j++) {
            board[row][j] = 'Q';
            if (isQueenSafe(board, row, j)) { // only move to next row if current position of queen is safe
                nQueens(board, row+1);                
            }
            board[row][j] = 'x';
        }        
    }
    
    public static void main(String[] args) {
        int n = 4;
        char board[][] = new char[n][n]; 
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = 'x';
            }
        }
        
        nQueens(board, 0);
        System.out.println(count);
    
    }   
}
