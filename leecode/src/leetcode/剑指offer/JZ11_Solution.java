package leetcode.剑指offer;

import java.util.Arrays;

/**
 * @author 张点
 * @description 旋转数组的最小数字
 * @date 2020/10/16 13:50
 **/
public class JZ11_Solution {
    /*public int minArray(int[] numbers) {
        Arrays.QuickSort(numbers);
        return numbers[0];
    }*/
    public int minArray(int[] numbers) {
        int start = 0;
        int end = numbers.length-1;
        while (start!=end){
            int mid = start+(end-start)/2;//防止溢出
            //如果numbers[mid]>numbers[end] 说明 mid 是 在左排序数组中，那么旋转点一定在右半部分[mid+1 , end]区间内，因此 start  = mid + 1 ;
            if(numbers[mid]>numbers[end]){
                start = mid + 1;
                //如果numbers[mid]<numbers[end] 说明mid 是在 右排序数组中，那么 旋转点一定在 [start , mid]区间内，所以 end = mid;
            }else if(numbers[mid]<numbers[end]){
                 end = mid;
                 //如果numbers[mid]==numbers[end],说明从最小值一定不在右边数组，那从头开始找最小的，最先开始变小的数就是要找的数。
            }else {
                int temp = start;
                for(int i = start+1;i<end;i++){
                    if(numbers[i]<numbers[temp]) {
                        temp = i;
                    }
                }
                return numbers[temp];
            }
        }
        return numbers[start];
    }
}
