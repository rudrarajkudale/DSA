package Arrays;

public class PairsOfArrays {
    public static void pairs(int arr[]){
        int total = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                System.out.print("{"+ arr[i] + "," + arr[j] + "}");
                total++;
            }
            System.out.println();
        }
        System.out.println("total pairs are:" + total);
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        pairs(arr);
    }
}
