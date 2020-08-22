package 牛客.剑指offer;

/**
 * @ClassName JZ7_Solution
 * @Description 斐波那契数列
 * @Author 张点
 * @Date 2020/8/9 17:11
 * @Version 1.0
 **/
public class JZ7_Solution {
    /*public int Fibonacci(int n) {
        if(n==0)return 0;
        if(n==1)return 1;
        return  Fibonacci(n-1)+Fibonacci(n-2);
    }*/
    public int Fibonacci(int n) {
        if(n==0)return 0;
        if(n==1)return 1;
        int first=0;
        int second =1;
        int fi = 0;
        for(int i = 2;i<=n;i++){
            fi=first+second;
            first=second;
            second=fi;
        }
        return  fi;
    }
}
