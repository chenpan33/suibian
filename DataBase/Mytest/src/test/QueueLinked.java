package src.test;

import com.sun.glass.ui.Size;
import org.w3c.dom.Node;

import java.time.temporal.ValueRange;
import java.util.Objects;

/**
 * @author panda
 * @description:
 * @date 2021/3/5 12:36
 */
public class QueueLinked<T> {
    //todo:成员变量
    Node head=new Node();
    Node end=head;//end和head起始地址相同
    int size=0;

    //todo:进队列
    public boolean offer(T val){
        if(val==null){throw new IllegalArgumentException("参数不合法"); }
        Node mid=new Node(val,null);
        if(this.isEmpty()){
            head=mid;
        }
        end.next=mid;
        end=mid;
        size++;
        return true;
    }
    //todo：出队列
    public T poll(){
        //空队列
        if(this.isEmpty()){
            return null;
        }
        //头节点被删除元素
        T delVal=head.val;
        head=head.next;
        size--;
        //判断删除后为空的情况下，end等于head,不判断了
        return delVal;
    }
    //todo：查看队头
    public T peek(){
        T peekVal=head.val;
        return peekVal;
    }
    //todo：获得长度size
    public int getSize(){
        return size;
    }
    //todo：判空
    public boolean isEmpty(){
        return size==0;
    }


    //重写toString


    @Override
    public String toString() {
        return "QueueLinked{" +
                "size=" + size +
                ", head=" + head +
                ", end=" + end +
                '}';
    }

    //节点类
    class Node{
        T val;
        Node next;

        public Node(T val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node() {
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
