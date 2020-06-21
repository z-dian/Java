package 回溯算法.格雷编码;

import java.util.ArrayList;
import java.util.List;

/*
题目描述：
格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。
输入: 2
输出: [0,1,3,2]
解释:
00 - 0
01 - 1
11 - 3
10 - 2

对于给定的 n，其格雷编码序列并不唯一。
例如，[0,2,3,1] 也是一个有效的格雷编码序列。

00 - 0
10 - 2
11 - 3
01 - 1
示例 2:

输入: 0
输出: [0]
解释: 我们定义格雷编码序列必须以 0 开头。
     给定编码总位数为 n 的格雷编码序列，其长度为 2n。当 n = 0 时，长度为 20 = 1。
     因此，当 n = 0 时，其格雷编码序列为 [0]。

公式法：
二进制转成格雷码其法则是保留二进制码最高位为格雷码的最高位，而格雷码的次高位的值为
二进制码的高为和次高位的异或值，以此类推。

原理：若二进制码表示为B[n-1]B[n-2]...B[2]B[1]B[0]
     相应的格雷码为：G[n-1]G[n-2]...G[2]G[1]G[0]
     其最高位保留：B[n-1]=G[n-1]
     其他各位：G[i]=B[i+1] xor(异或) B[i](i=0,1,2...n-2)

 */
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> gray = new ArrayList<Integer>();
        for (int binary = 0; binary < 1 << n; binary++) {
            gray.add(binary ^ binary >> 1);
        }
        return gray;
    }
}
