package 数组与字符串.字符串中的第一个唯一字符;

import java.util.HashMap;

/*
给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
示例：
s = "leetcode"
返回 0
s = "loveleetcode"
返回 2
 */
public class Solution {

    /*//哈希表
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        *//*
        Map.getOrDefault(Object key, V defaultValue)方法的作用是：
        当Map集合中有这个key时，就使用这个key值；
        如果没有就使用默认值defaultValue。
        *//*
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }*/

    //数组
    public int firstUniqChar(String s){

        int[] counter = new int[26];//计数
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            counter[chars[i]-'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if(counter[chars[i]-'a']==1){
                return i;
            }
        }
        return -1;
    }
}
