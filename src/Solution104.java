public class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        return helper(root);
    }
    int helper(TreeNode root){
        if (root==null) return 0;
        return Math.max(helper(root.left),helper(root.right))+1;
    }

    public static void main(String[] args) {
        Object[] a = {3,9,20,null,null,15,7};
        TreeNode in = Untils.creatTree(a);
        System.out.println(new Solution104().maxDepth(in));
    }
}
