package API2.Date;
/*
java.util.Date类：表示日期和时间的类
类 API2.Date 表示特定的瞬间，精确到毫秒。
毫秒：千分之一秒 1000毫秒=1秒
特定的瞬间：一个时间点，一刹那时间
毫秒值的作用：可以对时间和日期进行计算
2099-01-03到2088-01-01中间一共有多少天？
可以日期转换为毫秒进行计算，计算完毕，再把毫秒转化为日期

把日期转换为毫秒：
    当前的日期为2088-01-01
    时间原点为（0毫秒）：1970年1月1日 00:00:00（英国格林威治）
    就是计算当前日期到时间原点之间一共经历了多少毫秒（1575277166578）

把毫秒转化为日期：
    1 天 = 24 × 60 × 60 = 86400 秒 = 86400 x 1000 = 86400000毫秒
注意：
    中国属于东八区，会把时间增加8个小时
    1970年1月1日 08:00:00
 */
public class Demo01Date {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());//获取当前系统时间到1970年1月1日 00:00:00 一共经历了多少毫秒
    }
}