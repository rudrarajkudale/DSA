package String;

public class UpperCase {
    public static String upperCase(String str){
        StringBuilder sb = new StringBuilder();
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        int n = str.length();
        for(int i=1; i<n; i++){
            if(str.charAt(i) == ' ' && i != n-1){
                sb.append(i);
                ch = Character.toUpperCase(str.charAt(i+1));
                sb.append(ch);
                i++;
            }else{
                ch = str.charAt(i);
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String str = "hi, i am rudra.";
        System.out.println(upperCase(str));
    }
}
