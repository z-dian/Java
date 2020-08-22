package 牛客.剑指offer;

/**
 * @ClassName JZ6_Solution
 * @Description 旋转数组中的最小值
 * @Author 张点
 * @Date 2020/8/8 14:48
 * @Version 1.0
 **/
public class JZ6_Solution {
    /*public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) return 0;
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        while (array[left] >= array[right]) {
            //分界点
            if (right - left == 1) {
                mid = right;
                break;
            }
            mid = left + (right - left) / 2;
            //如果array[left] array[mid] array[right]三者相等时，无法判断最小值在哪边，那么求其最小值
            if (array[left] == array[mid] && array[mid] == array[right]) {
                return findMin(array, left, right);
            }
            //如果中间元素比前面的子数组所有元素都大或者等于，那么最小值位于后面的子数组
            if (array[mid] >= array[left]) {
                left = mid;
            } else {//如果中间元素比后面的元素小，那么最小值位于前面的子数组
                right = mid;
            }
        }
        return array[mid];
    }

    private int findMin(int[] array, int left, int right) {
        int min = array[left];
        for (int i = left + 1; i < right; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }*/
    /*public int minNumberInRotateArray(int[] array) {
        if(array.length==0)return 0;
        for (int i = 0; i < array.length-1; i++) {
            if(array[i+1]<array[i]){
                return array[i+1];
            }
        }
        return array[0];
    }*/
}
