package 牛客.剑指offer;

/**
 * @author 张点
 * @description 表示数值的字符串
 * @date 2020/9/29 16:54
 **/
public class JZ_53Solution {
    public boolean isNumeric(char[] str) {
        if (str.length == 0) return false;
        if (str.length == 1) {
            if (str[0] < '0' || str[0] > '9') {
                return false;
            }
        }

        //标记符号、小数点、e是否出现过
        boolean sign = false, decimal = false, hasE = false;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'e' || str[i] == 'E') {
                if (i == str.length - 1) return false;//e后面一定要跟数字
                if (hasE) return false;//e只能出现一个
                hasE = true;
            } else if (str[i] == '+' || str[i] == '-') {
                //第二次出现+—符号，则必须跟在e之后
                if (sign && str[i - 1] != 'e' && str[i - 1] != 'E') return false;
                //第一次出现+-符号，且不在字符串开头时，则也必须跟在e之后
                if (!sign && i > 0 && str[i - 1] != 'e' && str[i - 1] != 'E') return false;
                sign=true;
            }else if(str[i]=='.'){
                //e后面不能跟小数点，小数点不能出现两次
                if(hasE||decimal)return false;
                decimal=true;
            }else if(str[i]<'0'||str[i]>'9'){//非法字符
                return false;
            }
        }
        return true;
    }
}
