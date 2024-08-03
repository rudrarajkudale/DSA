package String;

public class PrintSubstring {
    public static void printSubstring(String str, int si, int ei){
        String substr = "";
        for(int i=si; i<ei; i++){
            substr += str.charAt(i);
        }
        System.out.println(substr);

        //or we can direct use function
        System.out.println(str.substring(si, ei));
    }
    public static void main(String[] args) {
        String str = "HelloWorld";
        printSubstring(str, 0, 4);
    }
}
