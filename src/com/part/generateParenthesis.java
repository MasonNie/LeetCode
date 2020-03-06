package com.part;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {

    void backtrack(List<String> res,String s,int open,int close,int n){
        if (s.length()==n*2) {
            res.add(s);
            return;
        }
        else {
            if (open<n){
                backtrack(res,s+"(",open+1,close,n);
            }
            if (close<open){
                backtrack(res,s+")",open,close+1,n);
            }
        }
    }

    public List<String> solution(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res,"",0,0,n);
        return res;
    }

    public static void main(String[] args) {
        generateParenthesis g = new generateParenthesis();
        List<String> out = g.solution(3);
        System.out.println(out);
    }
}
