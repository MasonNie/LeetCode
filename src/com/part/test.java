package com.part;

import java.util.*;

public class test {
    private void print() {
        System.out.println("o1");
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
class test2 extends test {
    public void print() {
        System.out.println("o2");
    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null||root2==null) return false;
        if(root1.val==root2.val) return check(root1,root2);
        else {
            return HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);
        }
        //return false;
    }
    boolean check(TreeNode root1,TreeNode root2){
        if(root2==null) return true;
        else if(root1==null) return false;
        if(root1.val!=root2.val) return false;
        return check(root1.left,root2.left)&&check(root1.right,root2.right);
    }
}

class OverridePrivateMethodTest {

    public static void main(String[] args) {
        test2 method = new test2();
        Object[] in1 = {3,4,5,1,2};
        Object[] in2 = {4,1};
        System.out.println(method.HasSubtree(Untils.creatTree(in1), Untils.creatTree(in2)));
    }

}
