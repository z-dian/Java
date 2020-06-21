package 搜索二维矩阵2;

import javax.crypto.SealedObject;
import java.util.Random;

/*
题目描述：
编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
每行的元素从左到右升序排列。
每列的元素从上到下升序排列。
示例:
现有矩阵 matrix 如下：
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
给定 target = 5，返回 true。
给定 target = 20，返回 false。
 */
public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {
                {
                        1, 2, 3
                },
                {
                        4, 5, 6
                }, {
                7, 8, 9
        }
        };
        Solution s = new Solution();
        boolean b = s.searchMatrix(matrix, 10);
        System.out.println(b);
    }

    //暴力法
    /*public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }*/
    //二分法
    //思路：某一行的第一个元素大于target，那么当前行和后面的行就不用再找了
    //     某一行的最后一个元素小于target，那么当前行就不用找了，换下一行
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] > target) {
                break;
            }
            if (matrix[i][matrix[i].length - 1] < target) {
                continue;
            }
            int col = binarySearch(matrix[i], target);
            if (col != -1) {
                return true;
            }
        }
        return false;
    }

    //二分查找
    private int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
