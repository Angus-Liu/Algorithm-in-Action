import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;
        import java.util.stream.Collectors;

public class Solution {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return verifySquence(Arrays.stream(sequence).boxed().collect(Collectors.toList()));
    }

    private boolean verifySquence(List<Integer> seq) {
        if (seq.size() == 0) {
            return true;
        }
        // 序列的最后一个节点为该树的根节点
        int root = seq.get(seq.size() - 1);
        // 左子树所有节点小于根节点
        List<Integer> leftSeq = new ArrayList<>();
        int i = 0;
        while (i < seq.size() - 1 && seq.get(i) < root) {
            leftSeq.add(seq.get(i++));
        }
        // 右子树所有节点大于根节点
        List<Integer> rightSeq = new ArrayList<>();
        while (i < seq.size() - 1 && seq.get(i) > root) {
            rightSeq.add(seq.get(i++));
        }
        // 右子树中有节点小于根节点，说明不是合法序列
        if (i != seq.size() - 1) {
            return false;
        }
        return verifySquence(leftSeq) && verifySquence(rightSeq);
    }
}