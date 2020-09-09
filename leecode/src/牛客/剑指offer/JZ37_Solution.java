package 牛客.剑指offer;


/**
 * @author 张点
 * @description 数字在升序数组中出现的次数
 * @date 2020/9/9 9:29
 **/
public class JZ37_Solution {
    //一般解法
    /*public int GetNumberOfK(int[] array, int k) {
        if(array==null||array.length==0){
            return 0;
        }
        int count = 0;
        for(int i = 0;i<array.length;i++){
            if(array[i]>k)break;
            if(array[i]==k){
                count++;
            }
        }
        return count;
    }*/
    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int firstK = binarySearch(array, k);
        int lastK = binarySearch(array, k + 1);
        return (firstK == array.length || array[firstK] != k) ? 0 : lastK - firstK;
    }

    private int binarySearch(int[] nums, int k) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (nums[mid] >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
