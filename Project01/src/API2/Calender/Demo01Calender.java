package API2.Calender;

import java.util.Calendar;
import java.util.Date;

/*
    java.util.Calender类：日历类
        Calender类是一个抽象类，里面提供了很多操作日历的方法（YEAR、MONTH、DAY_OF_MONTH、HOUR）
        Calendar类无法直接创建对象，里面有一个静态方法getInstance()，该方法返回了Calendar类的子类对象
        public static Calendar getInstance()：使用默认时区和语言环境获得一个日历。

    成员方法中的参数：
        int field:日历类的字段，可以使用Calender类的静态成员变量获取
    Calendar类中提供很多成员常量，代表给定的日历字段：

    | 字段值        | 含义                       |
    | ------------ | --------------------       |
    | YEAR         | 年                         |
    | MONTH        | 月（从0开始，可以+1使用）    |
    | DAY_OF_MONTH | 月中的天（几号）             |
    | HOUR         | 时（12小时制）              |
    | HOUR_OF_DAY  | 时（24小时制）              |
    | MINUTE       | 分                         |
    | SECOND       | 秒                         |
    | DAY_OF_WEEK  | 周中的天（周几，周日为1，可以-1使用） |
 */

public class Demo01Calender {
    public static void main(String[] args) {
        demo01();
        demo02();
        demo03();
        demo04();
    }

    private static void demo01() {
        //使用getInstance()方法获取Calender对象
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        System.out.println(year);//2019

        int month = c.get(Calendar.MONTH);
        System.out.println(month + 1);//12

        int date = c.get(Calendar.DAY_OF_MONTH);
        System.out.println(date);//6
    }

    private static void demo02() {
        Calendar c = Calendar.getInstance();
        System.out.println("================");
        //设置年为9999
        c.set(Calendar.YEAR, 9999);
        int year = c.get(Calendar.YEAR);
        System.out.println(year);//9999

        int month = c.get(Calendar.MONTH);
        System.out.println(month + 1);//12

        int date = c.get(Calendar.DAY_OF_MONTH);
        System.out.println(date);//6
        System.out.println("================");
        c.set(8888, 8, 8);
        System.out.println(c.get(Calendar.YEAR));
    }

    private static void demo03() {
        //使用getInstance()方法获取Calender对象
        Calendar c = Calendar.getInstance();
        System.out.println("===========");
        //把年增加2年
        c.add(Calendar.YEAR, 2);
        int year = c.get(Calendar.YEAR);
        System.out.println(year);//2019

        c.add(Calendar.MONTH, -2);
        int month = c.get(Calendar.MONTH);
        System.out.println(month + 1);//12

        int date = c.get(Calendar.DAY_OF_MONTH);
        System.out.println(date);//6
    }

    //把日历对象转换为日期对象
    private static void demo04() {
        //使用getInstance()方法获取Calender对象
        Calendar c = Calendar.getInstance();
        System.out.println("===========");
        Date date = c.getTime();
        System.out.println(date);
    }
}