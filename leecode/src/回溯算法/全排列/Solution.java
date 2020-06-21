package 回溯算法.全排列;

import java.util.*;

/*
题目描述：
给定一个 没有重复 数字的序列，返回其所有可能的全排列。
示例:
输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
算法思路：
这里有一个回溯函数，使用第一个整数的索引作为参数 backtrack(first)。

·如果第一个整数有索引 n，意味着当前排列已完成。
·遍历索引 first 到索引 n - 1 的所有整数。Iterate over the integers from index first to index n - 1.
    ·在排列中放置第 i 个整数，
     即 swap(nums[first], nums[i]).
    ·继续生成从第 i 个整数开始的所有排列: backtrack(first + 1).
    ·现在回溯，即通过 swap(nums[first], nums[i]) 还原.
 */
public class Solution {
    public void backtrack(int n, ArrayList<Integer> nums,List<List<Integer>> output,int first){
        //如果所有整数都用完了
        if(first==n){
            output.add(new ArrayList<Integer>(nums));
        }
        for(int i = first;i<n;i++){
            //将第i个整数放在第一位
            //在当前的排列中
            Collections.swap(nums,first,i);
            //使用下一个整数来完成排列
            backtrack(n,nums,output,first+1);
            //回溯
            Collections.swap(nums,first,i);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        //初始输出列表
        List<List<Integer>> output = new LinkedList<>();
        //将nums转换为list，因为输出是一个list列表
        ArrayList<Integer> num_list=new ArrayList<Integer>();
        for(int num:nums){
            num_list.add(num);
        }
        int n = nums.length;
        backtrack(n,num_list,output,0);
        return output;
    }
}
