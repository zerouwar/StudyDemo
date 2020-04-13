package cn.chenhuanming.leet.code;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author chenhuanming
 * Created at 2018/12/20
 */
public class 两数之和 {

    public static void main(String[] args) throws URISyntaxException {

    }

    /**
     * 用hash表记录target-当前值在nums的位置，这样只需要O(nums.length)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int remain = target-nums[i];

            if(map.get(remain)!=null){
                return new int[]{i,map.get(remain)};
            }

            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("no solution");
    }

}
