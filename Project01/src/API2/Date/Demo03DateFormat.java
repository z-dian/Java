package API2.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
    java.text.DateFormat:是日期/时间格式化子类的抽象类
    作用：
        格式化（也就是日期 -> 文本）、解析（文本-> 日期）
    成员方法：
         String format(API2.Date date)   按照指定模式，将一个 API2.Date 日期格式化为符合模式的字符串。
         API2.Date parse(String source)  从给定字符串的开始解析文本，以生成一个Date日期。
    DateFormat类是一个抽象类，无法直接创建对象使用，可以使用DateFormat类的子类

    java.text.SimpleDateFormat extends DateFormat

    构造方法：
        SimpleDateFormat(String pattern)
             用给定的模式和默认语言环境的日期格式符号构造 SimpleDateFormat。
        参数：
            pattern - 描述日期和时间格式的模式
        模式：区分大小写
            y   年
            M   月
            d   日
            H   时
            m   分
            s   秒
        写对应的模式，会把模式替换为对应的日期和时间。
        例如："yyyy-MM-dd HH:mm:ss"
        注意：模式中字母不可更改，连接模式的符合可以改变
        例如："yyyy年MM月dd日 HH时mm分ss秒"
 */
public class Demo03DateFormat {
    public static void main(String[] args) throws ParseException {
        demo01();
        demo02();
    }
    /*
    使用DateFormat类中的方法format，把日期格式化为文本
    使用步骤：
        1、创建SimpleDateFormat对象，构造方法传递指定的模式
        2、调用SimpleDateFormat对象中的方法，按照构造方法中指定的模式，把Date日期格式转化为符合模式的字符串（文本）
     */
    private static void demo01(){
        SimpleDateFormat simp = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        Date date=new Date();
        String d = simp.format(date);
        System.out.println(date);//Fri Dec 06 16:28:07 CST 2019
        System.out.println(d);//2019年12月06日 16时28分07秒
    }
    /*
    使用DateFormat类中的方法parse，把文本解析为日期
    使用步骤：
        1、创建SimpleDateFormat对象，构造方法传递指定的模式
        2、调用SimpleDateFormat对象中的方法parse，把符合构造方法中的模式的字符串，解析为Date时期
    注意：
        public API2.Date parse(String source) throws ParseException
        parse方法声明了一个异常叫ParseException
        如果一个字符串和构造方法的模式不一样，那么程序就会抛出异常
        调用了一个抛出了异常的方法，就必须处理这个异常，要么throws继续抛出这个异常，要么try catch自己处理
     */
    private static void demo02() throws ParseException {
        SimpleDateFormat simp = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");

        Date date= simp.parse("2019年12月06日 16时28分07秒");
        System.out.println(date);
    }
}
