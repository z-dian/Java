package 集合.Day02Iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
    java.util.Iterator接口：迭代器（对集合进行遍历）
    有两个常用的方法
        public E next():返回迭代的下一个元素。
        public boolean hasNext():如果仍有元素可以迭代，则返回 true。
    Iterator迭代器，是一个接口，我们无法直接使用，需要使用Iterator接口的实现类对象，获取实现类的方式比较特殊
    Collection接口中有一个方法，叫iterator()，这个方法返回的就是迭代器的实现类对象。
    Iterator<E> iterator()  返回在此 collection 的元素上进行迭代的迭代器。

    迭代器的使用步骤（重点）：
        1、使用集合中的方法iterator()获取迭代器的实现类对象，使用Iterator接口接收（多态）
        2、使用Iterator接口中的方法hasNext判断还有没有下一个元素
        3、使用Iterator接口中的方法next取出集合中的下一个元素
 */
public class Demo01Iterator {
    public static void main(String[] args) {
        //创建一个集合对象
        Collection<String> coll = new ArrayList<>();
        //往集合中添加元素
        coll.add("姚明");
        coll.add("科比");
        coll.add("麦迪");
        coll.add("詹姆斯");
        coll.add("艾弗森");
        /*
        1、使用集合中的方法iterator()获取迭代器的实现类对象，使用Iterator接口接收(多态)
        注意：
            Iterator<E> 接口也是有泛型的，迭代器的泛型跟着集合走，集合是什么泛型，迭代器就是什么泛型
        */
        Iterator<String> it = coll.iterator();

        /*
            发现使用Iterator取出集合元素是一个重复的过程，所以我们可以使用循环进行优化
            由于不知道集合元素的具体个数，所以使用while循环，循环结束条件：hasNext返回false
        */

        while (it.hasNext()) {
            String e = it.next();
            System.out.println(e);
        }
        System.out.println("===========================");
        //for循环格式
        for(Iterator<String> it2 = coll.iterator();it2.hasNext();){
            String s = it2.next();
            System.out.println(s);
        }
        /*//2.使用Iterator接口中的方法hasNext判断还有没有下一个元素
        boolean b = it.hasNext();
        System.out.println(b);

        //3、使用Iterator接口中的方法next取出集合中的下一个元素
        String s = it.next();
        System.out.println(s);//姚明

        b = it.hasNext();
        System.out.println(b);
        s = it.next();
        System.out.println(s);

        b = it.hasNext();
        System.out.println(b);
        s = it.next();
        System.out.println(s);

        b = it.hasNext();
        System.out.println(b);
        s = it.next();
        System.out.println(s);

        b = it.hasNext();
        System.out.println(b);
        s = it.next();
        System.out.println(s);

        b = it.hasNext();//没有元素，返回false
        System.out.println(b);
        s = it.next();//没有元素，在取出元素时就会抛出NoSuchElementException异常
        System.out.println(s);
*/
    }

}
