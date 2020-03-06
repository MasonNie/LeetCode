public class Solution92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode fake_head = new ListNode(0),pre_m = fake_head,pre=fake_head,p=head,next = p.next;
        fake_head.next = head;
        int count = 1;
        while(count<m){
            pre = p;
            p = p.next;
            count++;
        }
        pre_m = pre;
        while (count<=n){
            //reverse
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
            count++;
        }
        pre_m.next.next = p;
        pre_m.next = pre;
        return fake_head.next;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        ListNode out = new Solution92().reverseBetween(Untils.lianBiao(a),1,2);
        while (out!=null){
            System.out.print(out.val + "\t");
            out = out.next;
        }
    }
}
