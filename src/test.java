import java.util.*;

public class test {
    int res = 0;
    int findlongest(String s){
        if(s.length()<2) return s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int start = 0,res = 0;
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),i);
                res = Math.max(res,i-start+1);
            }else{
                if(map.get(s.charAt(i))>=start){
                    start = map.get(s.charAt(i))+1;
                }
                else{
                    map.put(s.charAt(i),i);
                    res = Math.max(res,i-start+1);
                }
            }
        }
        return res;
    }
    public int reversePairs(int[] nums) {
        if(nums.length<2) return 0;
        mergeSort(nums,0,nums.length-1);
        return res;
    }
    void mergeSort(int[] nums,int start,int end){
        if(start>=end) return;
        int mid = start + (end - start)/2;
        mergeSort(nums,start,mid);
        mergeSort(nums,mid+1,end);
        merge(nums,start,mid,end);
    }
    void merge(int[] nums,int start,int mid,int end){
        int[] m = new int[end-start+1];
        int pos = 0,l=start,r=mid+1;
        while(l<=mid&&r<=end){
            if(nums[l]>nums[r]){
                res += (mid - l + 1);
                m[pos++] = nums[r++];
            }else{
                m[pos++] = nums[l++];
            }
        }
        System.out.println(m.length);
        while(l<=mid) m[pos++] = nums[l++];
        while(r<=end) m[pos++] = nums[r++];
        for(int i=0;i<m.length;i++){
            nums[start+i] = m[i];
        }
    }
    int[][] dircs = {{-1,0},{0,-1},{1,0},{0,1}};
    int m,n;
    boolean[][] used;
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new LinkedList<>();
        m=matrix.length;
        if(m==0) return res;
        n= matrix[0].length;
        used = new boolean[m][n];
        boolean[][] pec = new boolean[m][n];
        boolean[][] artc = new boolean[m][n];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            int code = i*n+0;
            if (!used[i][0]){
                pec[i][0] = true;
                used[i][0] = true;
                q.offer(code);
            }

        }
        for(int j=1;j<n;j++){
            int code = j;
            if(!used[0][j]){
                pec[0][j] = true;
                used[0][j] = true;
                q.offer(code);
            }

        }

        bfs(pec,q,matrix);

        //print(pec);
        for(int i=0;i<used.length;i++){
            Arrays.fill(used[i],false);
        }

        for(int i=0;i<m;i++){
            int code = i*n+n-1;
            if (!used[i][n-1]){
                artc[i][n-1] = true;
                used[i][n-1] = true;
                q.offer(code);
            }

        }
        for(int j=0;j<n-1;j++){
            int code = (m-1)*n+j;
            if (!used[m-1][j]){
                artc[m-1][j] = true;
                used[m-1][j] = true;
                q.offer(code);
            }

        }
        bfs(artc,q,matrix);
        //print(artc);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(artc[i][j]&&pec[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;

    }
    void bfs(boolean[][] res, Queue<Integer> q, int[][] matrix){
        while(!q.isEmpty()){
            int code = q.poll();
            int r = code/n,c = code%n;
            used[r][c] = true;
            for(int[] dirc:dircs){
                int newr = r+dirc[0],newc = c+dirc[1];
                if(newr>=0&&newr<m&&newc>=0&&newc<n&&!used[newr][newc]&&matrix[newr][newc]>=matrix[r][c]){
                    used[newr][newc] = true;
                    res[newr][newc] = true;
                    q.offer(newr*n+newc);
                }
            }
        }
    }
    void print(boolean[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] in = {
                {1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}
        };
        int[] a = {7,5,6,4};
        System.out.println(new test().findlongest("abcdaebefghi"));
    }
}
