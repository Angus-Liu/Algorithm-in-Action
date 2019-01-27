/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {

    /**
     * 普通解法
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        // 判断头节点为删除值的情况，注意循环是为了处理首部连续是删除值的情况
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }
        // 判断链表为空的情况（原本就为空，删除首节点后为空）
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                // 注意删除 prev.next 后，不要移动 prev，因为新的 prev.next 仍然可能是待删除节点
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

    /**
     * 添加虚拟头节点解法（算法简单）
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
        // 创建一个虚拟头节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    /**
     * 递归方式解法
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements3(ListNode head, int val) {
        // 考虑问题规模最小的情况（递归退出条件）
        if (head == null) {
            return null;
        }
        // 减小问题规模，获得处理后的链表（不一定与 head 连在一起）
        ListNode res = removeElements3(head.next, val);
        // 判断 head 节点是否需要删除
        if (head.val == val) {
            return res;
        } else {
            head.next = res;
            return head;
        }
    }

    /**
     * 递归方式解法（简化）
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements4(ListNode head, int val) {
        // 考虑问题规模最小的情况（递归退出条件）
        if (head == null) return null;
        // 减小问题规模
        head.next = removeElements4(head.next, val);
        // 判断 head 节点是否需要删除
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 6, 3, 4, 5, 6});
        System.out.println(head);
        Solution solution = new Solution();
        head = solution.removeElements4(head, 6);
        System.out.println(head);
    }
}
