package 牛客.剑指offer;

/**
 * @author 张点
 * @description 正则表达式匹配
 * @date 2020/9/27 19:00
 **/
/*
思路：
首先考虑特殊情况:
    1>  两个字符串都为空，返回true
    2>  当str非空，pattern为空时，直接输出false；
        当str为空，pattern不为空时，有可能输出true:
        比如：str为空,pattern为任意一个字符后跟一个*，如*表示前面这个字符出现0次，返回true，如果*表示前面这个字符出现1一次及以上，返回false
接下来，开始匹配，有两种情况，成功或者失败。这里pattern有两种状况，一种是当前字符后面跟一个*，一种是不跟*：
    1> 当前字符后面不跟*，直接匹配。str的当前跟pattern的当前字符匹配，如果匹配上 返回true，否则 返回false
        注意这里pattern中有可能出现'.'，它可以当作任意字符使用。
    2> pattern当前字符后跟'*'，有三种情况：*可以表示当前字符出现0次、1次、多次
        1.当*表示当前字符出现0次时，str当前字符不变，pattern当前字符后移两位，跳过“当前字符 * ”
        2.pattern中当前字符后跟*表示一次时，字符串后移一位，模式串后移两位；
                                表示多次时，字符串后移一位，模式串不动，即继续匹配下一位。
 */
public class JZ_52Solution {

    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) return false;
        int strIndex = 0;
        int patternIndex = 0;
        return matchMethod(str, pattern, strIndex, patternIndex);
    }

    private boolean matchMethod(char[] str, char[] pattern, int strIndex, int patternIndex) {
        //有效检验，str和pattern都匹配到尾 ，匹配成功，返回true
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        //pattern先到尾，匹配失败，返回false
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }

        //如果pattern中当前字符下一个字符为*,且字符串第一个跟模式串第一个匹配
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if ((strIndex != str.length && str[strIndex] == pattern[patternIndex]) || (strIndex != str.length && pattern[patternIndex] == '.')) {
                //当*表示前面字符出现0次时，字符串当前字符不变，模式串后移两位
                return matchMethod(str, pattern, strIndex, patternIndex + 2) ||
                        //表示pattern当前字符被*匹配1次或者多次，str当前字符后移一位继续匹配，有可能pattern跟着后移一位，有可能跟着不动
                        matchMethod(str, pattern, strIndex + 1, patternIndex);
            } else {
                return matchMethod(str, pattern, strIndex, patternIndex + 2);
            }
        }
        //如果模式串第二个不是‘*’符号，则str当前字符跟pattern当前字符匹配，如果成功，str和pattern当前字符都后移一位，否则返回false
        if ((strIndex != str.length && str[strIndex] == pattern[patternIndex]) || (strIndex != str.length && pattern[patternIndex] == '.')) {
            return matchMethod(str, pattern, strIndex + 1, patternIndex + 1);
        }
        return false;
    }
}
