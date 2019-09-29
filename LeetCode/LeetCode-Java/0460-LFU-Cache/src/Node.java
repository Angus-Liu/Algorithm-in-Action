/**
 * @author angus
 * @date 2019/9/29
 */
public class Node {
    int key;

    int value;

    int freq;

    /**
     * 前一个节点
     */
    Node prev;

    /**
     * 后一个节点
     */
    Node next;

    /**
     * 后继节点（默认值为next）
     */
    Node succeed;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.freq = 1;
    }

    public Node(int key, int value, int freq, Node prev, Node next, Node succeed) {
        this.key = key;
        this.value = value;
        this.freq = freq;
        this.prev = prev;
        this.next = next;
        this.succeed = succeed;
    }
}
