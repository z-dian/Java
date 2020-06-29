package 堆栈与队列.扁平化嵌套列表迭代器;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/*
给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
示例 1:

输入: [[1,1],2,[1,1]]
输出: [1,1,2,1,1]
解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
示例 2:

输入: [1,[4,[6]]]
输出: [1,4,6]
解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
 */
/*
思路：
1、在类中添加nestedList、stack、iterator、integer四个属性，分别对应嵌套列表、迭代器存储栈、当前迭代器、当前遍历整数

2、构造函数初始化nestedList、iterator，iterator对应的就是构造参数的迭代器。

3、重写hasNext()函数，主要逻辑为：

    当前迭代器若hasNext()为true
        判断next()是否为整数，若为整数则赋值integer，返回``true`
        判断next()是否为列表，则将当前迭代器暂存至stack,并更新iterator为当前列表的迭代器，递归hasNext()函数
    当前迭代器若hasNext()为false且stack非空，则迭代器出栈更新为当前iterator，递归hasNext()函数

    其他情况则代表，整个扁平化嵌套列表已遍历完毕，返回false

4、重写next()函数，迭代器的使用规则是hasNext()返回为true时调用next()函数获取下一值，再次直接返回integer（当前遍历整数）即可。
 */
public class NestedIterator implements Iterator<Integer> {
    //嵌套列表
    private List<NestedInteger> nestedList = null;
    //迭代器存储栈
    private Stack<Iterator<NestedInteger>> stack = new Stack<>();
    //当前迭代器
    private Iterator<NestedInteger> iterator = null;
    //当前遍历整数
    private Integer integer = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        //嵌套列表初始化
        this.nestedList = nestedList;
        iterator = nestedList.iterator();
    }

    @Override
    public boolean hasNext() {
        if (iterator.hasNext()) {
            NestedInteger nestedInteger = iterator.next();
            if (!nestedInteger.isInteger()) {
                //返回该值列表
                stack.push(iterator);
                iterator = nestedInteger.getList().iterator();
                return hasNext();
            } else {
                integer = nestedInteger.getInteger();
                return true;
            }
        } else if (!iterator.hasNext() && !stack.isEmpty()) {
            //当前迭代器至列表末尾且栈非空
            //迭代器更新为上一级
            iterator = stack.pop();
            return hasNext();
        } else {
            return false;
        }
    }

    @Override
    public Integer next() {
        return integer;
    }
}
