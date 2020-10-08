package 牛客.剑指offer;

import java.util.ArrayList;

/**
 * @description 和为s的两个数字
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * @author 张点
 * @date 2020/9/14 10:49
 **/
public class JZ_42Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if(array==null||array.length==0)return res;
        int left = 0;
        int right = array.length-1;

        while (left<right){
            int temp = array[left]+array[right];
            if(temp < sum){
                left++;
            }else if(temp>sum){
                right--;
            }else {
                res.add(array[left]);
                res.add(array[right]);
                return res;
            }
        }
        return res;
    }
}
