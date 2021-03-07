package cn.chenhuanming.leet.code.medium;

import cn.chenhuanming.leet.code.common.Utils;

/**
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回
 * https://leetcode-cn.com/problems/counting-bits/
 */
public class 比特数计数 {

    public static void main(String[] args) {
        比特数计数 instance = new 比特数计数();
        int[] res = instance.countBits(2);
        Utils.println(res);
    }

    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        int highestBit = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & (i - 1)) == 0) {
                highestBit = i;
            }
            bits[i] = bits[i - highestBit] + 1;
        }
        return bits;
    }
}
