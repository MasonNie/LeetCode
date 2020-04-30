public class HeapSortTest {
    void heapSort(int[] nums){
        for(int i=(nums.length-1-1)/2;i>=0;i--){
            justHeap(nums,nums.length-1,i);
        }
        for (int i=nums.length-1;i>0;i--){
            swap(nums,0,i);
            justHeap(nums,i-1,0);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    private void justHeap(int[] nums, int end, int idx) {
        if (idx==end) return;
        int parentVal = nums[idx],left = 2*idx+1;
        while(left<=end){
            int bigest = left;
            if (left+1<=end){
                if (nums[left]<nums[left+1]){
                    bigest = left+1;
                }
            }
            if (nums[bigest]<=parentVal) break;
            nums[idx] = nums[bigest];
            idx = bigest;
            left = 2*idx+1;
        }
        nums[idx] = parentVal;
    }

    public static void main(String[] args) {
        int[] in = {9,3,7,-2,-2,15,0};
        new HeapSortTest().heapSort(in);
        for (int i:in) {
            System.out.print(i+" ");
        }
    }
}
