public class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return builder(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }
    TreeNode builder(int[] indorder,int[] postorder,int start_in,int end_in,int start_post,int end_post){
        if (end_post<0) return null;
        TreeNode root = new TreeNode(postorder[end_post]);
        int idx_root = find(indorder,postorder[end_post]);
        int l_end_in= idx_root-1,l_start_in=l_end_in-(idx_root-start_in)+1;
        int r_start_in=idx_root+1,r_end_in=r_start_in+(end_in-idx_root)-1;
        int l_end_post=end_post-(end_in-idx_root)-1,l_start_post=l_end_post-(idx_root-start_in)+1;
        int r_end_post=end_post-1,r_start_post=r_end_post-(end_in-idx_root)+1;
        if (idx_root-start_in>0) root.left=builder(indorder, postorder, l_start_in, l_end_in, l_start_post, l_end_post);
        if (end_in-idx_root>0)  root.right=builder(indorder,postorder,r_start_in,r_end_in,r_start_post,r_end_post);
        return root;
    }
    int find(int[] inorder,int x){
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i]==x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution106 sol =new Solution106();
        int[] a={1,9,3,15,20,7};
        int[] b={1,9,15,7,20,3};
        System.out.println(Untils.cengCi(sol.buildTree(a,b)));
    }
}
