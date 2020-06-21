package 回溯算法.子集;

import java.util.ArrayList;
import java.util.List;

/*
题目描述：
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
说明：解集不能包含重复的子集。
示例:
输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
回溯法：
定义一个回溯方法 backtrack(first, curr)，第一个参数为索引 first，第二个参数为当前子集 curr。
    如果当前子集构造完成，将它添加到输出集合中。
    否则，从 first 到 n 遍历索引 i。
        将整数 nums[i] 添加到当前子集 curr。
        继续向子集中添加整数：backtrack(i + 1, curr)。
        从 curr 中删除 nums[i] 进行回溯。

 */
public class Solution {
    List<List<Integer>> output = new ArrayList<>();
    int n,k;
    public void backtrack(int first,ArrayList<Integer> curr,int[] nums){
        //如果组合完成
        if(curr.size()==k){
            output.add(new ArrayList<>(curr));
        }

        for(int i = first;i<n;i++){
            //将i添加到当前组合中
            curr.add(nums[i]);
            //使用下一个整数完成组合
            backtrack(i+1,curr,nums);
            //回溯
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums){
        n=nums.length;
        for(k=0;k<n+1;k++){
            backtrack(0,new ArrayList<Integer>(),nums);
        }
        return output;
    }
}
