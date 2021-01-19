package leetcode.剑指offer;

/**
 * @author 张点
 * @description 二进制数中1的个数
 * @date 2020/10/23 10:03
 **/
public class JZ15_Solution {
    /*public int hammingWeight(int n) {
        String toBinaryString = Integer.toBinaryString(n);
        int count = 0;
        for(int i = 0;i<toBinaryString.length();i++){
            if(toBinaryString.charAt(i)=='1'){
                count++;
            }
        }
        return count;
    }*/
    //位运算
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n = n >> 1;
        }
        return count;
    }
}
