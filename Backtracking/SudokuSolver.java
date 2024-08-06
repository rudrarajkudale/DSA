package Backtracking;

public class SudokuSolver {
    public static void printsudoku(int[][] sudoku){
        for(int i=0; i<sudoku.length; i++){
            for(int j=0; j<sudoku.length; j++){
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean solvesudoku(int[][] sudoku, int row, int col){
        //if we are on 10th row means soduko is solved
        if(row == 9){
            return true;
        }

        //updating for each row
        int nextrow = row;
        int nextcol = col + 1;
        if(nextcol == 9){
            nextrow = row + 1;
            nextcol = 0;
        }

        //check is there is non blank space then don't change it 
        if(sudoku[row][col] != 0){
            return solvesudoku(sudoku, nextrow, nextcol);
        }

        //if blanck space then try digits
        for(int digit=0; digit<=9; digit++){
            //issafe functions checks the position is safe to plcae th digit
            if(isSafe(sudoku, row, col, digit)){
                sudoku[row][col] = digit;
                //if the digit is correct dont backtrack direct return
                if(solvesudoku(sudoku, nextrow, nextcol)){
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }
        
        return false;
    }

    public static boolean isSafe(int[][] sudoku, int row, int col, int digit){

        //first check if present in a row
        for(int i=0; i<sudoku.length; i++){
            if( sudoku[row][i] == digit){
                return false;
            }
        }

        //now check if present in a column
        for(int i=0; i<sudoku.length; i++){
            if( sudoku[i][col] == digit){
                return false;
            }
        }

        //check if digit present 
        int sr = (row/3)*3;
        int sc = (col/3)*3;

        for(int i=sr; i<sr+3; i++){
            for(int j=sc; j<sc+3; j++){
                if( sudoku[i][j] == digit){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] sudoku = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        if(solvesudoku(sudoku,0,0))
        {
            System.out.println("solution exists");
            printsudoku(sudoku);
        }else{
            System.out.println("solution not exists");
        }
    }
}
