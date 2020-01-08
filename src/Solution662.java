import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution662 {
    int ans = 0;
    public int widthOfBinaryTree(TreeNode root) {
//        int res = 0;
//        if (root==null) return res;
//        List<List<TreeNode>> res_a = new ArrayList<>();
//        bfs(root,0,res_a);
//        //res_a.remove(res_a.size()-1);
//        for (List<TreeNode> l:res_a
//             ) {
//            if (l.size()>res) res = l.size();
//        }
//        System.out.println(res_a);
//        return res;
        if (root==null) return 0;
        second(new HashMap<>(),root,1,0);
        return ans;
    }
    void second(Map<Integer,Integer> tmp, TreeNode node, int pos, int depth){
        if (node==null) return;
        tmp.computeIfAbsent(depth,x->pos);
        ans = Math.max(ans,pos-tmp.get(depth)+1);
        second(tmp, node.left, pos*2, depth+1);
        second(tmp, node.right, pos*2+1, depth+1);
    }
    void bfs(TreeNode node,int depth,List<List<TreeNode>> res){
        if (res.size() == depth){
            res.add(new ArrayList<>());
        }
        if (node==null) {
            res.get(depth).add(null);
            return;
        }
        res.get(depth).add(node);

        if (node.left!=null||node.right!=null){
            bfs(node.left, depth+1, res);
            if (node.right!=null) bfs(node.right, depth+1, res);
        }
        else return;
    }

    public static void main(String[] args) {
        Object[] a = {1,3,2,5,4,null,9};
        Object[] b = {1,3,2,5};
        Object[] c = {1,1,1,1,null,null,1,1,null,null,1};
        TreeNode in = Untils.creatTree(a);
        System.out.println(new Solution662().widthOfBinaryTree(in));

    }

}
