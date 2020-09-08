package 牛客.剑指offer;

/**
 * @ClassName JZ25_Solution
 * @Description 复杂链表的复制
 * @Author 张点
 * @Date 2020/8/26 13:43
 * @Version 1.0
 **/
/**
 * 思路：1、先复制原链表节点连接到原节点后
 *          如原链表为A->B->C->D->E,复制后为A->A'->B->B'->C->C'->D->D'->E->E'
 *       2、复制随机指针
 *       3、拆分链表
 */
public class JZ25_Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        //特判
        if(pHead == null) return  null;

        //1.复制原链表节点连接到原节点后
        RandomListNode currentNode = pHead;

        while (currentNode!=null){
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            RandomListNode nextNode = currentNode.next;
            currentNode.next = cloneNode;
            cloneNode.next=nextNode;
            currentNode = nextNode;
        }

        //2.重新遍历链表，复制旧节点的随机指针给新节点
        //让当前节点重新指向头节点，重新遍历
        currentNode = pHead;
        while (currentNode!=null){
            currentNode.next.random = currentNode.random == null?null:currentNode.random.next;
            currentNode = currentNode.next.next;
        }

        //3.拆分链表
        currentNode = pHead;
        RandomListNode cloneHead = pHead.next;
        while (currentNode!=null){
            RandomListNode cloneNode = currentNode.next;
            currentNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next==null?null:cloneNode.next.next;
            currentNode = currentNode.next;
        }
        return cloneHead;
    }

}
