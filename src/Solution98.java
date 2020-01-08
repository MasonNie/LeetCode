
public class Solution98 {
    long post = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        boolean res=false;

        res = inorder(root);
        return res;
    }
    boolean inorder(TreeNode root){
        if (root==null) return true;
        boolean left = inorder(root.left);
        if (root.val<=post) return false;
        post=root.val;
        return left&&inorder(root.right);
    }

    public static void main(String[] args) {
        Object[] a={Integer.MIN_VALUE};
        TreeNode in = new Untils().creatTree(a);
        System.out.println(new Solution98().isValidBST(in));
    }
}
