import java.util.List;

public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null||head.next==null) return head;
        ListNode p = head,pre = null;
        while (p!=null){
            if (pre == null){
                while (p.next != null&&p.val==p.next.val){
                    p = p.next;
                }
                if (head==p){
                    p = p.next;
                }else {
                    head = p.next;
                    p = p.next;
                }

                if (head==null||head.next==null){
                    return head;
                }
                else if (head.val!=head.next.val){
                    pre = head;
                }
            }else {
                //delete
                if (p.next!=null&&p.val==p.next.val){
                    while (p.next != null&&p.val==p.next.val){
                        p = p.next;
                    }
                    pre.next = p.next;
                    p = p.next;
                }else {
                    pre = p;
                    p = p.next;
                }
            }

        }
        return head;

    }

    public static void main(String[] args) {
        int[] a = {1,2,3,3,4,4,5};
        int[] b = {1,1,1,2,2,3,3,4,5,5};
        ListNode out = new Solution82().deleteDuplicates(Untils.lianBiao(b));
        while (out!=null){
            System.out.print(out.val+"\t");
            out = out.next;
        }
    }
}
