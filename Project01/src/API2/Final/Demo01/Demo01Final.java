package API2.Final.Demo01;

/*
final关键字代表最终、不可改变的，可以用于修饰类、方法和变量。

常见的有：
1、类：被修饰的类，不能被继承。
2、方法：被修饰的方法，不能被重写。
3、变量：被修饰的变量，不能被重新赋值。

 */
public class Demo01Final {

    public static void main(String[] args) {

        int num1 = 10;
        System.out.println(num1);//10
        num1 = 20;
        System.out.println(num1);//20
        System.out.println("============");

        final int num2 = 200;
        System.out.println(num2);

//        num2 = 250;//错误写法！final修饰的变量不能改变
//        num2 = 200;//错误写法！

        //正确写法！只要保证有唯一一次赋值即可
        final int num3;
        num3 = 30;
        System.out.println(num3);

        //对于基本类型来说，不可变说的是变量当中的数据不可改变
        //对于引用类型来说，不可变说的是变量当中的地址值不可改变
        Student stu1 = new Student("张三");
        System.out.println(stu1.getName());//张三

        stu1 = new Student("李四");
        System.out.println(stu1.getName());//李四
        System.out.println("================");

        final Student stu2 = new Student("王五");
        //错误写法！final的引用类型变量，其中的地址值不可改变
//       stu2 = new Student("马六");
        System.out.println(stu2.getName());
        stu2.setName("马六");
        System.out.println(stu2.getName());

    }
}
