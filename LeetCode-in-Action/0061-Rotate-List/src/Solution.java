class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        // 利用虚拟头结点和滑动窗口解决问题
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead;
        ListNode q = dummyHead;

        // 计算链表的长度
        ListNode r = dummyHead;
        int l = 0;
        while (r.next != null) {
            r = r.next;
            l++;
        }
        // k 根据长度取余，旋转效果一样
        k = k % l;
//        System.out.println("l:" + l);
//        System.out.println("k:" + k);
        if (k != 0) {
            for (int i = 0; i < k; i++) {
                q = q.next;
            }
            // 滑动窗口，使 p 指向待旋转的前一项，q 指向待旋转的最后一项
            while (q.next != null) {
                p = p.next;
                q = q.next;
            }
            q.next = dummyHead.next;
            dummyHead.next = p.next;
            p.next = null;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(new Solution().rotateRight(head, 4));
    }
}