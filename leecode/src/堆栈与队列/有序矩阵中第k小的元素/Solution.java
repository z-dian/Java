package 堆栈与队列.有序矩阵中第k小的元素;

/*
给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
示例：

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

返回 13。
 */
public class Solution {
    /*
    二分法：初始化left和right为矩阵的最小值和最大值，则原矩阵排成一维数组就是[left...right]，第k小的元素就是从
    left开始往右数，数到第k个位置的数组元素，取mid=(left+right)/2，即平均值，这个平均值不一定在数据中，但无所谓
    我们只需统计原矩阵里小于等于mid的元素的个数count。
    1) 如果count>=k，则说明第k小元素一定落在[left,mid]中，故right=mid；
    2) 若count<k，则第k小元素一定在[mid+1,right]中，故left=mid+1。
    就这样下去一直更新left和right，每次都能保证第k小元素落在[left,right]中，
    当区间缩小到只有一个元素时，即left=right时，就是第k小元素。
     */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        if (n == 1) return matrix[0][0];

        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];

        while (left < right) {
            int mid = (left + right) / 2;
            int count = get_count(matrix, mid);
            if (count >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private int get_count(int[][] matrix, int mid) {
        int n = matrix.length;
        int count = 0;
        //逐行查找
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] <= mid) {
                    count += (j + 1);//第j列及其之前列的元素肯定都小于等于mid，都加上
                    break;//直接开始下一行
                }
            }
        }
        return count;
    }
    /*public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int left = matrix[0][0];
        int right = matrix[row - 1][col - 1];
        while (left < right) {
            // 每次循环都保证第K小的数在start~end之间，当start==end，第k小的数就是start
            int mid = (left + right) / 2;
            // 找二维矩阵中<=mid的元素总个数
            int count = findNotBiggerThanMid(matrix, mid, row, col);
            if (count < k) {
                // 第k小的数在右半部分，且不包含mid
                left = mid + 1;
            } else {
                // 第k小的数在左半部分，可能包含mid
                right = mid;
            }
        }
        return right;
    }

    private int findNotBiggerThanMid(int[][] matrix, int mid, int row, int col) {
        // 以列为单位找，找到每一列最后一个<=mid的数即知道每一列有多少个数<=mid
        int i = row - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < col) {
            if (matrix[i][j] <= mid) {
                // 第j列有i+1个元素<=mid
                count += i + 1;
                j++;
            } else {
                // 第j列目前的数大于mid，需要继续在当前列往上找
                i--;
            }
        }
        return count;
    }*/
}
