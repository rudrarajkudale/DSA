package Backtracking;

//In this Question we have to just print a single solution
public class NQueen3 {
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
    public static boolean NQueen(char chessboard[][], int row){
        if(row == chessboard.length){
            return true;
        }

        for(int j=0; j<chessboard.length; j++){
            if(isSafe(chessboard, row, j)){
            chessboard[row][j] = 'Q';
            if(NQueen(chessboard, row+1)){
                return true;
            }
            chessboard[row][j] = 'x';
            }
        }
        return false;
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
        int n=4;
        char chessboard[][] = new char[n][n];
        for(int i=0; i<chessboard.length; i++){
            for(int j=0; j<chessboard.length; j++){
                chessboard[i][j] = 'x';
            }
        }
        boolean sol = NQueen(chessboard,0);
        if(sol){
            printBoard(chessboard);
        }else{
            System.out.println("didn't have any solution");
        } 
    }
}
