package cn.chenhuanming.leet.code;

/**
 * @author chenhuanming
 * Created at 2018-12-29
 */
public class 跳跃游戏 {
    public static void main(String[] args) {
        跳跃游戏 obj = new 跳跃游戏();
        System.out.println(obj.canJump(new int[]{2,3,1,1,4}));
    }

    public boolean canJump(int[] nums) {

        int pos = nums.length - 1;
        for (int i = pos; i >= 0; i--) {
            if (nums[i] >= pos - i) {
                pos = i;
            }
        }
        return pos == 00;
    }
}
