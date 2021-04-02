package src.tree;

import sun.reflect.generics.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.TreeMap;

/**
 * @author cskaoyan
 * @Description
 * @create 2020-08-25 9:59
 */
public class RedBlackTree<K  extends Comparable<K>,   V> {

    private static final  boolean RED = true;
    private static final  boolean BLACK = false;
    // 根节点
    private TreeNode root;


    class TreeNode{
        // 红黑树中节点的key
        K key;
        // 红黑树中节点的value
        V value;
        // 红黑树中节点的左右子树
        TreeNode  left, right;
        // 红黑树中节点的颜色
        boolean color;
        // 记录该节点作为根节点的树中所有元素个数
        int size;

        public TreeNode(K key, V value, TreeNode left, TreeNode right, boolean color, int size) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
            this.size = size;
        }
    }


    /**
     * 在红黑树中: 根据key, 查找某个key对应的value(它和普通的二叉搜索树查找没有区别)
     * @param k
     * @return
     */
    public V get(K k){
        if (root == null) throw new RuntimeException("tree is null");
        if (k == null) throw new IllegalArgumentException("param is null");


        TreeNode x = root;
        while (x != null){
            int com = k.compareTo(x.key);

            if (com > 0) x = x.right;
            else if (com < 0)  x = x.left;
            else return x.value;
        }
        return null;
    }


    private  TreeNode rotatalLeft(TreeNode h){
        TreeNode x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;

        //size的转变
        x.size = h.size;
        h.size = h.left.size + h.right.size + 1;
        return x;
    }

    private  TreeNode rotatalRight(TreeNode h){
        TreeNode x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        //size的转变
        x.size = h.size;
        h.size = h.left.size + h.right.size + 1;
        return x;
    }

    /**
     * 该方法: 是用来分裂节点的
     * (2-3-4(4节点): 中间节点上移分裂,
     * 红黑树体现: 分裂上去的节点和别的上层节点构成一个节点, 所以上移节点要变成红色
     * 分裂留到下层的元素, 变成黑色
     * )
     * @param x
     * @return
     */
    private TreeNode colorFlip(TreeNode x){
        x.color = !x.color;
        x.left.color = !x.left.color;
        x.right.color = !x.right.color;
        return x;
    }

    /**
     * 添加操作
     * @param key
     * @param value
     * @return
     */
    public boolean put(K key, V value){

        int oldSize = root.size;
        root = insert(root, key, value);
        root.color = BLACK;

        check();

        return  oldSize < root.size;
    }



    private TreeNode insert(TreeNode root, K key, V value){
        if (root == null) return new TreeNode(key, value, null, null, RED, 1);

        int com = key.compareTo(root.key);
        if (com > 0){
            root.right = insert(root.right, key, value);
        } else if (com < 0){
            root.left = insert(root.left, key, value);
        } else {
            // TODO : 表述新插入的元素存在相等的key
            root.value = value;
        }
        root = fixUp(root);
        return root;
    }

    /**
     * 判断某个节点是不是红色
     * @param root
     * @return
     */
    private boolean isRed(TreeNode root) {
        if (root == null) return false;
        return  root.color == RED;
    }


    /**
     * 为了检查已经做过操作的红黑树: 是不是标准的
     */
    private void check() {

        //TODO 判断该树是不是23树(条件: 1,右子不能红:应该分裂 2:左不红色能连续红)
        boolean is23 = is23(root);

        //TODO 判断该树是不是平衡(获得某一黑叶子节点高, 判断其它叶子是否和这个高相等:通过减减操作)
        boolean isBalanced = isBalanced(root);


        if (!is23 || !isBalanced  ){
            throw new RuntimeException("tree is not Red-Black-Tree");
        }
    }

    /**
     * 判断某一个红黑树: 是不是平衡的
     * @param root
     * @return
     */
    private boolean isBalanced(TreeNode root) {
        if (root == null) return  true;

        TreeNode x = root;
        int height = 0;
        while (x != null) {
            if (!isRed(x)){
                height++;
            }

            x = x.left;
        }

        boolean isBalanced = isBalanced(root, height);
        return isBalanced;
    }

    // 递归方法
    private boolean isBalanced(TreeNode root, int height) {
        if (root == null) return height == 0;

        if (!isRed(root)){
            height--;
        }

        boolean balancedLeft = isBalanced(root.left, height );
        boolean balancedRight = isBalanced(root.right, height );

        return balancedLeft && balancedRight;
    }


    /**
     * 判断我们的红黑树是不是2-3树(不能让他是2-3-4树; 新为4节点要分裂)
     * @param root
     * @return
     */
    private boolean is23(TreeNode root) {
        if (root == null) return true;

        // 右子不能红:应该分裂
        // 左不红色能连续红)
        if (isRed(root.right)){
            return false;
        }

        if (isRed(root.left) && isRed(root.left.left)){
            return false;
        }

        boolean left = is23(root.left);
        boolean right = is23(root.right);

        return left && right;
    }


    /**
     * 保证当右侧的节点是2节点的时候, 那么通过变换旋转, 让他变为非2节点
     * @param h
     * @return
     */
    private TreeNode moveRedRight(TreeNode h){
        colorFlip(h);
        if (isRed(h.left.left)){
            h = rotatalRight(h);
            colorFlip(h);
        }
        return h;
    }

    private TreeNode moveRedLeft(TreeNode h){
        colorFlip(h);
        if (isRed(h.right.left)){

            // 先把h.right 右旋
            h.right = rotatalRight(h.right);
            // 再把整体节点左旋
            h = rotatalLeft(h);

            colorFlip(h);
        }
        return h;
    }


    public void removeMax(){
        if (root == null) throw new RuntimeException("tree is null");

        root = removeMax (root);
        root.color = BLACK;

    }

    private TreeNode removeMax(TreeNode root) {

        // 如果左节点是红色节点, 那么右旋转
        if (isRed(root.left)) rotatalRight(root);

        // 如果右子节点为null, 说明该节点, 一定是最大节点
        if (root.right == null) return null;

        if (!isRed(root.right) && !isRed(root.right.left)){
          // root 的右节点一定是 2 节点
            root = moveRedRight(root);
        }
        root = fixUp(root);
        root.right = removeMax(root.right);
        return root;
    }

    public void removeMin(){
        if (root == null) throw new RuntimeException("tree is null");
        root = removeMin (root);
        root.color = BLACK;
    }

    private TreeNode removeMin(TreeNode root) {

        if (root.left == null) return null;

        if (!isRed(root.left) && !isRed(root.left.left)){

            root = moveRedLeft(root);
        }
        // 修复删除过程中的变换
        root = fixUp(root);
        root.left = removeMin(root.left);
        return root;
    }


    public boolean delete(K key){
        if (root == null) throw new RuntimeException("tree is null");
        if (key == null) throw new RuntimeException("key is null");

        int oldSize = root.size;

        root = delete(root, key);

        return oldSize < root.size;
    }

    private TreeNode delete(TreeNode root, K key) {
        int com = key.compareTo(root.key);

        if (com < 0){// 移动到left子树上执行删除操作
            if (!isRed(root.left) && !isRed(root.left.left)){
                root = moveRedLeft(root);
            }

            root.left = delete(root.left, key);
        }else {

            if (isRed(root.left)){
                root = rotatalRight(root);
            }

            if (key.compareTo(root.key) == 0 && root.right == null) return null;

            if (!isRed(root.right) && !isRed(root.right.left)){
                root = moveRedRight(root);
            }

            if (key.compareTo(root.key) == 0){

                //
                TreeNode target = minRight(root.right);
                root.value = target.value;
                root.key = target.key;


                root.right = removeMin(root.right);

            } else {
                root.right = delete(root.right, key);
            }
        }

        root = fixUp(root);

        root.size = root.left.size + root.right.size + 1;
        return root;

    }

    private TreeNode minRight(TreeNode right) {

        while (right.left != null ){
            right = right.left;
        }
        return right;
    }


    private TreeNode fixUp(TreeNode root) {
        // 修正红黑树
        if (isRed(root.right)) root = rotatalLeft(root);
        if (isRed(root.left) && isRed(root.left.left)) root = rotatalRight(root);
        // TODO: 放到这个位置, 保证在红黑树中插入完成之后不存在: 四节点
        // 判断该节点的左右子节点是不是红色的,
        // 如果是红色的, 说明对应2-3-4树种的4节点(3个key), 需要向上分裂
        if (isRed(root.left) && isRed(root.right)) colorFlip(root);
        // 改变整体的size
        root.size = root.left.size + root.right.size + 1;
        return root;
    }


}
