package cn.chenhuanming.leet.code.hard;

import java.util.*;

public class 最小区间 {
    public static void main(String[] args) {
        最小区间 instance = new 最小区间();
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(4, 10, 15, 24, 26));
        nums.add(Arrays.asList(0, 9, 12, 20));
        nums.add(Arrays.asList(5, 18, 22, 30));

        int[] ans = instance.smallestRange(nums);

        for (int an : ans) {
            System.out.print(an + " ");
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        int size = nums.size();
        int rangeLeft = 0, rangeRight = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[] tab = new int[size];

        //最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return nums.get(o1).get(tab[o1]) - nums.get(o2).get(tab[o2]);
            }
        });

        //初始化
        for (int i = 0; i < size; i++) {
            minHeap.offer(i);
            max = Math.max(max, nums.get(i).get(0));
        }

        while (true) {
            Integer minIndex = minHeap.poll();
            if (max - nums.get(minIndex).get(tab[minIndex]) < rangeRight - rangeLeft) {
                rangeLeft = nums.get(minIndex).get(tab[minIndex]);
                rangeRight = max;
            }
            tab[minIndex] += 1;
            if (tab[minIndex] == nums.get(minIndex).size()) {
                break;
            }
            minHeap.offer(minIndex);
            max = Math.max(max, nums.get(minIndex).get(tab[minIndex]));
        }
        return new int[]{rangeLeft, rangeRight};
    }
}
