import java.util.ArrayList;
import java.util.List;

public class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) return res;
        dfs(root,sum,res,new ArrayList<>());
        return res;
    }
    void dfs(TreeNode node,int sum,List<List<Integer>> res,List<Integer> path){
        if (node==null) return;
        if (node.left==null&&node.right==null&&sum==node.val){
            path.add(node.val);
            res.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }
        path.add(node.val);
        dfs(node.left,sum-node.val,res,path);
        dfs(node.right,sum-node.val,res,path);
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        Object[] tree = {5,4,8,11,null,13,4,7,2,null,null,5,1};
        Object[] tree2 = {-2,null,-3};
        TreeNode root = Untils.creatTree(tree2);
        //System.out.println(Untils.cengCi(root));
        System.out.println(new Solution113().pathSum(root,-5));
    }
}
