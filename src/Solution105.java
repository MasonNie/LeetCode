import javax.rmi.CORBA.Util;

public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }
    TreeNode build(int[] preorder,int[] inorder,int start_pre,int end_pre,int start_in,int end_in){
        if (start_pre>=preorder.length) return null;
        TreeNode root = new TreeNode(preorder[start_pre]);
        if (start_in==end_in) return root;
        int idx_root = find(inorder,preorder[start_pre]);
        int start_pre_l = start_pre+1,end_pre_l=start_pre_l+(idx_root-start_in)-1;
        int start_pre_r=end_pre_l+1,end_pre_r=start_pre_r+(end_in-idx_root)-1;
        int end_in_l=idx_root-1,start_in_l=end_in_l-(idx_root-start_in)+1;
        int start_in_r=idx_root+1,end_in_r=start_in_r+(end_in-idx_root)-1;
        if (start_pre_l<=end_pre_l){
            root.left=build(preorder, inorder, start_pre_l, end_pre_l, start_in_l, end_in_l);
        }
        if (start_pre_r<=end_pre_r){
            root.right=build(preorder, inorder, start_pre_r, end_pre_r,start_in_r,end_in_r );
        }

        return root;
    }
    int find(int[] a,int x){
        for (int i = 0; i <a.length ; i++) {
            if (a[i]==x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution105 sol =new Solution105();
        int[] a={3,9,1,2,20,15,7};
        int[] b={1,9,2,3,15,20,7};
        System.out.println(Untils.cengCi(sol.buildTree(a,b)));
    }
}
