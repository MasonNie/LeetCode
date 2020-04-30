import java.util.Random;

public class HeapSortTester {
    void heapSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            heapInit(nums,i);
        }
        int end = nums.length-1;
        while (end>0){
            swap(nums,0,end);
            end--;
            heapify(nums,0,end);

        }
    }

    private void heapify(int[] nums, int pos, int end) {
        if (end<1) return;
        int left = 2*pos+1;
        while (left <= end){
            int bigest = left+1<=end&&nums[left+1]>nums[left]?left+1:left;
            if (nums[bigest]>nums[pos]){
                swap(nums,bigest,pos);
                pos = bigest;
                left = 2*pos+1;
            }else break;
        }
    }

    private void heapInit(int[] nums, int idx) {
        while (nums[idx]>nums[(idx-1)/2]){
            swap(nums,idx,(idx-1)/2);
            idx = (idx-1)/2;
        }
    }

    private void swap(int[] nums, int idx, int i) {
        int tmp = nums[idx];
        nums[idx] = nums[i];
        nums[i] = tmp;
    }

    public static void main(String[] args) {
        int[] in = new int[10000];
        Random r = new Random();
        for (int i = 0; i < 10000; i++) {
            in[i] = r.nextInt(99);
        }
        new HeapSortTester().heapSort(in);
        for (int i:in
             ) {
            System.out.print(i+" ");

        }
    }
}
