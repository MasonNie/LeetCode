import java.util.*;

public class Solution133 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node copy = new Node(node.val,new ArrayList<>());
        if (node.neighbors.isEmpty()) return copy;
        Map<Node,Node> visited = new HashMap<>();
        visited.put(node,copy);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            Node now = queue.poll();
            for (Node neighbor:now.neighbors){
                if (!visited.containsKey(neighbor)){
                    visited.put(neighbor,new Node(neighbor.val,new ArrayList<>()));
                    queue.offer(neighbor);
                }
                visited.get(now).neighbors.add(visited.get(neighbor));
            }
        }
        return copy;
    }
}
