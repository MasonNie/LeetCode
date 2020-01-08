import java.util.*;

public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root==null) return res;
        inorder(root,res);
        return res;
    }
    void inorder(TreeNode root,List<Integer> res){
        if (root==null) return;

        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }

}

