package cn.chenhuanming.leet.code.medium;

import cn.chenhuanming.leet.code.common.Utils;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），
 * 输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，
 * 这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 下一个更大的元素II {
    public static void main(String[] args) {
        下一个更大的元素II instance = new 下一个更大的元素II();
        Utils.println(instance.nextGreaterElements(new int[]{1, 2, 1}));
    }

    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);

        for (int i = 0; i < nums.length * 2; i++) {
            int ri = i % nums.length;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[ri]) {
                res[stack.pop()] = nums[ri];
            }
            stack.push(ri);
        }
        return res;
    }
}
