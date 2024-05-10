package Array;

// 05 https://leetcode.cn/problems/spiral-matrix-ii/description/

/**
 * 螺旋矩阵II
 * 直接按照右下左上的顺序赋值，到了错误的位置修正一下即可
 */

public class SpiralMatrix_II {
    public static int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = 0;
            }
        }

        for (int i = 0, j = 0, num = 1; num <= n * n; ) {
            while (j < n && ans[i][j] == 0) {
                ans[i][j++] = num++;
            }
            i++;
            j--;
            while (i < n && ans[i][j] == 0) {
                ans[i++][j] = num++;
            }
            i--;
            j--;
            while (j >= 0 && ans[i][j] == 0) {
                ans[i][j--] = num++;
            }
            i--;
            j++;
            while (i >= 0 && ans[i][j] == 0) {
                ans[i--][j] = num++;
            }
            i++;
            j++;
        }
        return ans;
    }
}
