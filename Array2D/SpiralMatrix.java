package Array2D;

public class SpiralMatrix {
    public static void spiralMatrix(int matrix[][]){
        int srow = 0;
        int scol = 0;
        int erow = matrix.length-1;
        int ecol = matrix[0].length-1;

        while(srow <= scol && scol <= ecol){
            //printing upper row
            for(int i=scol; i<=ecol; i++){
                System.out.print(matrix[srow][i] + " ");
            }

            //printing end col
            for(int i=srow+1; i<=erow; i++){
                System.out.print(matrix[i][ecol] + " ");
            }

            //printing down row
            for(int i=ecol-1; i>=scol; i--){
                if(scol == ecol){
                    break;
                }
                System.out.print(matrix[erow][i] + " ");
            }

            //printing start col
            for(int i=erow-1; i>=scol+1; i--){
                if(srow == erow){
                    break;
                }
                System.out.print(matrix[i][scol] + " ");
            }

            //update all variables
            ecol--;
            erow--;
            srow++;
            scol++;
        }
        
    }
    public static void main(String[] args) {
        int matrix[][] = {
            {0, 1, 2, 3, 4},
            {5, 6, 7, 8, 9},
            {10, 11, 12, 13, 14},
            {15, 16, 17, 18, 19},
            {20, 21, 22, 23, 24}
        };   
        spiralMatrix(matrix);
    }

}
