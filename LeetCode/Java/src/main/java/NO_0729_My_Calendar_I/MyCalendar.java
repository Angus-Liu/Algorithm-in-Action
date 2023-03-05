package NO_0729_My_Calendar_I;

import java.util.ArrayList;
import java.util.List;

class MyCalendar {
    private final List<int[]> bookings;

    public MyCalendar() {
        bookings = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] b : bookings) {
            if (b[1] > start && b[0] < end) {
                return false;
            }
        }
        bookings.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
