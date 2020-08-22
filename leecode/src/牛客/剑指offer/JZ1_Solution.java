package 牛客.剑指offer;

/**
 * @ClassName JZ1_Solution
 * @Description 二维数组中的查找
 * @Author 张点
 * @Date 2020/8/5 16:30
 * @Version 1.0
 **/
public class JZ1_Solution {
    public boolean Find(int target, int[][] array) {
        int row = array.length;
        int column = array[0].length;
        if (array.length == 0 || array[0].length == 0) return false;
        for (int i = 0; i < row; i++) {
            //如果当前行第一个数字大于target，那么就不用找了，因为后面的数都比target大
            if (array[i][0] > target) {
                break;
            }
            //如果当前行最后一个数小于target，则当前行所有数都比target小，继续往下一行找
            if (array[i][column - 1] < target) {
                continue;
            }
            int col = binarysearch(array[i], target);
            if (col != -1) return true;

        }
        return false;
    }

    private int binarysearch(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == target) {
                return array[mid];
            } else if (array[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
