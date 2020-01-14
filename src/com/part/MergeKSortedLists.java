package com.part;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode(0),head =res;
        int flag=0;
        while (flag<lists.length){
            flag = 0;
            ListNode min = new ListNode(Integer.MAX_VALUE);
            int pos = -1;
            for (int i=0;i<lists.length;i++) {
                if (lists[i]!=null&&lists[i].val<min.val){
                    min = lists[i];
                    pos = i;
                }
                else if (lists[i]==null) flag++;
            }
            if (pos>-1){
                lists[pos]=lists[pos].next;
                res.next = min;
                res = res.next;
            }

        }

        return head.next;

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
        int []a = {1,4,5};
        int []b = {1,3,4};
        int []c = {2,6};
        ListNode[] lists = {lianBiao(a),lianBiao(b),lianBiao(c)};
        ListNode res = new MergeKSortedLists().mergeKLists(lists);
        while (res!=null){
            System.out.println(res.val);
            res = res.next;
        }

    }



}
