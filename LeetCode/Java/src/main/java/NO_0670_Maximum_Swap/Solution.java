package NO_0670_Maximum_Swap;

class Solution {
    public int maximumSwap(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        int n = nums.length;
        // nums 中待交换位（i）的后续位数字中有比其大的数字时，满足交换条件，
        // 此时选择最大且位置最靠后的那位进行交换即可
        for (int i = 0; i < n - 1; i++) {
            // maxIdx，maxNum 用于保存比当前待调交换位（i）大的且是最大的数位的信息
            int maxIdx = i;
            char maxNum = nums[i];
            // 从后向前遍历，找到比待交换位（i）数字大的数字中数值最大的那一位
            for (int j = n - 1; j > i; j--) {
                if (nums[j] > maxNum) {
                    maxIdx = j;
                    maxNum = nums[j];
                }
            }
            if (maxIdx != i) {
                swap(nums, i, maxIdx);
                return Integer.parseInt(String.valueOf(nums));
            }
        }
        return num;
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
