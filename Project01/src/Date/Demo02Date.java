package Date;

import java.util.Date;

public class Demo02Date {
    public static void main(String[] args) {
        demo01();
        System.out.println("============");
        demo02();
        System.out.println("============");
        demo03();
    }

    /*
        long getTime()把日期转换为毫秒值(相当于System.currentTimeMillis()方法)
     */
    private static void demo03() {
        Date date = new Date();
        long time = date.getTime();
        System.out.println(time);
    }

    /*
        Date类的带参构造方法
        Date(long date)：传递毫秒值，把毫秒值转换为Date日期
     */
    private static void demo02() {
        Date date = new Date(0L);
        System.out.println(date);//Thu Jan 01 08:00:00 CST 1970
        date = new Date(1575278517457L);
        System.out.println(date);//Mon Dec 02 17:21:57 CST 2019
    }

    /*
        Date类的空参构造方法
        Date()获取当前系统的日期和时间
     */
    private static void demo01() {
        Date date = new Date();
        System.out.println(date);
    }
}
