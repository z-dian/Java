package 数组与字符串.最长公共前缀;

/*
编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。
示例 1:
输入: ["flower","flow","flight"]
输出: "fl"
示例 2:
输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:
所有输入只包含小写字母 a-z 。
 */
public class Solution {
    public static void main(String[] args) {
        String[] s = {"dlower", "flow", "floight"};
        String str = new Solution().longestCommonPrefix(s);
        System.out.println(str);
    }

    //暴力法
    /*public String longestCommonPrefix(String[] s) {
        if (s.length == 0) {
            return "";
        }
        String str = s[0];
        for (int i = 1; i < s.length; i++) {
            int j = 0;
            for (; j < s[i].length() && j < str.length(); j++) {
                if (s[i].charAt(j) != str.charAt(j)) {
                    break;
                }
            }
            str = s[0].substring(0, j);
         *//*   if (str.equals("")) {
                return str;
            }*//*
        }
        return str;
    }*/
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        if (strs.length == 0 ){
            return result;
        }else {
            result = strs[0];
            for(int i = 1;i<strs.length;i++){
                while (strs[i].indexOf(result) != 0 ){
                    result = result.substring(0,result.length()-1);
                }
            }
        }
        return result;
    }
}
