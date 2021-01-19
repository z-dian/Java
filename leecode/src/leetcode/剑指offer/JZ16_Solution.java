package leetcode.剑指offer;

/**
 * @author 张点
 * @description 数值的整数次方
 * @date 2020/10/24 11:55
 **/
public class JZ16_Solution {

   /* public double myPow(double x, int n) {
        if (x == 0) return 0;
        long b = n;
        double res = 1.0f;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }*/
    //递归方法
   public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        if(n<0){
            return 1/x*myPow(1/x,-n-1);
        }
        return (n%2==0)?myPow(x*x,n/2):x*myPow(x*x,n/2);
   }
}
