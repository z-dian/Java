package 牛客.剑指offer;
/**
 * @author 张点
 * @description 把字符串转换成整数
 * @date 2020/9/25 10:21
 **/
public class JZ_49Solution {
    /*
    思路：遍历字符串
    1、如果第一个字符是'+' 则flag=1，如果是'-'则flag=-1
    2、如果第一个字符是数字，则计算到结果中：res = res*10 + charAt(i) - '0'，注意这里charAt(i)-'0' 是为了将字符转化成相应的整数
    3、其他情况，输入非法 返回0即可
     */
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) return 0;
        int flag = 1;
        int res = 0;
        for (int i = 0; i <str.length(); i++) {
            if(i==0&&(str.charAt(i)=='+'||str.charAt(i)=='-')){
                flag=str.charAt(i)=='-'?-1:1;
            }else if(str.charAt(i)>'0'&&str.charAt(i)<'9'){
                res = res * 10 +str.charAt(i)-'0';
            }else {
                return 0;
            }
        }
        return flag*res;
    }

    public static void main(String[] args) {
        int res = new JZ_49Solution().StrToInt("-12");
        System.out.println(res);
    }
}
