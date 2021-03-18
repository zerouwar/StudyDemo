package cn.chenhuanming.leet.code.medium;

import java.util.Arrays;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 * <p>
 * 返回符合要求的 最少分割次数 。
 * https://leetcode-cn.com/problems/palindrome-partitioning-ii/
 */
public class 分隔回文串II {
    public static void main(String[] args) {
        分隔回文串II instance = new 分隔回文串II();
        System.out.println(instance.minCut("leet"));
    }

    public int minCut(String s) {
        boolean[][] f = new boolean[s.length()][s.length()];
        for (boolean[] f1 : f) {
            Arrays.fill(f1, true);
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                f[i][j] = f[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }

        int[] p = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (f[0][i]) {
                p[i] = 0;
                continue;
            }

            int min = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (f[j + 1][i]) {
                    min = Math.min(min, p[j] + 1);
                }
            }
            p[i] = min;
        }
        return p[s.length() - 1];
    }
}
