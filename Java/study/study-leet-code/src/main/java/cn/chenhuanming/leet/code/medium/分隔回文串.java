package cn.chenhuanming.leet.code.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回 s 所有可能的分割方案。
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 */
public class 分隔回文串 {
    public static void main(String[] args) {
        分隔回文串 instance = new 分隔回文串();
        List<List<String>> res = instance.partition("bb");
        System.out.println(res);
    }

    public List<List<String>> partition(String s) {
        return dfs(s, 0, s.length() - 1);
    }

    public List<List<String>> dfs(String s, int l, int r) {
        if (l == r) {
            List<String> il = new ArrayList<>();
            il.add(String.valueOf(s.charAt(l)));
            List<List<String>> res = new ArrayList<>();
            res.add(il);
            return res;
        }

        List<List<String>> res = new ArrayList<>();
        if (isAba(s, l, r)) {
            res.add(Collections.singletonList(s.substring(l, r + 1)));
        }
        for (int i = l; i < r; i++) {
            if (isAba(s, l, i)) {
                List<List<String>> l2 = dfs(s, i + 1, r);
                for (List<String> u2 : l2) {
                    List<String> list = new ArrayList<>();
                    list.add(s.substring(l, i + 1));
                    list.addAll(u2);
                    res.add(list);
                }
            }
        }
        return res;
    }

    private boolean isAba(String s, int l, int r) {
        while (r < s.length() && l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
