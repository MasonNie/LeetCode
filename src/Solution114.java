import java.util.ArrayList;

public class Solution114 {
    public void flatten(TreeNode root) {
        if (root==null) return;
        if (root.left==null&&root.right==null) return;
        TreeNode node = root,right=null;
        while (node!=null){
            if (node.left==null){
                node = node.right;
                continue;
            }
            right = node.right;
            node.right = node.left;
            node.left = null;
            findRight(node).right = right;
            node = node.right;
        }

    }
    TreeNode findRight(TreeNode node){
        while (node.right!=null){
            node = node.right;
        }
        return node;
    }


    public static void main(String[] args) {
        Object[] a = {1,2,5,3,4,null,6};
        Object[] b = {1,null,2,3};
        Object[] c = {1,2,null,3,4,5};
        TreeNode root = Untils.creatTree(c);
        System.out.println(Untils.preorder(root,new ArrayList<>()));
        new Solution114().flatten(root);
        System.out.println(Untils.cengCi(root));
    }
}
