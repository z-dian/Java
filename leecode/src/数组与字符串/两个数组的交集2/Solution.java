package 数组与字符串.两个数组的交集2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
给定两个数组，编写一个函数来计算它们的交集。

示例 1:

输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2,2]
示例 2:

输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出: [4,9]
 */
public class Solution {
    //方法一：哈希表法
    /*
    使用哈希表记录数组1中的数和其对应频次。遍历数组2，如果当前索引的数在哈希表中存在，则把它丢进结果list中，
    并把它在哈希表中的频次-1，如果频次为0就移除它。完成遍历后，list中就是我们希望得到的结果。
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int num : nums1) {
            if(!map.containsKey(num)) map.put(num, 1);
            else map.put(num, map.get(num) + 1);
        }
        for(int num : nums2) {
            if(map.containsKey(num)) {
                map.put(num, map.get(num) - 1);
                if(map.get(num) == 0) map.remove(num);
                list.add(num);
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    //方法二：双指针法
    /*
        首先对两个数组进行排序，然后就是双指针，p1指向nums1，p2指向nums2：
            如果nums1[p1] == nums2[p2]，说明俩数组中都有这个数，是其交集，所以将它丢入list中。
            如果不等，则移动小的那个指针。
    */
     /*public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.QuickSort(nums1);
        Arrays.QuickSort(nums2);
        List<Integer> list = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while(p1 < nums1.length && p2 < nums2.length) {
            if(nums1[p1] < nums2[p2]) p1++;
            else if(nums1[p1] > nums2[p2]) p2++;
            else {
                list.add(nums1[p1]);
                p1++;
                p2++;
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; i++) res[i] = list.get(i);
        return res;
    }*/
}
