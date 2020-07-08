package 树.二叉树的序列化和反序列化;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，
同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。请设计一个算法来实现二叉树的序列
化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符
串并且将这个字符串反序列化为原始的树结构。
示例:
你可以将以下二叉树：

    1
   / \
  2   3
     / \
    4   5

序列化为 "[1,2,3,null,null,4,5]"
 */
/*
思路：
可以采用BFS和DFS遍历二叉树
我们可以先序遍历这颗二叉树，遇到空子树的时候序列化成 None，否则继续递归序列化。那么我们如何反序列化呢？
首先我们需要根据 , 把原先的序列分割开来得到先序遍历的元素列表，然后从左向右遍历这个序列：
   · 如果当前的元素为 None，则当前为空树
   · 否则先解析这棵树的左子树，再解析它的右子树

 */
public class Codec {

    public String serialize(TreeNode root){
        return rserialize(root,"");
    }

    private String rserialize(TreeNode root, String str) {
        if(root == null){
            str+="None,";
        }else {
            str+=str.valueOf(root.val)+",";
            str = rserialize(root.left,str);
            str = rserialize(root.right,str);
        }
        return str;
    }

    public TreeNode deserialize(String data){
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<>(Arrays.asList(data_array));
        return rdeserialize(data_list);
    }

    private TreeNode rdeserialize(List<String> list) {
        if(list.get(0).equals("None")){
            list.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = rdeserialize(list);
        root.right = rdeserialize(list);

        return root;
    }
}
