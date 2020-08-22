package 牛客.剑指offer;

import 数组与字符串.螺旋矩阵.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName JZ19_Solution
 * @Description 顺时针打印矩阵
 * @Author 张点
 * @Date 2020/8/19 14:52
 * @Version 1.0
 **/
public class JZ19_Solution {
    public static void main(String[] args) {
        int[][] matrix = {{1}};
        List<Integer> list = new Solution().spiralOrder(matrix);

        System.out.print(list.toString());

    }
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if(matrix==null)return null;
        int up = 0;
        int down = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;

        ArrayList<Integer> res = new ArrayList<>();
        while (true){
            for(int i = left;i<=right;i++){
                res.add(matrix[up][i]);
            }
            up++;
            if(up>down)break;
            for(int i = up;i<=down;i++){
                res.add(matrix[i][right]);
            }
            right--;
            if(left>right)break;
            for(int i=right;i>=left;i--){
                res.add(matrix[down][i]);
            }
            down--;
            if(up>down)break;
            for(int i = down;i>=up;i--){
                res.add(matrix[i][left]);
            }
            left++;
            if(left>right)break;
        }

        return res;
    }
}
