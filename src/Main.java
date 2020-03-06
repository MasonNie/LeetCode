import java.lang.reflect.Array;
import java.util.*;


public class Main {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode lianBiao(int[] a){
        ListNode res = new ListNode(0);
        ListNode now;
        now = res;
        for (int i=0;i<a.length;i++){
            now.next = new ListNode(a[i]);
            now = now.next;
        }
        return res.next;
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p,q,now;
        int count = 0;
        p = l1;
        q = l2;
        ListNode result = new ListNode(0);
        now = result;
        while(p!=null || q!=null){
            int x = (p!=null)? p.val:0;
            int y = (q!=null)? q.val:0;
            int sum = x+y+count;
            count = sum/10;
            now.next = new ListNode(sum%10);
            now = now.next;

            if (p != null) p=p.next;
            if (q != null) q=q.next;

        }
        return result.next;


    }

    public static int reverse(int x) {
        long res = 0;

        while(x!=0){
            int tmp = x%10;
            x = x/10;
            res = tmp + (res * 10);

        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
            return 0;
        return (int)res;
    }

    public static boolean isPalindrome(int x) {
        int x_t = x;
        if (x<0) return false;
        long r = 0;
        while(x_t!=0){
            int tmp = x_t%10;
            x_t = x_t/10;
            r = tmp + (r * 10);
        }
        if (r == (long)x) return true;
        else return false;

    }

    static int s2Int(char s) {
        int i = 0;
        if (s == 'I') i = 1;
        if (s == 'V') i = 5;
        if (s == 'X') i = 10;
        if (s == 'L') i = 50;
        if (s == 'C') i = 100;
        if (s == 'D') i = 500;
        if (s == 'M') i = 1000;
        return i;
    }
    public static int romanToInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int now = s2Int(s.charAt(i));
            int next = s2Int(s.charAt(i + 1));
            if (now < next) {
                res = res + -now;
            }
            else res = res + now;
        }
        return res + s2Int(s.charAt(s.length()-1));
    }

    public static String longestCommonPrefix(String[] strs) {
//        String res = "";
//        int j=0;
//        if (strs == null || strs.length == 0) return "";
//        while (j<strs[0].length()){
//            char a = strs[0].charAt(j);
//            for (int i=1;i<strs.length;i++){
//                if (j == strs[i].length() || strs[i].charAt(j) != a) {
//                    res = strs[0].substring(0,j);
//                    return res;
//                }
//            }
//            j++;
//        }
//        return res;
          if (strs.length == 0) return "";
          String prefix = strs[0];
          for (int i=1;i< strs.length;i++){
              while(strs[i].indexOf(prefix)!= 0){
                  prefix = prefix.substring(0,prefix.length() - 1);
                  if (prefix == "") return "";
              }
          }
          return prefix;

    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = l1,q = l2,now;
        ListNode res = new ListNode(0);
        now = res;
        while (p!=null && q!=null) {
            if (p.val < q.val){
                now.next = new ListNode(p.val);
                now = now.next;
                p = p.next;
            }else {
                now.next = new ListNode(q.val);
                now = now.next;
                q = q.next;
            }
        }
        if (p != null)  now.next = p;
        if (q != null)  now.next = q;
        return res.next;

    }

    public static int searchInsert(int[] nums, int target) { //35
        int res = nums.length;
        for (int i=0;i<nums.length;i++){
            if (nums[i]>=target) {
                res = i;
                break;
            }
        }
        return res;
    }

    public static String countAndSay(int n) {
        if (n == 1) return "1";
        String res = "";
        String str = countAndSay(n-1) + "*";
        int count = 1;
        for (int i=0;i<str.length()-1;i++){
            if (str.charAt(i)==str.charAt(i+1)){
                count += 1;
            }
            else {
                res = res + count + str.charAt(i);
                count = 1;
            }
        }
        return res;

    }

    public static String longestPalindrome(String s) { //5
        if (s.length()<=1) return s;
        int left = 0,right = 0;
        boolean dp[][]=new boolean[s.length()][s.length()];
        for (int i=s.length()-2;i>=0;i--){
            for (int j=i+1;j<s.length();j++){
                if (s.charAt(i)==s.charAt(j)&&(j-i+1<4||dp[i+1][j-1])){
                    dp[i][j]=true;
                    if (j-i+1>right-left+1){
                        right = j;
                        left = i;
                    }
                }
            }
        }
        return s.substring(left,right+1);

    }

    public static String convert(String s, int numRows){  //6
        if (numRows==1) return s;  //一行直接返回
        String res_t[] = new String[numRows]; //做结果
        for (int i=0;i<numRows;i++){ //初始化
            res_t[i]="";
        }
        int T = 2*numRows - 2;

        for (int i=0;i<s.length();i++){
            int a = i%T;  //循环结构
            if (a<numRows)
                res_t[a] += s.charAt(i);
            else
                res_t[T-a] += s.charAt(i);

        }
        String res = "";
        for (int i=0;i<numRows;i++){
                res += res_t[i];
        }
        return res;

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) { //4
        double res=0d;
        int p1=0,p2=0,tmp=0;
        int l1=nums1.length,l2=nums2.length;
        if (l1==0){
            if ((l1+l2)%2==0){
                res = nums2[(l1+l2)/2-1]+nums2[(l1+l2)/2];
                res = res/2;
            }
            else
                res = nums2[(l1+l2)/2];
            return res;
        }
        if (l2==0){
            if ((l1+l2)%2==0){
                res = nums1[(l1+l2)/2-1]+nums1[(l1+l2)/2];
                res = res/2;
            }
            else
                res = nums1[(l1+l2)/2];
            return res;
        }
        int num[] = new int[l1+l2];
        for (int i=0;i<l1+l2;i++){
            int n1 = p1<l1?nums1[p1]:Integer.MAX_VALUE;
            int n2 = p2<l2?nums2[p2]:Integer.MAX_VALUE;
            if (n1<n2){
                num[i]=n1;
                p1++;
            }

            else {
                    num[i] = n2;
                    p2++;
                }
            if(p1+p2>(l1+l2)/2){
                break;
            }

        }
        if ((l1+l2)%2==0){
            res = num[(l1+l2)/2-1]+num[(l1+l2)/2];
            res = res/2;
        }
        else
            res = num[(l1+l2)/2];
        return res;
    }

    public static int myAtoi(String str) {    //8
        if (str.length()==0) return 0;
        int res=0,p=0,flag=1;
        double bef_res = 0;
        while (p<str.length()){
            if (str.charAt(p)==' ') p++;
            else break;
        }
        if (p==str.length()) return 0;
        if ((str.charAt(p)>'9'||str.charAt(p)<'0')&&str.charAt(p)!='-'&&str.charAt(p)!='+') return 0;
        if (str.charAt(p)=='-') {
            flag = -1;
            p++;
        }
        else if (str.charAt(p)=='+') {
            p++;
        }
        for (int i=p;i<str.length();i++){
            if ((str.charAt(i)>'9'||str.charAt(i)<'0')) {
                break;
            }
            else if (bef_res<Long.MAX_VALUE/10&&bef_res>Long.MIN_VALUE/10)
                bef_res = bef_res*10 + (str.charAt(i)-'0');

        }
        bef_res *= flag;
        if (bef_res>Integer.MAX_VALUE) res = Integer.MAX_VALUE;
        else if (bef_res<Integer.MIN_VALUE) res = Integer.MIN_VALUE;
        else res = (int)bef_res;

        return res;

    }

    public static String intToRoman(int num) {  //要把没用的while改成if   12
        StringBuilder res = new StringBuilder();
        while (num>999){
           int qian = num/1000;
           res.append("M");
           num = num -1000;
        }
        while (num>99){
            int bai = num/100;
            if (bai == 9) {
                res.append("CM");
                num = num -900;
                break;
            }
            else if (bai == 4) {
                res.append("ID");
                num = num -400;
                break;
            }
            else if (bai >= 5) {
                res.append("D");
                num = num -500;
                continue;
            }
            else res.append("C");
            num = num-100;
        }
        while (num>9){
            int shi = num/10;
            if (shi == 9) {
                res.append("XC");
                num = num -90;
                break;
            }
            else if (shi == 4) {
                res.append("XL");
                num = num -40;
                break;
            }
            else if (shi >= 5) {
                res.append("L");
                num = num -50;
                continue;
            }
            else res.append("X");
        }
        while (num>0){
            int ge = num;
            if (ge == 9) {
                res.append("IX");
                break;
            }
            else if (ge == 4) {
                res.append("IV");
                break;
            }
            else if (ge >= 5) {
                res.append("V");
                num=num-5;
                continue;
            }
            else res.append("I");
            num --;
        }
        return res.toString();


    }

    public static int maxArea(int[] height) {
        if (height.length==0) return 0;
        int res = 0;
        int start=0,end=height.length-1;
        while (start<end){
            int len = end -start;
            int water = 0;
            if (height[start]<height[end]) {
                water=height[start];
                start++;
            }
            else {
                water=height[end];
                end--;
            }
            res = res > len*water?res:len*water;
        }
        return res;

    }


    public static List<List<Integer>> threeSum(int[] nums) {  //15
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length<3) return null;
        Arrays.sort(nums);
        for (int i=0;i<nums.length-2;i++){
            if (i>0&&nums[i]==nums[i-1]) continue;
            int l=i+1,r=nums.length-1;
            while (l<r){
                if (nums[i]+nums[l]+nums[r]==0){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[l]);
                    tmp.add(nums[r]);
                    res.add(tmp);
                    while(l<r&&nums[l]==nums[l+1]) l++;
                    while(l<r&&nums[r]==nums[r-1]) r--;
                    l++;
                    r--;

                }
                else if (nums[i]+nums[l]+nums[r]>0){
                    r--;
                }
                else if (nums[i]+nums[l]+nums[r]<0){
                    l++;
                }
            }

        }
        return res;

    }

    public static int threeSumClosest(int[] nums, int target) {
        int res = 0;
        int len = nums.length;
        if (nums==null||len<3) return res;
        int residual = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i=0;i<len-2;i++){
            if (i>0&&nums[i]==nums[i-1]) continue;
            int l=i+1,r=len-1;
            while (l<r){
                int cha = nums[i]+nums[l]+nums[r]-target;
                if (cha==0){
                    return target;
                }
                else if (cha>0){
                    r--;
                    if (residual>cha) {
                        res = cha+target;
                        residual = cha;
                    }
                }
                else {
                    l++;
                    if (residual>(-cha)) {
                        res = cha+target;
                        residual = -cha;
                    }
                }
            }
        }
        return res;
    }

//    public static List<String> letterCombinations(String digits) {  //17
//
//    }

    public static List<List<Integer>> fourSum(int[] nums, int target) { //18
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len<4) return res;
        Arrays.sort(nums);
        for (int i=0;i<len-3;i++){
            if (i>0&&nums[i]==nums[i-1]) continue;
            for (int j=i+1;j<len-2;j++){
                if (j>i+1&&nums[j]==nums[j-1]) continue;
                int l=j+1,r=len-1;
                while(l<r){
                    int sum = nums[i] + nums[j] + nums[l] +nums[r];
                    if (sum==target){
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[l]);
                        tmp.add(nums[r]);
                        res.add(tmp);
                        while (l<r&&nums[l]==nums[l+1]) l++;
                        while (l<r&&nums[r]==nums[r-1]) r--;
                        l++;
                        r--;
                    }
                    else if (sum>target){
                        r--;
                    }
                    else {
                        l++;
                    }
                }
            }
        }
        return res;

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {  //19
        if (head==null) return null;
        if (head.next==null&&n==1) return null;
        ListNode p = head,q = head;
        int count = 0;
        while (p!=null){
            if (count>n){
                q = q.next;
            }
            count ++;
            p = p.next;
        }
        if (count<=n) head = head.next;
        else if (n>0)q.next=q.next.next;

        return head;

    }

    static void backtrack(List<String> res,String s,int open,int close,int n){   //22
        if (s.length()==2*n){
            res.add(s);
            return;
        }
        if (open<n){
            backtrack(res,s+"(",open+1,close,n);
        }
        if (close<open){
            backtrack(res,s + ")",open,close+1,n);
        }

    }
    public static List<String> generateParenthesis(int n) {  //22

        List<String> res = new ArrayList<>();
        backtrack(res,"",0,0,n);
        return res;

    }



    public static ListNode swapPairs(ListNode head) {
        if (head==null||head.next==null) return head;
        ListNode p=head,q=p.next,tmp=null;
        head = q;
        while(p!=null){
            p.next=q.next;
            q.next=p;
            tmp = p;
            p=p.next;
            if (p!=null){
                q=p.next;
                if (q==null) break;
                tmp.next = q;
            }



        }
        return head;

    }
    public static void leftSee(List<Integer> out,TreeNode root,int depth){
        if (root==null) return;
        if (out.size() == depth) out.add(root.val);
        leftSee(out, root.right, depth+1);
        leftSee(out, root.left, depth+1);
    }


    public static void main(String[] args) {
        Integer a = new Integer(2);
        Integer b = new Integer(2);
        Integer c = new Integer(3);
        Object[] objects = {1,2,3,null,5,null,4};
        TreeNode treeNode = Untils.creatTree(objects);
        List<Integer> out = new ArrayList<>();
        leftSee(out,treeNode,0);
        System.out.println(out);
        List<Integer> test_a = Arrays.asList(1,2);
        List<Integer> test_b = Arrays.asList(1,2);
        System.out.println(test_a.equals(test_b));

        a = 1113;b = 1113;
        System.out.println(a == b);
    }
}
