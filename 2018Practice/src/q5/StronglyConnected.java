package q5;

import java.util.ArrayList;

//starting code


public class StronglyConnected {

    //DFS 1 void

    //DFS 2
    //transpose return transpose graph
    //combine altogether


    static boolean testStronglyConnected(int nodecount, int linkcount, ArrayList<Integer> l) {
        //first check, must declare outside
        ArrayList<Integer[]> a = new ArrayList<>();;
        int i;
        if (nodecount <= linkcount){
            //add the pair into the new arraylist

            //loop through the whole arraylist
            for(i=0;i<=l.size()-1;i+=2){
                a.add(new Integer[]{l.get(i),l.get(i+1)});}
            //check new arraylist
            ArrayList<Integer[]> b = new ArrayList<>();
            //check if old empty
            while(a.size()!=0)
                //add to the new arraylist
                b.add(a.get(0));
            //a.remove(a.get(0));
            //retrieve each array &el from each array
            for(int r=0; r<a.size();r++) {
                //check the array and compare
                if (a.get(r)[0] == b.get(b.size() - 1)[1]) {
                    b.add(a.get(r));
                    a.remove(r);
                    break;
                }
                if (r == a.size() - 1) return false;
            }
            //last check
            if(b.get(b.size()-1)[1]==b.get(0)[0]) return true;
            return false;}
        return false;}

}


