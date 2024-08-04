package Recursion;

public class RemoveDuplicatesFromString {
    public static String removeDuplicates(String str, int i, StringBuilder sb, boolean ch[]){
        if(i == str.length()){
            return sb.toString();
        }
        char c = str.charAt(i);
        if(ch[c - 'a'] == true){
            return removeDuplicates(str, i+1, sb, ch);
        }else{
            ch[c - 'a'] = true;
            return removeDuplicates(str, i+1, sb.append(str.charAt(i)), ch);
        }
    }
    public static void main(String[] args) {
        System.out.println(removeDuplicates("apanacollege", 0, new StringBuilder("") , new boolean[26]));
    }
}
