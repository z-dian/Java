package leetcode.剑指offer;
/**
 * @description 正则表达式匹配
 * @author 张点
 * @date 2020/10/26 8:50
 **/
public class JZ19_Solution {
    public boolean isMatch(String s, String p) {
        if(s==null||p==null)return false;
        int sIndex = 0;
        int pIndex = 0;
        return matchHelper(s,p,sIndex,pIndex);
    }

    public boolean matchHelper(String s,String p,int sIndex,int pIndex){
        //有效检验,s和p都到末尾，则匹配成功
        if(sIndex==s.length()&&pIndex==p.length()){
            return true;
        }
        //p模式串先到尾，匹配失败
        if(sIndex!=s.length()&&pIndex==p.length()){
            return false;
        }
        //如果模式串当前字符下一位是‘*’且字符串第一个字符跟模式串第一个字符匹配
        if(pIndex+1<p.length()&&p.charAt(pIndex+1)=='*'){
            if((sIndex!=s.length()&&s.charAt(sIndex)==p.charAt(pIndex))||(sIndex!=s.length()&&p.charAt(pIndex)=='.')){
                //当‘*’表示前面字符出现0次，字符串当前字符不变，模式串后移两位
                //当‘*’表示字符串前一位字符出现1次或者多次，字符串s后移1位，继续匹配
                return matchHelper(s,p,sIndex,pIndex+2)||matchHelper(s,p,sIndex+1,pIndex);
            }else{
                //当‘*’前面的字符与当前字符串不等时，*表示前面的字符出现0次，模式串指针后移两位继续匹配
                return matchHelper(s,p,sIndex,pIndex+2);
            }
        }
        //如果模式串下一个字符不是‘*’，则字符串跟模式串匹配，匹配成功字符串和模式串都往下走
        if((sIndex!=s.length()&&s.charAt(sIndex)==p.charAt(pIndex))||sIndex!=s.length()&&p.charAt(pIndex)=='.'){
            return matchHelper(s,p,sIndex+1,pIndex+1);
        }
        return false;

    }
}
