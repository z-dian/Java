package API2.Object;
/*
public String toString();返回该对象的字符串表示。
toString方法返回该对象的字符串表示，其实该字符串内容就是对象的类型+@+内存地址值。
由于toString方法返回的结果是内存地址，而在开发中，经常需要按照对象的属性得到相应的字符串表现形式，因此也需要重写它。
 */

public class Demo01ToString {
    public static void main(String[] args) {
        Person person = new Person("tom",20);
//        person.setName("marry");
//        person.setAge(18);
        System.out.println(person.toString());
    }

}
