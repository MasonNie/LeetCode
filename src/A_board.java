import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class A_board {
    void heapSort(int[] nums){
        if (nums.length==0) return;
        for (int i = (nums.length-1-1)/2; i >=0 ; i--) {
            heapify(nums,i,nums.length-1);
        }
        for (int i=nums.length-1;i>0;i--){
            int tmp = nums[i];
            nums[i] = nums[0];
            nums[0] = tmp;
            heapify(nums,0,i-1);
        }
    }

    private void heapify(int[] nums, int idx, int end) {
        if (idx==end) return;
        int val = nums[idx],left = 2*idx+1;
        while (left<=end){
            int bigest = left,right = left+1;
            if (right<=end&&nums[left]<nums[right]){
                bigest = right;
            }
            if (nums[bigest]<=val) break;
            else {
                nums[idx] = nums[bigest];
                idx = bigest;
                left = 2*idx+1;
            }
        }
        nums[idx] = val;
    }


    public int findNumberOfLIS(int[] nums) {
        if (nums.length<2) return nums.length;
        int res = 0,max = 1;
        int[] dp = new int[nums.length],time = new int[nums.length];
        Arrays.fill(dp,1);
        Arrays.fill(time,1);
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if (dp[i]<dp[j]+1){
                        dp[i] = Math.max(dp[j]+1,dp[i]);
                        time[i] = time[j];

                    }else if(dp[i]== (dp[j]+1)){
                        time[i] += time[j];
                    }
                }
            }
            if (dp[i]>max) {
                max =dp[i];
            }

        }
        if (max == 1) return nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i]==max) res += time[i];
        }
        return res;
    }
    public String convertToTitle(int n) {
        //n = n-1;
        StringBuilder bu = new StringBuilder();
        while(n>0){
            int c = (n)%26;
            if(c==0) {
                c = 26;
                n -= 26;

            }
            bu.append((char)(c+64));

            n = n/26;
        }
        Stack<Integer> s = new Stack<>();
        return bu.reverse().toString();

    }
    void preorder(TreeNode root){
        Stack<TreeNode> s = new Stack<>();
        TreeNode now = root;
        while (now!=null||!s.isEmpty()){
            while (now!=null){
                System.out.print(now.val+" ");
                s.push(now);
                now = now.left;
            }
            now = s.pop().right;
        }
    }
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
     List<Integer> res;
     public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
         res = new LinkedList<>();
         dfs(root,target,K);
         return res;
     }
     void findSub(TreeNode target,int K){
         if(target==null) return ;
         if(K==0) {
             res.add(target.val);
             return ;
         }
         findSub(target.left,K-1);
         findSub(target.right,K-1);
     }
     int dfs(TreeNode root, TreeNode target, int K){
         if(root==null) return -1;
         if(root==target) {
             findSub(target,K);
             return K;
         }
         int l = dfs(root.left,target,K);
         int r = dfs(root.right,target,K);
         if(l<0&&r<0){
             return -1;
         }else if(l>0){
             if(l==1){
                 res.add(root.val);
                 //return 1;
             }else{
                 findSub(root.right,K-2);
             }
             return l-1;
         }else {
             if(r==1){
                 res.add(root.val);
                 //return 1;
             }else{
                 findSub(root.left,K-2);
             }
             return r-1;
         }

     }

        int[][] drcs = {{-1,0},{1,0},{0,-1},{0,1}};
        public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
            int[][] res = new int[R*C][2];
            boolean[][] used = new boolean[R][C];
            res[0][0] = r0;
            res[0][1] = c0;
            if(R==1&C==1) return res;
            used[r0][c0] = true;
            int head = 0,len = 1;
            while(len>0){
                int size = len;
                //System.out.println("size:" + size);
                for(int i=0;i<size;i++){
                    head++;
                    len --;
                    for(int[] drc:drcs){
                        int x = res[head-1][0]+drc[0],y = res[head-1][1]+drc[1];
                        if(x>=0&&x<R&&y>=0&&y<C&&!used[x][y]){
                            used[x][y] = true;
                            //System.out.println(x+" "+y +" "+res[head+i-1][0] +" "+res[head+i-1][1]);
                            res[head+len][0] = x;
                            res[head+len][1] = y;
                            len++;
                        }
                    }
                }
            }
            return res;
        }
    void merge(LinkedList<int[]> inters){
        Collections.sort(inters,new Comparator<int[]>(){
            public int compare(int[] o1,int[] o2){
                return o1[0] - o2[0];
            }
        });
        Iterator<int[]> iter = inters.iterator();
        int[] last = iter.next();
        while(iter.hasNext()){
            int[] now = iter.next();
            if(last[1]+1==now[0]){
                last[1] = now[1];
                iter.remove();
            }
            else last = now;
        }

    }
    String trytest() {
            String  res = "aaaaaa";
        try {
            res = "bbbbbb";
            return res;
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            res = "cccccc";
            return res;
        }
        //return res;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<char[],List<String>> map = new HashMap<>();
        boolean[] used = new boolean[strs.length];
        for(int i=0;i<strs.length;i++){
            if(!used[i]){
                used[i] = true;
                List<String> tmp = new ArrayList<>();
                tmp.add(strs[i]);
                for(int j=i+1;j<strs.length;j++){
                    if(!used[j]&&check(strs[i],strs[j])){
                        used[j] = true;
                        tmp.add(strs[j]);
                    }
                }
                res.add(tmp);
            }
        }
        return res;
    }
    boolean check(String s1,String s2){
        int[] a = new int[26];
        int[] b = new int[26];
        for(char c:s1.toCharArray()){
            a[c-'a']++;
        }
        for(char c:s2.toCharArray()){
            if(a[c-'a']==0) return false;
            b[c-'a']++;
        }
        for(int i=0;i<26;i++){
            if(a[i]!=b[i]) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        //int[] a = {2 ,6, 5, 6, 3, 5};
        Semaphore s1 = new Semaphore(1);
        Semaphore s2 = new Semaphore(0);
        String a = "abc";
        String b = new String("abc");
        System.out.println(a==b);
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>(16,.75f,true);
        Iterator<Integer> iter = map.keySet().iterator();
        iter.next();
        HashSet<Integer> set = new HashSet<>();
        set.remove(1);

        A_board a_board =new A_board();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 5; i++) {
//                    try{
//                        s1.acquire();
//                        System.out.print("A");
//                        s2.release();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 5; i++) {
//                    try{
//                        s2.acquire();
//                        System.out.print("B");
//                        s1.release();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
//        Scanner sc = new Scanner(System.in);
//        sc.nextInt();

    }
}
