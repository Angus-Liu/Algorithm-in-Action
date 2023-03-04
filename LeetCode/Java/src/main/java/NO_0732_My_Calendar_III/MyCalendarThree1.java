package NO_0732_My_Calendar_III;

import java.util.HashMap;
import java.util.Map;

class MyCalendarThree1 {

    // k 次预订的最大值表示同一时间点上，日程安排的最大数目。
    private int maxKBooking = 0;

    private Map<Integer, Integer> bookings = new HashMap<>();

    public MyCalendarThree1() {

    }

    public int book(int startTime, int endTime) {
        for (int i = startTime; i < endTime; i++) {
            maxKBooking = Math.max(maxKBooking, bookings.merge(i, 1, Integer::sum));
        }
        return maxKBooking;
    }

    public static void main(String[] args) {
        MyCalendarThree1 myCalendarThree = new MyCalendarThree1();

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
