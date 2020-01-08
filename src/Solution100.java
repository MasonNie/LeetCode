public class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null||q==null){
            if (p==null&&q==null) return true;
            else return false;
        }
        boolean first = p.val==q.val;
        return first&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);


    }

}

