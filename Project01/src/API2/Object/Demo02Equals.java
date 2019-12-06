package API2.Object;

import java.util.ArrayList;

/*
Person类默认继承了Object类，所以可以使用Object类的equals方法。
boolean equals(API2.Object obj)指示其他某个对象是否与此对象“相等”。
equals方法源码：
    public boolean equals(API2.Object obj){
        return (this == obj);
    }
        参数：
        API2.Object obj：可以传递任意对象
        == 比较运算符，返回的是一个布尔值 true/false
        基本数据类型：比较的是值
        引用数据类型：比较的是两个对象的地址
    this是谁？ 哪个对象调用的equals方法，方法中的this就是那个对象；p1调用的equals方法所以this就是p1
*/
public class Demo02Equals {
    public static void main(String[] args) {
        Person p1 = new Person("迪丽热巴", 18);
//        Person p2 = new Person("古力娜扎", 19);
        Person p2 = new Person("迪丽热巴", 18);
        System.out.println("p1:" + p1);//p1:API2.Object.Person@1b6d3586
        System.out.println("p2:" + p2);//p2:API2.Object.Person@4554617c

//        p1 = p2;//p2的地址赋值给p1

        ArrayList<String> list = new ArrayList<>();

        boolean a = p1.equals(list);    //false
        boolean b = p1.equals(null);    //false
        boolean c = p1.equals(p1);      //true
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);



    }
}
