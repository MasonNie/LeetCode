import java.util.regex.Matcher;

public class Solution124 {
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root==null) return max;
        max = root.val;
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(dfs(node.left),0); //如果不能起作用负数就不加
        int right = Math.max(dfs(node.right),0);
        int path = node.val + left + right;
        if (path>max) max = path;

        return node.val + Math.max(left,right);
        //之所以max（left，right）是因为return的时候返回上一层的是一条路径不能是左右都走
        //上文之所以算path是因为可能这个节点是个根节点
    }

    public static void main(String[] args) {
        Object[] objects = {1,-2,3};
        Object[] objects1 = {-10,9,20,null,null,15,7};
        TreeNode a = Untils.creatTree(objects);

        TreeNode in = a;
        System.out.println(new Solution124().maxPathSum(in));
    }
}
