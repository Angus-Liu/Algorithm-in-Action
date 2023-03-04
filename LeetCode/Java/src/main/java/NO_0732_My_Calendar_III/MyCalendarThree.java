package NO_0732_My_Calendar_III;

import java.util.Map;
import java.util.TreeMap;

class MyCalendarThree {

    private final Map<Integer, Integer> cnt;

    public MyCalendarThree() {
        cnt = new TreeMap<>();
    }

    /**
     * 差分数组法
     */
    public int book(int startTime, int endTime) {
        // 表示从 start 预定的数目加 1
        cnt.merge(startTime, 1, Integer::sum);
        // 表示从 end 预定的数目减 1
        cnt.merge(endTime, -1, Integer::sum);
        // 此时以起点 x 开始的预定的数目 booking = ∑cnt[y](y≤x)
        int booking = 0, res = 0;
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            booking += entry.getValue();
            res = Math.max(res, booking);
        }
        return res;
    }

    public static void main(String[] args) {
        MyCalendarThree myCalendarThree = new MyCalendarThree();

        // 0  5  10  15  20  25  30  35  40  45  50  55  60
        //       10------20
        //                                       50------60
        //       10----------------------40
        //    5------15
        //    5--10
        //                   25----------------------55
        int maxKBooking = myCalendarThree.book(10, 20); // 返回 1 ，第一个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
        System.out.println(maxKBooking);

        maxKBooking = myCalendarThree.book(50, 60); // 返回 1 ，第二个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
        System.out.println(maxKBooking);

        maxKBooking = myCalendarThree.book(10, 40); // 返回 2 ，第三个日程安排 [10, 40) 与第一个日程安排相交，所以最大 k 次预订是 2 次预订。
        System.out.println(maxKBooking);

        maxKBooking = myCalendarThree.book(5, 15); // 返回 3 ，剩下的日程安排的最大 k 次预订是 3 次预订。
        System.out.println(maxKBooking);

        maxKBooking = myCalendarThree.book(5, 10); // 返回 3
        System.out.println(maxKBooking);

        maxKBooking = myCalendarThree.book(25, 55); // 返回 3
        System.out.println(maxKBooking);
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */
