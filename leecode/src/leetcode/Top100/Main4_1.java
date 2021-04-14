package leetcode.Top100;

/**
 * Description: 中位数
 * Created by zhang on 2021/3/3 9:35
 */
public class Main4_1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        //因为索引是从0开始，因此我们在这里必须加1，即索引的(k+1)个数才是第k小的数
        int left = (n + m + 1) / 2;//k/2
        int right = (n + m + 2) / 2;//k/2+1
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k
        return getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right);

    }

    private double getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        //len代表当前数组(也可能是经过递归排除后的数组)，符合当前条件的元素的个数
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;

        //如果len1的长度大于len2的位置，那么就把这两个数组互换位置，这样就保证len1永远比len2小
        if (len1 > len2) {
            return getKth(nums2, start2, end2, nums1, start1, end1, k);
        }
        //如果1个数组中没有元素了，那么找到剩余这个数组的第K个元素就行了
        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }
        //如果k==1了，说明接近中位数了，那么两个数组中start索引处小的值就为中位数
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        //为了防止  数组长度小于k/2，每次都会讲当前数组长度和k/2作比较，取其中的小的(如果取大的，数组就会越界)
        //然后数组如果len1小于k / 2，表示数组经过下一次遍历就会到末尾，然后后面就会在那个剩余的数组中寻找中位数
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;


        //如果nums1[i] > nums2[j]，表示nums2数组中(包含j索引)j之前的元素，逻辑上全部淘汰，即下次从j+1开始。
        //而k则变为k - (j - start2 + 1)，即减去逻辑上排出的元素的个数(要加1，因为索引相减，相对于实际排除的时要少一个的)
        if(nums1[i]>nums2[j]){
            return getKth(nums1,start1,end1,nums2,j+1,end2,k-(j-start2+1));
        }else {
            return getKth(nums1,i+1,end1,nums2,start2,end2,k-(i-start1+1));
        }
    }
}
