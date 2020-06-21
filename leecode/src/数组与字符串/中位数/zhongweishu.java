package 数组与字符串.中位数;

/*
题目：寻找两个有序数组的中位数
    给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
    请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
    你可以假设 nums1 和 nums2 不会同时为空。
    示例 1:
        nums1 = [1, 3]
        nums2 = [2]
        则中位数是 2.0
    示例 2:
        nums1 = [1, 2]
        nums2 = [3, 4]
        则中位数是 (2 + 3)/2 = 2.5

思路：将创建一个大小为m+n的数组，将两个数组排序放进新数组，然后找到中位数，返回中位数的值。
    如果新数组元素个数刚好为奇数，那么中位数就是最中间那个数，如果新数组元素个数为偶数，则中位数为最中间两个数的平均数。
 */
public class zhongweishu {
    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {2, 5, 6};
        double midNum = new zhongweishu().findMedianSortedArrays(nums1, nums2);
        System.out.println("中位数是：" + midNum);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int a[] = new int[m + n];
        //如果数组1为空，返回数组2的中位数
        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {
                return  nums2[n / 2];
            }
        }
        //如果数组2为空，返回数组1的中位数
        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            } else {
                return nums1[m / 2];
            }
        }
        //如果数组1和数组2都不为空时
        int i = 0, j = 0, k = 0;
        //向新数组添加数组元素
        while (k != (m + n)) {
            if (nums1[i] <= nums2[j]) {
                a[k++] = nums1[i++];
            } else {
                a[k++] = nums2[j++];
            }
            //当数组1的数据填完后，把剩下的数组2的都添加进新数组
            if (i == m) {
                while (j != n) {
                    a[k++] = nums2[j++];
                }
                break;
            }
            //当数组2的数据填完后，把剩下的数组1的都添加进新数组
            if (j == n) {
                while (i != m) {
                    a[k++] = nums1[i++];
                }
                break;
            }
        }
        //新数组元素个数为奇数和偶数时的返回情况
        if (k % 2 == 0) {
            return (a[k / 2 - 1] + a[k / 2]) / 2.0;
        } else {
            return a[k / 2];
        }
    }
}

