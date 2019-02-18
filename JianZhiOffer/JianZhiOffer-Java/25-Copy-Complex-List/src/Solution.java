import java.util.HashMap;
import java.util.Map;

public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        // 用于建立源链表与结果链表节点对应的关系，方便结果链表 random 指针的赋值
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode rHead = new RandomListNode(pHead.label);
        map.put(pHead, rHead);
        // 建立结果链表
        RandomListNode pNode = pHead, rNode = rHead;
        while (pNode.next != null) {
            pNode = pNode.next;
            rNode.next = new RandomListNode(pNode.label);
            rNode = rNode.next;
            map.put(pNode, rNode);
        }
        // 确立结果链表 random 指针
        pNode = pHead;
        rNode = rHead;
        while (pNode != null) {
            rNode.random = map.get(pNode.random);
            pNode = pNode.next;
            rNode = rNode.next;
        }
        return rHead;
    }
}