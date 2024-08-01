//     1
//    212
//   32123
//  4321234
// 543212345


class p13{
    public static void main(String[] args) {
        for(int i=1; i<=5; i++){
            for(int j=i; j<5; j++){
                System.out.print(" ");
            }
            for(int j=i; j>0; j--){
                System.out.print(j);
            }
            for(int j=2; j<=i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
