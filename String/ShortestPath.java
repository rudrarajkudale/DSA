package String;

public class ShortestPath {
    public static void shortestPath(String path, int x, int y){
        for(int i=0; i<path.length(); i++){
            if(path.charAt(i) == 'N'){
                y++;
            }
            else if(path.charAt(i) == 'S'){
                y--;
            }
            else if(path.charAt(i) == 'W'){
                x--;
            }
            else{
                x++;
            }
        }
        float shortpath = (float)Math.sqrt(x*x + y*y);
        System.out.println("The shortest path is: " + shortpath);
    }
    public static void main(String[] args) {
        String path = "WNEENESENNN";
        shortestPath(path, 0, 0);
    }
}
