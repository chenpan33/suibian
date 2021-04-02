import java.util.Scanner;

/**在一个定义了直角坐标系的纸上，画一个 (x1,y1) 到 (x2,y2) 的矩形指将横坐标范围从 x1 到 x2，纵坐标范围从 y1 到 y2 之间的区域涂上颜色。

 下图给出了一个画了两个矩形的例子。

 第一个矩形是 (1,1) 到 (4,4)，用绿色和紫色表示。

 第二个矩形是 (2,3) 到 (6,5)，用蓝色和紫色表示。

 图中，一共有 15 个单位的面积被涂上颜色，其中紫色部分被涂了两次，但在计算面积时只计算一次。

 在实际的涂色过程中，所有的矩形都涂成统一的颜色，图中显示不同颜色仅为说明方便。*/
public class p3203picture {
    public static void main(String[] args) {
        //面积area
        int area=0;
        Scanner in = new Scanner(System.in);
        System.out.println("请输入矩形数目");
        int n=in.nextInt();
        int [][]arr=new int[n][4];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入第"+(i+1)+"组x1,y1,x2,y2");
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j]=in.nextInt();
            }
            area=area+(arr[i][2]-arr[i][0])*(arr[i][3]-arr[i][1]);
        }
        System.out.println(area);
    }
}
