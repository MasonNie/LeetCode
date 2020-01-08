import java.util.*;

public class Solution1028 {
    public TreeNode recoverFromPreorder(String S) {//无法处理有重复数值的
        String[] nums = S.split("-");
        int count = 1;
        Map<Integer,Integer> map = new LinkedHashMap<Integer,Integer>();
        TreeNode root = new TreeNode(Integer.valueOf(nums[0]));
        for (int i = 1; i < nums.length; i++) {
            if (!nums[i].isEmpty()) {
                map.put(Integer.valueOf(nums[i]),count);
                count = 1;
            }else {
                count++;
            }
        }
        bulider(root,1,map);
        return root;
    }
    TreeNode getVal(Map<Integer,Integer> map,int depth){
        Iterator<Integer> iter = map.keySet().iterator();
        while (iter.hasNext()){
            int key = iter.next(),val = map.get(key);
            if (val<depth) break;
            if (val==depth){
                map.remove(key);
                return new TreeNode(key);
            }
        }
        return null;
    }
    TreeNode bulider(TreeNode root,int depth,Map<Integer,Integer> map){
        TreeNode node = getVal(map,depth);
        if (node!=null){
            root.left = bulider(node,depth+1,map);
            node = getVal(map,depth);
            if (node!=null) root.right = bulider(node,depth+1,map);
        }
        return root;
    }

    public static void main(String[] args) {
        String in = "1-2--3--4-5--6--7";
        TreeNode root = new Solution1028().recoverFromPreorder("1-2--3---4-5--6---7");
        System.out.println(Untils.cengCi(root));

    }
}
