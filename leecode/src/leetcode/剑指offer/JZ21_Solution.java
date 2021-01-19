package leetcode.剑指offer;


/**
 * @author 张点
 * @description 调整数组顺序使奇数位于偶数前面
 * @date 2020/10/29 8:34
 **/
public class JZ21_Solution {
    //解法一：双指针法
    /*
    思路：我们可以使用两个指针left和right。left从左边开始扫描，如果是奇数就往右走，如果遇到偶数就停下来（此时left指向的是偶数），
    right从右边开始扫描，如果是偶数就往左走，如果是奇数就停下来（此时right指向的是奇数），交换left和right指向的值。继续循环，
    直到left==right为止。
     */
    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1,temp;
        while (i < j) {
            while ((nums[i] & 1) == 1) {
                i++;
            }
            while ((nums[i] & 1) == 0){
                j--;
            }
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }

    //解法二：申请临时数组
    public int[] exchange1(int[] nums) {
        if (nums == null || nums.length == 0)
            return nums;
        int left = 0;
        int right = nums.length - 1;
        int res[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 0) {//偶数
                res[right--] = nums[i];
            } else {//奇数
                res[left++] = nums[i];
            }
        }
        return res;
    }
}
