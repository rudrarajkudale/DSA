package Array2D;

public class SearchInSorted {
    public static void searchKey(int matrix[][], int key){
        int row = 0;
        int col = matrix.length-1;
        while(row < matrix.length-1 || col > 0){
            if(matrix[row][col] == key){
                System.out.println("the key is on the index: " + row + "," + col);
                return;
            }
            else if(matrix[row][col] < key){
                row++;
            }else{
                col--;
            }
        }
        System.out.println("key not found");
    }
    public static void main(String[] args) {
        int matrix[][] = {{10,20,30,40},
                          {15,25,35,45},
                          {27,29,37,48},
                          {32,33,39,50}};

        searchKey(matrix, 33);
    }
}
