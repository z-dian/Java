package 盛水最多的容器;

/*
给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

思路：
1、设双指针i，j分别位于容器壁两端，根据固定规则移动指针（后续说明），并且更新面积最大值res，知道i==j时返回false；
2、每次选中围成水槽两板高度h[i],h[j]中的短板，向中间收窄1格，以下证明：
    · 设每一状态下水槽面积为S(i,j),（0<=i<j<n）,由于水槽的实际高度由两板中的短板决定，则可得面积式S(i,j) = min(h[i],j[j]) x (j-i)
    · 在每个状态下，无论长板还是短板收窄一格，都会导致水槽底边宽度-1。
        ·若向内移动短板，水槽的短板min(h[i],h[j])可能变大，因此水槽面积S(i,j)可能变大
        ·若向内移动长板，水槽的短板min(h[i],h[j])不变或变小，下个水槽的面积一定小于当前水槽面积。
    · 因此，向内收窄短板可以获取面积最大值。换个角度理解：
        · 若不指定移动规则，所有移动出现的 S(i,j)的状态数为 C(n, 2)，即暴力枚举出所有状态。
        · 在状态 S(i,j) 下向内移动短板至 S(i + 1,j)（假设 h[i] < h[j]），
          则相当于消去了S(i, j - 1), S(i, j - 2), ... , S(i, i + 1) 状态集合。
          而所有消去状态的面积一定<=S(i,j)：
            · 短板高度：相比S(i,j) 相同或更短（<=h[i]）；
            · 底边宽度：相比S(i,j) 更短。
        · 因此所有消去的状态的面积都<S(i,j)。通俗的讲，我们每次向内移动短板，所有的消去状态都不会导致丢失面积最大值 。
*/
public class Solution {
    public static void main(String[] args) {
        int height[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(new Solution().maxArea(height));

    }

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while (i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, height[i++] * (j - i)) :
                    Math.max(res, height[j--] * (j - i));
        }
        return res;
    }
    /*public int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }*/
}
