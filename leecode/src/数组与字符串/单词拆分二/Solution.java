package 数组与字符串.单词拆分二;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
说明：
分隔时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
示例 1：
输入:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
输出:
[
  "cats and dog",
  "cat sand dog"
]
示例 2：
输入:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
输出:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
解释: 注意你可以重复使用字典中的单词。
示例 3：
输入:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
输出:
[]
 */
public class Solution {
    //优化后的动态规划
    /*直接使用递归的方法，先判断当前字符串在不在wordDict中，如果在的话就递归的去求剩余字符串的所有组成可能，
    此外，吸取之前的教训，直接使用memoization技术，将递归过程求出来的解缓存起来，便于之后直接使用
    */
    public List<String> wordBreak(String s, List<String> wordDict) {
    HashSet<String> set = new HashSet<>();
        for (int i = 0; i < wordDict.size(); i++) {
            set.add(wordDict.get(i));
        }
        return wordBreakHelper(s,set,new HashMap<String,List<String>>());
    }

    private List<String> wordBreakHelper(String s,HashSet<String> set,HashMap<String,List<String>> map) {
        if(s.length()==0){
            return new ArrayList<>();
        }
        //如果字符串s刚好是map集合里的字典中的某个单词，直接返回这个单词
        if(map.containsKey(s)){
            return map.get(s);
        }
        List<String> res = new ArrayList<>();
        for(int j = 0;j<s.length();j++){
            //判断当前字符串是否存在
            if(set.contains(s.substring(j,s.length()))){
                if(j==0)//如果存在，直接将当前字符串添加到结果集
                    res.add(s.substring(j,s.length()));
                else {
                    //递归得到剩余的字符串的所有组成可能，然后和当前字符串分别用空格连起来加到结果中
                    List<String> temp = wordBreakHelper(s.substring(0,j),set,map);
                    for(int k = 0;k<temp.size();k++){
                        String t = temp.get(k);
                        res.add(t+" "+s.substring(j,s.length()));
                    }
                }
            }
        }
        //缓存结果
        map.put(s,res);
        return res;
    }
}
