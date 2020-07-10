package 排序与检索.最大数;

import java.util.Arrays;

/*
给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
示例 1:
输入: [10,2]
输出: 210
示例 2:
输入: [3,30,34,5,9]
输出: 9534330
 */
public class Solution {
    private String[] strings;
    private String string;
    public String largestNumber(int[] nums) {
        strings=new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i]=Integer.toString(nums[i]);
        }
        Arrays.sort(strings, (x,y)->(y+x).compareTo(x+y));//lambda自定义比较

        string = new String();
        for(String s :strings){
            string+=s;
        }

        return strings[0].equals("0")?"0":string;
    }


}
