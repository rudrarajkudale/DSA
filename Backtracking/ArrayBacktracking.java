package Backtracking;

public class ArrayBacktracking {
    public static void fillArray(int a[], int i, int val){
        if(i == a.length){
            return;
        }
        a[i] = val;
        fillArray(a, i+1, val+1);
        a[i] = val-2;
    }

    public static void printArray(int a[]){
        for(int i=0; i<a.length; i++){
            System.out.print(a[i] + " ");
        }
    }
    public static void main(String[] args) {
        int a[] = new int[5];
        fillArray(a, 0, 1);
        printArray(a);
    }
}
