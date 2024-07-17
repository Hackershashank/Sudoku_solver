import java.util.*;


public class Sudoku_solver {

    //Function to Check whether k can be placed int sudoku array at position (row,col)
    static boolean isValid(int[][] sudoku, int row, int col, int k) {
        int n = 9;
        for (int i = 0; i < n; i++) {
            if (sudoku[row][i] == k) return false;
            if (sudoku[i][col] == k) return false;
            if (sudoku[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == k) return false;
        }
        return true;
    }

    //Function to solve Sudoku using Backtracking
    static boolean solveSudoku(int[][] sudoku) {
        int n = 9;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (sudoku[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(sudoku, row, col, num)) {
                            sudoku[row][col] = num;
                            if (solveSudoku(sudoku)) return true;
                            else sudoku[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 9;

        //creating 2d array of size 9x9 to store the sudoku
        int[][] sudoku = new int[n][n];

        System.out.println("Insert the Sudoku elements and for blank positions insert 0: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sudoku[i][j] = sc.nextInt();
            }
        }
        System.out.println("Unsolved Sudoku looks alike: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
        if (solveSudoku(sudoku)) {
            System.out.println("Solved Sudoku looks alike: ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(sudoku[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Entered Sudoku is Invalid !!");
        }
    }
}
