import java.util.ArrayList;
import java.util.List;

public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        return isMirror(root,root);
//        List<Integer> zhongXu = new ArrayList<>();
//        inorder(root,zhongXu);
//        int size = zhongXu.size();
//        if (size%2 == 0) return false;
//        else {
//            for (int i = 0; i < size/2; i++) {
//                if (zhongXu.get(i)!=zhongXu.get(size-i-1)) return false;
//            }
//        }
//        return true;
    }
    void inorder(TreeNode root,List<Integer> res){
        if (root==null) return ;
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }
    boolean isMirror(TreeNode r1,TreeNode r2){
        if (r1==null&&r2==null) return true;
        if (r1==null||r2==null) return false;
        return (r1.val==r2.val)&&
                isMirror(r1.left,r2.right)&&
                isMirror(r1.right,r2.left);

    }

    public static void main(String[] args) {
        Object[] array = {1,2,2,2,null,2};
        TreeNode root = Untils.creatTree(array);
        System.out.println(new Solution101().isSymmetric(root));
    }
}
