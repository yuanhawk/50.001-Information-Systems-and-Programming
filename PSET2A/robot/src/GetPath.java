import java.util.*;
public class GetPath {
    //private static int x;
    //private static int y;
    //Fill in your answer for this method
    public static boolean getPath(int r, int c, ArrayList<Point> path, final int[][] grid) {
        System.out.println(path);
        //move from the top left (0,0) recursively
        //if path is found, return the path and true
        //path not found, return false
        //0 indicates that the spot is non blocked
        //can move right: if the +1 of the current spot c+1 is not 0
        //can move down if r+1  is not 0
        //if (x== c && y == r){
        //    return true;
        //}
        //else find the path to the point
        if (path.size() == 0) {
            path.add(new Point(0, 0));
            //path.add(a);
        }

        if (path.get(path.size()-1).x==r && (path.get(path.size()-1).y)==c){
            return true;
        }
        // go down
        int d = path.get(path.size()-1).x;
        //go right
        int e = path.get(path.size()-1).y;

            //check if the next point is within the array
            //check if the next point is an obstacle
            //add the next point if legit
            //recursively progress the path
            if (d != r && grid[d+1][e]!=1) {
                //vertical portion
                ArrayList<Point> s = new ArrayList<>(path);
                //create pairs of points
                s.add(new Point(d+1,e));
                //pass back to the original path if successful
                //overwrite the path given to us
                if (getPath(r,c,s,grid)==true){
                    //clear then copy all the path of s
                    path.clear();
                    path.addAll(s);
                    return true;
                }
            }
            if(e != c && grid[d][e+1]!= 1){
                ArrayList<Point> t = new ArrayList<>(path);
                //same thing
                t.add(new Point(d,e+1));
                if (getPath(r,c,t,grid)==true){
                    path.clear();
                    path.addAll(t);
                    return true;
                }
            }

            return false;
    }
}
//You do not need to change any code below ---------
class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }}


//--------------------------------------------------

/* HINT:
Your solution ought to work with a grid that is not square.
Here is the grid for Test Case 8:

            final int[][] grid = {
                    {0,0,0,1},
                    {0,1,0,0},
                    {0,1,1,1},
                    {0,0,0,1},
                    {1,1,0,0},
                    {1,1,1,0}
            };

*/
