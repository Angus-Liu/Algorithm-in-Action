import java.util.*;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> res = new ArrayList<>();
        int sumOfIndex = Integer.MAX_VALUE;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int value = map.get(list2[i]);
                if (i + value < sumOfIndex) {
                    res = new ArrayList<>(); // res.clear();
                    res.add(list2[i]);
                    sumOfIndex = i + value;
                } else if (i + value == sumOfIndex) {
                    res.add(list2[i]);
                }
            }
        }

        return res.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Piatti", "The Grill at Torrey Pines", "Shogun"};
        String[] res = new Solution().findRestaurant(list1, list2);
        System.out.println("res = " + Arrays.toString(res));
    }
}