package Array2D;

import java.util.Scanner;

public class InputMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //take side of matrix
        System.out.println("enter the size of matrix:");
        int n = sc.nextInt();

        //insert numbers
        int arr[][] = new int[n][n];
        System.out.println("enter the numbers of matrix:");
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                int num = sc.nextInt();
                arr[i][j] = num;
            }
        }
        sc.close();
        
        //print the matrix
        System.out.println("The Matrix is:");
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(arr[i][j] + " ");
            }
        }
    }
}

