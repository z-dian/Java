package 牛客.剑指offer;

import java.util.ArrayList;

/**
 * @author 张点
 * @description 和为S的连续正数序列
 * @date 2020/9/11 10:14
 **/
public class JZ_41Solution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        //两个起点，相当于动态窗口的两边，根据其窗口内的值的和来确定窗口的位置和大小
        int plow = 1, phigh = 2;
        while (plow < phigh) {
            //由于是连续的，差为1的一个序列，那么求和公式是(a0+an)*n/2
            int cur = (plow + phigh) * (phigh - plow + 1) / 2;
            if (cur == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = plow; i <= phigh; i++) {
                    list.add(i);
                }
                res.add(list);
                plow++;
                //如果当前窗口内的值之和小于sum，那么右边窗口右移一下
            } else if(cur<sum){
                phigh++;
                //如果当前窗口内的值之和大于sum，那么左边窗口右移一下
            }else {
                plow++;
            }
        }
        return res;
    }
}
