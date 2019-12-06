package API2.StringBuilder;
/*
    StringBuilder和String可以相互转换：
        String->API2.StringBuilder:可以使用StringBuilder的构造方法
            API2.StringBuilder(String str)构造一个字符串生成器，并初始化为指定的字符串内容。
        API2.StringBuilder->String:可以使用StringBuilder的toString方法
            public String toString():通过toString方法，StringBuilder对象将会转换为String对象
 */
public class Demo03toString {

    public static void main(String[] args) {
        //String->API2.StringBuilder
        String str="hello";
        System.out.println("str:"+str);
        StringBuilder bu = new StringBuilder(str);
        //往StringBuilder中添加数据
        bu.append("world");
        System.out.println("bu:"+bu);

        // API2.StringBuilder->String
        String s = bu.toString();
        System.out.println("s:"+s);

    }


}
