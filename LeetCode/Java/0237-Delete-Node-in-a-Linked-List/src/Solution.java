/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // 将待删除节点赋值为下一个节点
        node.val = node.next.val;
        node.next = node.next.next;
    }
}