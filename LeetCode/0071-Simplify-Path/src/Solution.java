import java.util.LinkedList;

class Solution {
    public String simplifyPath(String path) {
        // 利用栈或队列来解决
        LinkedList<String> queue = new LinkedList<>();
        String[] paths = path.split("/");
        for (String p : paths) {
            if ("".equals(p) || ".".equals(p)) {
                continue;
            } else if ("..".equals(p)) {
                if (!queue.isEmpty()) {
                    queue.removeLast();
                }
            } else {
                queue.addLast("/" + p);
            }
        }
        if (queue.isEmpty()) {
            return "/";
        } else {
            StringBuilder res = new StringBuilder();
            while (!queue.isEmpty()) {
                res.append(queue.removeFirst());
            }
            return res.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.simplifyPath("/home/"));
        System.out.println(solution.simplifyPath("/a/./b/../../c/"));
        System.out.println(solution.simplifyPath("/../"));
        System.out.println(solution.simplifyPath("/home//foo/"));
    }
}