package cn.chenhuanming.leet.code.medium;

/**
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 最大正方形 {
    public static void main(String[] args) {

    }

    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        //dp[i][j]表示右下角是该点的最大正方形边长最大值
        int[][] dp = new int[m][n];

        //记录最大边长
        int maxWidth = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]=='0'){
                    dp[i][j] = 0;
                }else if(i==0||j==0){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }
                maxWidth = Math.max(maxWidth,dp[i][j]);
            }
        }
        return maxWidth * maxWidth;
    }
}
