import java.util.*;

public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) return res;
        List<Integer> meiCeng = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue_tmp = new LinkedList<>();
        queue.add(root);
        int ceng=0;
        while (!queue.isEmpty()){
            TreeNode t = queue.peek();

            if (t.left!=null){
                    queue_tmp.add(t.left);
                }
                if (t.right!=null){
                    queue_tmp.add(t.right);
                }
            queue.poll();
            meiCeng.add(t.val);
            if (queue.isEmpty()){
                if (ceng%2==0){
                    res.add(new ArrayList<>(meiCeng));
                }
                else {
                    Collections.reverse(meiCeng);
                    res.add(new ArrayList<>(meiCeng));
                }

                queue=new LinkedList<>(queue_tmp);
                queue_tmp.clear();
                meiCeng.clear();
                ceng+=1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Object[] a = {3,9,20,1,2,15,7};
        TreeNode in = Untils.creatTree(a);
        System.out.println(new Solution103().zigzagLevelOrder(in));
    }
}
