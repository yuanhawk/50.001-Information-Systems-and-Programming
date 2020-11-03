package homework3_7;

import java.util.ArrayList;

public class GetPath {
    //Fill in your answer for this method

    /**
     *
     * @param r = destination spot
     * @param c = destination spot
     * @param path
     * @param grid = passed in as the last input argument
     * @return returns true if path can be found
     */

    // starts at 0, 0

    public static boolean getPath (int r, int c, ArrayList<Point> path, final int [][] grid) {
        // check boundaries (r, c is out of range?)
        if (r < 0 || c < 0 || r > grid.length || c > grid[0].length)
            return false;

        // check if (r, c is a wall)
        if (grid[r][c] == 1)
            return false;

        // Initial starting pt
        if (path.size() == 0)
            path.add(new Point(0, 0));

        int x = path.get(path.size()-1).x;
        int y = path.get(path.size()-1).y;

        if (x == r && y == c)
            return true;

        if (y + 1 < grid[x].length) {
            if (grid[x][y + 1] != 1 && y < c) {
                ArrayList<Point> yi = new ArrayList<>(path);
                yi.add(new Point(x, y + 1));

                if (getPath(r, c, yi, grid)) {
                    path.clear();
                    path.addAll(yi);
                    return true;
                }
            }
        }

        if (x + 1 < grid.length) {
            if (grid[x + 1][y] != 1 && x < r) {
                ArrayList<Point> xi = new ArrayList<>(path);
                xi.add(new Point(x + 1, y));

                if (getPath(r, c, xi, grid)) {
                    path.clear();
                    path.addAll(xi);
                    return true;
                }
            }
        }

        return false;
    }
}

class Point {
    int x;
    int y;

    Point (int x, int y) {
        this.x=x;
        this.y=y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}