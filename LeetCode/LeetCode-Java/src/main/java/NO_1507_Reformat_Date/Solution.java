package NO_1507_Reformat_Date;

import java.util.Arrays;
import java.util.List;

/**
 * 转变日期格式
 * https://leetcode-cn.com/problems/reformat-date/
 */
class Solution {

    private final List<String> days = Arrays.asList(
            "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th",
            "11th", "12th", "13th", "14th", "15th", "16th", "17th", "18th", "19th",
            "20th", "21st", "22nd", "23rd", "24th", "25th", "26th", "27th", "28th",
            "29th", "30th", "31st"
    );

    private final List<String> months = Arrays.asList(
            "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    );

    public String reformatDate(String date) {
        String[] dates = date.split(" ");
        String year = dates[2];
        int month = months.indexOf(dates[1]) + 1;
        int day = days.indexOf(dates[0]) + 1;
        return String.format("%s-%02d-%02d", year, month, day);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> testDataList = Arrays.asList(
                "20th Oct 2052",
                "6th Jun 1933",
                "26th May 1960"
        );
        testDataList.forEach(date ->
                System.out.println(s.reformatDate(date))
        );
    }
}
