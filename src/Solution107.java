import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        helper(res,0,root);
        Collections.reverse(res);
        return res;
    }
    void helper(List<List<Integer>> res,int level,TreeNode node){
        if (node==null) return;
        if (level>=res.size()){
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        helper(res, level+1, node.left);
        helper(res, level+1, node.right);
    }
    public static void main(String[] args) {
        Object[] a={3,9,20,null,null,15,7};
        TreeNode in = Untils.creatTree(a);
        System.out.println(new Solution107().levelOrderBottom(in));
    }
}
