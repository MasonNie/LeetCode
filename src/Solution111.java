public class Solution111 {
    int res = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if  (root==null) return 0;
        helper(root,1);
        return res;
    }
    void helper(TreeNode node,int depth){
        if (node.left==null&&node.right==null) {
            if (depth<res)
                res = depth;
        }
        if (node.left!=null) helper(node.left,depth+1);
        if (node.right!=null) helper(node.right,depth+1);

    }

    public static void main(String[] args) {
        Object[] a = {3,9,20,1,null,15,7};
        System.out.println(new Solution111().minDepth(Untils.creatTree(a)));
    }
}
