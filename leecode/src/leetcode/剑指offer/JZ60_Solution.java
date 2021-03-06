package leetcode.剑指offer;
/**
 * @description n个骰子的点数
把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
示例 1:
输入: 1
输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
示例2:
输入: 2
输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 * @author 张点
 * @date 2020/12/25 13:34
 **/
public class JZ60_Solution {
    //动态规划思想：使得n-1点数概率数组和1点数概率数组元素两两相乘，并将乘积结果加到n点数概率数组上。
    //运算完成后就得到了最终的n点数概率数组
    public double[] dicesProbability(int n) {
        //初始化一个骰子时的概率数组
        double pre[]={1/6d,1/6d,1/6d,1/6d,1/6d,1/6d};
        //一个骰子时的概率数组已经初始化，从2个骰子开始计算
        for(int i=2;i<=n;i++){
            //当前骰子点数概率数组的长度
            double tmp[]=new double[5*i+1];
            for(int j=0;j<pre.length;j++)
                //计算每增加一个骰子时当前点数的概率
                for(int x=0;x<6;x++)
                    tmp[j+x]+=pre[j]/6;
            pre=tmp;
        }
        return pre;
    }
}
