package 反转字符串中的单词;
/*
题目描述：
给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
示例 1:
输入: "Let's take LeetCode contest"
输出: "s'teL ekat edoCteeL tsetnoc"

思路：
1、用split将字符串分割成一个个单词，放入字符串数组里
2、字符串数组的每一个元素都转化成字符数组
3、然后反转字符数组

 */
public class Solution {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(new Solution().reverseWords(s));
    }
    public String reverseWords(String s){
        String str[] = s.split(" ");
        StringBuilder res = new StringBuilder();
        int len = str.length;
        for (int i = 0; i < len; i++) {
            res.append(new StringBuilder(str[i]).reverse().toString()+" ");
        }
        return res.toString().trim();
    }
}
