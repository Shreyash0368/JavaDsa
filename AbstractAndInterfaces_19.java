abstract class Animals {
    String name;
    abstract void eat();    
}

class Deer extends Animals {
    public void eat() {
        System.out.println("Deer Eats grass");
    }
}

class Tiger extends Animals {
    
    public void eat() {
        System.out.println("Tiger Eats meat");        
    }
}

interface ChessPiece {
    void moves();
}

class Queen implements ChessPiece {
    public void moves() {
        System.out.println("Can move in any direction");
    }
}

class Rook implements ChessPiece {    
    public void moves() {
        System.out.println("Can move in straight line in any direction");        
    }
}

public class AbstractAndInterfaces_19 {
    public static void main(String[] args) {
        
        // working of abstract classes
        Deer d = new Deer();
        d.name = "tony";
        d.eat();

        Tiger t = new Tiger();
        t.name = "Anthony";
        t.eat();

        // working of inetrfaces
        Queen q1 = new Queen();
        q1.moves();

        Rook r1 = new Rook();
        r1.moves();



    }
    
}