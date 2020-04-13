package cn.chenhuanming.leet.code;

import java.util.*;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 *
 * @author chenhuanming
 * Created at 2018-12-28
 */
public class 判断是否可能是栈的弹出序列 {
    public static void main(String[] args) {
        System.out.println(IsPopOrder(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1}));
    }

    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0, j = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            for (; j < popA.length && stack.peek() == popA[j]; ) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();

    }
}
