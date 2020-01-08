import java.util.ArrayList;

public class Solution109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head==null) return null;
        ArrayList<Integer> list = new ArrayList<Integer>();
        ListNode p = head;
        while (p!=null){
            list.add(p.val);
            p = p.next;
        }
        int size = list.size();
        TreeNode root = builder(list,0,size-1);
        return root;
    }
    TreeNode builder(ArrayList<Integer> list,int l,int r){
        if (l>r) return null;
        //if (l==r) return new TreeNode(list.get(l));
        int mid = (l+r)%2==0?(l+r)/2:(l+r)/2+1;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = builder(list,l,mid -1);
        node.right = builder(list,mid +1,r);
        return node;
    }


    public static void main(String[] args) {
        int[] in = {-10,-3,0,5,9,10};
        Solution109 sol = new Solution109();
        TreeNode root = sol.sortedListToBST(Untils.lianBiao(in));

    }
}
