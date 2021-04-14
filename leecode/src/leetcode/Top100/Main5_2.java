package leetcode.Top100;

/**
 * Description: 最长回文子串
 * Created by zhang on 2021/3/2 10:25
 */
public class Main5_2 {
    //中心扩展法
    public String longestPalindrome(String s) {
        //特判
        int len = s.length();
        if(len<2)return s;
        //定义起始，末尾坐标
        int start = 0,end = 0;
        //从0开始扩展
        for(int i = 0;i<len;i++){
            //获取以某一字符为中心的回文子串长度
            int odd_len = extendAroudCenter(s,i,i);
            //获取以字符间隙为中心的回文子串长度
            int evev_len = extendAroudCenter(s,i,i+1);
            //获取最大回文子串长度
            int maxLen = Math.max(odd_len,evev_len);
            //更新最大长度
            if(maxLen > end - start){
                //若某回文子串长度为奇数，计算起始坐标start时需要-1，否则计算不准确
                start = i-(maxLen-1)/2;
                end = i + maxLen/2;
            }
        }
        //返回最大回文子串，这里end+1是因为java本身左闭右开的原因
        return s.substring(start,end+1);
    }
    //中心扩展
    private int extendAroudCenter(String s,int left,int right){
        //若当前左右边界不越界，且子串两边字符相等，则向外扩展
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        //返回扩展后子串的长度
        return right - left - 1;
    }

    public static void main(String[] args) {
        String s = "ababaabc";
        System.out.println(new Main5_2().longestPalindrome(s));
    }
}
