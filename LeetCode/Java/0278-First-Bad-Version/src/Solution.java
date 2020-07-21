public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        // 二分查找的应用
        int l = 1;
        int r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (isBadVersion(mid)) {
                // 没用 mid - 1，是因为 mid - 1 可能不是 BadVersion，因此需要保留 mid
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
}