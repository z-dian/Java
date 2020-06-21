package 数组与字符串.验证回文串;

/*
题目描述：
给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
说明：本题中，我们将空字符串定义为有效的回文串。
示例 1:
输入: "A man, a plan, a canal: Panama"
输出: true
示例 2:

输入: "race a car"
输出: false
 */
public class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^0-9a-z]", "");
        char[] c = s.toCharArray();
        int i = 0,j=c.length-1;
        while (i<j){
            if(c[i]!=c[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
