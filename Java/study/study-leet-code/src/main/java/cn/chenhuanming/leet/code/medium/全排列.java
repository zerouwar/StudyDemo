package cn.chenhuanming.leet.code.medium;

import cn.chenhuanming.leet.code.common.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 全排列 {

    public static void main(String[] args) {
        全排列 instance = new 全排列();
        instance.permute(new int[]{1, 2, 3}).forEach(System.out::println);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        this.permuteImpl(nums, 0, result);
        return result;
    }

    private void permuteImpl(int[] nums, int start, List<List<Integer>> result) {
        if(start==nums.length-1){
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = start; i < nums.length; i++) {
                Utils.exchange(nums, i, start);
                permuteImpl(nums, start+1, result);
                Utils.exchange(nums, i, start);
        }
    }

}
