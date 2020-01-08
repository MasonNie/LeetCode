import java.time.temporal.Temporal;
import java.util.HashMap;
import java.util.Map;

public class Solution993 {
    Map<Integer,TreeNode> parent;
    Map<Integer,Integer> depth;
    public boolean isCousins(TreeNode root, int x, int y) {
        parent = new HashMap<>();
        depth = new HashMap<>();
        dfs(root,null);
        boolean res = depth.get(x)==depth.get(y)&&parent.get(x)!=parent.get(y);
        return res;
    }
    void dfs(TreeNode node,TreeNode par){
        if (node!=null){
            depth.put(node.val,par==null?0:depth.get(par.val)+1);
            parent.put(node.val,par);
            dfs(node.left,node);
            dfs(node.right,node);
        }
    }


    public static void main(String[] args) {
        Object[] a = {1,2,3,4};
        TreeNode in = Untils.creatTree(a);
        System.out.println(new Solution993().isCousins(in,4,1));
    }
}
