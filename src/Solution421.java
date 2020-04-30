class Solution421 {
    public int findMaximumXOR(int[] nums) {
        TireNode root = new TireNode(-1);
        int res = 0;
        //int mask = 0;
        for(int num:nums){
            TireNode node = root;
            for(int i=31;i>=0;i--){
                //mask = (1<<i)&num;
                if(((1<<i)&num) == 0){
                    if(node.zero==null){
                        node.zero = new TireNode(0);
                    }
                    node = node.zero;
                }else{
                    if(node.one==null){
                        node.one = new TireNode(1);
                    }
                    node = node.one;
                }
            }
        }
        for(int num:nums){
            TireNode node = root;
            int xor = 0;
            for(int i=31;i>=0;i--){
                //mask = (1<<i)&num;
                if(((1<<i)&num) == 0){
                    if(node.one!=null){
                        node = node.one;
                        xor += (1<<i);
                    }else{
                        node = node.zero;
                    }
                }else{
                    if(node.zero!=null){
                        node = node.zero;
                        xor += (1<<i);
                    }else{
                        node = node.one;
                    }
                }
            }
            res = Math.max(res,xor);
        }
        return res;

    }
    class TireNode{
        TireNode zero;
        TireNode one;
        int val ;
        public TireNode(int x){
            val = x;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution421().findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
    }
}