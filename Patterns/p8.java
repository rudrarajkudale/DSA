// 1 
// 2 3
// 4 5 6
// 7 8 9 10
// 11 12 13 14 15

class p8{
    public static void main(String[] args) {
        int num = 1;
        for(int i=0; i<5; i++){
            for(int j=0; j<=i; j++){
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }
}