package OOPs;
public class CreateClass{
    public static void main(String[] args){
        Pen p1 = new Pen();
        p1.changeColor("blue");
        p1.changeTip(5);
        System.out.println(p1.color + "," + p1.tip);

        //Also change like this
        p1.color = "Yellow";
        System.out.println(p1.color + "," + p1.tip);
    }
}
class Pen{
    String color;
    int tip;

    void changeColor(String newcolor){
        color = newcolor;
    }

    void changeTip(int newtip){
        tip = newtip;
    }
}

