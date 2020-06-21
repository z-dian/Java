package 搜索二维矩阵2;

import javafx.concurrent.Task;

/*
思路：从右上角开始，如果当前值大于target值，则取掉当前列，如果当前值小于target值，取掉当前行。
也就是说如果target大于当前值，就向下走，
如果target小于当前值，就向左走，
如果相等，直接返回true
 */
public class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if(target>matrix[row][col]){
                row++;
            }else if(target<matrix[row][col]){
                col--;
            }else
                return true;
        }
        return false;
    }
}
