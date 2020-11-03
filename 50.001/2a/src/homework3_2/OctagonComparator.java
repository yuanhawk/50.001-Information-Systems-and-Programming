package homework3_2;

import homework3_1.Octagon;

public class OctagonComparator implements Comparator<Octagon> {

    @Override
    public int compare(Octagon a, Octagon b) {
        if (a.getSide() > b.getSide())
            return 1;
        else if (a.getSide() > b.getSide())
            return 0;
        else
            return -1;
    }
}
