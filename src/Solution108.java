import java.util.ArrayList;

public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;

        return builder(nums,0,len);
    }
    TreeNode builder(int[] nums,int start,int end){
        if (start==end) return null;
        int mid = (start+end)/2;
        TreeNode now = new TreeNode(nums[mid]);
        now.left=builder(nums, start, mid);
        now.right=builder(nums,mid+1,end);
        return now;
    }

    public static void main(String[] args) {
        int[] in = {-10,-3,0,5,9};
        TreeNode node = new Solution108().sortedArrayToBST(in);
        System.out.println(Untils.inorder(node,new ArrayList<>()));
    }
}
