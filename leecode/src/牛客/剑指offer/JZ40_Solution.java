package 牛客.剑指offer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author 张点
 * @description 数组中只出现一次的数字
 * @date 2020/9/10 19:21
 **/
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果


public class JZ40_Solution {
    //普通解法：容易想到
    /*public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0)+1);
        }
        for(int i = 0;i<array.length;i++){
            if(map.get(array[i])==1){
                res.add(array[i]);
            }
        }
        num1[0]=res.get(0);
        num2[0]=res.get(1);
    }*/

    /**位运算，需要知识储备：一个数与自己异或为0，一个数与0异或为自己。
     *
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int temp = array[0];
        //首先把数组中的数字全部进行异或
        for (int i = 1; i < array.length; i ++){
            temp ^= array[i];
        }
        //把异或结果的最后一位1的那位找出来
        temp &= -temp;
        //以这一位是否为1或者0作为分类标准进行分类
        for (int val : array){
            if ((val&temp) == 0){
                num1[0] ^= val;
            } else {
                num2[0] ^= val;
            }
        }
    }
}
