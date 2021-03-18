package cn.chenhuanming.leet.code.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * <p>
 * 整数除法仅保留整数部分。
 */
public class 基本计算器II {
    public static void main(String[] args) {
        基本计算器II is = new 基本计算器II();
        System.out.println(is.calculate("1+1-1"));
    }

    public int calculate(String s) {
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<Character> symbolStack = new ArrayDeque<>();

        int res = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (this.isNumber(s.charAt(i))) {
                int l = i, r = i;
                while (i < s.length() && this.isNumber(s.charAt(i))) {
                    i++;
                    r++;
                }

                Integer num = Integer.valueOf(s.substring(l, r));
                if (symbolStack.isEmpty() || symbolStack.peek() == '-' || symbolStack.peek() == '+') {
                    numStack.push(num);
                } else {
                    char symbol = symbolStack.pop();
                    if (symbol == '*') {
                        Integer left = numStack.pop();
                        numStack.push(left * num);
                    } else {
                        Integer left = numStack.pop();
                        numStack.push(left / num);
                    }
                }
            } else {
                symbolStack.push(s.charAt(i++));
            }
        }

        while (!symbolStack.isEmpty()) {
            char symbol = symbolStack.pollLast();
            if (symbol == '+') {
                Integer left = numStack.pollLast();
                Integer right = numStack.pollLast();
                numStack.addLast(left + right);
            } else {
                Integer left = numStack.pollLast();
                Integer right = numStack.pollLast();
                numStack.addLast(left - right);
            }
        }
        return numStack.pop();
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
}
