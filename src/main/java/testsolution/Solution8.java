package testsolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * created  by KDF on 2017/10/20.
 */


//public class testsolution.Solution8 {
//
//    public static void main(String[] args) {
//        List alist = new ArrayList();
//
//        System.out.println("请输入约瑟夫环  中 总个数数：");
//        Scanner sca = new Scanner(System.in);
//        int N = sca.nextInt();
//        // 提示输入要出圈的数值
//        System.out.println("请输入要出圈的数值：");
//        int X = sca.nextInt();
//        System.out.println("按出圈的次序输出序号：");
//
//        for(int i=0 ;i<N;i++){
//            alist.add(i+1);
//        }
//
//        int i=-1;
//        int countX=0;
//        while(alist.size()!=0){
//            ++i;
//            if(i== alist.size()){
//                i=0;
//            }
//            ++countX;
//            if(countX==X){//输出
//                System.out.print(alist.get(i)+ " ");
//                alist.remove(i);
//                countX=0;
//                i--;//修正
//            }
//        }
//
//        System.out.println("''''''''"+(3%10)+"....."+(3/10));
//    }
//
//}

public class Solution8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入总人数：");
        int totalNum = scanner.nextInt();
        System.out.print("请输入报数的大小：");
        int cycleNum = scanner.nextInt();
        yuesefu(totalNum, cycleNum);
        scanner.close();
    }

    public static void yuesefu(int totalNum, int countNum) {
        // 初始化人数
        List<Integer> start = new ArrayList<Integer>();
        for (int i = 1; i <= totalNum; i++) {
            start.add(i);
        }
        // 从第K个开始计数
        int k = 0;
        while (start.size() >=countNum) {
            k = k + countNum;
            // 第m人的索引位置
            k = k % (start.size()) - 1;
            // 判断是否到队尾
            if (k < 0) {
                System.out.println(start.get(start.size() - 1));
                start.remove(start.size() - 1);
                k = 0;
            } else {
                System.out.println(start.get(k));
                start.remove(k);
            }
        }
        for(int i=0;i<start.size();i++){
            System.out.println(start.get(i));
        }
    }
}


