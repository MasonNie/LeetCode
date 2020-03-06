public class Solution148 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
        public ListNode sortList(ListNode head) {
            if(head==null||head.next==null) return head;
            ListNode p = head,mid=null;
            mid = findMid(head);
            ListNode rhead = mid.next;
            mid.next = null;
            ListNode left = sortList(head);
            ListNode right = sortList(rhead);
            ListNode merge = new ListNode(0);
            p = merge;
            while(left!=null&&right!=null){
                if(left.val<right.val){
                    p.next = left;
                    left = left.next;
                }else{
                    p.next = right;
                    right = right.next;
                }
                p = p.next;
            }
            p.next = left!=null?left:right;
            return merge.next;

        }
        ListNode findMid(ListNode head){

            ListNode slow = head,fast = head;
            while(slow!=null&&fast!=null&&fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

    public static void main(String[] args) {
        int[] a = {4,2,1,3};
        ListNode in = Untils.lianBiao(a);
        ListNode out = new Solution148().sortList(in);
        while(out!=null){
            System.out.print(out.val+" ");
        }
    }
}
