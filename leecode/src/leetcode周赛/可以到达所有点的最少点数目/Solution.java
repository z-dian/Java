package leetcode周赛.可以到达所有点的最少点数目;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author 张点
 * @Date 2020/8/28 17:50
 * @Version 1.0
 **/
/*
给你一个 有向无环图 ， n 个节点编号为 0 到 n-1 ，以及一个边数组 edges ，其中 edges[i] = [fromi, toi] 
表示一条从点  fromi 到点 toi 的有向边。
找到最小的点集使得从这些点出发能到达图中所有点。题目保证解存在且唯一。

你可以以任意顺序返回这些节点编号。

示例 1：

输入：n = 6, edges = [[0,1],[0,2],[2,5],[3,4],[4,2]]
输出：[0,3]
解释：从单个节点出发无法到达所有节点。从 0 出发我们可以到达 [0,1,2,5] 。从 3 出发我们可以到达 [3,4,2,5] 。
所以我们输出 [0,3] 。
思路：
如果图中有一条a->b的边，那么b一定不会在最小的点集中，因为b能到达的点a也一定能到达，且a还能比b多到达一个点（a自己），
选b不如选a。因此，只有入度为0的点才可能在最小点集中。

最小点集中必须包括所有入度为0的点，假如某个入度为0的点a不在最小点集中，那么最小点集中的其他点一定无法访问到a点，
不符合最小点集能到达图中所有点的要求。

由于题目保证解存在且唯一，因此最小点集为图中所有入度为0的点

 */
public class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
       int[] inDegrees = new int[n];
        for (List<Integer> edge : edges) {
            inDegrees[edge.get(1)]++;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(inDegrees[i]==0){
                res.add(i);
            }
        }
        return res;
    }
}
