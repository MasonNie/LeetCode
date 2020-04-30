import javafx.beans.property.ReadOnlyIntegerWrapper;

import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.awt.Point;

public class Tester{
    public int maxJumps(int[] arr, int d) {
        int[] cache = new int[arr.length];
        int res = 1;
        for(int i=0;i<arr.length;i++){
            res = Math.max(res,dfs(arr,d,i,cache));
        }
        return res;
    }
    int dfs(int[] arr,int d,int pos,int[] cache){
        //if(pos<0||pos>=arr.length) return 0;

        int max = 1;
        for(int i=1;i<=d;i++){
            if(pos+i<arr.length&&arr[pos+i]<arr[pos]) max = Math.max(max,1+dfs(arr,d,pos+i,cache));
            else break;
        }
        for(int i=1;i<=d;i++){
            if(pos-i>=0&&arr[pos-i]<arr[pos]) max = Math.max(max,1+dfs(arr,d,pos-i,cache));
            else break;
        }
        return max;
    }
    void mergeSort(int[] nums,int start,int end,int[] res){
        if (start>=end) return;
        int mid = start + (end - start)/2;
        mergeSort(nums, start, mid,res);
        mergeSort(nums,mid+1,end,res);
        //int[] tmp = new int[end-start+1];
        int l = start,r = mid+1,pos = start;
        while(l<=mid&&r<=end){
            if (nums[l]<nums[r]){
                res[pos++] = nums[l++];
            }else res[pos++] = nums[r++];
        }
        while (l<=mid) res[pos++] = nums[l++];
        while (r<=end) res[pos++] = nums[r++];
        for (int i = start; i <=  end; i++) {
            nums[i] = res[i];
        }
    }
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")) return "0";
        if(num1.equals("1")) return num2;
        if(num2.equals("1")) return num1;
        String res = "0";
        for(int i=num2.length()-1;i>=0;i--){
            res = add(res,coreMulti(num1,num2.charAt(i)-'0',num2.length()-1-i));
        }
        return res;
    }
    String coreMulti(String num1,int time,int base){
        if(time==0) return "0";
        String tail = "";
        for(int i=0;i<base;i++){
            tail = tail + "0";
        }
        if(time==1) return num1+tail;
        String res = "0";
        for(int i=0;i<time;i++){
            res = add(res,num1);
        }

        return res+tail;
    }
    String add(String num1, String num2){
        if(num1.equals("0")) return num2;
        if(num2.equals("0")) return num1;
        int p1 = num1.length()-1,p2 = num2.length()-1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while(p1>=0||p2>=0){
            int n1 = p1<0?0:num1.charAt(p1)-'0';
            int n2 = p2<0?0:num2.charAt(p2)-'0';
            int sum = n1 + n2 +carry;
            carry = (sum)/10;
            res.append(sum%10);
            p1--;p2--;
        }
        if(carry>0) res.append(carry);
        return res.reverse().toString();
    }
    Semaphore r_count = new Semaphore(1);
    Semaphore mutex = new Semaphore(1);
    ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock(true);
    int rcount = 0;
    int data = 0;
    void reader(){
        while (true){
            try {
                Thread.sleep((long)Math.random()*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try{
                rwlock.readLock().lock();
//                r_count.acquire();
//                rcount++;
//                if (rcount==1) mutex.acquire();
//                r_count.release();
//                //read
                System.out.println(Thread.currentThread().getName()+"read date"+data);
//                r_count.acquire();
//                rcount--;
//                if (rcount==0) mutex.release();
//                r_count.release();
            }catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                rwlock.readLock().unlock();
            }
        }

    }
    void wirter(){
        while(true){
            try {
                Thread.sleep((long)Math.random()*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
//                mutex.acquire();
                rwlock.writeLock().lock();
                this.data = new Random().nextInt(321);
                System.out.println(Thread.currentThread().getName()+"wirte data"+this.data);
//                mutex.release();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                rwlock.writeLock().unlock();
            }
        }

    }
    int dp(int n, int[][] flights, int src, int dst, int K){
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(mat[i],Integer.MAX_VALUE);
        }
        for(int i=0;i<flights.length;i++){

            mat[flights[i][0]][flights[i][1]] = flights[i][2];
        }
        for(int k=0;k<K;k++){
            int[][] dptmp = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dptmp[i],Integer.MAX_VALUE);
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if (i==j) continue;
                    dptmp[i][j] = Math.min(mat[i][j],dptmp[i][j]);
                    for(int r=0;r<n;r++){
                        if (r==i||r==j) {
                            continue;
                        }
                        else if(mat[i][r]!=Integer.MAX_VALUE&&mat[r][j]!=Integer.MAX_VALUE){
                            dptmp[i][j] = Math.min(dptmp[i][j],mat[i][r]+mat[r][j]);
                            if (i==src&&j==dst&&dptmp[i][j]<mat[i][j])
                                System.out.println(r);
                        }

                    }

                }
            }
            mat = dptmp;
            System.out.println("dp: "+mat[src][dst]);
        }
        return mat[src][dst];
    }
    int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] dist = new int[2][n];
        int INF = Integer.MAX_VALUE / 2;
        Arrays.fill(dist[0], INF);
        Arrays.fill(dist[1], INF);
        dist[0][src] = dist[1][src] = 0;
        for (int i = 0; i <= K; ++i){
            for (int[] edge: flights){
                dist[i&1][edge[1]] = Math.min(dist[i&1][edge[1]], dist[~i&1][edge[0]] + edge[2]);

            }System.out.println("tiJie: "+dist[i&1][dst]);
        }
        return dist[K&1][dst] < INF ? dist[K&1][dst] : -1;
    }

    public static void main(String[] args) {
        int[] a  = {6,4,14,6,8,13,9,7,10,6,12};


        int[] b = {7,6,5,4,3,2,1};
        int[] in = b;
        int[] res = new int[in.length];
        Tester tester = new Tester();
        HashMap<Character,Integer> map = new HashMap<>();
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue()-o1.getValue();

            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>(1);
        pq.offer(1);
        pq.offer(-1);
        new ArrayList<Integer>(pq);
        Point p = new Point(0,0),p2 = new Point(1,1);



//        for (int i = 0; i < 3; i++) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    tester.reader();
//                }
//            },"reader"+i).start();
//        }
//        for (int i = 0; i < 3; i++) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    tester.wirter();
//                }
//            },"writer"+i).start();
//        }

//        System.out.println(tester.add("11640","10897461"));
//        System.out.println(11640+10897461);
    }
}
