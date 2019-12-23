package 螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

/*
给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
示例 1:
输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]
示例 2:
输入:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
输出: [1,2,3,4,8,12,11,10,9,5,6,7]
思路：
1、设置 上up 下down 左left 右right 四个方向的阈值
2、对 上 下 左 右 进行线性遍历
3、设置终止条件 当左边(left)阈值大于右边(right)阈值 或者 上边(up)阈值大于下边(down)阈值

 */
public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> list = new Solution().spiralOrder(matrix);

        System.out.print(list.toString());

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List res = new ArrayList();
        if (matrix.length == 0)
            return res;
        int left = 0;
        int right = matrix[0].length - 1;
        int up = 0;
        int down = matrix.length - 1;
        while (true) {
            //上 线性遍历
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
            //边界判断
            up++;
            if (up > down) break;
            //右线性遍历
            for (int i = up; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            //边界判断
            right--;
            if (right < left) break;

            //下线性遍历
            for (int i = right; i >= left; i--) {
                res.add(matrix[down][i]);
            }
            //边界判断
            down--;
            if (down < up) break;
            //左线性遍历
            for (int i = down; i >= up; i--) {
                res.add(matrix[i][left]);
            }
            //边界判断
            left++;
            if (left > right) break;

        }
        return res;
    }
}
