package OOPs;

public class AbstractInterface {
    public static void main(String[] args)
    {
        Queen q = new Queen();
        q.moves();
        Pawn p = new Pawn();
        p.moves();
    }      
}

interface Chess{
    void moves();
}

class Queen implements Chess {
    public void moves(){
        System.out.println("left, right, up, down, diagonal");
    }
}

class Pawn implements Chess {
    public void moves(){
        System.out.println("up, diagonal");
    }
}
