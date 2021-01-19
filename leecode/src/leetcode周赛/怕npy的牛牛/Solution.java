package leetcode周赛.怕npy的牛牛;

/*
牛牛非常怕他的女朋友，怕到了走火入魔的程度，以至于每当他看到一个字符串同时含有n,p,y三个字母他都害怕的不行。
现在有一个长度为m的只包含小写字母‘a’-‘z’的字符串x，牛牛想知道能令他不害怕的最长子串的长度是多少。
（对于字符串”abc”来说，”c”,”ab”都是原串的子串，但”ac”不是原串子串）
 */
public class Solution {
    public int Maximumlength(String x) {
        // write code here双指针法
        char[] ch = x.toCharArray();
        int i, nnum = 0, pnum = 0, ynum = 0, left = 0, res = 0;
        for (i = 0; i < x.length(); i++) {
            if (ch[i] == 'n') nnum++;
            if (ch[i] == 'p') pnum++;
            if (ch[i] == 'y') ynum++;
            while (nnum >= 1 && pnum >= 1 && ynum >= 1) {
                if (ch[left] == 'n') nnum--;
                if (ch[left] == 'p') pnum--;
                if (ch[left] == 'y') ynum--;
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ypknnbpiyc";
        System.out.println(new Solution().Maximumlength(s));
    }
}
