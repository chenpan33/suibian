package src.test;

/**
 * @author panda
 * @description:链表实现队列API
 * @date 2021/3/5 12:36
 */
public class DemoQueueLinked {
    public static void main(String[] args) {
        QueueLinked<String> list = new QueueLinked<>();
        System.out.println("“张1”入队列---------------------");
        list.offer("张1");
        System.out.println(list);
        System.out.println("队头出队列---------------------");
        System.out.println(list.poll());
        System.out.println("队头继续出队列---------------------");
        System.out.println(list.poll());
        list.offer("张2");
        list.offer("张3");
        list.offer("张4");
        list.offer("张5");
        list.offer("张6");
        System.out.println(list);
        System.out.println("查看队头---------------------");
        System.out.println(list.peek());
        System.out.println("队列长度---------------------");
        System.out.println(list.getSize());


    }
}
