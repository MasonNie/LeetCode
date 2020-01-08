public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l1=m-1,l2=n-1,pos=m+n-1;
        for(int i=pos;i>=0;i--){
            int n1=l1<0?Integer.MIN_VALUE:nums1[l1];
            int n2=l2<0?Integer.MIN_VALUE:nums2[l2];
            if(n1>n2){
                nums1[i]=n1;
                l1--;

            }
            else{
                nums1[i]=n2;
                l2--;

            }
        }

    }

    public static void main(String[] args) {
        int[] a={-1,2,3,0,0,0},b={2,5,6};
        new Solution88().merge(a,a.length-b.length,b,b.length);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }
}

