public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        if (root==null) return true;
        return check(root)!=-1;
    }
    int check(TreeNode node){
        if (node==null){
            return 0;
        }
        int left = check(node.left);
        if (left==-1) return -1;
        int right = check(node.right);
        if (right==-1) return -1;

        return Math.abs(left-right)>1?-1:Math.max(check(node.left),check(node.right))+1;
    }

    public static void main(String[] args) {
        Object[] a = {3,9,20,null,null,15,7};
        Object[] b= {1,2,2,3,3,null,null,4,4};
        System.out.println(new Solution110().isBalanced(Untils.creatTree(a)));
    }
}
