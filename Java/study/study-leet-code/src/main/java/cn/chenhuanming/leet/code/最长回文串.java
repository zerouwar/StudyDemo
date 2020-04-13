package cn.chenhuanming.leet.code;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * @author chenhuanming
 * Created at 2018-12-29
 */
public class 最长回文串 {
    public static void main(String[] args) {
        最长回文串 test = new 最长回文串();
        String result = test.longestPalindrome("babad");
        System.out.println(result);
    }

    public String longestPalindrome(String s) {
        if(s==null||s.length()==0){
            return s;
        }
        boolean[][] table = new boolean[s.length()][s.length()];

        int left = 0, right = 0;

        for (int i = table.length - 1; i >= 0; i--) {
            for (int j = table.length - 1; j >= i; j--) {
                if (i == j) {
                    table[i][j] = true;
                } else if (j == i + 1) {
                    table[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    table[i][j] = s.charAt(i) == s.charAt(j) && table[i + 1][j - 1];
                }

                if (table[i][j] && j - i > right - left) {
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right + 1);
    }
}
