package cn.chenhuanming.leet.code.medium;

/**
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 * https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/
 */
public class 至少有K个重复字符的最长字串 {
    public static void main(String[] args) {

    }

    public int longestSubstring(String s, int k) {
        return dfs(s, 0, s.length() - 1, k);
    }

    public int dfs(String s, int l, int r, int k) {
        int[] chars = new int[26];

        for (int i = l; i <= r; i++) {
            chars[s.charAt(i) - 'a'] += 1;
        }

        char split = 0;

        for (int i = 0; i < 26; i++) {
            if (chars[i] > 0 && chars[i] < k) {
                split = (char) ('a' + i);
                break;
            }
        }

        if (split == 0) {
            return r - l + 1;
        }

        int i = l;
        int res = 0;
        while (i <= r) {
            while (i <= r && s.charAt(i) == split) {
                i++;
            }

            if (i > r) {
                break;
            }

            int start = i;
            while (i <= r && s.charAt(i) != split) {
                i++;
            }

            res = Math.max(res, dfs(s, start, i - 1, k));
        }
        return res;
    }
}
