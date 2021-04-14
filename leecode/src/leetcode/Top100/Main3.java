package leetcode.Top100;

import java.util.HashMap;

/**
 * Description: 无重复字符的最长字串
 * 示例1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * Created by zhang on 2021/2/24 12:03
 */
public class Main3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == "" || s.length() == 0) return 0;
        int maxlen = 0;
        int left = 0;
        //map中key是当前字符，value 为 当前字符位置
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            //如果map中包含当前字符s.charAt(i)，说明i已经出现过，那么更改滑动窗口left坐标，剔除已经出现过的第一个字符
            //map.get(s.charAt(i)) + 1表示：如果map中包含当前字符，有两种情况：
            //1、如abca，left = 0，当遍历到c时，有效子串为“abc”,下一个字符为a，包含在map中，则更新滑动窗口left至当前位置+1，
            // 此时left = Math.max(0,0+1)=1，因此当前有效子串变为“bca”
            //2、如abba，left = 0，当遍历第一个b时，有效子串为“ab”,下一个还是b字符，包含在map中那么更新滑动窗口left = map.get(b)+1 = 2,
            //此时有效子串更新为“b”,到下一个字符a时，map中仍然包含a，map.get(a)=0,如果还像之前一样处理那么left = map.get(a)+1 = 1,
            //实际上此时的left应该不变仍然为2，这样子串才能成为“ba”
            //综上所述，我们每次更新left，left = Math.max(left,map.get(s.charAt(i))+1);
            //另外更新left后，不管原来的s.charAt(i)是否在最长子串中，都要将其位置更新为当前的坐标i，只有这样当前的字符才能进入最长子串
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            //无论是否更新left，都要更新当前字符的坐标
            map.put(s.charAt(i), i);
            maxlen = Math.max(maxlen, i - left + 1);
        }
        return maxlen;
    }
}
