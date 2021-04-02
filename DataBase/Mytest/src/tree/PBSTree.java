package src.tree;

/**
 * @author panda
 * @description:
 * @date 2021/3/7 21:24
 */
public class PBSTree<T extends Comparable<T>>
{
    //todo：成员变量root和size
    private  Node root;
    int size;


    //todo:1.添加；
    public boolean add(T t){
        if (t==null){throw new IllegalArgumentException("param id null");}
        Node node = new Node(null,t,null);
        if(size==0){
            root=node;
            size++;
            return true;
        }
        Node mid=root;        int ca=0;//代表t与mid的差值
        while (mid!=null){
            ca=t.compareTo(mid.value);
            if(ca==0){
                return  false;
            }
            else if (ca<0){
                mid=mid.left;
            }else {
                mid=mid.right;
            }
        }
        return false;
    }
    //todo:2.1删除；
    public boolean remove(T t){
        return false;
    //todo:2.2《递归》删除；
    public boolean remove(T t){
        return false;
}

    //todo:3.查找；
    public boolean search(T t){
        return false;
    }
    //todo:4.1.1  先+栈；

    //todo:4.1.2  先+递归；
    //todo:4.2.1  中+栈；
    //todo:4.2.2  中+递归；
    //todo:4.3.1  后+栈；
    //todo:4.3.2  后+递归；
    //todo:4.4.1  层序+栈；
    //todo:4.4.2  层序+递归；

    //todo:。5.1建树《前中》
    //todo:。5.2建树《中后》








    //node类
    class Node {
        Node left;// 左子树
        T value;
        Node right;// 右子树
        public Node(Node left, T value, Node right) {
            this.left = left;
            this.value = value;
            this.right = right;
        }
    }
}
