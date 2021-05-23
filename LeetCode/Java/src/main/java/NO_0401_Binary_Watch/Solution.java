package NO_0401_Binary_Watch;

import java.util.ArrayList;
import java.util.List;

class Solution {


    private List<String> res = new ArrayList<>();
    /**
     * hour: 0-3
     * minute: 4-9
     */
    private boolean[] light = new boolean[10];

    public List<String> readBinaryWatch(int num) {
        readBinaryWatch(num, 0);
        return res;
    }

    public void readBinaryWatch(int num, int start) {
        if (num == 0) {
            int hour = 0;
            int minute = 0;
            for (int i = 0; i < light.length; i++) {
                if (light[i]) {
                    // 计算可以用查表法简化
                    if (i < 4) {
                        hour += Math.pow(2, i);
                    } else {
                        minute += Math.pow(2, i - 4);
                    }
                }
            }
            if (hour < 12 && minute < 60) {
                StringBuilder s = new StringBuilder();
                s.append(hour).append(":");
                if (minute < 10) {
                    s.append(0);
                }
                s.append(minute);
                res.add(s.toString());
            }
            return;
        }

        for (int i = start; i < light.length; i++) {
            light[i] = true;
            readBinaryWatch(num - 1, i + 1);
            light[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().readBinaryWatch(1));
    }
}