package cn.chenhuanming.leet.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author chenhuanming
 * Created at 2018-12-29
 */
public class 三数之和 {
    public static void main(String[] args) {
        三数之和 obj = new 三数之和();

        System.out.println(obj.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int right = nums.length - 1;
            int target = -nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                while (right > j && nums[j] + nums[right] > target) {
                    right--;
                }
                if (right == j) {
                    continue;
                }
                if (nums[j] + nums[right] == target) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[right]));
                }
            }
        }
        return result;
    }
}
