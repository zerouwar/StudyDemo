package cn.chenhuanming.leet.code.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
 * <p>
 * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * <p>
 * 你需要计算完成所有任务所需要的 最短时间 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/task-scheduler
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 任务调度器 {

    public static void main(String[] args) {
        任务调度器 instance = new 任务调度器();
        int turn = instance.leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2);
        System.out.println(turn);
    }

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> taskMap = new HashMap<>();
        Queue<CdTask> queue = new LinkedList<>();
        int handled = 0;
        int turn = 0;

        for (char task : tasks) {
            if (taskMap.get(task) == null) {
                taskMap.put(task, 1);
                queue.add(new CdTask(task, 0));
            } else {
                taskMap.put(task, taskMap.get(task) + 1);
            }
        }


        while (handled < tasks.length) {
            turn++;

            if (queue.peek().startTurn == 0 || turn - queue.peek().startTurn > n) {
                CdTask cdTask = queue.poll();
                cdTask.startTurn = turn;
                System.out.print(cdTask.task + ",");
                handled++;
                taskMap.put(cdTask.task, taskMap.get(cdTask.task) - 1);
                if (taskMap.get(cdTask.task) > 0) {
                    queue.add(cdTask);
                }
            }
        }

        return turn;
    }

    private static class CdTask {
        public Character task;
        public int startTurn;

        public CdTask(Character task, int startTurn) {
            this.task = task;
            this.startTurn = startTurn;
        }
    }
}
