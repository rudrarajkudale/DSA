package OOPs;

public class AccessModifiers {
    public static void main(String[] args) {
        BankAC b1 = new BankAC();
        b1.username = "Rudra";

        //but we cant access password like
        //b1.password = "R123";

        b1.changePass("R123");
        System.out.println(b1.username);
    }
}

class BankAC{
    public String username;
    private String password;

    void changePass(String pass){
        password = pass;
        System.err.println(password);
    }
}