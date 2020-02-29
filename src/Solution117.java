import java.util.LinkedList;
import java.util.Queue;

public class Solution117 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node connect(Node root) {
        if (root==null) return null;
        Queue<Node> nodes = new LinkedList<Node>();
        nodes.offer(root);
        while (!nodes.isEmpty()){
            int level_size = nodes.size();
            for (int i = 0; i < level_size; i++) {
                Node tmp = nodes.poll();
                if (i != level_size-1){
                    tmp.next = nodes.peek();
                }
                if (tmp.left!=null) nodes.offer(tmp.left);
                if (tmp.right!=null) nodes.offer(tmp.right);
            }
        }
        return root;
    }
}
