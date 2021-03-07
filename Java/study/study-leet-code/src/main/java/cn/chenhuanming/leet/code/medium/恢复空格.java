package cn.chenhuanming.leet.code.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 恢复空格 {
    public static void main(String[] args) {

    }

    public int respace(String[] dictionary, String sentence) {
        Set<String> table = new HashSet<>(Arrays.asList(dictionary));

        int n = sentence.length();
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < i; j++) {
                if (table.contains(sentence.substring(j, i))) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }

        return dp[n];
    }
}
