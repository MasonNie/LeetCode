import java.util.LinkedList;
import java.util.List;

public class Solution95 {
    public List<TreeNode> generateTrees(int n) {
        if (n==0) return null;
        return generate(1,n);

    }
    List<TreeNode> generate(int start,int end){
        List<TreeNode> all_tree = new LinkedList<TreeNode>();
        if (start>end){
            all_tree.add(null);
            return all_tree;
        }
        for (int i = start; i <end+1 ; i++) {
            List<TreeNode> left =  generate(start,i-1);
            List<TreeNode> right = generate(i+1,end);
            for (TreeNode l:left) {
                for (TreeNode r:right) {
                    TreeNode root = new TreeNode(i);
                    root.left=l;root.right=r;
                    all_tree.add(root);
                }
            }
        }
        return all_tree;
    }

    public static void main(String[] args) {
        for (TreeNode t:new Solution95().generateTrees(3)){
            System.out.println(Untils.cengCi(t));
        }
    }
}
