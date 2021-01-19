package leetcode.剑指offer;

/**
 * Description: 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * 示例:
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 * Created by zhang on 2021/1/6 9:23
 */
public class JZ66_Solution {
    //两个数组
    /*public int[] constructArr(int[] a) {
        if (a.length == 0) return new int[0];
        int n = a.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = right[n - 1] = 1;
        //计算下三角形乘积数组
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }
        //计算上三角形乘积数组
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }*/
    //一个数组，用b数组存储左边的乘积，用temp变量记录右侧的值，每算出一个值就与左侧的相乘，这样也就省去了右侧数组
    public int[] constructArr(int[] a) {
        if (a.length == 0) return new int[0];
        int len = a.length;
        int[] b = new int[len];
        b[0] = 1;
        for (int i = 1; i < len; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        int temp = 1;
        for (int j = len - 2; j >= 0; j--) {
            temp *= a[j + 1];
            b[j] *= temp;
        }
        return b;
    }
}
