package 牛客.剑指offer;

/**
 * @author 张点
 * @description 构建乘积数组
 * @date 2020/9/27 14:00
 **/
public class JZ_51Solution {
    public int[] multiply(int[] A) {
        if (A.length == 0) return A;
        int[] B = new int[A.length];

        for (int i = 0; i < B.length; i++) {
            int tempA = 1;
            int tempB = 1;
            for (int j = 0; j < i; j++) {
                tempA *= A[j];
            }
            for (int m = i + 1; m < A.length; m++) {
                tempB *= A[m];
            }
            B[i] = tempA * tempB;
        }
        return B;
    }
}
