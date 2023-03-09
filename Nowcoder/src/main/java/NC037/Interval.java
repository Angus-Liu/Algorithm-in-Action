package NC037;

import java.util.ArrayList;

public class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return "[" + start + "," + end + "]";
    }

    public static ArrayList<Interval> of(int[][] intArr) {
        ArrayList<Interval> list = new ArrayList<>();
        for (int[] i : intArr) {
            list.add(new Interval(i[0], i[1]));
        }
        return list;
    }
}
