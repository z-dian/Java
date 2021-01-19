package leetcode.剑指offer;
/**
 * @description 二维数组中的查找
 * @author 张点
 * @date 2020/10/10 14:03
 **/
public class JZ04_Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0)return false;
        int rows = matrix.length;
        int row = 0;
        int columns = matrix[0].length;
        int column = columns-1;

        while (row<rows&&column>=0){
            int num = matrix[row][column];
            if(num==target){
                return true;
            }else if(num>target){
                column--;
            }else {
                row++;
            }
        }
        return false;
    }
}
