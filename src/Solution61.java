import java.util.List;

public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        int len=1,i_k=0;
        if (head==null) return null;
        if (k==0) return head;
        ListNode p=head,q=null;
        while(p.next!=null){
            if (len<k){

            }
            else if (len==k){
                q=head;
            }
            else q=q.next;
            p=p.next;
            len+=1;
        }
        if (k==len) return head;
        if (q==null){
            i_k=k%len;
            q=head;
            for (int i = len; i > i_k+1; i--) {
                q=q.next;
            }
        }
        //Rotate
        p.next=head;
        head=q.next;
        q.next=null;
        System.out.println(len+" "+q.val);
        return head;
    }
    public ListNode lianBiao(int[] a){
        ListNode res = new ListNode(0);
        ListNode now;
        now = res;
        for (int i=0;i<a.length;i++){
            now.next = new ListNode(a[i]);
            now = now.next;
        }
        return res.next;
    }

    public static void main(String[] args) {
        int[] a={1,2,3,4,5};
        int[] b={0,1,2};
        Solution61 sol = new Solution61();
        ListNode node=sol.rotateRight(sol.lianBiao(b),0);
        while(node!=null){
            System.out.print(node.val+" ");
            node=node.next;
        }
    }

}
