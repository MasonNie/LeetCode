import java.util.ArrayList;
import java.util.List;

public class Solution129 {
    public int sumNumbers(TreeNode root) {
        int res = 0;
        if (root==null) return res;
        List<Integer> list = new ArrayList<>();
        dfs(root,0,list);
        for (int i:list
             ) {
            res += i;
        }
        return res;

    }
    void dfs(TreeNode node, int path, List<Integer> list){
//        if (node==null) {
//            list.add(path);
//            return;
//        }
        if (node.left==null&&node.right==null){
            list.add(node.val+path*10);
            return;
        }
        path = path*10+node.val;
        if (node.left!=null) dfs(node.left,path,list);
        if (node.right!=null) dfs(node.right, path, list);
    }

    public static void main(String[] args) {
        Object[] a = {1,2,3};
        Object[] b = {4,9,0,5,1};
        TreeNode in = Untils.creatTree(b);
        System.out.println(new Solution129().sumNumbers(null));
    }
}
