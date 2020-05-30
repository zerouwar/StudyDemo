package cn.chenhuanming.leet.code.medium;

/**
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 和为k的子数组 {

    public static void main(String[] args) {
        和为k的子数组 instance = new 和为k的子数组();
        int i = instance.subarraySum(new int[]{-1,-1,1}, 0);
        System.out.println(i);
    }

    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int last = 0;
        int lastIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            while(lastIndex<nums.length && last<=k){
                last += nums[lastIndex++];
            }
            if(last == k){
                res++;
            }
            last -= nums[i];
        }
        return res;
    }
}
