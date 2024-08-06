package Backtracking;

//In this we find all the possible solutions to place the queen on 2D board
public class NQueen1 {

    //This function will print the every solution
    public static void printBoard(char chessboard[][]){
        System.out.println("------chess board------");
        for(int i=0; i<chessboard.length; i++){
            for(int j=0; j<chessboard.length; j++){
                System.out.print(chessboard[i][j] + " ");
            }
            System.out.println();
        }
    }

    //recursion will be done in this function
    public static void NQueen(char chessboard[][], int row){
        if(row == chessboard.length){
            printBoard(chessboard);
            return;
        }

        for(int j=0; j<chessboard.length; j++){
            if(isSafe(chessboard, row, j)){
            chessboard[row][j] = 'Q';
            NQueen(chessboard, row+1);
            chessboard[row][j] = 'x';
            }
        }
    }

    //this function checks if the position of queen is safe or not
    public static boolean isSafe(char chessboard[][], int row, int col){
        //check vertical
        for(int i=row; i>=0; i--){
            if(chessboard[i][col] == 'Q'){
                return false;
            }
        }

        //check left diagonal
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--,j--){
            if(chessboard[i][j] == 'Q'){
                return false;
            }
        }

        //check right diagonal
        for(int i=row-1, j=col+1; i>=0 && j<chessboard.length; i--, j++){
            if(chessboard[i][j] == 'Q'){
                return false;
            }
        }

        //if safe return true
        return true;
    }
    public static void main(String[] args) {
        int n=5;
        char chessboard[][] = new char[n][n];
        for(int i=0; i<chessboard.length; i++){
            for(int j=0; j<chessboard.length; j++){
                chessboard[i][j] = 'x';
            }
        }
        NQueen(chessboard,0);
    }
}
