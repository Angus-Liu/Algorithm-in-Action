package NO_1032_Stream_of_Characters;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * StreamChecker 类实现了一个数据结构，用于检查一个给定的字母流（即字符流）中是否有以单词列表中的任意单词结尾的单词。
 * StreamChecker 使用 Trie 树数据结构和 Aho-Corasick 算法。
 */
class StreamChecker {
    TrieNode root;  // Trie 树的根节点
    TrieNode temp;  // Trie 树的临时节点，用于查询过程中的状态维护

    /**
     * StreamChecker 的构造函数。初始化 Trie 树和 Aho-Corasick 自动机。
     *
     * @param words 一个包含所有可能单词的字符串数组
     */
    public StreamChecker(String[] words) {
        root = new TrieNode();
        // 遍历单词列表，依次将每个单词添加到 Trie 树中
        for (String word : words) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (cur.getChild(index) == null) {
                    cur.setChild(index, new TrieNode());
                }
                cur = cur.getChild(index);
            }
            // 在 Trie 树的最后一个字符节点上标记为单词结尾
            cur.setEnd(true);
        }
        // 将根节点的失败指针指向自己
        root.setFail(root);
        // 初始化队列，用于进行 BFS 遍历
        Queue<TrieNode> q = new ArrayDeque<>();
        // 遍历根节点的子节点
        for (int i = 0; i < 26; i++) {
            // 如果该子节点存在
            if (root.getChild(i) != null) {
                // 将该子节点的失败指针指向根节点
                root.getChild(i).setFail(root);
                // 将该子节点加入队列
                q.add(root.getChild(i));
            } else {
                // 如果该子节点不存在，则将其指向根节点
                root.setChild(i, root);
            }
        }
        while (!q.isEmpty()) {  // 开始 BFS 遍历
            TrieNode node = q.poll();
            // 如果该节点或其失败指针节点是单词结尾，则将该节点标记为单词结尾
            node.setEnd(node.isEnd() || node.getFail().isEnd());
            // 遍历该节点的所有子节点
            for (int i = 0; i < 26; i++) {
                // 如果该子节点存在
                if (node.getChild(i) != null) {
                    // 将该子节点的失败指针指向其父节点的失败指针的相应子节点
                    node.getChild(i).setFail(node.getFail().getChild(i));
                    // 将该子节点加入队列
                    q.offer(node.getChild(i));
                } else {
                    // 这行代码的作用是在当前节点 node 的孩子节点中，
                    // 如果当前孩子节点为空，则将其指向 node 的失败节点的孩子节点 i。
                    // 这是在实现 Aho-Corasick 字符串匹配算法中自动机的构建过程中使用的一个技巧。
                    // 当自动机中的某个节点没有对应某个字符的孩子节点时，我们可以将它指向其失败节点
                    // 的该字符孩子节点，从而实现失败指针的设置，使得匹配失败时可以直接跳转到其失败
                    // 节点，从而继续匹配。
                    node.setChild(i, node.getFail().getChild(i));
                }
            }
        }
        temp = root;
    }

    public boolean query(char letter) {
        temp = temp.getChild(letter - 'a');
        return temp.isEnd();
    }

    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        TrieNode fail;

        public TrieNode() {
            children = new TrieNode[26];
        }

        public TrieNode getChild(int index) {
            return children[index];
        }

        public void setChild(int index, TrieNode node) {
            children[index] = node;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }

        public TrieNode getFail() {
            return fail;
        }

        public void setFail(TrieNode fail) {
            this.fail = fail;
        }
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
