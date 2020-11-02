import java.util.ArrayList;
import java.util.Collections;

public class Octagon implements Comparable<Octagon> {
    private double side;
    public Octagon(double side){
        this.side = side;
    }
    public double getSide() {
        return side;
    }
    @Override
    public int compareTo(Octagon oct){
        //sorting based on peri
        if(side>oct.side){
            return 1;
        }
        else if (side == oct.side){
            return 0;
        }
        else{
            return -1;
        }
    }

    public static void main(String[] args){
        ArrayList<Octagon> a = new ArrayList<>();
        Octagon o = new Octagon(2);
        Octagon o1 = new Octagon(3);
        Octagon o2 = new Octagon(1);
        a.add(o);
        a.add(o1);
        a.add(o2);
        Collections.sort(a);
        for (Octagon o3:a){
            System.out.println(o.getSide());
        }


    }

}