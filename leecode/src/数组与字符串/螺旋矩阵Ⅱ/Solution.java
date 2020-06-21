package 数组与字符串.螺旋矩阵Ⅱ;
/*
给定一个正整数 n，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
示例:
输入: 3
输出:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 */
public class Solution {
    public static void main(String[] args) {
        int n = 3;
        int res[][] = new Solution().generateMatrix(n);

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j <res[i].length ; j++) {
                System.out.print(res[i][j]+",");
            }
        }
    }

    public int[][] generateMatrix(int n) {
        int res[][] = new int[n][n];
        int up = 0;
        int down = n - 1;
        int left = 0;
        int right = n - 1;
        int count = 1;
        while (count <=n * n) {
            for (int i = left; i <= right; i++) {
                res[up][i] = count++;
            }
            up++;
            if (up > down) break;
            for (int i = up; i <= down; i++) {
                res[i][right] = count++;
            }
            right--;
            if (right < left) break;
            for (int i = right; i >= left; i--) {
                res[down][i] = count++;
            }
            down--;
            if (down < up) break;
            for (int i = down; i >= up; i--) {
                res[i][left] = count++;
            }
            left++;
            if (right < left) break;
        }
        return res;
    }
}
