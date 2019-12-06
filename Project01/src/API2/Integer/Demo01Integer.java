package API2.Integer;

/*
    装箱：从基本类型转换为对应的包装类对象。
        构造方法：
        API2.Integer(int value) ：构造一个新分配的 API2.Integer 对象，它表示指定的 int 值。
        API2.Integer(String s)  ： 构造一个新分配的 API2.Integer 对象，它表示 String 参数所指示的 int 值。
            传递的字符串必须是基本类型的字符串，否则会抛出异常，比如：“100”正确，“a” 抛异常
        静态方法：
            static API2.Integer valueOf(int i)
                返回一个表示指定的 int 值的 API2.Integer 实例。
            static API2.Integer valueOf(String s)
                返回保存指定的 String 的值的 API2.Integer 对象。
    拆箱：从包装类对象转换为对应的基本类型。
        成员方法：
            int intValue()
                以 int 类型返回该 API2.Integer 的值。
            long longValue()
                以 long 类型返回该 API2.Integer 的值。

 */

public class Demo01Integer {
    public static void main(String[] args) {
        //装箱：把基本类型的数据包装到包装类中
        //构造方法
        Integer in1 = 1;
        System.out.println(in1);
        //静态方法
        Integer in3 = Integer.valueOf(1);
        System.out.println(in3);

        Integer in4 = Integer.valueOf("2");
//        API2.Integer in4 = API2.Integer.valueOf("a");数字格式化异常
        System.out.println(in4);

        System.out.println("============");
        //拆箱：从包装类对象转换为对应的基本类型。
        int i = in1.intValue();
        System.out.println(i);
    }
}
