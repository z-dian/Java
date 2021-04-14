package 数组与字符串.合并两个有序数组;

import java.util.Arrays;

/*
给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
说明:
初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
示例:
输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3
输出: [1,2,2,3,5,6]
 */
public class Solution {
    public static void main(String[] args) {
        int m = 3, n = 3;
        int nums1[] = {1, 2, 3, 0, 0, 0};
        int nums2[] = {2, 5, 6};
        new Solution().merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    /*public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m;
        while (i < m + n) {
            for (int j = 0; j < n; j++) {
                nums1[i++] = nums2[j];
            }
        }
        Arrays.QuickSort(nums1);
    }*/
    /*
    双指针：p指向nums1最后面，p1指向nums1的最后一位非零元素，p2指向nums2的最后一位元素
    从结尾开始改写nums1数组，p2从nums2最后一位元素开始遍历，如果大于nums1的最后一个元素的值，则添加到数组1的后面
    若小于nums1最后的元素，则把当前指针p1所指向的元素添加到nums1后面

     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1=m-1,p2=n-1,p=m+n-1;
        while (p1>=0&&p2>=0){
            nums1[p--]=nums1[p1]<nums2[p2]?nums2[p2--]:nums1[p1--];
        }
        System.arraycopy(nums2,0,nums1,0,p2+1);
    }
}

