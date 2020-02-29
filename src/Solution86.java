public class Solution86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode fake_head = new ListNode(0);
        fake_head.next = head;
        ListNode p = head,pre = fake_head,pos = null;
        while (p != null){
            if (p.val >= x){
                if (pos == null){
                    pos = pre;
                }
            }else {
                if (pos != null){
                    ListNode tmp = p;
                    pre.next = p.next;
                    p = p.next;
                    // Insert
                    insert(pos,tmp);
                    pos = pos.next;
                    continue;
                }
            }
            pre = p;
            p = p.next;
        }
        return fake_head.next;
    }
    private void insert(ListNode pos,ListNode now){
        ListNode tmp_next = pos.next;
        pos.next = now;
        now.next = tmp_next;
    }

    public static void main(String[] args) {
        int[] a = {1,4,3,2,5,2};
        ListNode in = Untils.lianBiao(a);
        ListNode out = new Solution86().partition(in,3);
        while (out != null){
            System.out.print(out.val + "\t");
            out = out.next;
        }
    }
}
