package API2.StringBuilder;

/*
    public API2.StringBuilder append(...)：添加任意类型数据的字符串形式，并返回当前对象自身。
    public String toString()：将当前StringBuilder对象转换为String对象。
 */
public class Demo02StringBuilder {
    public static void main(String[] args) {
        //创建StringBuilder对象
        StringBuilder stu1 = new StringBuilder();

        //使用append方法往StringBuilder中添加任意类型数据
        // append方法返回的是this，调用方法的对象是stu1，那么this就是stu1
        StringBuilder stu2 = stu1.append("abc");//把stu1的地址赋值给了stu2

        System.out.println(stu1);//abc
        System.out.println(stu2);//abc
        System.out.println(stu1 == stu2);//true    比较的是地址

        //使用append方法无需接收返回值
        System.out.println("============");
        stu1.append("abc");
        stu1.append(1);
        stu1.append(8.8);
        stu1.append("中国");
        stu1.append(true);
        System.out.println(stu1);//abcabc18.8中国true
        System.out.println("==================");
        //链式编程
        StringBuilder builder = new StringBuilder();
        builder.append("hello").append("world").append(true).append(100);
        System.out.println("builder:"+builder);//builder:helloworldtrue100
    }
}
