package leetcode.剑指offer;
/**
 * @description 剪绳子
 * @author 张点
 * @date 2020/10/21 21:17
 **/
public class JZ14_1_Solution {
    public int cuttingRope(int n) {
        if(n<=3){
            return n-1;
        }else if(n%3==0){
            //如果n是3的倍数，绳子每段剪3
            return (int) Math.pow(3,n/3);
        }else if(n%3==1){
            //如果n%3==1，我们减一个长度为4的，其他长度都为3
            return (int) (4*Math.pow(3,(n-4)/3));
        }else {
            //如果n%3==2，我们减出一个长度为2的，其他长度都为3
            return (int) (2*Math.pow(3,n/3));
        }
    }
}
