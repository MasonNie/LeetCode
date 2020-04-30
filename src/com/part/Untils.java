package com.part;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Untils {
    static TreeNode creatTree(Object[] in){
        TreeNode tree = new TreeNode((int)in[0]),p=tree;
        Queue<TreeNode> use = new LinkedList<TreeNode>();
        use.add(p);
//        while (p!=null){
//            p=use.peek();
//
//        }
        int count=0;
        for (int i = 1; i < in.length; i++) {

            p=use.peek();
            if (in[i]==null) {
                if (count==0){
                    p.left=null;
                }
                else p.right=null;
                //use.add(null);
                count++;
            }
            else {
                if (count==0){
                    p.left=new TreeNode((int)in[i]);
                    use.add(p.left);
                }
                else {
                    p.right=new TreeNode((int)in[i]);
                    use.add(p.right);
                }
                count++;
            }
            if (count==2){
                count=0;
                use.poll();
            }
        }
        return tree;

    }
    public static List<List<Integer>> cengCi(TreeNode root) {
        List<List<Integer>> lslink=new ArrayList<List<Integer>>();
        List<Integer> er = new ArrayList<>();
        er.add(root.val);
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        Queue<TreeNode> tmp = new LinkedList<>();
        lslink.add(new ArrayList<>(er));
        er.clear();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node=queue.peek();
            if (node.left!=null){
                er.add(node.left.val);
                tmp.add(node.left);
            }
            if (node.right!=null){
                er.add(node.right.val);
                tmp.add(node.right);
            }
            queue.poll();
            if (queue.isEmpty()) {
                queue=new LinkedList<>(tmp);
                tmp.clear();
                if (!er.isEmpty()){
                    lslink.add(new ArrayList<>(er));
                    er.clear();
                }

            }

        }
        return lslink;
    }
    static public List<Integer> inorder(TreeNode root, List<Integer> res){
        if(root!=null){
            inorder(root.left,res);
            res.add(root.val);
            inorder(root.right,res);
        }
        return res;
    }
    static public List<Integer> preorder(TreeNode root, List<Integer> res){
        if(root!=null){
            res.add(root.val);
            preorder(root.left,res);
            preorder(root.right,res);
        }
        return res;
    }
    static public ListNode lianBiao(int[] a){
        ListNode res = new ListNode(0);
        ListNode now;
        now = res;
        for (int i=0;i<a.length;i++){
            now.next = new ListNode(a[i]);
            now = now.next;
        }
        return res.next;
    }
}
