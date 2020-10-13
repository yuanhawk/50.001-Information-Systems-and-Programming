public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9};
        int target = 9;
        System.out.println(binSearch(a, target, 0, a.length - 1));
    }

    public static int binSearch(int[] a, int target, int l, int r) {

        if (l == r || l > r)
            if (a[l] == target)
                return l;
            else return -1;

        int mid = (l + r) / 2;

        if (a[mid] == target)
            return mid;
        else if (a[mid] < target)
            return binSearch(a, target, mid + 1, r);
        else
            return binSearch(a, target, l, mid - 1);
    }
}
