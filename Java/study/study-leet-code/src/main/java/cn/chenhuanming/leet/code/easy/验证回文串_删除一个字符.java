package cn.chenhuanming.leet.code.easy;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 */
public class 验证回文串_删除一个字符 {

    public static void main(String[] args) {
        验证回文串_删除一个字符 instance = new 验证回文串_删除一个字符();

        System.out.println(instance.validPalindrome("abaq"));
    }

    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int l = 0, r = chars.length - 1;
        for (;l < r && chars[l] == chars[r];l++,r--);

        return this.palindrome(chars, l + 1, r) || this.palindrome(chars, l, r - 1);
    }

    private boolean palindrome(char[] chars, int l, int r) {
        for (;l < r && chars[l] == chars[r];l++,r--);
        return l >= r;
    }
}
