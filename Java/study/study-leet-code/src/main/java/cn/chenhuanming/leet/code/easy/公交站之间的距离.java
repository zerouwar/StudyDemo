package cn.chenhuanming.leet.code.easy;

/**
 * 环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。
 * <p>
 * 环线上的公交车都可以按顺时针和逆时针的方向行驶。
 * <p>
 * 返回乘客从出发点 start 到目的地 destination 之间的最短距离。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/distance-between-bus-stops
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 公交站之间的距离 {
    public static void main(String[] args) {
        公交站之间的距离 instance = new 公交站之间的距离();
        int result = instance.distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 2);
        System.out.println(result);
    }

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int i = start;
        int r1 = 0, r2 = 0;
        while (i != destination) {
            r1 += distance[i];
            i = (i + 1) % distance.length;
        }
        i = destination;
        while (i != start) {
            r2 += distance[i];
            i = (i + 1) % distance.length;
        }
        return Math.min(r1, r2);
    }
}
