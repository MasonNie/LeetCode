import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution99 {
    public void recoverTree(TreeNode root) {
        if (root==null) return;
        Map<Integer,TreeNode> map = new HashMap<Integer, TreeNode>();
        ArrayList<Integer> list = new ArrayList();
        inorder(map,root,list);
        int last = -1;

        for (int i=list.size()-1;i>0;i--) {
            if (last==-1&&list.get(i)<list.get(i-1)) last=i;
            if (last!=-1&&list.get(i-1)<list.get(last)) {
                int tmp = map.get(list.get(i)).val;
                map.get(list.get(i)).val = map.get(list.get(last)).val;
                map.get(list.get(last)).val = tmp;
                return;
            }
        }
        if (last!=-1){
            int tmp = map.get(list.get(0)).val;
            map.get(list.get(0)).val = map.get(list.get(last)).val;
            map.get(list.get(last)).val = tmp;
        }
    }
    void inorder(Map map,TreeNode node,ArrayList list){
        if (node==null) return;
        inorder(map,node.left,list);
        map.put(node.val,node);
        list.add(node.val);
        inorder(map, node.right,list);
    }

    public static void main(String[] args) {
        Object[] a = {1,3,null,null,2};
        Object[] b = {3,1,4,null,null,2};
        TreeNode root = Untils.creatTree(b);
        new Solution99().recoverTree(root);
        System.out.println(Untils.inorder(root,new ArrayList<>()));

    }
}
