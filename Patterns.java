public class Patterns {
    public static void invertedHalfPyramid(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows; j++) {
                if (j > rows - i) {
                    System.out.print('*');
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void invertedHalfPyramidNumbers (int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows - i + 1; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void oneZeroTriangle(int rows) {
        int x = -1;

        for (int i = 1; i <= rows; i++) {
            if (i%2 == 0) {
                x = 0;
            } else {
                x = -1;
            }            
            for (int j = 1; j <= i; j++) {
                System.out.print(-1 * x);
                x = ~x;
            }
            System.out.println();
        }
    }

    public static void butterfly(int rows) {
        rows = rows*2;

        // 1st half of the pattern
        for (int i = 1; i <= rows/2; i++) {
            for (int j = 1; j <= rows; j++) {
                if (j <= i || j > rows - i) {
                    System.out.print('*');
                }
                else {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }

        // 2nd half of the pattern
        for (int i = rows/2; i >= 1; i--) {
            for (int j = 1; j <= rows; j++) {
                if (j <= i || j > rows - i) {
                    System.out.print('*');
                }
                else {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }

    public static void solidRhombus(int rows) {
        int offset = rows - 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows + offset; j++) {
                if (j > offset) {
                    System.out.print('*');
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println();
            offset--;
        }        
    }

    public static void hollowRhombus(int rows) {
        int offset = rows - 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows + offset; j++) {
                if ( ((i == 1) && (j > offset)) || (i == rows) || (j == offset + 1) || (j == rows + offset)) {
                    System.out.print('*');
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println();
            offset--;
        }        
    }

    public static void diamond(int rows) {
        rows = rows * 2;
        rows--;
        int mid = rows/2;
        for (int i = 0; i <= rows/2; i++) {
            for (int j = 0; j < rows; j++) {
                if (j >= mid - i && j <= mid + i) {
                    System.out.print('*');
                }
                else {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }

        // 2nd half of the pattern
        for (int i = rows/2; i >= 0; i--) {
            for (int j = 0; j <= rows; j++) {
                if (j >= mid - i && j <= mid + i) {
                    System.out.print('*');
                }
                else {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // invertedHalfPyramid(7);
        System.out.println("---------------------------------");
        // invertedHalfPyramidNumbers(6);
        // oneZeroTriangle(5);
        // butterfly(16); // for 8 lines of pattern we'll be given 4 as input
        // solidRhombus(6);
        // hollowRhombus(6);
        diamond(4); // for 8 lines of pattern we'll be given 4 as input
    }
}
