package Object;

import java.util.Objects;

public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
   /* @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }*/
   /*
    Object类的equals方法，默认比较的是两个对象的地址值，没有意义
    所以我们要重写equals方法，比较两个对象的属性（name，age）
    问题：
        隐含着一个多态
        多态的弊端：无法使用子类特有的内容（属性和方法）
        Object obj = p2 = new Person("古力娜扎",19);
        解决：可以使用向下转型(强转)把Object类转换为Person
    */

   /* @Override
    public boolean equals(Object obj) {
        //增加一个判断，如果传递的参数是this本身，直接返回true，提高程序效率
        if (obj == this)
        {
            return true;
        }
        //增加一个判断，如果传递的参数是null，直接返回false
        if (obj==null){
            return false;
        }
        //增加判断，防止类型转化一次ClassCastException
        if (obj instanceof Person)
        //向下转型，Object类转换为Person
        {
            Person p = (Person) obj;

            //比较两个对象的属性，一个对象是this(p1)，一个对象是p(obj -> p2)
            boolean b = this.name.equals(p.name) && this.age == p.age;
            return b;
        }
        //不是person类型直接返回false
        return false;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        //getClass() != o.getClass()  使用反射技术，判断 o 是否是Person类型,等效于 obj instanceof Person
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
