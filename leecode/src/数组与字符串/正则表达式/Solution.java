package 数组与字符串.正则表达式;

/**
 * @ClassName Solution
 * @Description 正则表达式匹配
 * @Author 张点
 * @Date 2020/7/25 16:54
 * @Version 1.0
 **/
/*
请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配

分析：
1、特判
    1>两个字符串都为空，返回true
    2>当第一个字符串为空时，第二个字符串非空，有可能匹配成功，比如第二个字符串是“a*a*a*a*”。由于'*'表示它前面的字符可以出现任意次（包含0次），所以有可能成功；
    当第一个字符串非空 ，第二个字符串为空，直接返回false
2、开始匹配，这里有两种可能，成功或者失败  但考虑到pattern下一个字符有可能为“*”，所以分为两种情况：

    1>pattern下一个字符不为“*”，这种情况，直接匹配。如果匹配成功，继续匹配下一个；如果匹配失败，返回false。
    注意：这里匹配成功有两种情况，第一种是字符相同，第二种是pattern的当前字符为“.”,同时str的当前字符不为空

    2>pattern下一个字符为“*”，“*”代表它前面的字符有可能出现0次、1次或者多次
        <1>若“*”表示匹配0个字符时，当前字符不变，pattern当前字符后移2位，跳过“当前字符*”
        <2>若“*”表示匹配 1个或者多个字符时，str当前字符后移一位，pattern当前字符不变

 */
public class Solution {
    /*
    1、如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。
    2、如果 字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。

    而当模式中的第二个字符是“*”时：
    如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。如果字符串第一个字符跟模式第一个字符匹配，可以有3种匹配方式：
    1、模式后移2字符，相当于x*被忽略；
    2、字符串后移1字符，模式后移2字符；
    3、字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；
     */
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) return false;
        int strIndex = 0;
        int patternIndex = 0;
        return matchMethod(str, strIndex, pattern, patternIndex);
    }

    private boolean matchMethod(char[] str, int strIndex, char[] pattern, int patternIndex) {
        //有效性检验：str到尾，pattern到尾，匹配成功
        if (strIndex == str.length && patternIndex == pattern.length) return true;
        //pattern先到尾，匹配失败
        if (strIndex != str.length && patternIndex == pattern.length) return false;
        //str到尾，pattern未到尾(不一定匹配失败，因为*可以匹配0个)
        if (strIndex == str.length && patternIndex != pattern.length) {
            //只有pattern剩下的部分为a*b*c*的形式，才匹配成功
            if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
                return matchMethod(str, strIndex, pattern, patternIndex + 2);
            }
            return false;
        }

        //str未到尾，pattern未到尾，若模式当前字符下一个为"*"，有三种情况：第一种匹配了0个
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if (pattern[patternIndex] == str[strIndex] || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                return matchMethod(str, strIndex, pattern, patternIndex + 2)//匹配0个，跳过
                        || matchMethod(str, strIndex + 1, pattern, patternIndex + 1)//*匹配了1个跳过
                        || matchMethod(str, strIndex + 1, pattern, patternIndex);//*匹配了一个，再匹配str的下一个
            } else {
                //直接跳过*（*匹配了0个）
                return matchMethod(str, strIndex, pattern, patternIndex + 2);
            }
        }
        //若模式当前符号为"."，可以代替任何字符，相当于与str字符串当前字符匹配成功，继续往后
        if(pattern[patternIndex]==str[strIndex]||(pattern[patternIndex]=='.'&&strIndex!=str.length)){
            return matchMethod(str,strIndex+1,pattern,patternIndex+1);
        }
        return false;
    }

}

