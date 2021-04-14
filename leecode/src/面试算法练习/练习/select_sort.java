package 面试算法练习.练习;

/**
 * Description: leecode
 * Created by zhang on 2021/1/20 18:16
 */
public class select_sort {
    public static void main(String[] args) {
        int[] nums = {4, 2, 6, 3, 7, 8, 1};
        sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    private static void sort(int[] nums) {
        int minIndex;
        for (int i = 0; i < nums.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
    }
}
