package com.part;

public class ReverseNodes_in_kGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode first=head,tail=head,p=head;
        for (int i=0;i<k-1;i++){
            if (tail!=null) tail = tail.next;
            else return head;
        }
        if (tail==null) return head;
        head = head.next;
        for (int i=0;i<k-1;i++){
            ListNode tmp = head.next;
            head.next=p;
            p = head;
            head = tmp;
        }
        first.next = reverseKGroup(head,k);
        return tail;
    }


    static ListNode lianBiao(int []a){
        ListNode res = new ListNode(0),head = res;
        for (int i=0;i<a.length;i++){
            ListNode tmp = new ListNode(a[i]);
            res.next = tmp;
            res = res.next;
        }
        return head.next;
    }
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5};
        ListNode lk = lianBiao(a);
        lk = new ReverseNodes_in_kGroup().reverseKGroup(lk,2);
        while (lk!=null){
            System.out.println(lk.val);
            lk = lk.next;
        }
    }
}
